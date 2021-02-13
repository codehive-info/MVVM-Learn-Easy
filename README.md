# # MVVM- Codehive.info

Hi, MVVM is nothing but MODEL VIEW VIEWMODEL.
This Stratergry is strongly recommended by Google.

  - Model - Here Data Model classes are listed which can be further used to represent the data. 
  Model classes can also be used in serilized data form and also for data encapsulation. 
  - View - View are nothing but what happens on the main thread i.e. UI thread all the view 
  Manipulations are done in this class.
  - ViewModel -  Here all the data is assigned. Now you will think why really we want to assign
  this code in saperate class? why not to directly use it MainActivity and why ViewModel?
So this ViewModel is introduced by Android JetPack and Recommeded by Google. Here many 
things such lifecycle management, memory leaks and configuration changes are prevented.
And we developers can focus direcly on the Business Logic

