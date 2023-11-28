package git.foxminded.dzaimenko;

public class StartCharacterCounter {

    public static void main(String[] args) {
        CharacterCounter characterCounter = new CharacterCounter();
        String originalString = "Java is a high-level, class-based, object-oriented programming language";

        characterCounter.showResult(originalString);

    }

}