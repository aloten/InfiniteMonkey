// Aidan Loten
// 3/6/2021
// Lab 3 - Infinite Monkey Theorem

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * SequenceTable
 * This class has a HashMap whose keys are sequences and values
 * are FrequencyMap HashMaps.
 * Has methods that help build HashMap and
 * generate the next character for new text.
 * @author Aidan Loten
 */
public class SequenceTable {

    // Initialize HashMap
    private Map<String, FrequencyMap> maps = new HashMap<>();
    // a reusable random number generator
    private static final Random rand = new Random();
    private int k;
    static final int ALPHA_SIZE = 26;

    /**
     * Constructor
     * @param k length of sequence
     */
    public SequenceTable(int k) {
        this.k = k;
    }

    /**
     * If a HashMap key sequence already exists with a non null
     * FrequencyMap, then update frequency.
     * Else, create a new Hashmap entry, which involves initializing
     * a new FrequencyMap pair.
     * @param sequenceAndChar sequence string plus character in question
     */
    public void addString(String sequenceAndChar) {
        String key = sequenceAndChar.substring(0, k);
        char nextChar = sequenceAndChar.charAt(k);
        FrequencyMap value = maps.get(key);

        if (value != null) {
            value.addCharacter(nextChar);
        }
        else {
            value = new FrequencyMap(key);
            maps.put(key, value);
            value.addCharacter(nextChar);
        }
    } // end addString method

    /**
     * Get the next character by passing a random into to getCharacter method in FrequencyMap
     * Return a random char if sequence does not exist in maps HashMap.
     * @param sequence of length k
     * @return the next character selected
     */
    public char getNextCharacter(String sequence) {
        try {
            int random = rand.nextInt(maps.get(sequence).mapSize);
            char nextCharacter = maps.get(sequence).getCharacter(random);
            return nextCharacter;
        } catch (NullPointerException e) {
            return randomChar();
        }
    }

    /**
     * Generate a random letter from 'a' to 'z'.
     * @return The random character.
     */
    private static char randomChar() {
        return (char) (rand.nextInt(ALPHA_SIZE) + 'a');
    }

    /**
     * String override.
     * @return maps HashTable in viewable form.
     */
    @Override
    public String toString() {
        return "SequenceTable{" +
                "maps=" + maps +
                '}';
    }

} // End of SequenceTable class
