package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Statament;
import com.example.demo.Service.StatamentService;

@RestController
@RequestMapping("/statements")
public class StatamentController {

    @Autowired
    private StatamentService statamentService;

    @PostMapping("/create")
    public Statament createStatament(@RequestParam String name,@RequestParam Double amount,@RequestParam String type){
       return  statamentService.createStatament(name, amount, type);
    }

    @GetMapping("/{name}")
    public List<Statament> getAllStatamentsByName(@PathVariable String name){
        return statamentService.getAllStatamentsByName(name);
    }
}
