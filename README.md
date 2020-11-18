# java-hibernate-jpa-app
Simple CRUD like application using **Hibernate ORM** & **Apache Maven**.

## #1 Install MySQL Server & create database

If you want this app work, you have to install **MySQL server** first.

To do that, you can use the command below (if you are using [Chocolatey](https://chocolatey.org/) software):

`choco install mysql`

Now you have to connect to the MySQL server...

`mysql -u root`

...and create database (**localdatabase** is the name of the database in this case):

`create database localdatabase;`

## #2 Install Apache Maven

Use the command below to install **Apache Maven**:

`choco install maven`

## #3 Run app

Install app using:

`mvn install`

Or if you have already compiled files:

`mvn clean install`

Run app:

`mvn exec:java -Dexec.mainClass="pl.adriankurek.main.App"`

App wont't work without MySQL Server.
