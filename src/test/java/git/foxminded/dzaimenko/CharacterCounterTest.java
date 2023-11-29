package git.foxminded.dzaimenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterCounterTest {

    @Test
    void testCountCharactersInSimpleString() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: "java"
                List of characters:
                'a' - 2
                'v' - 1
                'j' - 1
                """;
        String actual = counter.showResult("java");

        assertEquals(expected, actual);
    }

    @Test
    void testCountCharactersInStringWithSpaces() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: "java language"
                List of characters:
                ' ' - 1
                'a' - 4
                'u' - 1
                'e' - 1
                'v' - 1
                'g' - 2
                'j' - 1
                'l' - 1
                'n' - 1
                """;
        String actual = counter.showResult("java language");

        assertEquals(expected, actual);
    }

    @Test
    void testCountCharactersInStringWithNumbersAndSymbols() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: "java17@! language!!"
                List of characters:
                '@' - 1
                ' ' - 1
                'a' - 4
                '!' - 3
                'e' - 1
                'g' - 2
                'j' - 1
                'l' - 1
                'n' - 1
                '1' - 1
                'u' - 1
                'v' - 1
                '7' - 1
                """;
        String actual = counter.showResult("java17@! language!!");

        assertEquals(expected, actual);
    }

    @Test
    void testCountCharactersIsCaseSensitive() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: "Object-Oriented Programming"
                List of characters:
                ' ' - 1
                'a' - 1
                'b' - 1
                'c' - 1
                'd' - 1
                'e' - 3
                'g' - 2
                'i' - 2
                'j' - 1
                '-' - 1
                'm' - 2
                'n' - 2
                'O' - 2
                'o' - 1
                'P' - 1
                'r' - 3
                't' - 2
                """;
        String actual = counter.showResult("Object-Oriented Programming");

        assertEquals(expected, actual);
    }

    @Test
    void testCountCharactersInEmptyString() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: ""
                List of characters:
                """;
        String actual = counter.showResult("");

        assertEquals(expected, actual);
    }

    @Test
    void testCountCharactersInStringWithUnicodeCharacters() {
        CharacterCounter counter = new CharacterCounter();

        String expected = """
                String: "→→←↑→↑"
                List of characters:
                '←' - 1
                '↑' - 2
                '→' - 3
                """;
        String actual = counter.showResult("→→←↑→↑");

        assertEquals(expected, actual);
    }

    @Test
    void testRepeatedStringProcessingUsesCache() {
        CharacterCounter counter = new CharacterCounter();
        String testString = "This is a very long line that extends beyond the " +
                "screen limits and creates reading inconvenience if not divided.";

        long startTime = System.nanoTime();
        counter.showResult(testString);
        long firstCallDuration = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        counter.showResult(testString);
        long secondCallDuration = System.nanoTime() - startTime;

        assertTrue(secondCallDuration < firstCallDuration);

    }

}