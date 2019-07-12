package com.softsurroundings.soft.surroundings.services;

import com.softsurroundings.soft.surroundings.models.CheckedOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;



    public void sendEmail(List<CheckedOut> onlyCheckedOut) {

               ///Acbeamer@softsurroundings.com

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            System.out.println("sending to Acbeamer@softsurroundings.com");
            helper.setTo("Acbeamer@softsurroundings.com");
            helper.setSubject("Scanner Report");
            helper.setText(buildEmailBody(onlyCheckedOut), true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }


    private String buildEmailBody(List<CheckedOut> onlyCheckedOut) {
        String x = "USERS WITH CHECKED OUT SCANNERS <br>";
        String tablePlusHeaders = "<table style='min-width: 500px;'>" +
                "<tr><th>USER ID</th><th>SCANNER ID</th><th>TIME OF SCAN</th></tr>";
        String rows = onlyCheckedOut.stream()
                .map(CheckedOut::toTableRow)
                .collect(Collectors.joining());
        String tableEnding = "</table>";
        return  getStyle().concat(x).concat(tablePlusHeaders).concat(rows).concat(tableEnding);
    }


    private String getStyle() {
        return "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>";
    }

}
