package ru.stqa.pft.sandbox;

public class PointMainClass {

  public static void main(String[] args) {

    Point p1 = new Point(3, 4);
    Point p2 = new Point(7, 11);

    System.out.println("Odległość między punktami (" + p1.x1 + "," + p1.y1 + ") i (" + p2.x1+ "," + p2.y1+ ") = " + distance(p1,p2));
}


  public static double distance(Point p1, Point p2) {
    return Math.sqrt(Math.pow((p2.x1- p1.x1),2) + Math.pow((p2.y1 - p1.y1),2));


  }
}


