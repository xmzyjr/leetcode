
package feture.ms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanshan
 */
public class M1602 {

    class WordsFrequency {

        private Map<String, Integer> wordMap;

        public WordsFrequency(String[] book) {
            if (book == null || book.length == 0)
                return;
            wordMap = new HashMap<>(book.length);
            for (String word : book) {
                Integer integer = wordMap.get(word);
                if (integer == null)
                    integer = 1;
                else
                    integer++;
                wordMap.put(word, integer);
            }
        }

        public int get(String word) {
            if (word == null || word.length() == 0)
                return 0;
            Integer integer = wordMap.get(word);
            if (integer == null)
                return 0;
            else
                return integer;
        }
    }

}
