## Codebase for the agora android app.

I have used Native Java for development.

**I have used Retrofit for calling the signup and login API's. The API's that i have used are part of agora web api's.
I have tried to use OOP concepts wherever possible and documented the code efficiently.**


Also, the data in the application is all dummy and certain features like adding candidates in creating election, choosing algorithm are all hard coded and not functional. This prototype is made to demonstrate the UI aspect of every screen and basic functionalities like Login, Signup etc.

**The link for the video of the whole flow of the prototype on a live android design is given below:**

https://drive.google.com/file/d/1xZagRDk4iAhOXPovUwIhTXS0ROOUaaJC/view?usp=sharing


## Mockups For Android Development under Project Agora Web
I have created mockups regarding Issue #91


I have tried to keep the UI pretty simple yet very user friendly and tried to use maximum material design guidelines.The theme colours are choosed keeping in mind Agora Web Colours and even tried to incorporate your feedback on other requests as well.


Hoping to get the feedback from all the mentors and other people.


###### Splash Screen

Wen the app is opened this will be introductory splash screen with logo spinning in circular motion. It will check wether the user is signed in or not and will redirect to login page or dashboard page accordingly.

![Loading](gsoc19 android mockups/Loading.png)

###### Login Page

The Login Page will have option of login through google, facebook and email. Used Agora colours all over

![AOSSIE_Login](gsoc19 android mockups/AOSSIE_Login.jpg)

###### Register Page

![Register](gsoc19 android mockups/Register.png)

Once the registration is done a verification email will be sent to the user. We can use firebase auth for that.

###### Dashboard Page

On clicking on any of the card the corresponding elections page will be opened with data filtered according to the option clicked.

![dashboard](gsoc19 android mockups/dashboard.png)


###### View Election 

User can add more number of candiates on this page by editing the election. 

![viewElection](/gsoc19 android mockups/createdElection.png)


###### Election Page

User can see the elections created by him with this screen and can edit them as well. By clicking on any election the view Election screen will be opened

![createdElection](gsoc19 android mockups/viewElection.png)


###### Completed Election

User can see the list of completed elections and result on this page.

![completedElection__2_](gsoc19 android mockups/completedElection (2).png)

###### Create Election

I have divided the process of creating election in multiple screens with total of 4 screens. Tried to follow the basic theming of colours and design everywhere.

![createElection1](gsoc19 android mockups/createElection1.png)    ![createElection2](gsoc19 android mockups/createElection2.png)

![createElection3](gsoc19 android mockups/createElection3.png)    ![createElection4](gsoc19 android mockups/createElection4.png)

###### Eligible Voting Elections Screen

The elections that you are eligible to vote for will be visible on this screen.

![EligibleElection](gsoc19 android mockups/EligibleElection.png)

###### Cast Voting Screen (preferrential)

User can Cast vote through this screen.

![voteScreen](gsoc19 android mockups/voteScreen.png)

###### Cast Voitng Screen (range)

User can Cast vote through this screen by using range algorithm.

![voteScreen](gsoc19 android mockups/voteScreenRange.png)

###### Cast Voitng Screen (range)

User can Cast vote through this screen by using score algorithm.

![voteScreen](gsoc19 android mockups/voteScreenScore.png)


###### Side Nav Bar

This will have various options to navigate through the app

![sideNav](gsoc19 android mockups/sideNav.png)

###### Profile

Profile section of the app with menu feautres of changing password, viewing your elections in recycler views and updating profile etc.

![Profile](gsoc19 android mockups/Profile.png)

