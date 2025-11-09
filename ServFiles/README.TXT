Instructions of operation.

Under both directories, Server and Client, you can find both the source files and the executable JAR file. 
------------------------------------------------------------------------------------
Server:
Program to run a Java Server using the ServerSocket method. You can use the distributable JAR file to set up your own server from my program. 

I already have a globally available server using Amazon AWS running this program, You can use it instead. but if you want to create your own, simply:
Create a server. I suggest using Amazon AWS Ec2.
Install the latest Java Runtime Enviorment (JDK 24) on the server.
Run the JAR file in the background.

The serversocket is set to use port 4098 for signup and 8096 for Log in.

---------------------------------------------------------------------

Client:

These are the source files and executable for connecting to the server, signing up with your own details, and logging in with any previously created credentials.

If you decide to use my already existing Server, you can simply run the executable by running command prompt in the client directory and using the command "java -jar ServAWSTestClient.jar".
If you decide and have created your own server, you will need to modify the source files to connect to your server instead:
open the project folder in your IDE.
Open the "ServAWSTestClient.java' file.
Go to line 33, where we create the "socketSign" variable, and change the url to your server's url.
Repeat this previous step for line 53.
Now clean and build to create a new executable and run it as previously indicated.

Running the JAR file.
After running, the command prompt will ask you whether to sign up (1), or log in (2). Type and enter 1 to sign up or enter 2 to log in.

For both options you will first be asked to enter a username, then a password. 
You can enter any username or password when sigining up and use these log ins anytime from log in.
--------------------------------------------------------------------------------------------------