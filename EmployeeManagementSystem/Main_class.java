package EmployeeManagementSystem.EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){

        setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Ions/Main.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1170,650);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(320,120,550,60);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Raleway",Font.BOLD,35));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(365,270,150,40);
        add.setForeground(Color.black);
        add.setBackground(Color.white);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(595,270,150,40);
        view.setForeground(Color.black);
        view.setBackground(Color.white);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(470,370,150,40);
        rem.setForeground(Color.black);
        rem.setBackground(Color.white);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        JButton back = new JButton("Back");
        back.setBounds(470,570,150,40);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });
        img.add(back);


        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main_class();
    }
}

