package ua.edu.ucu.apps.task2;

import ua.edu.ucu.apps.task2.mailCode.TRCCode;

import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    Client client = new Client("basystyi.pn@ucu.edu.ua",
        "Oleg",
        LocalDate.of(1991, 1, 1),
        "no");

    MailInfo mailInfo = new MailInfo(client, new TRCCode());

    MailSender sender = new MailSender("apiKey", "apiSecret", "senderEmail");


    MailBox box = new MailBox(sender);
    box.addMailInfo(mailInfo);
    box.sendAll();
  }
}
