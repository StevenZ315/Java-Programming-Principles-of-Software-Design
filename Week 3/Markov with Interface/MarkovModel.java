
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovModel extends AbstractMarkovModel {
    public MarkovModel(int keyLength) {
        myRandom = new Random();
        order = keyLength;
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - order);
        String key = myText.substring(index, index + order);
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

