package com.softsurroundings.soft.surroundings.services;

import com.softsurroundings.soft.surroundings.debug.Debug;
import com.softsurroundings.soft.surroundings.models.CheckedOut;

import java.util.List;

public class CheckoutManager {


    static boolean isCheckedOut(CheckedOut scanned, List<CheckedOut> allEntries) {

        for(CheckedOut priorEntry : allEntries) {
            if(priorEntry.getUserId().equals(scanned.getUserId()) && priorEntry.getScannerId().equals(scanned.getScannerId()) && priorEntry.isCheckedOut())
                return false;
        }

        return true;
    }

    static void returnScanner(List<CheckedOut> currentData, CheckedOut newlyScanned) {
        for(CheckedOut priorEntry : currentData) {
            if(newlyScanned.getUserId().equals(priorEntry.getUserId()) && newlyScanned.getScannerId().equals(priorEntry.getScannerId()) && priorEntry.isCheckedOut())
                priorEntry.setCheckedOut(false);
        }
    }


    public static void checkout(List<CheckedOut> currentData, CheckedOut newlyScanned) {

        boolean wasAccountedFor = false;

        for(CheckedOut priorEntry : currentData) {
            if(newlyScanned.getUserId().equals(priorEntry.getUserId()) && newlyScanned.getScannerId().equals(priorEntry.getScannerId())) {
                priorEntry.setCheckedOut(true);
                wasAccountedFor = true;
            }
        }

        if(!wasAccountedFor)
            currentData.add(newlyScanned);
    }

    public static List<CheckedOut> clearReturnedEntries(List<CheckedOut> contents) {
        contents.removeIf(entry -> !entry.isCheckedOut());
        return contents;
    }
}
