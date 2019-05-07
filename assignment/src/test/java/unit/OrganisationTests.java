package unit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import views.BaseView;
import views.OrganisationView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrganisationTests {
    private OrganisationView organisationView;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    public OrganisationTests() {

        organisationView = new OrganisationView();
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
        organisationView.setScanToString("input");
        Assert.assertEquals(organisationView.getName(), "input");
    }

    @Test
    public void testConvertToOrgOption() {
        try {
            Assert.assertNull(organisationView.convertToOrgOption(null));
        } catch (SQLException e) {
            organisationView.displayIncorrectInput();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testIsNameValidated() {
        organisationView.isNameValidated(null);

    }


}
