package Project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextInputDemo3 extends TextInputDemo {
     private String s1;
     private String s2;
    TextInputDemo3(String s1, String s2) {
        super(s1, s2);
        this.s1=s1;
        this.s2=s2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] A = new String[2];
        if ("Continue".equals(e.getActionCommand())) {
            A[0] = streetField.getText();
            A[1] = cityField.getText();
            WelcomeToLibraryGUI.identity3(A);
        }
        if ("Exit".equals(e.getActionCommand())) {
            try {
                WelcomeToLibraryGUI.Exit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


        //updateDisplays();
    }

    @Override
    protected JComponent createEntryFields() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBackground(new Color(248, 213, 131));
        panel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        String[] labelStrings = {
                "Enter your ID:","Enter your password:",
        };
        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        //Create the text field and set it up.
        streetField = new JTextField();
        streetField.setColumns(20);
        fields[fieldNum++] = streetField;

        cityField = new JTextField();
        cityField.setColumns(20);
        fields[fieldNum++] = cityField;
        cityField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (cityField.getText().length() <=3||cityField.getText().length() >=8) {
                    button1.setEnabled(false);
                } else
                    button1.setEnabled(true);
            }
        });
        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i],
                    JLabel.TRAILING);
            labels[i].setLabelFor(fields[i]);
            labels[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            panel.add(labels[i]);
            panel.add(fields[i]);

            //Add listeners to each field.
            JTextField tf = null;
            if (fields[i] instanceof JSpinner) {
                tf = getTextField((JSpinner) fields[i]);
            } else {
                tf = (JTextField) fields[i];
            }
            tf.addActionListener(this);
            tf.addFocusListener(this);
        }
        SpringUtilities.makeCompactGrid(panel,
                labelStrings.length, 2,
                GAP, GAP, //init x,y
                GAP, GAP / 2);//xpad, ypad
        return panel;
    }
}
