package Project11;

import OriginalCode.Exception.InvalidInputException;
import OriginalCode.WelcomeToLibrary;
import OriginalCode.ui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WelcomeToLibraryGUI {
    static Library UBClibrary=Library.getInstance();
    static WelcomeToLibrary w=new WelcomeToLibrary();
    //static Library UBClibrary=Library.getInstance();
    public static JFrame frame;
    public static JPanel panel1 = new JPanel();
    public static JPanel panel2= new JPanel();
    public static JPanel panel3=new JPanel();
    public static JPanel panel4=new JPanel();
    public static JPanel panel5=new JPanel();
    public static JPanel panel6=new JPanel();
    public static JPanel panel7=new JPanel();
    public static JPanel panel8=new JPanel();
    public static JPanel panel9=new JPanel();
    public static JPanel panel10=new JPanel();
    public static JPanel panel11=new JPanel();
    public static TextDemo t;
    public static PasswordDemo p;
    public static PasswordDemo q;
    public static TextDemo j;
    public static PasswordDemo l;
    public static void main(String[] args) throws IOException {
        if(UBClibrary.loadLibrary()!=null)
            UBClibrary=UBClibrary.loadLibrary();
        frame=new WindowClose(UBClibrary);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        panel1.setVisible(true);
        placeComponents(panel1);
        frame.setVisible(true);

        /////////////////////////////////////////////////
        UBClibrary.saveLibrary();
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);
        ButtonDemo button=new ButtonDemo("New    User","Click to enter Registration System","a");
        button.setBounds(450,580,200,300);
        button.setBackground(new Color(248, 213, 131));

        panel.add(button);
        ButtonDemo button2=new ButtonDemo("Returning    User","Click to enter Login System","b");
        button2.setBounds(780,580,250,300);
        button2.setBackground(new Color(248, 213, 131));
        panel.add(button2);
        JLabel yellowLabel = new JLabel("Welcome to UBC Library",JLabel.CENTER);

        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
        // 创建 JLabel
        //JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
//        userLabel.setBounds(500,500,200,200);
//        userLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//        panel.add(userLabel);
//
//        /*
//         * 创建文本域用于用户输入
//         */
//        JTextField userText = new JTextField(20);
//        userText.setBounds(100,20,165,25);
//        panel.add(userText);
//
//        // 输入密码的文本域
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(10,50,80,25);
//        panel.add(passwordLabel);
//
//        /*
//         *这个类似用于输入的文本域
//         * 但是输入的信息会以点号代替，用于包含密码的安全性
//         */
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100,50,165,25);
//        panel.add(passwordText);
//
//        // 创建登录按钮
//        JButton loginButton = new JButton("login");
//        loginButton.setBounds(10, 80, 80, 25);
//        panel.add(loginButton);
    }
    public static void registration(){
        placeComponents2(panel2);
        frame.add(panel2);
        panel1.setVisible(false);
        panel2.setVisible(true);
    }
    public static void registrationAsStudent(){
        placeComponents3(panel3);
        frame.add(panel3);
        panel2.setVisible(false);
        panel3.setVisible(true);
    }
    private static void placeComponents2(JPanel panel) {

        panel.setLayout(null);
        ButtonDemo button3=new ButtonDemo("Student","","c");
        button3.setBounds(450,580,200,300);
        button3.setBackground(new Color(248, 213, 131));
        panel.add(button3);
        JLabel l=new JLabel(" You would like to be registered as:",JLabel.CENTER);
        l.setBounds(0,400,800,300);
        l.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        panel.add(l);
        ButtonDemo button4=new ButtonDemo("Librarian","","d");
        button4.setBounds(780,580,250,300);
        button4.setBackground(new Color(248, 213, 131));
        panel.add(button4);
        JLabel yellowLabel = new JLabel("Welcome to UBC Library Registration System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);

        // 创建 JLabel
        //JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
//        userLabel.setBounds(500,500,200,200);
//        userLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//        panel.add(userLabel);
//
//        /*
//         * 创建文本域用于用户输入
//         */
//        JTextField userText = new JTextField(20);
//        userText.setBounds(100,20,165,25);
//        panel.add(userText);
//
//        // 输入密码的文本域
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setBounds(10,50,80,25);
//        panel.add(passwordLabel);
//
//        /*
//         *这个类似用于输入的文本域
//         * 但是输入的信息会以点号代替，用于包含密码的安全性
//         */
//        JPasswordField passwordText = new JPasswordField(20);
//        passwordText.setBounds(100,50,165,25);
//        panel.add(passwordText);
//
//        // 创建登录按钮
//        JButton loginButton = new JButton("login");
//        loginButton.setBounds(10, 80, 80, 25);
//        panel.add(loginButton);
    }
    public static void registrationAsLibrarian(){
        placeComponents6(panel6);
        frame.add(panel6);
        panel2.setVisible(false);
        panel6.setVisible(true);
    }
    private static void placeComponents6(JPanel panel){
        panel.setLayout(null);
//        TextAndPasswordDemo text1=new TextAndPasswordDemo();
//        text1.setBounds(450,480,600,300);
//        text1.setBackground(new Color(248, 213, 131));
//        text1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

//        panel.add(text1);
        t=new TextDemo("Create your ID:");
        t.setBounds(489,520,600,200);
        t.setBackground(new Color(248, 213, 131));
        t.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        p=new PasswordDemo("Create your password:");
        p.setBounds(459,560,600,200);
        p.setBackground(new Color(248, 213, 131));
        p.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        q=new PasswordDemo("Confirm your password:");
        q.setBounds(450,600,600,200);
        q.setBackground(new Color(248, 213, 131));
        q.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
//        String[] pack=new String[3];
//        pack[0]=t.streetField.getText();
//        pack[1]=p.getText();
//        pack[2]=q.getText();
        ButtonDemo button3=new ButtonDemo("Confirm","","e");
        ButtonDemo button = new ButtonDemo("Exit","","exit");
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        button.setBackground(new Color(248, 213, 131));
        button.setBounds(940,650,80,100);
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        //button.addActionListener(this);
        panel.add(button);
        button3.setBounds(750,650,200,200);
        button3.setBackground(new Color(248, 213, 131));
        button3.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        panel.add(button3);
        panel.add(q);
        panel.add(p);
        panel.add(t);


        JLabel yellowLabel = new JLabel("Welcome to UBC Library Registration System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
    }
    public static void veryfyLibrarian() throws InvalidInputException {
        String ID=t.streetField.getText();
        String p1=p.getText();
        String q1=q.getText();
        if(!p1.equals(q1))
            JOptionPane.showMessageDialog(null,"Password not equal"," ",JOptionPane.WARNING_MESSAGE);
        else if(p1.length()<=3||p1.length()>=8)
            JOptionPane.showMessageDialog(null,"Password length must be between 3 to 8 exclusive"," ",JOptionPane.WARNING_MESSAGE);
        else {
            Librarian l=new Librarian(ID,p1);
            if(UBClibrary.getLibrarianList().contains(l))
                JOptionPane.showMessageDialog(null,"ID is occupied"," ",JOptionPane.WARNING_MESSAGE);
            else {
                UBClibrary.getLibrarianList().add(l);
                JOptionPane.showMessageDialog(new ProgressButtonDemo2(),new ProgressButtonDemo2());
                librarianService2(l);
            }
        }
    }
    private static void placeComponents3(JPanel panel){
        panel.setLayout(null);
        TextInputDemo text1=new TextInputDemo("Enter your name:","Enter your ID:");
        text1.setBounds(450,500,600,300);
        text1.setBackground(new Color(248, 213, 131));
        text1.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        panel.add(text1);


        JLabel yellowLabel = new JLabel("Welcome to UBC Library Registration System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
    }
    public static void identity(String[] A){
        Student s=null;
        try {
            if(A[1]!=null)
            s=new MathStudent(A[0],A[1]);
        //    System.out.println(UBClibrary.getStudentList().get(0).equals(s));
        } catch (InvalidInputException e) {
        }
        if(UBClibrary.getStudentList().contains(s)){
            JOptionPane.showMessageDialog(null,"Name or ID is occupied"," ",JOptionPane.WARNING_MESSAGE);
        }
        else{
            registerS(A);
        }
    }
    public static void verifyReturning1(){
        placeComponent7(panel7);
        frame.add(panel7);
        panel1.setVisible(false);
        panel7.setVisible(true);
    }
    public static void placeComponent7(JPanel panel){
        panel.setLayout(null);
        panel.setLayout(null);
        ButtonDemo button3=new ButtonDemo("Student","","m");
        button3.setBounds(450,580,200,300);
        button3.setBackground(new Color(248, 213, 131));
        panel.add(button3);
        JLabel l=new JLabel(" You are:",JLabel.CENTER);
        l.setBounds(0,400,800,300);
        l.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        panel.add(l);
        ButtonDemo button4=new ButtonDemo("Librarian","","n");
        button4.setBounds(780,580,250,300);
        button4.setBackground(new Color(248, 213, 131));
        panel.add(button4);
        JLabel yellowLabel = new JLabel("Welcome to UBC Library Login System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
    }
    public static void registerS(String[] A){
        placeComponents5(panel5,A);
        frame.add(panel5);
        panel3.setVisible(false);
        panel5.setVisible(true);
    }
    public static void studentReturn(){
        placeComponents8(panel8);
        frame.add(panel8);
        panel7.setVisible(false);
        panel8.setVisible(true);
    }
    public static void librarianReturn(){
        placeComponents9(panel9);
        frame.add(panel9);
        panel7.setVisible(false);
        panel9.setVisible(true);
    }
    public static void identity2(String[] A) throws InvalidInputException {
        boolean b=false;
        for(Student s:UBClibrary.getStudentList()){
            if(s.getSName().equals(A[0])&&s.getSID().equals(A[1])) {
                b = true;
                studentService(s);
            }
        }
        if(b==true){

        }
        else{
            int m = JOptionPane.showConfirmDialog(null, "Sorry, you are not in our student list, register or not?", "User Not Found",JOptionPane.YES_NO_OPTION);
            if(m==0){
                registrationAsStudent2();
            }
        }
    }
    public static void studentService(Student s){
        placeComponents10(panel10,s);
        frame.add(panel10);
        panel8.setVisible(false);
        panel10.setVisible(true);
    }
    public static void placeComponents10(JPanel panel,Student s){
        panel.setLayout(null);
        JLabel yellowLabel = new JLabel("Welcome, "+s.getSName(),JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));


        JLabel j=new JLabel("Choose a service: ",JLabel.CENTER);
        j.setBounds(550,450,200,30);
        j.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        j.setOpaque(true);
        j.setBackground(new Color(248, 213, 131));
        j.setPreferredSize(new Dimension(200, 180));
        panel.add(j);
       //选服务
        ListDemo lis=new ListDemo(s,UBClibrary,frame);
        lis.setBackground(new Color(248, 213, 131));
        lis.setBounds(450,500,600,200);
        panel.add(lis);
        panel.add(yellowLabel);
//       ButtonDemo button1=new ButtonDemo("Confirm","","con");
//        button1.setBackground(new Color(248, 213, 131));
//        button1.setBounds(940,650,80,100);
//        button1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
//        ButtonDemo button2=new ButtonDemo("Exit","","exit");
//        button2.setBackground(new Color(248, 213, 131));
//        button2.setBounds(940,650,80,100);
//        button2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
//        panel.add(button1);
//        panel.add(button2);

    }
    public static void registrationAsStudent2(){
        placeComponents3(panel3);
        frame.add(panel3);
        panel8.setVisible(false);
        panel3.setVisible(true);
    }
    public static void placeComponents8(JPanel panel){
        panel.setLayout(null);
        TextInputDemo2 text2=new TextInputDemo2("Enter your name:","Enter your ID:");
        text2.setBounds(450,500,600,300);
        text2.setBackground(new Color(248, 213, 131));
        text2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        panel.add(text2);
        JLabel yellowLabel = new JLabel("Welcome to UBC Library Student Login System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);

    }
    public static void placeComponents9(JPanel panel){
        panel.setLayout(null);
         j=new TextDemo("Enter your ID:");
        j.setBounds(489,520,600,200);
        j.setBackground(new Color(248, 213, 131));
        j.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
         l=new PasswordDemo("Enter your password:");
        l.setBounds(459,560,600,200);
        l.setBackground(new Color(248, 213, 131));
        l.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        ButtonDemo button4=new ButtonDemo("Confirm","","p");
        button4.setBounds(750,650,200,200);
        button4.setBackground(new Color(248, 213, 131));
        button4.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        ButtonDemo button = new ButtonDemo("Exit","","exit");
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        button.setBackground(new Color(248, 213, 131));
        button.setBounds(940,650,80,100);
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        //button.addActionListener(this);
        panel.add(button);
        panel.add(button4);
        panel.add(l);
        panel.add(j);
        JLabel yellowLabel = new JLabel("Welcome to UBC Library Librarian Login System",JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
    }
    public static void librarianService(Librarian l){
        placeComponents11(panel11,l);
        frame.add(panel11);
        panel9.setVisible(false);
        panel11.setVisible(true);
    }
    public static void librarianService2(Librarian l){
        placeComponents11(panel11,l);
        frame.add(panel11);
        panel6.setVisible(false);
        panel11.setVisible(true);
    }
    public static void placeComponents11(JPanel panel,Librarian l){
        panel.setLayout(null);
        JLabel yellowLabel = new JLabel("Welcome, "+l.getID(),JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));


        JLabel j=new JLabel("Choose a service: ",JLabel.CENTER);
        j.setBounds(550,450,200,30);
        j.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        j.setOpaque(true);
        j.setBackground(new Color(248, 213, 131));
        j.setPreferredSize(new Dimension(200, 180));
        panel.add(j);
        ListDemo2 lis=new ListDemo2(l,UBClibrary,frame);
        lis.setBackground(new Color(248, 213, 131));
        lis.setBounds(450,500,600,200);
        panel.add(lis);

        panel.add(yellowLabel);
    }
    public static void identity3(String[] A){
        boolean b=false;
        for(Librarian s:UBClibrary.getLibrarianList()){
            if(s.getID().equals(A[0])&&s.getPassWord().equals(A[1])) {
                b = true;
                librarianService(s);
            }
        }
        if(b){

        }
        else{
            int m = JOptionPane.showConfirmDialog(null, "Sorry, you are not in our librarian list, register or not?", "User Not Found",JOptionPane.YES_NO_OPTION);
            if(m==0){
                registrationAsLibrarian2();
            }
        }
    }
    public static void registrationAsLibrarian2(){
        placeComponents6(panel6);
        frame.add(panel6);
        panel9.setVisible(false);
        panel6.setVisible(true);
    }
    public static void placeComponents5(JPanel panel,String[] s){
        panel.setLayout(null);
        RadioButtonDemo r=new RadioButtonDemo(s);
        r.setBounds(450,480,400,300);
        r.setBackground(new Color(248, 213, 131));
        r.setFont(new Font(Font.DIALOG, Font.BOLD, 20));

        panel.add(r);
        JLabel abel = new JLabel("choose your major: ",JLabel.CENTER);
        abel.setBounds(460,450,500,30);
        abel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

        abel.setOpaque(true);
        abel.setBackground(new Color(248, 213, 131));
        abel.setPreferredSize(new Dimension(200, 180));
        panel.add(abel);

        JLabel yellowLabel = new JLabel("Welcome, "+s[0],JLabel.CENTER);
        yellowLabel.setBounds(0,-40,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);

    }
    public static void r(String s,String[] a) throws InvalidInputException {
        Student st=null;
        switch(s){
            case "Math": st=new MathStudent(a[0],a[1]);break;
            case "English": st=new EnglishStudent(a[0],a[1]);break;
            case "Engineering": st=new EngineeringStudent(a[0],a[1]);break;
        }
        UBClibrary.getStudentList().add(st);
        studentService2(st);
    }
    public static void studentService2(Student s){
        placeComponents10(panel10,s);
        frame.add(panel10);
        panel5.setVisible(false);
        panel10.setVisible(true);
    }
    public static void Exit() throws Exception {
        placeComponents4(panel4);
        frame.add(panel4);
        panel3.setVisible(false);
        panel4.setVisible(true);
        int ans= JOptionPane.showConfirmDialog(null,"Would you like to save the information to UBC Library","Save",JOptionPane.YES_NO_OPTION);
        if(ans==0){
            UBClibrary.saveLibrary();
            JOptionPane.showMessageDialog(new ProgressBarDemo(),new ProgressBarDemo());

        }
        System.exit(0);
        frame.setVisible(false);
    }
    private static void placeComponents4(JPanel panel) {


        panel.setLayout(null);
        JLabel yellowLabel = new JLabel("Thanks for using UBC Library System",JLabel.CENTER);
        yellowLabel.setBounds(0,0,1500,850);
        yellowLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
        panel.add(yellowLabel);
    }
    public static void exit(){
        System.exit(0);
    }
}

