package com.softsurroundings.soft.surroundings.services;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softsurroundings.soft.surroundings.models.CheckedOut;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Component
public class InventoryService {

    static Logger log = Logger.getLogger(InventoryService.class.getName());


    public List<CheckedOut> readFile() {
        return getContents();
    }

    public List<CheckedOut> getCheckouts() {
        List<CheckedOut> all = getContents();
        CheckoutManager.clearReturnedEntries(all);
        return all;
    }


    public List<CheckedOut> getContents() {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = DirectoryManager.createIfNecessary();

        try {
            return objectMapper.readValue(file, new TypeReference<List<CheckedOut>>() {});
        } catch (IOException e) {
            return new ArrayList<CheckedOut>();
        }
    }

    public void updateFile(List<CheckedOut> newCheckedOut) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileWriter(DirectoryManager.createIfNecessary()), newCheckedOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void scan(String userId, String scannerId) {

        log.info(String.format("New Scan: %s | %s", userId, scannerId));

        List<CheckedOut> currentData = getContents();
        CheckedOut newlyScanned = getNewCheckedOut(userId, scannerId, currentData);


        if(newlyScanned.isCheckedOut())
            CheckoutManager.checkout(currentData, newlyScanned);
       else
            CheckoutManager.returnScanner(currentData, newlyScanned);

        updateFile(currentData);
    }



    private CheckedOut getNewCheckedOut(String userId, String scannerId, List<CheckedOut> currentData) {
        CheckedOut newCheckedOut = new CheckedOut();
        newCheckedOut.setScannerId(scannerId);
        newCheckedOut.setUserId(userId);
        newCheckedOut.setLastTimeScanned(LocalDateTime.now());
        newCheckedOut.setCheckedOut(CheckoutManager.isCheckedOut(newCheckedOut, currentData));
        return newCheckedOut;
    }

}


