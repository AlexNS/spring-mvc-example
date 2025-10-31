package com.example.mm.controllers;

import com.example.mm.repositores.CategoryRepository;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/")
public class IndexController {

    private final CategoryRepository categoryRepository;

    public IndexController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping
    public String index(ModelMap modelMap) {
        var categories = categoryRepository.findAll();

        var categoriesList = StreamSupport
                .stream(categories.spliterator(), false)
                .toList();

        modelMap.addAttribute("categories", categoriesList);
        return "index";
    }
}

