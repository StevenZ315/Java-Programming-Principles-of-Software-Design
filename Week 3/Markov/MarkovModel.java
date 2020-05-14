
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int length;
    
    public MarkovModel(int keyLength) {
        myRandom = new Random();
        length = keyLength;
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        
        while (pos < myText.length()) {
            int index = myText.indexOf(key, pos);
            if (index == -1 || index + length >= myText.length()) {
                break;
            } else {
                follows.add(myText.substring(index + length, index + length + 1));
                pos = index + key.length();
            }
        }
        return follows;
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - length);
        String key = myText.substring(index, index + length);
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

