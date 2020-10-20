package Project11;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;

/**
 * TextInputDemo.java uses these additional files:
 *   SpringUtilities.java
 *   ...
 */
public class TextInputDemo extends JPanel implements ActionListener,FocusListener {
    JTextField streetField, cityField;
    JFormattedTextField zipField;
    JSpinner stateSpinner;
    boolean addressSet = false;
    Font regularFont, italicFont;
    JLabel addressDisplay;
    final static int GAP = 10;
    String name1;
    String name2;
    static JButton button1;
    public TextInputDemo(String name1,String name2) {
        // setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.name1=name1;
        this.name2=name2;
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
        leftHalf.add(createButtons());

        add(leftHalf);
        //  add(createAddressDisplay());
    }

    protected JComponent createButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        panel.setBackground(new Color(248, 213, 131));
        button1 = new JButton("Continue");
        button1.setFont(new Font(Font.DIALOG,Font.PLAIN, 20));
        button1.addActionListener(this);
        button1.setActionCommand("Continue");
        button1.setEnabled(false);
        panel.add(button1);

        JButton button = new JButton("Exit");
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
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
        String[] A=new String[2];
        if ("Continue".equals(e.getActionCommand())) {
            A[0]=streetField.getText();
            A[1]=cityField.getText();
            WelcomeToLibraryGUI.identity(A);
        }
        if("Exit".equals(e.getActionCommand())){
            try {
                WelcomeToLibraryGUI.Exit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }




    protected String formatAddress() {
        if (!addressSet) return "No address set.";

        String street = streetField.getText();
        String city = cityField.getText();
        String state = (String) stateSpinner.getValue();
        String zip = zipField.getText();
        String empty = "";

        if ((street == null) || empty.equals(street)) {
            street = "<em>(no street specified)</em>";
        }
        if ((city == null) || empty.equals(city)) {
            city = "<em>(no city specified)</em>";
        }
        if ((state == null) || empty.equals(state)) {
            state = "<em>(no state specified)</em>";
        } else {
            int abbrevIndex = state.indexOf('(') + 1;
            state = state.substring(abbrevIndex,
                    abbrevIndex + 2);
        }
        if ((zip == null) || empty.equals(zip)) {
            zip = "";
        }

        StringBuffer sb = new StringBuffer();
        sb.append("<html><p align=center>");
        sb.append(street);
        sb.append("<br>");
        sb.append(city);
        sb.append(" ");
        sb.append(state); //should format
        sb.append(" ");
        sb.append(zip);
        sb.append("</p></html>");

        return sb.toString();
    }

    //A convenience method for creating a MaskFormatter.
    protected MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
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
                name2,
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
                if(cityField.getText().length()!=8) {
                    button1.setEnabled(false);
                }
                else
                    button1.setEnabled(true);
            }
        });


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
        frame.add(new TextInputDemo("",""));

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}