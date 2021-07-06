package ru.stqa.pft.rest;


import com.google.gson.Gson;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  private WebDriver wd;

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  private boolean isIssueOpen(int issueId) throws IOException {
    Issue issue = getIssue(7350);
    return issue.getState().equalsIgnoreCase("Open");
  }

  private Issue getIssue(int issueId) throws IOException {
    String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/" + issueId + ".json"))
            .returnContent().asString();
    Issue issue = new Gson().fromJson(json, Issue.class);
    //return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    return issue;
  }


  private Executor getExecutor() {
    return Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed", "");
  }
}
