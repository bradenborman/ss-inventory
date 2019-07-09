package com.softsurroundings.soft.surroundings.cron;

import com.softsurroundings.soft.surroundings.models.CheckedOut;
import com.softsurroundings.soft.surroundings.services.CheckoutManager;
import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Report {

    @Autowired
    InventoryService inventoryService;


    @Scheduled(cron = "0/30 * * * * ?")
    public void updateNextTeamPlayingAndOddsQuick() {
        List<CheckedOut> onlyCheckedOut = CheckoutManager.clearReturnedEntries(inventoryService.getContents());
        System.out.println("Sending report and clearing returned guns");
        inventoryService.updateFile(onlyCheckedOut);
    }


//    @Scheduled(cron = "0 0 8 * * ?") //Every day at 8am
//    public void updateNextTeamPlayingAndOdds() {
//        logger.info("Scheduled task hit: updateTeamsPlayingToday.");
//        sportsDataApiService.updateTeamsPlayingToday();
//    }


}