package Project11;

import OriginalCode.ui.Library;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowClose extends JFrame{
    //private Library l;
    private static final long serialVersionUID = 1L;

    public WindowClose(Library l) {
        setTitle("UBC Library System");
        setBounds(400, 400, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                int ans= JOptionPane.showConfirmDialog(null,"Would you like to save the information to UBC Library","Save",JOptionPane.YES_NO_OPTION);
                if(ans==0){
                    l.saveLibrary();
                    JOptionPane.showMessageDialog(new ProgressBarDemo(),new ProgressBarDemo());
                }
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });

        setVisible(true);
    }

}