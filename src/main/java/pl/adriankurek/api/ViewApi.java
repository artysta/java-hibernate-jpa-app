package pl.adriankurek.api;

import java.awt.event.*;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import pl.adriankurek.model.User;

public interface ViewApi {
    void onInsertButtonClick(ActionListener listener);
    void onUpdateButtonClick(ActionListener listener);
    void onDeleteButtonClick(ActionListener listener);
    void onClearButtonClick(ActionListener listener);
    void onComboBoxClick(ActionListener listener);
        
    JTextField getNameTextField();
    JTextField getCityTextField();

    JComboBox<User> getComboBox();

    void showMessage(String message, String tag, int type);
    int showYesNoMessage(String message, String tag, int type);
}