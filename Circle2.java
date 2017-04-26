

public class Circle2 extends Circle
{

public Circle2(double x, double y, double radius)
{
   super(x,y,radius); //Change x and y back around, they were in wrong position.
}

public boolean intersects(Circle other)
{
   double d;
   d = Math.sqrt(Math.pow(center.x - other.center.x, 2) +
                 Math.pow(center.y - other.center.y, 2));
   if (d <= (radius+other.radius))
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
   else
      return false;
}

}
