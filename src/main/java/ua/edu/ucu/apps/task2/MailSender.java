package ua.edu.ucu.apps.task2;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.resource.Emailv31;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

@AllArgsConstructor
public class MailSender {
  private final String apiKey;
  private final String apiSecret;
  private final String fromEmail;

  public void sendEmail(MailInfo info) {
    try {
      // Set up Mailjet client
      ClientOptions options = ClientOptions.builder()
          .apiKey(apiKey)
          .apiSecretKey(apiSecret)
          .build();
      MailjetClient client = new MailjetClient(options);

      // Create email request
      MailjetRequest request = new MailjetRequest(Emailv31.resource)
          .property(Emailv31.MESSAGES, new JSONArray()
              .put(new JSONObject()
                  .put("From", new JSONObject()
                      .put("Email", fromEmail)
                      .put("Name", "ViktoKorneplod"))
                  .put("To", new JSONArray()
                      .put(new JSONObject()
                          .put("Email", info.getClientEmail())))
                  .put("Subject", "ТЦК")
                  .put("HTMLPart", info.generate())));

      MailjetResponse response = client.post(request);

      if (response.getStatus() == 200) {
        System.out.println("Email sent successfully!");
      } else {
        System.err.println("Failed to send email. Status: " + response.getStatus());
        System.err.println("Response: " + response.getData());
      }
    } catch (Exception e) {
      System.err.println("Error while sending email: " + e.getMessage());
    }
  }
}
