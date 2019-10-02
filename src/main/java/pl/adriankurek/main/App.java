package pl.adriankurek.main;

import pl.adriankurek.controller.Controller;
import pl.adriankurek.model.UserData;
import pl.adriankurek.view.View;

public class App {
    public static void main( String[] args ) {
        new Controller(new View(), new UserData());
    }
}