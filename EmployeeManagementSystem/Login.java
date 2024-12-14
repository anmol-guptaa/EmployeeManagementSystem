package EmployeeManagementSystem.EmployeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(450,250,100,30);
        username.setFont(new Font("Raleway",Font.BOLD,18));
        add(username);

        tusername = new JTextField();
        tusername.setBounds(550,250,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(450,300,100,30);
        password.setFont(new Font("Raleway",Font.BOLD,18));
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(550,300,150,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(550,350,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(550,400,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("EmployeeManagementSystem/Ions/Login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1170,650);
        add(img);

        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try {
                String username = tusername.getText();
                String password = tpassword.getText();

                conn conn = new conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}