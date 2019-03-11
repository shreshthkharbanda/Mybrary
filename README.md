# Mybrary

*****************************************************************************************
Description: This readme file is for Mybrary application used by a library member of North Creek High School. It includes application installation instructions and detailed information about application features, technologies used, artifacts, and sources
Released Version: 1.0.0
Released Date: Feb 26th 2018
Author: Shreshth Kharbanda, North Creek High School, Bothell WA
*****************************************************************************************

## Installation Instructions:
 - Download apk file on Android/FireOS device from the location (https://github.com/smartyshre/Mybrary/blob/master/mybrary.apk)
 - Make sure Github is opened as the desktop version
 - Open the apk file from the device
 - This will install the Mybrary app on your device
 - Open the Mybrary App

**Application Name: Mybrary**
**Application Description: Library Management System for library members**
### Application Features:
 - User Registration including initial signup, login, password reset and an option to stay logged-in.
 - Book Database to list all books with author's name, title, location, category and likes
 - Like Features: User can like the book by clicking the "like button" for books that the user has checked out and also can see the total number of likes
 - Reserve Book: Allows user to reserve/checkout the book by manually entering the book identification number or scanning the barcode of the book (the barcode's value should be the book identification number)
 - My Account: Shows all the checked out books by the logged in user, fine amount (if any), number of likes, checked out date and due date
 - Library Map: Visual map of the library to locate the book
 - Push Notifications: If book is overdue, the user gets the push notification on the device
 - Email Notifications: Password reset instructions
 - Refresh: Swipe/Pull to refresh the current screen
 - Social Media Integration: Share book information with multiple social media platforms when user clicks on a single book in book catalog or list of books checked out
 

## User Interface Layer: This layer is the front end of the application for users to interact with the Library Management System
### Technologies Used:
  - Compatible Devices: Android based Mobile/Tablets
  - Language: Java/XML


### Artifacts:
  - APK File Name: Mybrary.apk


## Back End (Server Side) Layer
**This layer has the database for all the books and transactions for user's checkout. Also, PHP scripts to retrieve data for front layer and update database based on user actions on the device.**

### Technologies Used:
  - Database: MySQL Database
  - Operating System: Linux
  - Cloud Platform: AWS
  - Language: PHP
  

### Artifacts:
 Database Name: Poller (database server is running on AWS)
 ### PHP File Names: All files are in the /var/www/html folder in the server running on AWS
   - checkUserNamePassword.php - This script is used for user login to get the input from front end and validate user-id/password against "user" Table
   - booksCheckedOut.php - Allows user to view books he/she has checked out currently. 
   - getAllBooks.php - Shows the book database in the user interface layer
   - barcodeScan.php - Provides all information about the book that has just been scanned by the user
   - checkoutBook.php - Allows the user to checkout a book. Triggered when user enters id and clicks "Checkout Book" or scans a barcode of an existing book in the database
   - signUpLibrary.php - Inserts data into the LibraryUsers table inside the database
   - insertToken.php - Inserts firebase identification number and firebase registration identification number. Inserted/Updated in the database when a user signs into any device
   - updatePassword.php - Updates a password into the LibraryUsers table within the database with an auto-generated password inside the app
   


### Scheduled Job (Cronjob):
   - sendfirebasenotification.php
   
   ## Screenshots
 ![picture alt](https://ibb.co/LrQ4jPX "Book Catalog")           ![picture alt](https://ibb.co/FWGR0Nx "Log In Screen")              ![picture alt](https://ibb.co/MSqDV1B "Log In Screen Filled Out")          ![picture alt](https://ibb.co/fny3mB2 "Log In Screen Filled Out With Password Visible")            ![picture alt](https://ibb.co/9pg32vY "Reset Password Dialog Box")         ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570824_1817692558325633_4983673639460771397_n.jpg?_nc_cat=0&oh=f823441909f7b45b6c8947e50fc82d57&oe=5B4172B1 "Log In Screen Filled Out")          ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570824_1817692558325633_4983673639460771397_n.jpg?_nc_cat=0&oh=f823441909f7b45b6c8947e50fc82d57&oe=5B4172B1 "Log In Screen Filled Out")          ![picture alt](https://ibb.co/fny3mB2 "Log In Screen Filled Out With Visible Password")            ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542649_1817692618325627_6173399451050820616_n.jpg?_nc_cat=0&oh=cdc9858eae7473e54b2931ea5fdf5b11&oe=5B37EC44 "Reset Password Dialog Box")         ![picture alt](https://ibb.co/6XT88JL "Sign Up Screen")          ![picture alt](https://ibb.co/VtGd08S "Sign Up Screen Continued")          ![picture alt](https://ibb.co/ydxJT0b "My Account Screen")         ![picture alt](https://ibb.co/XLLwSQz "Checkout Book Dialog Box")                ![picture alt](https://ibb.co/WKqcV0G "Checkout Book Manually")            ![picture alt](https://ibb.co/0B4661H "Scan to Checkout Book")         ![picture alt](https://ibb.co/RjPcdF1 "Report Bug Dialog Box")          ![picture alt](https://ibb.co/QrWJRXW "Library Map in App")         ![picture alt](https://ibb.co/JxZN4Q5
 "Change Password DIalog Box")
 
 
 Sources:
   - JSON Parse Sources:
    	- http://sampleprogramz.com/android/mysqldb.php
    	- http://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples 
   - Likebutton Library from Github:
    	- https://github.com/jd-alexander/LikeButton
    	- https://github.com/jsibbold/zoomage
