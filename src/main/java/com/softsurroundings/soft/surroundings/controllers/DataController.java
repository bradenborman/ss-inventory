package com.softsurroundings.soft.surroundings.controllers;


import com.softsurroundings.soft.surroundings.models.CheckedOut;
import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
public class DataController {


    @Autowired
    private InventoryService inventoryService;

    @GetMapping("data")
    public List<CheckedOut> getData() {
        return inventoryService.readFile();
    }

    @GetMapping("scan")
    public CheckedOut add() {
        return inventoryService.scan("150", "333");
    }

}
