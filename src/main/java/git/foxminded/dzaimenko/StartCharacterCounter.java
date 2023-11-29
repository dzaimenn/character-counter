package git.foxminded.dzaimenko;

public class StartCharacterCounter {

    public static void main(String[] args) {
        CharacterCounter characterCounter = new CharacterCounter();

        String str1 = "Task 1.4 Collection Framework";
        String str2 = "Java is a high-level, class-based, object-oriented programming language";
        String str3 = "Task 1.4 Collection Framework";

        System.out.println(characterCounter.showResult(str1));
        System.out.println(characterCounter.showResult(str2));
        System.out.println(characterCounter.showResult(str3));

    }

}