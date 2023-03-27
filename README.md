# MobileApps-HW06
In this assignment we use RecycleView to make an activity that mimics the inbox screen of an email application.

Inbox Description
This class describes an email inbox message. The class is named Inbox. 
I has the following members: String from, String email, String message, String date, boolean selected.
The constructor initializes an instance of Inbox with the boolean selected member set to false.
It has getters and setters for from, email, message, and date. 
The boolean member has a method to return the value of selected and a method to set selected to true or false. 
The boolean member also has method that inverts its value.

Data Generator Description
The first member of this class is a static variable called r that is initialized with a new instance of the Java Random class.
This is followed by a method, called randInt, that returns a random integer value by calling .nextInt method from the Random class.
The random number will be between 0 (inclusive) and the maximum value(inclusive) passed as a parameter.
Note about this method: (max-min)+1 is used to ensure that the result falls withing the range from min to max inclusively.
The next method, getInboxData, returns a List of Inbox objects.
The final method, getRandomInboxItem, returns a single instance of an Inbox object.

