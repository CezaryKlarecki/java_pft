package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ChangingPasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() throws IOException, MessagingException {
    app.mail().start();
  }

    @Test
    public void testChangingPassword() throws IOException, MessagingException {
      String email = "user1@localhost";
      String user = ("user1");
      List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
      String confirmationLink = findChangingPasswordLink(mailMessages, email);
      app.changingPassword().reset(confirmationLink);
      String newPassword = "password1";
      app.changingPassword().finish(confirmationLink);
      assertTrue(app.newSession().login(user, newPassword));
    }


  private String findChangingPasswordLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}