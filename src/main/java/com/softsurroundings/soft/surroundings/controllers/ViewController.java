package com.softsurroundings.soft.surroundings.controllers;

import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private InventoryService inventoryService;


    @RequestMapping("/")
    public String getView(Model model) {
        model.addAttribute("data", inventoryService.getCheckouts());
        return "index";
    }

    @PostMapping("/scan")
    public String add(@RequestParam("userID") String userID, @RequestParam("scannerID") String scannerID) {
        inventoryService.scan(userID, scannerID);
        return "redirect:/";

    }

}
