
/**
 * Write a description of MarkovOne here.
 * 
 * @author StevenZ 
 * @version 05/12/20
 */

import java.util.*;


public class MarkovOne extends AbstractMarkovModel {
    public MarkovOne() {
        myRandom = new Random();
        order = 1;
    }

    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
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
