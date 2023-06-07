package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDie(){
        return "roll-dice";
    }

    @GetMapping ("/roll-dice/{n}")
    public String diceRolled(@PathVariable int n, Model model) {
        Random rand = new Random();
        int randNum = rand.nextInt(7);
        model.addAttribute("guess", n);
        model.addAttribute("rand", randNum);
        return "result";
    }
}
