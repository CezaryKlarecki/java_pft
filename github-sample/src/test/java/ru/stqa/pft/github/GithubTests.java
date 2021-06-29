package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

  @Test
  public void testCommits() throws IOException {
    Github github = new RtGithub("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");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("CezaryKlarecki", "java_pft")).commits();
    for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
