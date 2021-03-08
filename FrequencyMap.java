// Aidan Loten
// 3/6/2021
// Lab 3 - Infinite Monkey Theorem

import java.util.HashMap;
import java.util.Map;

/**
 * FrequencyMap
 *
 * This class has a HashMap attribute that holds string sequences
 * and the frequencies of the next character after the sequences
 * of length k.
 * @author Aidan Loten
 */
public class FrequencyMap {

    private Map<Character, Integer> frequencies = new HashMap<>();
    int mapSize = 0;
    private String sequence;

    /**
     * Constructor
     * @param sequenceAndChar is the sequence string from text including the k + 1 char
     */
    public FrequencyMap(String sequenceAndChar) {
        this.sequence = sequenceAndChar;
    }

    /**
     * Found this from:
     *  https://stackoverflow.com/questions/81346/most-efficient-way-to-increment-a-map-value-in-java
     *  Update to Java 8
     *  If key is found, add 1 to value, else create new key with value of 1
     * @param nextChar next character after the given sequence
     */
    public void addCharacter(char nextChar) {
        frequencies.merge(nextChar, 1, Integer::sum);
        mapSize += 1;
    }

    /**
     * Gets a character from hashmap based on frequency ratio
     * @param rand randomly generated int
     * @return key character that is selected by rand variable
     */
    public char getCharacter(int rand) {

        int count = 0;

        for (char key : frequencies.keySet()) {
            count += frequencies.get(key);
            if (rand <= count) {
                return key;
            }
        }
        // This catches if sequence has not been seen
        return 0;
    }

    /**
     * Overrides toString method
     * @return String version of HashMap
     */
    @Override
    public String toString() {
        return "FrequencyMap{" +
                frequencies +
                '}';
    }

} // End of FrequencyMap class



