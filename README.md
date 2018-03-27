# Mybrary

*****************************************************************************************
Description: This readme file is for Mybrary application used by a library member of North Creek High School. It includes application installation instructions and detailed information about application features, technologies used, artifacts, and sources
Released Version: 1.0.0
Released Date: Feb 26th 2018
Author: Shreshth Kharbanda, North Creek High School, Bothell WA
*****************************************************************************************

## Installation Instructions:
 - Download apk file on Android device from the location (https://github.com/smartyshre/Mybrary/blob/master/mybrary.apk)
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
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29541163_1817692561658966_1716975351108929989_n.jpg?_nc_cat=0&oh=3cc33f495a85349d5b6f46ffcf0f1940&oe=5B2EFA69 "Book Catalog")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570740_1817692564992299_801350620055616289_n.jpg?_nc_cat=0&oh=9d05cf28df3e6e6c2274c2df40cefcdd&oe=5B2A1B8B "Log In Screen")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570824_1817692558325633_4983673639460771397_n.jpg?_nc_cat=0&oh=f823441909f7b45b6c8947e50fc82d57&oe=5B4172B1 "Log In Screen Filled Out")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29541004_1817692621658960_6781789323506361927_n.jpg?_nc_cat=0&oh=c6c17a52b5ab8fcc66449cc7f5a53dae&oe=5B39A16D "Log In Screen Filled Out With Visible Password")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542649_1817692618325627_6173399451050820616_n.jpg?_nc_cat=0&oh=cdc9858eae7473e54b2931ea5fdf5b11&oe=5B37EC44 "Reset Password Dialog Box")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570824_1817692558325633_4983673639460771397_n.jpg?_nc_cat=0&oh=f823441909f7b45b6c8947e50fc82d57&oe=5B4172B1 "Log In Screen Filled Out")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29570824_1817692558325633_4983673639460771397_n.jpg?_nc_cat=0&oh=f823441909f7b45b6c8947e50fc82d57&oe=5B4172B1 "Log In Screen Filled Out")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29541004_1817692621658960_6781789323506361927_n.jpg?_nc_cat=0&oh=c6c17a52b5ab8fcc66449cc7f5a53dae&oe=5B39A16D "Log In Screen Filled Out With Visible Password")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542649_1817692618325627_6173399451050820616_n.jpg?_nc_cat=0&oh=cdc9858eae7473e54b2931ea5fdf5b11&oe=5B37EC44 "Reset Password Dialog Box")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29541366_1817692624992293_3237117610067100849_n.jpg?oh=11a8ee5777aabde3488cf65ef8767455&oe=5B378243 "Sign Up Screen")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29541023_1817692644992291_4815199753924078807_n.jpg?_nc_cat=0&oh=bdf7546ba773e4ebdf41191fb7a6b91d&oe=5B72E554 "Sign Up Screen Continued")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542068_1817692648325624_4056070623331354647_n.jpg?_nc_cat=0&oh=b8abc00483d2c8f5d9ab21c3b1ced5ae&oe=5B6F8135 "My Account Screen")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29594510_1817692661658956_6513081292687654861_n.jpg?oh=551c4cde13b78f5fe1c0e480d6746cf4&oe=5B756E64 "Checkout Book Dialog Box")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542812_1817692691658953_4361740578305392385_n.jpg?_nc_cat=0&oh=f1fb639fd5d3b6fdf098d2ce8e4c2cdc&oe=5B2937CD "Checkout Book Manually")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29542735_1817692704992285_4316998118836091921_n.jpg?_nc_cat=0&oh=f3200e524a9286ad108a38d7ffa81104&oe=5B425E19 "Scan to Checkout Book")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29540957_1817692711658951_147611486677435462_n.jpg?_nc_cat=0&oh=48b49e36e36a3847134570103d9a49d8&oe=5B2A430D "Report Bug Dialog Box")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29512947_1817692744992281_5056422911431862566_n.jpg?_nc_cat=0&oh=a6779e3b850188fd3d3951d167e451ae&oe=5B43F264 "Library Map in App")
 - ![picture alt](https://scontent-sea1-1.xx.fbcdn.net/v/t1.0-9/29683538_1817692754992280_6267524187077630526_n.jpg?oh=0fa09e49f9fb1b2e646db6b6e9e1c0ee&oe=5B35F756 "Change Password DIalog Box")
 
 
 Sources:
   - JSON Parse Sources:
    	- http://sampleprogramz.com/android/mysqldb.php
    	- http://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples 
   - Likebutton Library from Github:
    	- https://github.com/jd-alexander/LikeButton
