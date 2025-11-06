package com.example.mm.controllers;

import com.example.mm.repositores.CategoryRepository;
import com.example.mm.repositores.ExpenseRecordRepository;
import org.apache.el.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("/")
public class IndexController {

    private final ExpenseRecordRepository expenseRecordRepository;

    public IndexController(ExpenseRecordRepository expenseRecordRepository) {
        this.expenseRecordRepository = expenseRecordRepository;
    }


    @GetMapping
    public String index(ModelMap modelMap) {
        var expenseRecords = expenseRecordRepository.findAll();

        var expenseRecordsList = StreamSupport
                .stream(expenseRecords.spliterator(), false)
                .toList();

        modelMap.addAttribute("expenseRecords", expenseRecordsList);

        return "index";
    }
}

