package views;

import models.Organisation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Contains anything that the user sees or interacts with
 * These include all print statements and scanner inputs
 */
public class OrganisationView extends BaseView {

    /**
     * Provides a user input for a user to submit their name
     * @return the user's name that they submitted
     */
    public String getName() {
        System.out.println("Enter Organisation Name: ");
        return getInput();
    }

    public void displayNameError() { displayError("Illegal Organisation name"); }

    /**
     * Displays the message relating to if the organisation already exists
     */
    public void displayDuplicateEntryMessage() {
        super.displayError("This organisation already exists");
    }

    /**
     * Displays a confirmation message
     */
    public void displaySuccessMessage() {
        super.displaySuccess("The organisation was inserted");
    }

    public void isNameValidated(String organisationName) throws RuntimeException {

        if (organisationName == null) {
            throw new RuntimeException();
        }
    }

    public Integer convertToOrgOption(String organisationIdString) throws SQLException {
        System.out.println(organisationIdString);
        if (organisationIdString == null || organisationIdString.equals("")) {
            return null;
        }
        return convertToOption(organisationIdString, "organisation", "organisation_id");
    }



    /**
     * provide user input to select organisation
     * @return organisation id
     */
    public String getOrganisationId(ResultSet resultSet) throws SQLException {
        System.out.println("Select an organisation by entering id or press enter to skip: ");
        System.out.println("0: Back to menu");

        while (resultSet.next()) {
            System.out.println(String.format("%d: %s", resultSet.getInt("organisation_id"), resultSet.getString("name")));
        }
        return getInput();
    }
}
