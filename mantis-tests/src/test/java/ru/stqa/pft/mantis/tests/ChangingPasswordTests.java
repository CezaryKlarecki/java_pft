package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.appmanager.HelperBase;
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
      String email = "user1@localhost.localdomain";


      List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
      String confirmationLink = findChangingPasswordLink(mailMessages, email);
      app.changingPassword().reset(confirmationLink);
      app.changingPassword().finish(confirmationLink, newPassword);
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