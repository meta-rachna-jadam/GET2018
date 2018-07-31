import java.time.LocalDateTime;

public class ShapeUtility {
    public static double calculateDistance(Point point1, Point point2){
        double distance;
        distance = Math.sqrt(Math.pow((point1.getXPoint() - point2.getXPoint()), 2) + 
                (Math.pow((point1.getYPoint() - point2.getYPoint()), 2)));
        return distance;
    }
    public static LocalDateTime getCurrentDateAndTime(){
        LocalDateTime currentTime  = LocalDateTime.now();
        return currentTime;
    }
}
