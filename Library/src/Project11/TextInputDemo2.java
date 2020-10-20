package Project11;

import OriginalCode.Exception.InvalidInputException;

import java.awt.event.ActionEvent;

public class TextInputDemo2 extends TextInputDemo {

    public TextInputDemo2(String s1, String s2){
        super(s1,s2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] A=new String[2];
        if ("Continue".equals(e.getActionCommand())) {
            A[0]=streetField.getText();
            A[1]=cityField.getText();
            try {
                WelcomeToLibraryGUI.identity2(A);
            } catch (InvalidInputException e1) {
                e1.printStackTrace();
            }
        }
        if("Exit".equals(e.getActionCommand())){
            try {
                WelcomeToLibraryGUI.Exit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


        //updateDisplays();
    }
}
