Feature: Testing for the different methods of one API
  Users should be able to submit
  GET, DELETE and POST requests to a web service

  Background:
    Given The user admin get to web services

  @GET_ALL
  Scenario: The authorized admin can looking a user
    When the admin look a user to the BD
    Then the requested data are returned

  @GET
  Scenario: The authorized admin can looking the users
    When the admin look users to the BD
    Then the requested data is returned

  @POST
  Scenario: The authorized admin can add a user
    When the admin add a user to the BD
    Then the user is added

  @DELETE
  Scenario: The authorized admin can delete a user
    When the admin delete a user to the BD
    Then the user is deleted