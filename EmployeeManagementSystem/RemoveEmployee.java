package EmployeeManagementSystem.EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice choiceEMPID;
    JButton delete, back;

    RemoveEmployee() {
        setUndecorated(true);
        setLayout(null);

        JLabel label = new JLabel("Employee ID");
        label.setBounds(400, 200, 100, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        label.setForeground(Color.white);
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(520, 200, 150, 70);
        add(choiceEMPID);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()) {
                choiceEMPID.add(resultSet.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(400, 250, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelName.setForeground(Color.white);
        add(labelName);

        JLabel textName = new JLabel();
        textName.setBounds(520, 250, 200, 30);
        add(textName);

        JLabel labelPhone = new JLabel("Phone");
        labelPhone.setBounds(400, 300, 100, 30);
        labelPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelPhone.setForeground(Color.white);
        add(labelPhone);

        JLabel textPhone = new JLabel();
        textPhone.setBounds(520, 300, 200, 30);
        add(textPhone);

        // Label for Email and its corresponding text field
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(400, 350, 100, 30);
        labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        labelEmail.setForeground(Color.white);
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(520, 350, 200, 30);
        add(textEmail);

        // Fetch employee details when an Employee ID is selected
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update employee details when different employee ID is selected
        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from employee where empId = '" + choiceEMPID.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        // Delete button
        delete = new JButton("Delete");
        delete.setBounds(400, 450, 100, 30);
        delete.setBackground(Color.white);
        delete.setForeground(Color.black);
        delete.addActionListener(this);
        add(delete);

        // Back button
        back = new JButton("Back");
        back.setBounds(530, 450, 100, 30);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Ions/remove.jpg"));
        Image i22 = i11.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        setSize(1170, 650);
        setLocation(200, 50); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == delete) {
            try {
                conn c = new conn();
                String query = "delete from employee where empId = '" + choiceEMPID.getSelectedItem() + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Main_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
