package com.softsurroundings.soft.surroundings.controllers;


import com.softsurroundings.soft.surroundings.models.CheckedOut;
import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DataController {


    @Autowired
    private InventoryService inventoryService;

    @GetMapping("data")
    public List<CheckedOut> getData() {
        return inventoryService.readFile();
    }


}
