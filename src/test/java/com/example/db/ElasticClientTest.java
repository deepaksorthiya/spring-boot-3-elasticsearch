package com.example.db;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.time.Duration;

import static com.example.constant.Constants.*;

@Configuration
public class ElasticClientTest {

    @Bean
    public ElasticsearchClient elasticRestClient() throws IOException {
        // Creating the testcontainer
        String image = "docker.elastic.co/elasticsearch/elasticsearch:8.15.3";
        ElasticsearchContainer container = new ElasticsearchContainer(image)
                .withEnv("ES_JAVA_OPTS", "-Xms256m -Xmx256m")
                .withEnv("path.repo", "/tmp") // for snapshots
                .withStartupTimeout(Duration.ofSeconds(30))
                .withPassword("changeme");
        container.start();

        // Connection settings
        int port = container.getMappedPort(9200);
        HttpHost host = new HttpHost("localhost", port, "https");
        SSLContext sslContext = container.createSslContextFromCa();

        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(
                AuthScope.ANY, new UsernamePasswordCredentials("elastic", "changeme")
        );

        // Building the rest client
        RestClient restClient = RestClient.builder(host)
                .setHttpClientConfigCallback(hc -> hc
                        .setDefaultCredentialsProvider(credsProv)
                        .setSSLContext(sslContext)
                )
                .build();
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();
        ElasticsearchTransport transport = new RestClientTransport(restClient,
                new JacksonJsonpMapper(mapper));
        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        // Creating the indexes
        createSimpleIndex(esClient, USERS);
        createIndexWithDateMapping(esClient, ARTICLES);
        createIndexWithDateMapping(esClient, COMMENTS);

        return esClient;
    }

    private void createSimpleIndex(ElasticsearchClient esClient, String index) throws IOException {
        BooleanResponse indexRes = esClient.indices().exists(ex -> ex.index(index));
        if (!indexRes.value()) {
            esClient.indices().create(c -> c
                    .index(index));
        }
    }

    private void createIndexWithDateMapping(ElasticsearchClient esClient, String index) throws IOException {
        BooleanResponse indexRes = esClient.indices().exists(ex -> ex.index(index));
        if (!indexRes.value()) {
            esClient.indices().create(c -> c
                    .index(index)
                    .mappings(m -> m
                            .properties("createdAt", p -> p
                                    .date(d -> d))
                            .properties("updatedAt", p -> p
                                    .date(d -> d))));

        }
    }
}
