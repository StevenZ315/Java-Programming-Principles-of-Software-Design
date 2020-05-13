
/**
 * Write a description of LargestQuakes here.
 * 
 * @author StevenZ
 * @version 05/13/20
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for " + list.size());
        
        ArrayList<QuakeEntry> bigQuakes = getLargest(list, 5);
        for (QuakeEntry qe : bigQuakes) {
            System.out.println(qe); 
        }
    }
    
    private int indexOfLargest(ArrayList<QuakeEntry> quakeData) {
        int retIndex = 0;
        double magnitude = 0.0;
        
        for (int k=0; k < quakeData.size(); k++) {
            QuakeEntry qe = quakeData.get(k);
            if (qe.getMagnitude() > magnitude) {
                retIndex = k;
                magnitude = qe.getMagnitude();
            }
        }
        return retIndex;
    }
    
    ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        
        for (int k=0; k < howMany; k++) {
            int index = indexOfLargest(copy);
            answer.add(copy.get(index));
            copy.remove(index);
        }
        return answer;
    }
}
