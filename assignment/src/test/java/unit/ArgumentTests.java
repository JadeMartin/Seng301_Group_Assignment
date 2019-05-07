package unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import views.ArgumentView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArgumentTests {
    private ArgumentView argumentView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    public ArgumentTests() {

        argumentView = new ArgumentView();
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
    public void testGetRephrasing (){
        argumentView.setScanToString("input");
        Assert.assertEquals(argumentView.getRephrasing(), "input");
    }

    @Test
    public void testGetStart() {
        argumentView.setScanToString("1");
        Assert.assertEquals(argumentView.getStart(), "1");
    }

    @Test
    public void testGetEnd() {
        argumentView.setScanToString("2");
        Assert.assertEquals(argumentView.getEnd(), "2");
    }

    @Test
    public void testGetArgumentTwo() {
        argumentView.setScanToString("4");
        Assert.assertEquals(argumentView.getArgumentTwo(), "4");
    }

    @Test
    public void testGetArgumentLink(){
        argumentView.setScanToString("2");
        Assert.assertEquals(argumentView.getArgumentLink(), "2");
    }

    @Test (expected = RuntimeException.class)
    public void testValidateWrongIndexOrder(){
        argumentView.validateIndexOrder(2, 1);
    }

    @Test (expected = RuntimeException.class)
    public void testValidateSameIndexOrder(){
        argumentView.validateIndexOrder(2, 2);
    }

    @Test
    public void testValidateIndexOrder(){
        argumentView.validateIndexOrder(2, 3);
    }

    @Test
    public void testValidateNotSameArgument(){
        argumentView.validateNotSameArgument(1, 2);
    }

    @Test (expected = RuntimeException.class)
    public void testValidateSameArgument(){
        argumentView.validateNotSameArgument(1, 1);
    }

    @Test
    public void testConvertToZero(){
        Assert.assertEquals(argumentView.convertTo("1"), 1);
    }

    @Test
    public void testConvertToTrue(){
        Assert.assertEquals(argumentView.convertTo("0"), 0);
    }


    @Test (expected = RuntimeException.class)
    public void testConvertToNegative(){
        argumentView.convertTo("-1");
    }

    @Test (expected = RuntimeException.class)
    public void testConvertToBool(){
        argumentView.convertToBool("3");
    }

    @Test
    public void testConvertToBoolTrue(){
        Assert.assertEquals(argumentView.convertToBool("1"), true);
    }

    @Test
    public void testConvertToBoolFalse(){
        Assert.assertEquals(argumentView.convertToBool("2"), false);
    }


}
