import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ButtonGroup;

public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("Register");


        //declare labels and textfields of information
        JLabel l1 = new JLabel("Name:");
        JTextField tf1 = new JTextField();

        JLabel l2 = new JLabel("Last Name:");
        JTextField tf2 = new JTextField();

        JLabel l3 = new JLabel("Email:");
        JTextField tf3 = new JTextField();

        JLabel l4 = new JLabel("Phone Number:");
        JTextField tf4 = new JTextField();

        JLabel l5 = new JLabel("Password:");
        JTextField tf5 = new JTextField();

        //declare two RadioButtuns for choosing gender
        JRadioButton b1 = new JRadioButton("A) Male");
        JRadioButton b2 = new JRadioButton("B) Female");

        //declare an array of strings to show the cities in ComboBox
        String[] cities = {"Tehran" , "Tabriz" , "Shiraz" , "Esfahan" , "Mashhad" , "Semnan" , "Ahvaz"};
        JLabel l7 = new JLabel("City:");
        JComboBox cb = new JComboBox(cities);

        //declare an array of strings to show months of birth in JList
        String[] birthMonth = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JLabel l8 = new JLabel("Birth:");
        JList jl = new JList(birthMonth);

        //declare Register Button
        JButton b3 = new JButton("Register");

        //declare 8 JLabels to set final info in them
        JLabel l9 = new JLabel();
        JLabel l10 = new JLabel();
        JLabel l11 = new JLabel();
        JLabel l12 = new JLabel();
        JLabel l13 = new JLabel();
        JLabel l14 = new JLabel();
        JLabel l15 = new JLabel();
        JLabel l16 = new JLabel();
        JLabel l17 = new JLabel();

        //implements ActionListener of Register JButton function (implementation of actionPerformed func)
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //checks if all the fields in the Register Form are filled or not
                if (tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") ||
                        (!b1.isSelected() && !b2.isSelected()) || jl.getSelectedIndex() < 0 || cb.getSelectedItem().toString().equals("")){
                    l9.setText("fill all the components");
                }

                //checks if Phone number is not less than 11 digits
                if (tf4.getText().length() < 11){
                    l9.setText("Enter a correct phone number");
                }

                //checks if Email address contains @ character
                if (!tf3.getText().contains("@")){
                    l9.setText("Enter a correct Email address");
                }

                //set the labels down of the form final info
                l10.setText("Name: " +tf1.getText());
                l11.setText("Last name: " +tf2.getText());
                l12.setText("Email address: " +tf3.getText());
                l13.setText("Phone number: " +tf4.getText());
                l14.setText("Password: " +tf5.getText());
                if (b1.isSelected()) {
                    l15.setText("Gender: Male");
                } else if (b2.isSelected()){
                    l15.setText("Gender: Female");
                }
                l16.setText("City:" +(String) cb.getSelectedItem());
                l17.setText(("Birth month: " +jl.getSelectedValue().toString()));
            }
        });

        f.add(l1);
        tf1.setSize(300, 50);
        f.add(tf1);
        f.add(l2);
        f.add(tf2);
        f.add(l3);
        f.add(tf3);
        f.add(l4);
        f.add(tf4);
        f.add(l5);
        f.add(tf5);
        f.add(b1);
        f.add(b2);
        f.add(l7);
        f.add(cb);
        f.add(l8);
        f.add(jl);
        f.add(new JScrollPane(jl));
        f.add(b3);
        f.add(l9);
        f.add(l10);
        f.add(l11);
        f.add(l12);
        f.add(l13);
        f.add(l14);
        f.add(l15);
        f.add(l16);
        f.add(l17);
        f.setVisible(true);
        f.setSize(1000,1000);
        f.setLayout(new GridLayout(13,1));
    }
}
