package com.example.ex_4_hw.controller;

import com.example.ex_4_hw.model.Cat;
import com.example.ex_4_hw.repository.CatRepository;
import com.example.ex_4_hw.service.FileGatewayEx;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CatController {
    private final CatRepository catRepository;
    private final FileGatewayEx fileGateway;
    private final Counter addCatCounter = Metrics.counter("add_cat_count");
    @GetMapping("/cats")
    public String getCat(Model model){
        model.addAttribute("cats", catRepository.getCats());
        return "cats";
    }
    @PostMapping("/cats")
    public String addCat(Cat c, Model model){
        fileGateway.writeToFile(c.getName() + ".txt", c.toString());
        catRepository.addCat(c);
        model.addAttribute("cats", catRepository.getCats());
        addCatCounter.increment();
        return "cats";
    }
}
