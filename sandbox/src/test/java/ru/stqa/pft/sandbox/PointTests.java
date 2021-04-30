package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(1,3);
    Point p2 = new Point(5,6);
    Assert.assertEquals(p1.distance(p2), 5.0);

    Point p3 = new Point(6,7);
    Point p4 = new Point(9,1);
    Assert.assertEquals(p3.distance(p4), 6.708203932499369);

    Point p5 = new Point(5,3);
    Point p6 = new Point(2,2);
    Assert.assertEquals(p5.distance(p6), 3.1622776601683795);

  }
}
