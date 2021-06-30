package ru.stqa.pft.sandbox;

import org.testng.*;
import org.testng.annotations.*;

public class SquareTests {
  @Test
  public void testArea() {

    Square s = new Square(5);
    Assert.assertEquals(s.area(), 20);

  }

}
