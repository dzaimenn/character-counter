package git.foxminded.dzaimenko;

public class StartCharacterCounter {

    public static void main(String[] args) {
        CharacterCounter characterCounter = new CharacterCounter();
        String originalString = "Task 1.4 Collection Framework";

        System.out.println(characterCounter.showResult(originalString));

    }

}