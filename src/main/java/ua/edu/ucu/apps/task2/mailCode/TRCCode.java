package ua.edu.ucu.apps.task2.mailCode;

import ua.edu.ucu.apps.task2.Client;

public class TRCCode implements MailCode {
  @Override
  public String generate(Client client) {
    return String.format("Soldier %s, you have been invited to Sykhiv territorial recruitment centre",
        client.getName());

  }
}
