package unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import views.BaseView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BaseTests {
    private BaseView baseView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    public BaseTests() {

        baseView = new BaseView();
    }

    @Before
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void teardown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void testGetInputSuccess() {
        baseView.setScanToString("input");
        Assert.assertEquals(baseView.getInput(), "input");
    }

    @Test
    public void testGetIntInputSuccess() {
        baseView.setScanToString("1");
        Assert.assertEquals(baseView.getIntInput(), 1);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetIntInputException() {
        baseView.setScanToString("sdf");
        baseView.getIntInput();
    }

    @Test(expected = RuntimeException.class)
    public void validateNotNullStringNull() {
        baseView.validateNotNullString(null);
    }

    @Test(expected = RuntimeException.class)
    public void validateNotNullStringEmpty() {
        baseView.validateNotNullString("");
    }

    @Test
    public void validateNotNullStringSuccess() {
        baseView.validateNotNullString("string");
    }

    @Test
    public void displayErrorSuccess() {
        baseView.displayError("message");
        Assert.assertEquals(output.toString().trim(), "Error: message");
    }

    @Test
    public void displayConfirmationSuccess() {
        baseView.displayConfirmation("message");
        Assert.assertEquals(output.toString().trim(), "Please confirm: message");
    }

    @Test
    public void displaySuccessSuccess() {
        baseView.displaySuccess("message");
        Assert.assertEquals(output.toString().trim(), "Success: message");
    }

    @Test
    public void displayIncorrectInputSuccess() {
        baseView.displayIncorrectInput();
        Assert.assertEquals(output.toString().trim(), "Error: Input is incorrect");
    }

    @Test
    public void displayOutOfBoundsSuccess() {
        baseView.displayOutOfBounds();
        Assert.assertEquals(output.toString().trim(), "Error: Input is out of bounds");
    }

}
