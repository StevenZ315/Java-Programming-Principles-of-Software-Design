
/**
 * Write a description of Tester here.
 * 
 * @author StevenZ
 * @version 05/13/20
 */

import java.util.*;
import edu.duke.*;

public class Tester {
    void testGetFollows() {
        MarkovOne markov = new MarkovOne();
        markov.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows = markov.getFollows("t.");
        System.out.println(follows.toString());
    }
    
    void testGetFollowsWithFile() {
        MarkovOne markov = new MarkovOne();
        FileResource fr = new FileResource();
	String st = fr.asString();
	st = st.replace('\n', ' ');
        markov.setTraining(st);
        
        String key = "th";
        ArrayList<String> follows = markov.getFollows(key);
        System.out.println("There are " + follows.size() + " characters following " + key);
    }
}
