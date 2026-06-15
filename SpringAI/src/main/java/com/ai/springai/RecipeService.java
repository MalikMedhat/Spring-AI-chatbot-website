package com.ai.springai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private ChatModel chatModel;

    public String generateRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
        String finalPrompt = String.format(
                "Generate a recipe using these ingredients: %s. Cuisine style: %s. Dietary restrictions: %s.",
                ingredients, cuisine, dietaryRestrictions
        );

        try {
            return chatModel.call(finalPrompt);
        } catch (Exception e) {
            return "Error generating recipe: " + e.getMessage();
        }
    }
}


//package com.ai.springai;
//
//import org.springframework.ai.chat.model.ChatModel;
//import org.springframework.ai.chat.prompt.Prompt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RecipeService {
//
//    @Autowired
//    private ChatModel chatModel;
//
//    public String generateRecipe(String ingredients, String cuisine, String dietaryRestrictions) {
//        String promptText = String.format(
//            "Create a detailed recipe using these ingredients: %s. " +
//            "Cuisine type: %s. " +
//            "Dietary restrictions: %s. " +
//            "Please provide: recipe name, ingredients list with quantities, step-by-step instructions, and cooking time.",
//            ingredients,
//            cuisine.isEmpty() ? "any" : cuisine,
//            dietaryRestrictions.isEmpty() ? "none" : dietaryRestrictions
//        );
//
//        try {
//            return chatModel.call(new Prompt(promptText))
//                    .getResult()
//                    .getOutput()
//                    .getContent();
//        } catch (Exception e) {
//            return "Error generating recipe: " + e.getMessage();
//        }
//    }
//}
