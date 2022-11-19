package com.shelfy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shelfy.model.recipes.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final HttpClient httpClient;
    private final String apiKey;
    private final ObjectMapper objectMapper;
    private static final String URL = "https://api.spoonacular.com/recipes/findByIngredients";

    public RecipeServiceImpl(HttpClient httpClient, @Value("${recipes.api.key}") String apiKey, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.apiKey = apiKey;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Recipe> getRecipesByIngredients(String ingredients) {
        try {
            final HttpResponse<String> response = httpClient.send(
                    HttpRequest.newBuilder(getUri(ingredients)).GET().build(),
                    HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                return List.of();
            }
            return objectMapper.readValue(response.body(), new TypeReference<>() {
            });
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URI getUri(String ingredients) {
        return URI.create(URL +
                "?apiKey=" + apiKey +
                "&ingredients=" + ingredients +
                "&number=3" +
                "&sort=max-used-ingredients");
    }
}
