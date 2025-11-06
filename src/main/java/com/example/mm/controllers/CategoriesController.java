package com.example.mm.controllers;

import com.example.mm.entities.Category;
import com.example.mm.repositores.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoryRepository categoryRepository;

    public CategoriesController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    public String index(ModelMap modelMap) {
        var categories = categoryRepository.findAll();

        var categoriesList = StreamSupport
                .stream(categories.spliterator(), false)
                .toList();

        modelMap.addAttribute("categories", categoriesList);
        return "categories";
    }

    @PostMapping
    public String add(Category newCategory) {
        categoryRepository.save(newCategory);

        return "redirect:/categories";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value="id") int id) {
        categoryRepository.deleteById(id);

        return "redirect:/categories";
    }
}

