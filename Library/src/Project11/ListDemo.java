package Project11;

import OriginalCode.WelcomeToLibrary;
import OriginalCode.ui.Library;
import OriginalCode.ui.Student;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/* ListDemo.java requires no other files. */
public class ListDemo extends JPanel
        implements ListSelectionListener {
    public static WelcomeToLibrary w=new WelcomeToLibrary();
    Student s;
    Library lib;
    JFrame p;
    private JList list;
    private DefaultListModel listModel;

    private static final String hireString = "Confirm";
    private static final String fireString = "Choose";
    private JButton fireButton;
    private JTextField employeeName;
    private JButton hireButton;
    public ListDemo( Student s,Library l,JFrame f) {
        super(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("(1) Display all books in store");
        listModel.addElement("(2) Check for a specific book");
        listModel.addElement("(3) Check personal information");
        listModel.addElement("(4) Lend a book");
        listModel.addElement("(5) Return a book");
        listModel.addElement("(6) Specification recommendation");
        listModel.addElement("(7) Check librarian list");
        listModel.addElement("(8) Online Library");
        listModel.addElement("(9) exit");
        this.s=s;
        this.lib=l;
        this.p=f;
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        hireButton = new JButton(hireString);
        HireListener hireListener = new HireListener(hireButton);
        hireButton.setActionCommand(hireString);
        hireButton.addActionListener(hireListener);
        hireButton.setEnabled(false);

        fireButton = new JButton(fireString);
        fireButton.setActionCommand(fireString);
        fireButton.addActionListener(new FireListener());

        employeeName = new JTextField(10);
        employeeName.addActionListener(hireListener);
        //employeeName.getDocument().addDocumentListener(hireListener);
        String name = listModel.getElementAt(
                list.getSelectedIndex()).toString();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(fireButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(employeeName);
        employeeName.enableInputMethods(false);
        buttonPane.add(hireButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    class FireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            employeeName.setText((String)listModel.getElementAt(index));
            hireButton.setEnabled(true);
//            try {
//                WelcomeToLibraryGUI.Exit();
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//            switch(index){
//                case 0: //lib.displayAvailableBooks();break;
//                case 1: //w.checkSingleBookHelper(lib);break;
//                case 2: //s.displayPrivateInformation();break;
//                case 3: //w.lendBookHelper(s,lib);break;
//                case 4: //w.returnBookHelper(s,lib);break;
//                case 5: //s.recommend(lib.getBookList());break;
//                case 6: // lib.checkLibrarianList(lib.getLibrarianList());break;
//                case 7:
////                    try {
////                        w.onlineLibHelper(lib);
////                    } catch (IOException e1) {
////                        e1.printStackTrace();
////                    }
////                    break;
//                case 8://return;
//            }
//            listModel.remove(index);
//
//            int size = listModel.getSize();
//
//            if (size == 0) { //Nobody's left, disable firing.
//                fireButton.setEnabled(false);
//
//            } else { //Select an index.
//                if (index == listModel.getSize()) {
//                    //removed item in last position
//                    index--;
//                }
//
//                list.setSelectedIndex(index);
//                list.ensureIndexIsVisible(index);
//            }
        }
    }

    //This listener is shared by the text field and the hire button.
    class HireListener implements ActionListener, DocumentListener {

        private boolean alreadyEnabled = false;
        private JButton button;

        public HireListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            p.setVisible(false);
            try{switch(list.getSelectedIndex()){
                case 0: w.mains1(s,lib);break;
                case 1: w.mains2(s,lib);break;
                case 2: w.mains3(s,lib);break;
                case 3: w.mains4(s,lib);break;
                case 4: w.mains5(s,lib);break;
                case 5: w.mains6(s,lib);break;
                case 6: w.mains7(s,lib);break;
                case 7:w.mains8(s,lib);break;
                case 8:w.mains9(s,lib);break;
            }}catch(IOException m){

            }
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                fireButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                fireButton.setEnabled(true);
            }
        }
    }

}
