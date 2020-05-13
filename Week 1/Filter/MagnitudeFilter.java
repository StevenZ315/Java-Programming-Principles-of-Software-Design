
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author StevenZ
 * @version 05/13/20
 */
public class MagnitudeFilter implements Filter{
    private double min;
    private double max;
    public MagnitudeFilter(double minMag, double maxMag) {
        min = minMag;
        max = maxMag;
    }
    
    public boolean satisfies (QuakeEntry qe) {
        return (qe.getMagnitude() >= min && qe.getMagnitude() <= max);
    }
    
    public String getName() {
        return "Magnitude";
    }  
}
