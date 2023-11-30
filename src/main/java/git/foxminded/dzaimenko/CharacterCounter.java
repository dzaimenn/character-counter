package git.foxminded.dzaimenko;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

        String characterCountsStr = characterCounts.entrySet()
                .stream()
                .map(entry -> "'" + entry.getKey() + "'" + " - " + entry.getValue())
                .collect(Collectors.joining("\n"));

        return "String: \"" + str + "\"\n" + "List of characters:\n" + characterCountsStr + "\n";
    }

}