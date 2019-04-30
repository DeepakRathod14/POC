@ScheduleReport
Feature: As a User of CME-EDB Reporting I am on Schedule Request Page. I am trying to validating all possible features and scenario of Schedule Request.

  @TC_SR_001
  Scenario: Verify Grid Column Names in Schedule Report Page (TC_SR_001)
    Given Requested Reports page as landing page after successfully login.
    When Click on "Scheduled Report" tab.
    Then Scheduled Report Grid should display its column name
      | ColumnName  |
      | User ID     |
      | Report      |
      | Description |
      | Criteria    |
      | Frequency   |
      | Runtime     |

  @TC_SR_002
  Scenario: Verify Pagination Functionality in Scheduled Report Page (TC_SR_002)
    Given Requested Reports page as landing page after successfully login.
    And Click on "Scheduled Report" tab.
    Then Click on "1" page link from pagination navigator
    And Verify on page "Previous" and "First" link should be disable.
    Then Click on "3" page link from pagination navigator
    And Verify on page "Next" and "Last" link should be disable.

  @TC_SR_003
  Scenario: Verify Grid Row Display Functionality in Scheduled Report Per Page (TC_SR_003)
    Given Requested Reports page as landing page after successfully login.
    When Click on "Scheduled Report" tab.
    Then Verify Scheduled Grid Page should display maximum "10" recoreds in single page.

  @TC_SR_004
  Scenario: Verify Sorting Functionality on Schedule Report Page (TC_SR_004)
    Given Requested Reports page as landing page after successfully login.
    And Click on "Scheduled Report" tab.
    Then verify Requested Reports shorting functionality for all column.
      | ColumnName | Sorting Type |
      | User ID    | Accending    |
      | User ID    | Decending    |
      | Report     | Accending    |
      | Report     | Decending    |
      | Criteria   | Accending    |
      | Criteria   | Decending    |
      | Time       | Accending    |
      | Time       | Decending    |
      | Status     | Accending    |
      | Status     | Decending    |

  #@TC_SR_005
  #Scenario: Verify Edit schedule Report Functionality in schedule Reports (TC_SR_005)
  #	Given Requested Reports page as landing page after successfully login.
  #	When User select any scheduled recored and "Edit" option from action menu
  #	Then verify report modified successfully.
  @TC_SR_006
  Scenario: Verify Delete Report Functionality in Scheduled Reports (TC_RR_009)
    Given Requested Reports page as landing page after successfully login.
    And Click on "Scheduled Report" tab.
    When User select any scheduled recored and "Delete" option from action menu
    Then Verify delete popup with warnning message "Are you sure you want to delete" should be display.
    Then Click on "Cancel" button delete popup
    And Delete popup should be close and recored should "Not" delete from grid.
    When User select any recored and "Delete" option from action menu
    Then Click on "Ok" button delete popup
    And Delete popup should be close and recored should "Be" delete from grid.
#@TC_SR_007
#Scenario: Verify Submitt Report Functionality in Scheduled Reports (TC_RR_009) 
