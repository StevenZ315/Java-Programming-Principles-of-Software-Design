
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author StevenZ
 * @version 05/13/20
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel{
    private HashMap<String, ArrayList<String>> followsMap;
    
    public EfficientMarkovModel(int keyLength) {
        myRandom = new Random();
        order = keyLength;
        followsMap = new HashMap<String, ArrayList<String>>();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
        buildMap();
        //printHashMapInfo();
    }
    
    private void buildMap() {
        followsMap.clear();
        if (order == 0) return;
        
        for (int i = 0; i < myText.length() - order + 1; i++) {
            String key = myText.substring(i, i + order);
            if (! followsMap.containsKey(key)) {
                followsMap.put(key, super.getFollows(key));
            }
        }
    }
    
    protected ArrayList<String> getFollows (String key) {
        return followsMap.getOrDefault(key, new ArrayList<String>());
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
    
    void printHashMapInfo() {
        if (followsMap.keySet().size() < 15) {
            for (String key : followsMap.keySet())
                System.out.println(key + ": " + followsMap.get(key));
        }

        System.out.println("map has "+followsMap.keySet().size()+" keys.");
        int biggest = largestValue();
        System.out.println("size of largest array = "+biggest);
        System.out.println("keys of that size:");
        for (String key : followsMap.keySet()) {
            if (biggest == followsMap.get(key).size())
                System.out.println("'"+key+"'");
        }
        System.out.println("==============");
    }

    private int largestValue () {
        int largestSize = 0;
        for (String key : followsMap.keySet()) {
            int thisSize = followsMap.get(key).size();
            if (thisSize > largestSize)
                largestSize = thisSize;
        }
        return largestSize;
    }
    
    public String toString() {
        return "EfficientMarkovModel with order of " + order;
    }
}
