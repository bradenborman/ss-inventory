package com.softsurroundings.soft.surroundings.services;

import com.softsurroundings.soft.surroundings.models.CheckedOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;



    public void sendEmail(List<CheckedOut> onlyCheckedOut) {

        String result = onlyCheckedOut.stream()
                .map(CheckedOut::toString)
                .collect( Collectors.joining( "\n" ) );

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("Acbeamer@softsurroundings.com");

        msg.setSubject("Scanners still checked out");
        msg.setText(buildEmailBody(onlyCheckedOut));

        javaMailSender.send(msg);

    }

    private String buildEmailBody(List<CheckedOut> onlyCheckedOut) {

        String x = "NOTES FOR ADAM: you might have to set up an email account for this. Stilling looking but obv dont have like a server that I can just use. " +
                "Able to user a GMAIL account though. This was run automatically early this morning. \n\n\n USERS WITH CHECKED OUT SCANNERS \n\n";

        return x + onlyCheckedOut.stream()
                .map(CheckedOut::toString)
                .collect( Collectors.joining( "\n" ) );

    }

}
