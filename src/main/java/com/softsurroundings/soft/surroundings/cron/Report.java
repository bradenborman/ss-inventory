package com.softsurroundings.soft.surroundings.cron;

import com.softsurroundings.soft.surroundings.models.CheckedOut;
import com.softsurroundings.soft.surroundings.services.CheckoutManager;
import com.softsurroundings.soft.surroundings.services.EmailService;
import com.softsurroundings.soft.surroundings.services.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Report {

    private static final Logger logger = LoggerFactory.getLogger(Report.class);

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private EmailService emailService;

    //@Scheduled(cron = "0 */30 * ? * *")
    //@Scheduled(cron = "0/14 * * * * ?") //Every 14 seconds
    @Scheduled(cron = "0 30 4 * * ?") //Every day at 4:30am
    public void updateNextTeamPlayingAndOddsQuick() {
        List<CheckedOut> onlyCheckedOut = CheckoutManager.clearReturnedEntries(inventoryService.getContents());
        System.out.println("Sending report and clearing returned guns");
        inventoryService.updateFile(onlyCheckedOut);
        emailService.sendEmail(onlyCheckedOut);
    }


    @Scheduled(cron = "0 */30 * ? * *") //At second :00, every 30 minutes starting at minute :00, of every hour
    public void logData() {
        logger.info(String.format("Application up and running. %s scanners are checked out." , inventoryService.getCheckouts().size()));
    }


}