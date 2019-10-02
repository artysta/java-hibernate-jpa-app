package pl.adriankurek.controller;

import pl.adriankurek.api.UserDataApi;
import pl.adriankurek.api.ViewApi;
import pl.adriankurek.model.User;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import java.util.List;

public class Controller {
	private ViewApi view;
	private UserDataApi data;

	public Controller(ViewApi view, UserDataApi data) {
		this.view = view;
		this.data = data;

		// Insert listener.
		view.onInsertButtonClick(e -> {
			String name = view.getNameTextField().getText().trim();
			String city = view.getCityTextField().getText().trim();

			if (name.equals("") || city.equals("")) {
				view.showMessage("The fields can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			User user = new User();
			user.setName(name);
			user.setCity(city);

			if (user != null) {
				int result = view.showYesNoMessage(
						"Do you want to add new user to data base? (values " + user.toString() + ")", "Warning",
						JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					data.insertUser(user);
					view.showMessage("User " + user.toString() + " added to database.", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					refreshCmbBoxData();
				}
			}
		});

		// Update listener.
		view.onUpdateButtonClick(e -> {
			User user = (User) view.getComboBox().getSelectedItem();

			if (user != null) {
				user.setName(view.getNameTextField().getText());
				user.setCity(view.getCityTextField().getText());

				int result = view.showYesNoMessage("Do you want to update user? (new values " + user.toString() + ")",
						"Warning", JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					data.updateUser(user);
					view.showMessage("User updated!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					refreshCmbBoxData();
				}
			} else {
				view.showMessage("No user is selected. Probably there are no users in your database.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Delete listener.
		view.onDeleteButtonClick(e -> {
			User user = (User) view.getComboBox().getSelectedItem();

			if (user != null) {
				int result = view.showYesNoMessage(
						"Do you want to remove user form data base? (values " + user.toString() + ")", "Warning",
						JOptionPane.WARNING_MESSAGE);

				if (result == JOptionPane.YES_OPTION) {
					data.deleteUser(user);
					view.showMessage("User deleted from database! (values " + user.toString(), "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				view.showMessage("No user is selected. Probably there are no users in your database.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			refreshCmbBoxData();
		});

		view.onClearButtonClick(e -> {
			view.getNameTextField().setText("");
			view.getCityTextField().setText("");
		});

		view.onComboBoxClick(e -> {
			User user = (User) view.getComboBox().getSelectedItem();

			if (user != null) {
				view.getNameTextField().setText(user.getName());
				view.getCityTextField().setText(user.getCity());
			}
		});

		refreshCmbBoxData();
	}

	private void refreshCmbBoxData() {
		JComboBox<User> cmb = view.getComboBox();
		cmb.removeAllItems();

		List<User> users = data.getUsers();
		
		for (User u : users) {
			cmb.addItem(u);
		}
	}
}