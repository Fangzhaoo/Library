package Project11;

import OriginalCode.Exception.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/*
 * Components.ButtonDemo.java requires the following files:
 *   images/right.gif
 *   images/middle.gif
 *   images/left.gif
 */
public class ButtonDemo extends JPanel
        implements ActionListener {
    protected JButton b1, b2, b3;
    public ButtonDemo(String button,String tip,String info) {
        b2 = new JButton(button);
        b2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand(info);
        b2.addActionListener(this);
        b2.setToolTipText(tip);
        add(b2);
    }

    public void actionPerformed(ActionEvent e) {
        if ("a".equals(e.getActionCommand())) {
            WelcomeToLibraryGUI.registration();
        }
        if("b".equals(e.getActionCommand())){
            WelcomeToLibraryGUI.verifyReturning1();
        }
        if("c".equals(e.getActionCommand())){
            WelcomeToLibraryGUI.registrationAsStudent();
        }
        if("d".equals(e.getActionCommand())){
            WelcomeToLibraryGUI.registrationAsLibrarian();
        }
        if("e".equals(e.getActionCommand())){
            try {
                WelcomeToLibraryGUI.veryfyLibrarian();
            } catch (InvalidInputException e1) {
                e1.printStackTrace();
            }
        }
        if("m".equals(e.getActionCommand())){
            WelcomeToLibraryGUI.studentReturn();
        }
        if("n".equals(e.getActionCommand())){
            WelcomeToLibraryGUI.librarianReturn();
        }
        if("p".equals(e.getActionCommand())){
            String[] a=new String[2];
            a[0]= WelcomeToLibraryGUI.j.streetField.getText();
            a[1]= WelcomeToLibraryGUI.l.getText();
            WelcomeToLibraryGUI.identity3(a);
        }
        if("exit".equals(e.getActionCommand())){
            try {
                WelcomeToLibraryGUI.Exit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
