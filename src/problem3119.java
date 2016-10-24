import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Created by Brian Martinez on 10/24/2016.
 */
public class problem3119 {
    // Do not instantiate.
    private problem3119() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        //int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            //if (key.length() < minlen) continue;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
            }
        }

        // store the word occurrences in a symbol table
        // ordered by frequency, not word
        ST<Integer, String> topWords = new ST<Integer, String>();
        for (String w : st.keys()) {
            topWords.put(st.get(w), w);
        }

        // print out the max frequency, then delete that key
        // to get a new max frequency in the next iteration
        StdOut.println("Top 10 word occurrences:");
        for (int i = 0; i < 10; i++) {
            int ct = topWords.max();
            StdOut.println(topWords.get(ct) + ", " + ct + " occurrences");
            topWords.delete(ct);
        }
        
    }
    
    
}
    
