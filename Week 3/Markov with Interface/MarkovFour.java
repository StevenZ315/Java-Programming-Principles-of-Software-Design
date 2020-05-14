
/**
 * Write a description of MarkovFour here.
 * 
 * @author StevenZ 
 * @version 05/13/20
 */

import java.util.*;

public class MarkovFour extends AbstractMarkovModel {
    
    public MarkovFour() {
        order = 4;
        myRandom = new Random();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 4);
        String key = myText.substring(index, index + 4);
        sb.append(key);
        for(int k=0; k < numChars - 1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            } else {
                int randomIndex = myRandom.nextInt(follows.size());
                String text = follows.get(randomIndex);
                sb.append(text);
                key = key.substring(1) + text;
            }
        }
        
        return sb.toString();
    }

}
