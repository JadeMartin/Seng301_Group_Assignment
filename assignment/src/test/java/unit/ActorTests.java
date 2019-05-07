package unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import views.ActorView;
import views.BaseView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ActorTests {
    private ActorView actorView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    public ActorTests() {
        actorView = new ActorView();
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
    public void getFirstNameSuccess() {
        actorView.setScanToString("John");
        Assert.assertEquals(actorView.getFirstName(), "John");
    }

    @Test
    public void getFirstNameNull() {
        actorView.setScanToString("\n");
        Assert.assertEquals(actorView.getFirstName(), null);
    }

    @Test
    public void getLastNameSuccess() {
        actorView.setScanToString("Smith");
        Assert.assertEquals(actorView.getLastName(), "Smith");
    }

    @Test
    public void getLastNameNull() {
        actorView.setScanToString("\n");
        Assert.assertEquals(actorView.getLastName(), null);
    }

//    @Test
//    public void convertHomonymSuccess() {
//        Assert.assertTrue(actorView.);
//    }


}
