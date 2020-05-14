
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int order;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
    
    protected ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        
        while (pos < myText.length()) {
            int index = myText.indexOf(key, pos);
            if (index == -1 || index + key.length() >= myText.length()) {
                break;
            } else {
                follows.add(myText.substring(index + key.length(), index + key.length() + 1));
                pos = index + key.length();
            }
        }
        return follows;
    }
    
    abstract public String getRandomText(int numChars);
    
    public String toString(){
        return "MarkovModel with order " + order;
    }
}
