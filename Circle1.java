
public class Circle1 extends Circle
{

public Circle1(double x, double y, double radius)
{
   super(x,y,radius);
}

public boolean intersects(Circle other)
{
  double d;
  d = Math.sqrt(Math.pow(center.x - other.center.x, 2) +
                Math.pow(center.y - other.center.y, 2));
   if (Math.abs(center.x - other.center.x) <= (radius+other.radius) &&
       Math.abs(center.y - other.center.y) <= (radius+other.radius))
       {
         if(radius > d+other.radius)
         {
           return false; //Circle2 is inside of circle1 and its smaller so no intersect.
         }
         else if(other.radius > d+radius)
         {
           return false; //Circle1 is inside of circle2 and its smaller so no intersect.
         }
         else
         {
           return true; //Its intersecting
         }
       }
   return false;
}

}
