package test;

import app.logic.fxmlcontroller.AddStudentController;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import junit.framework.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationTest;

public class AddStudentControllerTest extends ApplicationTest {

    @Test
    void emptyLoginPasswordWhenLoggingIn() {
        AddStudentController controller = new AddStudentController();
        String signInValuePassword = "codecademy";

    }
}
