# java-hibernate-jpa-app
Simple CRUD like application using **Hibernate ORM** & **Apache Maven**.

## #1 Install MySQL Server & Apache Maven

If you want this app work, you have to install MySQL server first, change database name in **UserData.java** and update **persistence.xml** file by adding your own **username** and **password**.

You also need to have **Apache Maven** installed.

Use below command (if you are using [Chocolatey](https://chocolatey.org/) software) to install **Maven**:

`choco install maven`


## #2 Run app

Install app using:

`mvn install`

Or if you have already compiled files:

`mvn clean install`

Run app:

`mvn exec:java -Dexec.mainClass="pl.adriankurek.main.App"`

App wont't work without MySQL Server.
