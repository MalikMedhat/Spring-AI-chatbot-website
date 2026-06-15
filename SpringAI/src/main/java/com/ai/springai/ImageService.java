package com.ai.springai;

import org.springframework.stereotype.Service;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class ImageService {

    public String generateImageUrl(String prompt) {
        try {
            String query = URLEncoder.encode(prompt.trim(), StandardCharsets.UTF_8);
            return "https://loremflickr.com/768/512/" + query;
        } catch (Exception e) {
            return "https://loremflickr.com/768/512/nature";
        }
    }
}
