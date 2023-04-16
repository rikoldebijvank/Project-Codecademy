package test;

import app.database.DatabaseController;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxAssert;
import org.testfx.matcher.control.LabeledMatchers;

public class AddStudentControllerTest extends TestFXBase {
    private DatabaseController db = new DatabaseController();
    private static TestFXBase controller = new TestFXBase();
    private String name = "testName";
    private String email = "testemail@gmail.com";
    private String gender = "M";
    private String address = "testaddress";
    private String dateOfBirth = "01-01-2005";
    private String country = "testcountry";
    private String postalCode = "1234 AB";

    @Before
    public void goToPage() throws InterruptedException {
        clickOn("#loginPassword");
        write("codecademy");
        clickOn("#checkLogin");
        clickOn("#continueToStudents");
        clickOn("#addStudentButton");
    }

    @Test
    public void testEmptyValuesResultsInError() {
        clickOn("#createStudentButton");
        FxAssert.verifyThat("#studentSignUpError", LabeledMatchers.hasText("Please fill out the form"));
    }

    @Test
    public void testWrongEmailFormatError() {
        clickOn("#studentName");
        write(name);
        clickOn("#studentEmail");
        write("wrong@email.");
        clickOn("#studentGender");
        write(gender);
        clickOn("#studentAddress");
        write(address);
        clickOn("#studentDateOfBirth");
        write(dateOfBirth);
        clickOn("#studentCountry");
        write(country);
        clickOn("#studentPostalCode");
        write(postalCode);
        clickOn("#createStudentButton");

        FxAssert.verifyThat("#studentSignUpError", LabeledMatchers.hasText("Incorrect email format"));
    }

    @Test
    public void testBirthdayNotInThePast() {
        clickOn("#studentName");
        write(name);
        clickOn("#studentEmail");
        write(email);
        clickOn("#studentGender");
        write(gender);
        clickOn("#studentAddress");
        write(address);
        clickOn("#studentDateOfBirth");
        write("01-01-2222");
        clickOn("#studentCountry");
        write(country);
        clickOn("#studentPostalCode");
        write(postalCode);
        clickOn("#createStudentButton");

        FxAssert.verifyThat("#studentSignUpError", LabeledMatchers.hasText("Birth date has to be in the past"));
    }

    @Test
    public void testWrongInputForGender() {
        clickOn("#studentName");
        write(name);
        clickOn("#studentEmail");
        write(email);
        clickOn("#studentGender");
        write("wrongGender");
        clickOn("#studentAddress");
        write(address);
        clickOn("#studentDateOfBirth");
        write(dateOfBirth);
        clickOn("#studentCountry");
        write(country);
        clickOn("#studentPostalCode");
        write(postalCode);
        clickOn("#createStudentButton");

        FxAssert.verifyThat("#studentSignUpError", LabeledMatchers.hasText("Gender has to be either 'M' or 'F'"));
    }

    @Test
    public void testWrongInputFoPostalCode() {
        clickOn("#studentName");
        write(name);
        clickOn("#studentEmail");
        write(email);
        clickOn("#studentGender");
        write(gender);
        clickOn("#studentAddress");
        write(address);
        clickOn("#studentDateOfBirth");
        write(dateOfBirth);
        clickOn("#studentCountry");
        write(country);
        clickOn("#studentPostalCode");
        write("AAAA 10");
        clickOn("#createStudentButton");

        FxAssert.verifyThat("#studentSignUpError", LabeledMatchers.hasText("Incorrect Postal Code Format, use the format \"9999 XX\""));
    }
}
