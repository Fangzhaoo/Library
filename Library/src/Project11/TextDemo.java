package Project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * TextInputDemo.java uses these additional files:
 *   SpringUtilities.java
 *   ...
 */
public class TextDemo extends JPanel implements ActionListener,FocusListener {
    public JTextField streetField;
    JFormattedTextField zipField;
    JSpinner stateSpinner;
    boolean addressSet = false;
    Font regularFont, italicFont;
    JLabel addressDisplay;
    final static int GAP = 10;
    String name1;
    static JButton button1;
    public TextDemo(String name1) {
        // setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.name1=name1;
        JPanel leftHalf = new JPanel() {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize() {
                Dimension pref = getPreferredSize();
                return new Dimension(Integer.MAX_VALUE,
                        pref.height);
            }
        };
        leftHalf.setBackground(new Color(248, 213, 131));
        leftHalf.setLayout(new BoxLayout(leftHalf,
                BoxLayout.PAGE_AXIS));
        leftHalf.add(createEntryFields());
        add(leftHalf);
    }


    /**
     * Called when the user clicks the button or presses
     * Enter in a text field.
     */
    public void actionPerformed(ActionEvent e) {
        String[] A=new String[2];
        if ("Continue".equals(e.getActionCommand())) {
        }
        if("Exit".equals(e.getActionCommand())){
            try {
                WelcomeToLibraryGUI.Exit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }


    /**
     * Called when one of the fields gets the focus so that
     * we can select the focused field.
     */
    public void focusGained(FocusEvent e) {
        Component c = e.getComponent();
        if (c instanceof JFormattedTextField) {
            selectItLater(c);
        } else if (c instanceof JTextField) {
            ((JTextField) c).selectAll();
        }
    }

    //Workaround for formatted text field focus side effects.
    protected void selectItLater(Component c) {
        if (c instanceof JFormattedTextField) {
            final JFormattedTextField ftf = (JFormattedTextField) c;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    ftf.selectAll();
                }
            });
        }
    }

    //Needed for FocusListener interface.
    public void focusLost(FocusEvent e) {
    } //ignore

    protected JComponent createEntryFields() {
        JPanel panel = new JPanel(new SpringLayout());
        panel.setBackground(new Color(248, 213, 131));
        panel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        String[] labelStrings = {
                name1,
        };

        JLabel[] labels = new JLabel[labelStrings.length];
        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        //Create the text field and set it up.
        streetField = new JTextField();
        streetField.setColumns(25);
        fields[fieldNum++] = streetField;
        //Associate label/field pairs, add everything,
        //and lay it out.
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


    public JFormattedTextField getTextField(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            return ((JSpinner.DefaultEditor) editor).getTextField();
        } else {
            System.err.println("Unexpected editor type: "
                    + spinner.getEditor().getClass()
                    + " isn't a descendant of DefaultEditor");
            return null;
        }
    }


}