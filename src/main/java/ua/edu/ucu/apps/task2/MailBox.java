package ua.edu.ucu.apps.task2;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
  public final MailSender sender;
  List<MailInfo> infos = new ArrayList<>();

  MailBox(MailSender sender) {
    this.sender = sender;
  }

  void addMailInfo(MailInfo mailInfo) {
    infos.add(mailInfo);
  }

  void sendAll() {
    for (MailInfo info : infos) {
      sender.sendMail(info);
    }
  }
}
