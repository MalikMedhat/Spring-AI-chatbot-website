package com.ai.springai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenAIController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ImageService imageService;

    // ─── Home page ───────────────────────────────────────────────
    @GetMapping("/")
    public String home() {
        return "redirect:/chat";
    }

    // ─── CHAT ────────────────────────────────────────────────────
    @GetMapping("/chat")
    public String chatPage() {
        return "chat";
    }

    @PostMapping("/chat")
    public String askChat(@RequestParam String prompt, Model model) {
        String response = chatService.chat(prompt);
        model.addAttribute("prompt", prompt);
        model.addAttribute("response", response);
        return "chat";
    }

    // ─── RECIPE GENERATOR ────────────────────────────────────────
    @GetMapping("/recipe")
    public String recipePage() {
        return "recipe";
    }

    @PostMapping("/recipe")
    public String generateRecipe(
            @RequestParam String ingredients,
            @RequestParam(defaultValue = "") String cuisine,
            @RequestParam(defaultValue = "") String dietaryRestrictions,
            Model model) {

        String recipe = recipeService.generateRecipe(ingredients, cuisine, dietaryRestrictions);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("cuisine", cuisine);
        model.addAttribute("dietaryRestrictions", dietaryRestrictions);
        model.addAttribute("recipe", recipe);
        return "recipe";
    }

    // ─── IMAGE GENERATOR ─────────────────────────────────────────
    @GetMapping("/image")
    public String imagePage() {
        return "image";
    }

    @PostMapping("/image")
    public String generateImage(@RequestParam String prompt, Model model) {
        String imageUrl = imageService.generateImageUrl(prompt);
        model.addAttribute("prompt", prompt);
        model.addAttribute("imageUrl", imageUrl);
        return "image";
    }
}
