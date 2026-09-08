Feature: Hotel Booking Adactin Application


# =========================================================
# LOGIN TEST - Scenario Outline + Examples
# =========================================================

Background:
Given user Launches The Application

@SmokeTest
Scenario Outline: Login with valid and invalid credentials

When user Enters "<username>" In Username Field
And user Enters "<password>" In Password Field
And user clicks the Login button
Then login result should be "<expectedResult>"
And user should be navigated to the Search Hotel page

Examples: Valid Users
| username            | password | expectedResult |
| Divyathiyagarajan27 | Shivanya@28 | success |

Examples: Invalid Users
| username           | password | expectedResult |
| Adactin | admin1234 | failure |
| sand | 123 | failure |


# =========================================================
# COMPLETE HOTEL BOOKING FLOW
# =========================================================

@SanityTest

# Login
Scenario Outline: Complete Hotel Booking Flow


When user Enters "<username>" In Username Field
And user Enters "<password>" In Password Field
And user clicks the Login button
Then login result should be "<expectedResult>"
And user should be navigated to the Search Hotel page


# Search Hotel
When user Selects the Location In Location Field
And user Select The Hotel In Hotel Field
And user Select The Room Type In RoomType Field
And user Select The No. Of Rooms In Room Field
And user Enters The Date In check In Date Field
And user Enters The Date In check Out Date Field
And user Select Adults per Room In Adults Per Room Field
And user Select Children Per Room In Children Per Room Field
Then user Click On The Search Button And It Navigates To The Select Hotel Page


# Select Hotel
When user Click The Radio Button To Select The Hotel
Then user Click On The Continue Button And It Navigates To The Booking Page

# =========================================================
# Book Hotel
# When user Enter The Firstname In Firstname Field
# And user Enter The Lastname In Lastname Field
# And user Enter The Address In Billing Address Field
# And user Enter The Credit Card No. In Credit Card No. Field
# And user Select The Credit Card Type In Credit Card Type Field
# And user Select The Month In Expiry Date Field
# And user Select The Year In Expiry Date Field
# And user Enter The Cvv No. In Cvv Field
# Then user Click On The Book Now Button And It Navigates To The Booking Confirmation Page
# =========================================================

# Book Hotel
 When user enters the following booking details

    | firstname | lastname | address | cardno | cardtype | month | year | cvv |
    | Divya     | Thiyagarajan    | Chennai | 4111111111111111 | VISA | December | 2028 | 123 |

Then user Click On The Book Now Button And It Navigates To The Booking Confirmation Page


# Review Booking
When user Click On The My Itinerary Button And It Navigates To The Book Itinerary Page


# Cancel Booking
When user Click On The Cancel Button In Cancel Field
Then user Click Ok Button on Alert And It Navigates To The Book Itinerary Page


# Logout
Then user Click On The Logout Button And It Navigates To The Logout Page

Examples: Valid Users
| username            | password | expectedResult |
| Divyathiyagarajan27 | Shivanya@28 | success |