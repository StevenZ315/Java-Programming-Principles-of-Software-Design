
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author StevenZ
 * @version 05/13/20
 */

import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2) {

        String q1Info = q1.getInfo();
        String q2Info = q2.getInfo();
        if (q1Info == null) q1Info = "";
        if (q2Info == null) q2Info = "";

        int infoTest = lastWord(q1Info).compareTo(lastWord(q2Info));
        return (infoTest != 0) ? infoTest : Double.compare(q1.getMagnitude(), q2.getMagnitude());
    }

    private String lastWord (String s) {
        String[] words = s.split("\\W",0);
        return (words.length == 0) ? s : words[words.length-1];
    }
}
