package Project11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextAndPasswordDemo extends JPanel implements ActionListener,FocusListener {
    JTextField streetField;
    JFormattedTextField zipField;
    JSpinner stateSpinner;
    boolean addressSet = false;
    Font regularFont, italicFont;
    JLabel addressDisplay;
    final static int GAP = 10;
    static JButton button1;
    public TextAndPasswordDemo() {
        JPanel leftHalf = new JPanel() {
            //Don't allow us to stretch vertically.
            public Dimension getMaximumSize() {
                Dimension pref = getPreferredSize();
                return new Dimension(Integer.MAX_VALUE,
                        pref.height);
            }
        };
        leftHalf.setBackground(new Color(248, 213, 131));
        leftHalf.add(createEntryFields());
        leftHalf.add(createPassword());
        leftHalf.add(createPassword2());
        leftHalf.add(createButtons());
        add(leftHalf);
        //  add(createAddressDisplay());
    }
    protected JComponent createPassword(){

        return new PasswordDemo("Create your password:");
    }
    protected JComponent createPassword2(){

        return new PasswordDemo("Confirm your password:");
    }
    protected JComponent createButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel.setBackground(new Color(248, 213, 131));
        button1 = new JButton("Continue");
        button1.setFont(new Font(Font.DIALOG,Font.PLAIN, 15));
        button1.addActionListener(this);
        button1.setActionCommand("Continue");
        button1.setEnabled(false);
        panel.add(button1);

        JButton button = new JButton("Exit");
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        button.addActionListener(this);
        button.setActionCommand("Exit");
        panel.add(button);

        //Match the SpringLayout's gap, subtracting 5 to make
        //up for the default gap FlowLayout provides.
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0,
                GAP - 5, GAP - 5));
        return panel;
    }

    /**
     * Called when the user clicks the button or presses
     * Enter in a text field.
     */
    public void actionPerformed(ActionEvent e) {
//        String[] A=new String[2];
        if ("Continue".equals(e.getActionCommand())) {
        }
        if("Exit".equals(e.getActionCommand())){
        }


        //updateDisplays();
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
                "Create your ID:",
        };

        JLabel[] labels = new JLabel[labelStrings.length];

        JComponent[] fields = new JComponent[labelStrings.length];
        int fieldNum = 0;

        //Create the text field and set it up.
        streetField = new JTextField();
        streetField.setColumns(20);
        fields[fieldNum++] = streetField;


        //Associate label/field pairs, add everything,
        //and lay it out.
        for (int i = 0; i < labelStrings.length; i++) {
            labels[i] = new JLabel(labelStrings[i],
                    JLabel.LEFT);
            labels[i].setLabelFor(fields[i]);
            labels[i].setFont(new Font(Font.DIALOG, Font.BOLD, 15));
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

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TextInputDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new TextAndPasswordDemo());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
