package ua.edu.ucu.apps.task2.mailCode;

import ua.edu.ucu.apps.task2.Client;

public class BirthdayCode implements MailCode {
  @Override
  public String generate(Client client) {
    return String.format("Your mum is beatufil %s", client.getName());
  }
}
