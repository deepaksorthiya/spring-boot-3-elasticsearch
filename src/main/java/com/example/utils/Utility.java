package com.example.utils;

import co.elastic.clients.elasticsearch.core.SearchResponse;

import java.util.Objects;

public class Utility {

    public static boolean isNullOrBlank(String s) {
        return Objects.isNull(s) || s.isBlank();
    }

    /**
     * Utility method to be used for single result queries.
     *
     * @return The document id.
     */
    public static <TDocument> String extractId(SearchResponse<TDocument> searchResponse) {
        return searchResponse.hits().hits().getFirst().id();
    }

    /**
     * Utility method to be used for single result queries.
     *
     * @return An object of the class that was specified in the query definition.
     */
    public static <TDocument> TDocument extractSource(SearchResponse<TDocument> searchResponse) {
        return searchResponse.hits().hits().getFirst().source();
    }
}
