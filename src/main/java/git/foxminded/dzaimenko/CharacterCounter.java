package git.foxminded.dzaimenko;

import java.util.HashMap;
import java.util.Map;

public class CharacterCounter {

    private final Map<String, Map<Character, Integer>> cache = new HashMap<>();

    private boolean isStringCached(String str) {
        return cache.containsKey(str);
    }

    private Map<Character, Integer> countNumberOfCharactersAndTheirRepetitions(String str) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        for (char ch : str.toCharArray()) {
            characterCounts.put(ch, characterCounts.getOrDefault(ch, 0) + 1);
        }
        return characterCounts;
    }

    private Map<Character, Integer> selectingProcessingResult(String str) {
        if (isStringCached(str)) {
            return cache.get(str);
        }

        Map<Character, Integer> characterCounts = countNumberOfCharactersAndTheirRepetitions(str);
        cache.put(str, characterCounts);
        return characterCounts;
    }

    public String showResult(String str) {
        Map<Character, Integer> characterCounts = selectingProcessingResult(str);
        StringBuilder result = new StringBuilder();

        result.append("String: \"" + str + "\"\n");
        result.append("List of characters:\n");

        for (Map.Entry<Character, Integer> entry : characterCounts.entrySet()) {
            result.append("'" + entry.getKey() + "'" + " - " + entry.getValue() + "\n");


        }
        return result.toString();
    }

}
