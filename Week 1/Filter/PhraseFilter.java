
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    private String type;
    private String text;
    public PhraseFilter(String loc, String phrase) {
        type = loc;
        text = phrase;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        String title = qe.getInfo();
        int titleIndex = title.indexOf(text);
        return ((type == "start" && titleIndex == 0) || 
                (type == "end" && titleIndex == title.length() - text.length()) || 
                (type == "any" && titleIndex != -1));
    }      
    
    public String getName() {
        return "Phrase";
    }  
}
