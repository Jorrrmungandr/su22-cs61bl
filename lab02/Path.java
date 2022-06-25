/** A class that represents a path via pursuit curves. */
public class Path {

    private Point curr;
    private Point next;

    // TODO
    public Path(double x, double y)
    {
        next = new Point(x, y);
        curr = new Point(0, 0);
    }

    public double getCurrX()
    {
        return curr.getX();
    }

    public double getCurrY()
    {
        return curr.getY();
    }

    public double getNextX()
    {
        return next.getX();
    }

    public double getNextY()
    {
        return next.getY();
    }

    public Point getCurrentPoint()
    {
        return curr;
    }

    public void setCurrentPoint(Point point)
    {
        curr = new Point(point);
    }

    public void iterate(double dx, double dy)
    {
        setCurrentPoint(next);
        next.setX(next.getX()+dx);
        next.setY(next.getY()+dy);
    }
}
