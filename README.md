## This is the codebase for the agora android app.

I have used Native Java for development.
Currently i have used firebase authentication for registration and login but later on we will move to rest API’s. 

Also, the data in the application is all dummy and certain features like adding candidates in creating election, choosing algorithm are all hard coded and not functional. This prototype is made to demonstrate the UI aspect of every screen and basic functionalities like Login, Signup etc.

The link for the video of the whole flow of the prototype on a live android design is given below:

https://drive.google.com/file/d/1xZagRDk4iAhOXPovUwIhTXS0ROOUaaJC/view?usp=sharing


## Mockups For Android Development under Project Agora Web
I have created mockups regarding Issue #91


I have tried to keep the UI pretty simple yet very user friendly and tried to use maximum material design guidelines.The theme colours are choosed keeping in mind Agora Web Colours and even tried to incorporate your feedback on other requests as well.


Hoping to get the feedback from all the mentors and other people.


###### Splash Screen

Wen the app is opened this will be introductory splash screen with logo spinning in circular motion. It will check wether the user is signed in or not and will redirect to login page or dashboard page accordingly.

![Loading](/uploads/a1c94c8b07e5941f0b4149a347c69423/Loading.png)


###### Login Page

The Login Page will have option of login through google, facebook and email. Used Agora colours all over
![AOSSIE_Login](/uploads/c7720fa4162a482e513ed742bab37a4c/AOSSIE_Login.jpg)

###### Register Page

![Register](/uploads/f037b89faab6ef14b5c16362cc1f5f5a/Register.png)

Once the registration is done a verification email will be sent to the user. We can use firebase auth for that.

###### Dashboard Page

On clicking on any of the card the corresponding elections page will be opened with data filtered according to the option clicked.

![dashboard](/uploads/abe6a4d4d5927f27803c45bfe0ad028e/dashboard.png)

###### Election Page

User can see the elections created by him with this screen and can edit them as well. By clicking on any election the view Election screen will be opened

![createdElection](/uploads/0afaf2b74f454460c82c791af2754889/createdElection.png)

###### View Election 

User can add more number of candiates on this page by editing the election. 

![viewElection](/uploads/ddbf442accc435ac42a211c51332bb40/viewElection.png)

###### Completed Election

User can see the list of completed elections and result on this page.

![completedElection__2_](/uploads/ab09d30237eb6f9c664dab35d20644aa/completedElection__2_.png)

###### Create Election

I have divided the process of creating election in multiple screens with total of 4 screens. Tried to follow the basic theming of colours and design everywhere.

![createElection1](/uploads/efc4927fde09bbcfefe94ee49cce047b/createElection1.png)    ![createElection2](/uploads/7963a083ac23d7e635e93b3b98bc9300/createElection2.png)

![createElection3](/uploads/17c5a89008e2d0630a4b87bfababa8b0/createElection3.png)    ![createElection4](/uploads/1bd155e5761a7fa6fdad2d9a8e135ee5/createElection4.png)

###### Eligible Voting Elections Screen

The elections that you are eligible to vote for will be visible on this screen.

![EligibleElection](/uploads/82245872fa8c4440cb8ae7dc015fea26/EligibleElection.png)

###### Cast Voting Screen

User can Cast vote through this screen.

![voteScreen](/uploads/adbc1c0a753153835a4b889a5bd85418/voteScreen.png)

###### Side Nav Bar

This will have various options to navigate through the app

![sideNav](/uploads/a7c029f834a9df6496058500589228ca/sideNav.png)

###### Profile

Profile section of the app with menu feautres of changing password, viewing your elections in recycler views and updating profile etc.

![Profile](/uploads/13a899f773f9d5e02db116fbfb9ff1b9/Profile.png)


Waiting eagerly for the feedback. You can see all the designs in the repositiory as well