package unit;

import controllers.AffiliationController;
import models.Affiliation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import views.ActorView;
import views.AffiliationView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AffiliationTests {
    private AffiliationView affiliationView;
    private AffiliationController affiliationController;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();


    public AffiliationTests() {
        affiliationView = new AffiliationView();
        affiliationController = new AffiliationController();
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
    public void getRoleSuccess() {
        affiliationView.setScanToString("role");
        Assert.assertEquals(affiliationView.getRole(), "role");
    }

    @Test
    public void getRoleNull() {
        affiliationView.setScanToString("\n");
        Assert.assertEquals(affiliationView.getRole(), null);
    }

    @Test
    public void getStartDateSuccesss() {
        affiliationView.setScanToString("12/12/12");
        Assert.assertEquals(affiliationView.getStartDate(), "12/12/12");
    }

    @Test
    public void getStartDateNull() {
        affiliationView.setScanToString("\n");
        Assert.assertEquals(affiliationView.getStartDate(), null);
    }

    @Test
    public void getEndDateSuccesss() {
        affiliationView.setScanToString("12/12/12");
        Assert.assertEquals(affiliationView.getEndDate(), "12/12/12");
    }

    @Test
    public void getEndDateNull() {
        affiliationView.setScanToString("\n");
        Assert.assertEquals(affiliationView.getEndDate(), null);
    }

    @Test
    public void convertToDateSuccess() throws ParseException {
        Assert.assertEquals(affiliationView.convertToDate("12/12/12"), new SimpleDateFormat("dd/MM/yyyy").parse("12/12/12"));
    }

    @Test
    public void convertToDateNull() throws ParseException {
        Assert.assertEquals(affiliationView.convertToDate(null), null);
    }

    @Test (expected = ParseException.class)
    public void convertToDateError() throws ParseException {
        affiliationView.convertToDate("string");
    }

    @Test
    public void displaySuccess() {
        affiliationView.displaySuccessMessage();
        Assert.assertEquals(output.toString().trim(), "Success: Affiliation successfully inserted");
    }

    @Test
    public void displayErrorMessage() {
        affiliationView.displayErrorMessage();
        Assert.assertEquals(output.toString().trim(), "Error: Affiliation could not be inserted");
    }

    @Test
    public void validDatesSuccess() throws ParseException{
        Date start = new SimpleDateFormat("dd/MM/yyyy").parse("11/11/11");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/12");
        affiliationController.validateDates(start, end);
    }

    @Test (expected = RuntimeException.class)
    public void validDatesBefore() throws ParseException{
        Date start = new SimpleDateFormat("dd/MM/yyyy").parse("12/12/12");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("11/11/11");
        affiliationController.validateDates(start, end);
    }

}