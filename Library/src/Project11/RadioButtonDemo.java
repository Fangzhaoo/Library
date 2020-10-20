package Project11;

import OriginalCode.Exception.InvalidInputException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


    /*
     * RadioButtonDemo.java requires these files:
     *   images/Bird.gif
     *   images/Cat.gif
     *   images/Dog.gif
     *   images/Rabbit.gif
     *   images/Pig.gif
     */
    public class RadioButtonDemo extends JPanel
            implements ActionListener {
        static String birdString = "Math";
        static String catString = "English";
        static String dogString = "Engineering";
        static String[] a;
       // JLabel picture;

        public RadioButtonDemo(String[] s) {
            super(new BorderLayout());
            a=s;
            //Create the radio buttons.
            JRadioButton birdButton = new JRadioButton(birdString);
            birdButton.setMnemonic(KeyEvent.VK_B);
            birdButton.setActionCommand("Math");
            birdButton.setSelected(true);
            birdButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            JRadioButton catButton = new JRadioButton(catString);
            catButton.setMnemonic(KeyEvent.VK_C);
            catButton.setActionCommand("English");
            catButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));

            JRadioButton dogButton = new JRadioButton(dogString);
            dogButton.setMnemonic(KeyEvent.VK_D);
            dogButton.setActionCommand("Engineering");
            dogButton.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));


            //Group the radio buttons.
            ButtonGroup group = new ButtonGroup();
            group.add(birdButton);
            group.add(catButton);
            group.add(dogButton);

            //Register a listener for the radio buttons.
            birdButton.addActionListener(this);
            catButton.addActionListener(this);
            dogButton.addActionListener(this);



            //Put the radio buttons in a column in a panel.
            JPanel radioPanel = new JPanel(new GridLayout(0, 1));
            radioPanel.add(birdButton);
            radioPanel.add(catButton);
            radioPanel.add(dogButton);
            radioPanel.setBackground(new Color(248, 213, 131));
            radioPanel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
            add(radioPanel, BorderLayout.LINE_START);
            //add(picture, BorderLayout.CENTER);
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        }

        /** Listens to the radio buttons. */
        public void actionPerformed(ActionEvent e) {


            int n = JOptionPane.showConfirmDialog(null, "Register as "+e.getActionCommand()+" student ?", "Major Choice",JOptionPane.YES_NO_OPTION);
            if(n==0){
                JOptionPane.showMessageDialog(new ProgressButtonDemo2(),new ProgressButtonDemo2());
                try {
                    WelcomeToLibraryGUI.r(e.getActionCommand(),a);
                } catch (InvalidInputException e1) {
                    e1.printStackTrace();
                }
            }
            if(n==1){

            }
        }

    }

