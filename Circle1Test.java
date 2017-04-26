
/***
* Example JUnit testing class for Circle1 (and Circle)
*
* - must have your classpath set to include the JUnit jarfiles
* - to run the test do:
*     java org.junit.runner.JUnitCore Circle1Test
* - note that the commented out main is another way to run tests
* - note that normally you would not have print statements in
*   a JUnit testing class; they are here just so you see what is
*   happening. You should not have them in your test cases.
***/

import org.junit.*;

public class Circle1Test
{
   // Data you need for each test case
   private Circle1 circle1;

//
// Stuff you want to do before each test case
//
@Before
public void setup()
{
   circle1 = new Circle1(1,2,3);
}

//
// Stuff you want to do after each test case
//
@After
public void teardown(){}

//
// Test a simple positive move
//
@Test
public void simpleMove()
{
   Point p;
   p = circle1.moveBy(1,1);
   Assert.assertTrue(p.x == 2 && p.y == 3);
}

//
// Test a simple negative move
//
@Test
public void simpleMoveNeg()
{
   Point p;
   p = circle1.moveBy(-1,-1);
   Assert.assertTrue(p.x == 0 && p.y == 1);
}

//
// Test Increasing the radius
//
@Test
public void scaleUp()
{
   double r;
   r = circle1.scale(2);
   Assert.assertTrue(r == 6);
}

//
// Test Keeping the radius the same with scale
//
@Test
public void scaleSame()
{
   double r;
   r = circle1.scale(1);
   Assert.assertTrue(r == 3);
}

//
// Test Decreasing the radius
//
@Test
public void scaleDown()
{
   double r;
   r = circle1.scale(.5);
   Assert.assertTrue(r == 1.5);
}

//
// Test Where a Circle is not Intersecting
//
@Test
public void NotIntersecting()
{
   boolean i;
   Circle1 circle2 = new Circle1(8,2,3);
   i = circle1.intersects(circle2);
   Assert.assertTrue(i==false);
}

//
// Test Where a Circle is Barely Intersecting with one another
//
@Test
public void BarelyIntersecting()
{
   boolean i;
   Circle1 circle2 = new Circle1(7,2,3);
   i = circle1.intersects(circle2);
   Assert.assertTrue(i==true);
}

//
// Test Where a Circle is Intersecting with one another
//
@Test
public void Intersecting()
{
   boolean i;
   Circle1 circle2 = new Circle1(6,2,3);
   i = circle1.intersects(circle2);
   Assert.assertTrue(i==true);
}

//
// Test Where a Circle is Intersecting with one another, and the center of 1 circle is inside one another.
//
@Test
public void SmallCircleInsideIntersecting()
{
   boolean i;
   Circle1 circle2 = new Circle1(1,3,2);
   i = circle1.intersects(circle2);
   Assert.assertTrue(i==true);
}

//
// Test Where a Circle is Not Intersecting with one another, and the center of 1 circle is inside one another.
//
@Test
public void SmallCircleInsideButNotIntersecting()
{
   boolean i;
   Circle1 circle2 = new Circle1(1,2,1);
   i = circle1.intersects(circle2);
   Assert.assertTrue(i==false);
}

//
// Test for Radius Less than 0 Should throw an error
//
@Test
public void MinInvalidRadius()
{
  //Circle1 circle2 = new Circle1(1,2,-1); //Should Error as It exceeds the double amount minimum
  try {
    Circle1 circle2 = new Circle1(1,2,-1); //Should Error as It exceeds the double amount minimum
    Assert.fail("A negative radius was allowed");
  } catch (Exception e) {
    Assert.assertTrue(1==1); //exception was thrown so Pass the test.
  }
}

//
// Test for Radius Greater than the Limit of Double Should throw an error
//
@Test
public void MaxInvalidRadius()
{
  try {
    double maxvalue = Double.MAX_VALUE;
    Circle1 circle2 = new Circle1(1,2,maxvalue*2); //Should Error as It exceeds the double amount limit
    System.out.println("circle2 radius 2 = " + circle2.radius);
    Assert.fail("A double plus 1 radius was allowed");
  } catch (Exception e) {
    Assert.assertTrue(1==1); //exception was thrown so Pass the test.
  }
}

/*** NOT USED
public static void main(String args[])
{
   try {
      org.junit.runner.JUnitCore.runClasses(
               java.lang.Class.forName("Circle1Test"));
   } catch (Exception e) {
      System.out.println("Exception: " + e);
   }
}
***/

}
