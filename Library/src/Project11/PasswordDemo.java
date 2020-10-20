package Project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* PasswordDemo.java requires no other files. */

public class PasswordDemo extends JPanel
        implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";

    //private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;

    public PasswordDemo(String s) {
        //Use the default FlowLayout.
      //  controllingFrame = f;

        //Create everything.
        passwordField = new JPasswordField(25);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);
        JLabel label = new JLabel(s,JLabel.LEFT);
        //label.setBounds(20,20,400,20);
        label.setBackground(new Color(248, 213, 131));
        label.setLabelFor(passwordField);
        label.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);
        textPane.setBackground(new Color(248, 213, 131));
        textPane.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        add(textPane);
    }
    public String getText(){
        char[] pass = passwordField.getPassword();
        String password = new String(pass);
        return password;
    }



    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PasswordDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(248, 213, 131));
        //Create and set up the content pane.
        final PasswordDemo newContentPane = new PasswordDemo("a");
        final PasswordDemo newContentPane2 = new PasswordDemo("b");
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.add(newContentPane);
        frame.add(newContentPane2);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}