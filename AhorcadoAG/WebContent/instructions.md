Get started with HangmanGame
-----------------------------------
Welcome to Java Web Starter application!

This sample application demonstrates how to write a Java Web application (powered by WebSphere Liberty) and deploy it on Bluemix.

1. [Install the cf command-line tool](https://www.ace.ng.bluemix.net/docs/#starters/BuildingWeb.html#install_cf).
2. [Download the starter application package](https://ace.ng.bluemix.net:443/rest/starter-download).
3. Extract the package and `cd` to it.
4. Connect to Bluemix:

		cf api https://ace.ng.bluemix.net

5. Log into Bluemix:

		cf login -u yourLoginID
		cf target -o yourLoginID -s dev
				
6. Compile the Java code and generate the war package using ant.
7. Deploy your app:

		cf push HangmanGame -p HangmanGame.war

8. Access your app: [http://yourdomain.ng.bluemix.net](http://yourdomain.ng.bluemix.net)
