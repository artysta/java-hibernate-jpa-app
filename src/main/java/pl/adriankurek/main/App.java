package pl.adriankurek.main;

import pl.adriankurek.api.UserDataApi;
import pl.adriankurek.api.ViewApi;
import pl.adriankurek.controller.Controller;
import pl.adriankurek.model.UserData;
import pl.adriankurek.view.View;

import javax.swing.JOptionPane;

import org.hibernate.service.spi.ServiceException;

public class App {
    public static void main(String[] args) {
        try {
            UserDataApi model = new UserData();
            ViewApi view = new View();
            new Controller(view, model);
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null,
                    String.format("Error! Ensure that you have MySQL server installed!\n\nException message: %s.",
                    e.getMessage()),
                    "Warning", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    String.format("Something went wrong!\n\nException message: %s.", e.getMessage()), "Warning",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
    }
}