package com.teily.backend.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init() throws Exception {
        // Read from env var instead of file
        String firebaseCredentials = System.getenv("FIREBASE_CONFIG");

        if (firebaseCredentials == null || firebaseCredentials.isBlank()) {
            throw new IllegalStateException("Missing FIREBASE_CREDENTIALS environment variable");
        }

        var serviceAccount = new ByteArrayInputStream(
                firebaseCredentials.getBytes(StandardCharsets.UTF_8)
        );

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}
