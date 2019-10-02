package pl.adriankurek.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import pl.adriankurek.model.User;
import pl.adriankurek.api.ViewApi;

public class View extends JFrame implements ViewApi {
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;;
	private JButton btnClear;

	private JTextField txtFieldName;
	private JTextField txtFieldCity;

	private JPanel panelTxt;
	private JPanel panelBtn;
	private JLabel lblName;
	private JLabel lblCity;

	private JLabel lblUsers;
	private JComboBox<User> cmbBox;

    public View() {
        super("Users Data Base");

		btnInsert = new JButton("Insert");
		btnUpdate = new JButton("Update selected");
		btnDelete = new JButton("Delete");
		btnClear = new JButton("Clear fields");
		
		txtFieldName = new JTextField(8);
		txtFieldCity = new JTextField(8);

		panelTxt = new JPanel();
		panelBtn = new JPanel();

		cmbBox = new JComboBox<>();

		lblName = new JLabel("Name: ");
		lblCity = new JLabel("City: ");

		lblUsers = new JLabel("Users: ");

		panelTxt.setLayout(new GridLayout(4, 1));

		panelTxt.add(lblName);
		panelTxt.add(txtFieldName);
		panelTxt.add(lblCity);
		panelTxt.add(txtFieldCity);

		panelTxt.add(lblUsers);
		panelTxt.add(cmbBox);

		panelBtn.add(btnInsert);
		panelBtn.add(btnUpdate);
		panelBtn.add(btnDelete);
		panelBtn.add(btnClear);

		add(BorderLayout.NORTH, panelTxt);
		add(BorderLayout.SOUTH, panelBtn);

		setLookAndFeel();
		setSize(570, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void onInsertButtonClick(ActionListener listener) {
        btnInsert.addActionListener(listener);
    }

    @Override
    public void onUpdateButtonClick(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    @Override
    public void onDeleteButtonClick(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    @Override
    public void onClearButtonClick(ActionListener listener) {
        btnClear.addActionListener(listener);
	}
	
	@Override
	public void onComboBoxClick(ActionListener listener) {
		cmbBox.addActionListener(listener);
	}

    @Override
    public JTextField getNameTextField() {
        return txtFieldName;
    }

    @Override
    public JTextField getCityTextField() {
        return txtFieldCity;
    }

    @Override
    public JComboBox<User> getComboBox() {
        return cmbBox;
    }

    @Override
    public void showMessage(String message, String tag, int type) {
        JOptionPane.showMessageDialog(null, message, tag, type);
    }

    @Override
    public int showYesNoMessage(String message, String tag, int type) {
        int result = JOptionPane.showConfirmDialog(null, message, tag, JOptionPane.YES_NO_OPTION);
		return result;
    }

    private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {

		}
    }
}