/**
 * Point class is use to manage coordinates
 * @author Rachna Jadam
 *
 */
public class Point {
    private final int xPoint;
    private final int yPoint;
    public Point(int xPoint, int yPoint){
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }
    
    /**
     * This method is use to get x-coordinate of point
     * @return x-coordinate of point
     */
    public int getXPoint()
    {
        return this.xPoint;
    }
    
    /**
     * This method is use to get y-coordinate of point
     * @return y-coordinate of point
     */
    public int getYPoint(){
        return this.yPoint;
    }

}
