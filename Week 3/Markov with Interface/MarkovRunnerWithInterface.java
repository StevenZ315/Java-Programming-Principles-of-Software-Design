
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size) {
        markov.setTraining(text);
        markov.setRandom(621);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size);

    }
    
    void testHashMap () {
        EfficientMarkovModel e = new EfficientMarkovModel(5);
        e.setRandom(615);
        FileResource fr = new FileResource("data/romeo.txt");
        String st = fr.asString().replace('\n', ' ');
        e.setTraining(st);
        e.printHashMapInfo();
    }
    
    void compareMethods() {
        int order = 2;
        int seed = 42;
        int outputLen = 1000;
        FileResource fr = new FileResource("data/hawthorne.txt");
        //FileResource fr = new FileResource("../data/romeo.txt");
        String st = fr.asString().replace('\n', ' ');

        MarkovModel m = new MarkovModel(order);
        EfficientMarkovModel e = new EfficientMarkovModel(order);

        long start = System.nanoTime();
        runModel(m, st, outputLen);
        long end = System.nanoTime();
        System.out.println(m.toString()+" took "+(end-start)/1000000000.0+" seconds");
        System.out.println("==================================");
        start = System.nanoTime();
        runModel(e, st, outputLen);
        end = System.nanoTime();
        System.out.println(e.toString()+" took "+(end-start)/1000000000.0+" seconds");
    }

    
    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
