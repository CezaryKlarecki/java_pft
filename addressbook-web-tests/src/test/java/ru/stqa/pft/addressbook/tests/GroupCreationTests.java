package ru.stqa.pft.addressbook.tests;

import org.testng.*;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {


    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2").withHeader("tet3").withFooter("test4");
    app.group().create(group);
    app.goTo().groupPageAgain();
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
