
/**
 * Write a description of DistanceFilter here.
 * 
 * @author StevenZ 
 * @version 05/13/20
 */
public class DistanceFilter implements Filter{
    private Location center;
    private double max;
    public DistanceFilter(Location loc, double maxDist) {
        center = loc;
        max = maxDist;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        return qe.getLocation().distanceTo(center) < max;
    }
    
    public String getName() {
        return "Distance";
    }  
}
