package com.softsurroundings.soft.surroundings.cron;

import com.softsurroundings.soft.surroundings.models.CheckedOut;
import com.softsurroundings.soft.surroundings.services.CheckoutManager;
import com.softsurroundings.soft.surroundings.services.EmailService;
import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Report {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private EmailService emailService;


    //@Scheduled(cron = "0/14 * * * * ?")
    @Scheduled(cron = "0 30 4 * * ?") //Every day at 4:30am
    public void updateNextTeamPlayingAndOddsQuick() {
        List<CheckedOut> onlyCheckedOut = CheckoutManager.clearReturnedEntries(inventoryService.getContents());
        System.out.println("Sending report and clearing returned guns");
        inventoryService.updateFile(onlyCheckedOut);
        emailService.sendEmail(onlyCheckedOut);
    }

}