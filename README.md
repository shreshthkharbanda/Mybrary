*****************************************************************************************
Description: This readme file is for Mybrary application used for Library Management System. It includes application installation instructions and detail information about application features, technologies used, artifacts, and sources 
Released Version: 1.0.0
Released Date: Feb 26th 2018
Author: Shreshth Kharbanda, North Creek High School, Bothell WA
*****************************************************************************************

Installation Instructions:
 - Download apk file on Android device from the location (https://github.com/smartyshre/Mybrary/blob/master/FBLA%20App/FblaLibraryApp/app/mybrary.apk)
 - Open the apk file from the device
 - This will install the Mybrary app on your device
 - Open the Mybrary App


Application Name: Mybrary 
Application Description: Library Management System for library members
Application Features:
 - User Registration including initial signup, login, password reset and an option to stay logged-in.
 - Book Database to list all books with author's name, title, location, category and likes and by clicking on the book item, it displays book description
 - Like Features: User can like the book by clicking the "like" icon for books that user has checked out and also see total number of likes
 - Reserve Book: Allows user to reserve/checkout the book by manually entering the book identification number or scanning the barcode from the book
 - My Account: Shows all the checked out books by the logged in user, fine amount (if any), number of likes, checked out date and due date
 - Library Map: Visual map of the library to locate the book
 - Push Notifications: If book is overdue, user gets the push notification on the device
 - Email Notifications: Password reset instructions
 - Refresh - Swipe / Pull to refresh the current screen 
 
User Interface Layer: This layer is the front end of the application for users to interact with the Library Management System
Technologies Used:
  - Compatible Devices: Android based Mobile/Tablets
  - Language: Java/XML

Artifacts:
 APK File Name: Mybrary.apk (https://github.com/smartyshre/Mybrary/blob/master/FBLA%20App/FblaLibraryApp/app/mybrary.apk)



Back End (Server Side) Layer - This layer has the database for all the books and transactions for user's checkout. Also, PHP scripts to retrieve data for front layer and update database based on user actions on the device. 
Technologies Used: 
  - Database: MySQL Database
  - Operating System: Linux
  - Cloud Platform: AWS
  - Language: PHP
  
Artifacts:
 Database Name: Poller (database server is running on AWS)
 PHP File Names: All files are in /var/www/html folder in the server running on AWS
   - CheckUserNamePassword.php - This script is used for user login to get the input from front end and validate user-id/password against "LibraryUsers" Table
   - BooksCheckOut.php - 

 Scheduled Job (Cronjob):
   - sendfirebasenotification.php 
   
   
 Other Sources:
   JSON Parse Source(s):
    - http://sampleprogramz.com/android/mysqldb.php
    - http://www.codejava.net/java-se/jdbc/jdbc-tutorial-sql-insert-select-update-and-delete-examples
    - https://www.codeproject.com/Articles/267023/Send-and-receive-json-between-android-and-php
   Likebutton Library from Github:
    - https://github.com/jd-alexander/LikeButton
   Gmail sending source:
    - https://github.com/plum-umd/android-intents/tree/master/TimeTracker/src/org/umd/timetracker
   Zooming Library from Github:
    - https://github.com/jsibbold/zoomage
   MaterialBarcodeScanner Library from Github:
    - https://github.com/EdwardvanRaak/MaterialBarcodeScanner
      