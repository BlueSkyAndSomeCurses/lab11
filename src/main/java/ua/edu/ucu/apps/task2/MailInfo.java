package ua.edu.ucu.apps.task2;

import lombok.AllArgsConstructor;
import ua.edu.ucu.apps.task2.mailCode.MailCode;

@AllArgsConstructor
public class MailInfo {
  private Client client;
  private MailCode mailCode;

  public String generate() {
    return mailCode.generate(client);
  }

  public String getClientEmail() {
    return client.getEmail();
  }
}
