
public class WordGram {
    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
        myHash = toString().hashCode();
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }
    
    public int hashCode() {
        return myHash;
    }
    
    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (String word : myWords) {
            sb.append(word + " ");
        }
        return sb.toString().trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        if (this.length() != other.length()) {
            return false;
        }
        for (int k = 0; k < length(); k++) {
            if (! myWords[k].equals(other.wordAt(k))) {
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) { 
        WordGram out = new WordGram(myWords, 0, myWords.length);
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        System.arraycopy(out.myWords, 1, out.myWords, 0, out.myWords.length-1);
        out.myWords[out.myWords.length-1] = word;
        
        out.myHash = out.toString().hashCode();
        return out;
    }

}