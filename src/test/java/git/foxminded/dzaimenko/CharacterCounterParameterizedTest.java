package git.foxminded.dzaimenko;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterCounterParameterizedTest {

    @ParameterizedTest
    @MethodSource("provideStringsForTest")
    void testCharacterCounter(String input, String expected) {
        CharacterCounter counter = new CharacterCounter();
        String actual = counter.showResult(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of("java", """
                        String: "java"
                        List of characters:
                        'a' - 2
                        'v' - 1
                        'j' - 1
                        """),
                Arguments.of("java language", """
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
                        """),
                Arguments.of("java17@! language!!", """
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
                        """),
                Arguments.of("Object-Oriented Programming", """
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
                        """),
                Arguments.of("", """
                        String: ""
                        List of characters:
                        """),
                Arguments.of("→→←↑→↑", """
                        String: "→→←↑→↑"
                        List of characters:
                        '←' - 1
                        '↑' - 2
                        '→' - 3
                        """)
        );
    }

}
