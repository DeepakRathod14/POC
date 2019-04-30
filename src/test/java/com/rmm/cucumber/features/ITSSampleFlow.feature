@Demo @Regression
Feature: As a User of ITS I am performing navigation demo

  @TC_ITS_001
  Scenario: Performed Login and verify Navigation
    Given Open Browser and lunch application
    And Verify login page should be display
    When Enter valid username and password into login page
    Then Verify default page should be dashboard
    And Verify required menu options on home page
      | Menu Options     |
      | Dashboard        |
      | Tickets          |
      | Quick Access     |
      | Patches          |
      | Scripts          |
      | Reports          |
      | Admin            |
      | RMM Setup        |
      | BDR              |
      | Security         |
      | Cloud Monitoring |

  @TC_SR_002
  Scenario: Verify Dashboard widged
    Given Verify default page should be dashboard
    Then Verify different widged on dashboard page should display
      | Device Availability Summary                    |
      | BDR                                            |
      | Backup Status                                  |
      | Desktop: Patch Status                          |
      | Continuum Vault                                |
      | Agent Status                                   |
      | Critical Events for the Last 24 Hours          |
      | Product Announcements                          |
      | New Ticket                                     |
      | Server: Patch Status                           |
      | Message board                                  |
      | VMware Monitoring                              |
      | Desktop: Patch Status                          |
      | Desktop: Endpoint Protection Definition Status |
      | Server: Endpoint Protection Definition Status  |
