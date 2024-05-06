package com.example.demo;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface RecommendationService {

    @UserMessage("""
            You are acting as a travel recommendation service.
            Provide a destination suggestion for a user based on their preferred country: {country} activity: {activity} and mood: {mood}.
            """)
    String recommend(String country, String activity, String mood);
}
