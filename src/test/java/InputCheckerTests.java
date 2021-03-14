import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.example.utils.InputChecker;

import java.util.ArrayList;
import java.util.List;

public class InputCheckerTests {

    @Test
    @DisplayName("isUsername_correctInput_true")
    public void isUsername_correctInput() {
        String correctUsername = "Claus";
        Assertions.assertTrue(InputChecker.isUsername(correctUsername));
    }

    @Test
    @DisplayName("isUsername_nullInput_false")
    public void isUsername_nullInput() {
        Assertions.assertFalse(InputChecker.isUsername(null));
    }
    
    @Test
    @DisplayName("isUsername_incorrectInputs_false")
    public void isUsername_incorrectInputs() {
        List<String> incorrectInputs = new ArrayList<>() {{
            add("");
            add("~adidas");
            add("привет");
            add("@");
            add("01234567891234567");
            add("abcdefghhijklmnop");
        }};

        incorrectInputs.forEach(str -> Assertions.assertFalse(InputChecker.isUsername(str)));
    }

    @Test
    @DisplayName("isEmail_correctInput_true")
    public void isEmail_correctInput() {
        String correctEmail = "manbear@pig.com";
        Assertions.assertTrue(InputChecker.isEmail(correctEmail));
    }

    @Test
    @DisplayName("isEmail_nullInput_false")
    public void isEmail_nullInput() {
        Assertions.assertFalse(InputChecker.isEmail(null));
    }

    @Test
    @DisplayName("isEmail_incorrectInputs_false")
    public void isEmail_incorrectInputs() {
        List<String> incorrectInputs = new ArrayList<>() {{
            add("");
            add("adidas");
            add("привет");
            add("@");
            add("@mail.com");
            add("01234567891234567@gmail.com");
            add("abcdefghhijklmnop@gmail.com");
            add("mew@abcdefghhijklmnop.com");
            add("@01234567891234567.com");
            add("manbear@pigcom");
            add("manbear@pig.");
            add("manbear@pig.a");
            add("manbear@pig.aaaa");
            add("manbear@pig.куп");
            add("manbear@pig.~^g");
            add("~@#$%^&*()@pig.com");
            add("manbear@@#@%.com");
        }};

        incorrectInputs.forEach(str -> Assertions.assertFalse(InputChecker.isEmail(str)));
    }

    @Test
    @DisplayName("isPhoneNumber_correctInput_true")
    public void isPhoneNumber_correctInput() {
        String correctPhoneNumber = "+7 (952) 265-5119";
        Assertions.assertTrue(InputChecker.isPhoneNumber(correctPhoneNumber));
    }

    @Test
    @DisplayName("isPhoneNumber_nullInput_false")
    public void isPhoneNumber_nullInput() {
        Assertions.assertFalse(InputChecker.isPhoneNumber(null));
    }

    @Test
    @DisplayName("isPhoneNumber_incorrectInputs_false")
    public void isPhoneNumber_incorrectInputs() {
        List<String> incorrectInputs = new ArrayList<>() {{
            add("+7(952) 265-5119");
            add("+7 (952)265-5119");
            add("+7 (952) 2655119");
            add("+7 (952) 265 51-19");
            add("+7 952 265 51 19");
            add("+8 (952) 265 5119");
            add("7 (952) 265 5119");
            add("+7 (952) 265 51191");
            add("+7 952) 265 51191");
            add("+7 (952 265 51191");
            add("+79522655119");
            add("89522655119");
            add("8952 265 51-19");
            add("8 952 265 51-19");
            add("8 952 265 5119");
            add("8 952 265 51-19");
            add("8-952-265-51-19");
            add("12");
            add("cat");
            add("кот");
            add("№;%");
        }};

        incorrectInputs.forEach(str -> Assertions.assertFalse(InputChecker.isPhoneNumber(str)));
    }
}
