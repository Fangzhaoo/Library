package OriginalCode;

import OriginalCode.Exception.*;
import OriginalCode.ui.*;
import Project11.WelcomeToLibraryGUI;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Observable;
import java.util.Scanner;

import static java.lang.System.exit;

public class WelcomeToLibrary extends Observable{
    static WelcomeToLibrary w=new WelcomeToLibrary();
    static Scanner scan=new Scanner(System.in);
//    Library UBClibrary=new Library();

//    public static void main(String[] args) throws IOException {
//        Library UBClibrary=Library.getInstance();
//        if(UBClibrary.loadLibrary()!=null)
//            UBClibrary=UBClibrary.loadLibrary();
//        for(Librarian librarian:UBClibrary.getLibrarianList()){
//            w.addObserver(librarian);
//        }
//        //System.out.println(UBClibrary.getStudentList().get(0).getSName()+UBClibrary.getStudentList().get(0).getSID());
//        System.out.println("WelCome to UBC Library.");
//        Object o = logInSystem(UBClibrary);
//        if (o instanceof Student) {
//            studentSystem(UBClibrary, ((Student) o));
//        }
//        else if (o instanceof Librarian)
//            librarianSystem(UBClibrary,((Librarian) o));
//        else
//            System.out.println("System exits.");
//        System.out.println("Thanks for using UBClibrary");
//        UBClibrary.saveLibrary();
//    }

    public static void mains1(Student s,Library l) throws IOException {

        l.displayAvailableBooks();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains2(Student s,Library l) throws IOException {

        checkSingleBookHelper(l);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains3(Student s,Library l) throws IOException {

        s.displayPrivateInformation();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains4(Student s,Library l) throws IOException {

        lendBookHelper(s,l);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains5(Student s,Library l) throws IOException {

        returnBookHelper(s,l);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains6(Student s,Library l) throws IOException {

        s.recommend(l.getBookList());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains7(Student s,Library l) throws IOException {

        l.checkLibrarianList(l.getLibrarianList());
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains8(Student s,Library l) throws IOException {

        onlineLibHelper(l);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(l,s);
            return;
        }
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mains9(Student s,Library l)  {

        System.out.println("Thanks for using UBClibrary");
        l.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mainl1(Librarian l,Library lib){
        l.setStatus(true);
        buyNewBooksHelper(l,lib);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,l);
            return;
        }
        lib.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mainl2(Librarian l,Library lib){
        l.setStatus(true);
        lib.displayStudentInformation();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,l);
            return;
        }
        lib.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mainl3(Librarian l,Library lib){
        l.setStatus(true);
        checkSingleStudentHelper(lib);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,l);
            return;
        }
        lib.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mainl4(Librarian l,Library lib){
        l.setStatus(false);
        System.out.println("Thanks for using UBClibrary");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,l);
            return;
        }
        lib.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    public static void mainl5(Librarian l,Library lib){
        l.setStatus(true);
        System.out.println("Thanks for using UBClibrary");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,l);
            return;
        }
        lib.saveLibrary();
        WelcomeToLibraryGUI.exit();
        exit(0);
    }
    //REQUIRES: lib must be non-null
    //MODIFIES:this
    //EFFECTS: verify user's identity
    public static Object logInSystem(Library lib){
        System.out.println("1: Existing User     2: New User");
        String answer=scan.next();
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1: Existing User  2: New User)");
            answer=scan.next();
        }
        if(answer.equals("1")){
            return identityVerifySystem(lib);
        }
        else{
            System.out.println("You would like to be registered as: (1) student   (2) librarian");
            String answer1=scan.next();
            while(!answer1.equals("1")&&!answer1.equals("2")){
                System.out.println("Invalid input. Please enter again:  (1 for student  2 for librarian)");
                answer1=scan.next();
            }
            if(answer1.equals("1"))
                return w.studentRegistrationSystem(lib);
            else
                return w.librarianRegistrationSystem(lib);
        }
    }
    //REQUIRES: lib must be non-null
    //MODIFIES:this
    //EFFECTS: create and return a new student if not a previous user, otherwise asking for signing or exist.
    public  Student studentRegistrationSystem(Library lib){
        Student newStudent=null;
        System.out.println("Please enter your name: ");
        String name=scan.next()+scan.nextLine();
        System.out.println("Please enter your student ID: ");
        String ID=scan.nextLine();
        System.out.print("What is your major (Math/English/Engineering): ");
        String specification=scan.nextLine();
        while(!specification.equals("Math")&&!specification.equals("English")&&!specification.equals("Engineering")){
            System.out.println("Invalid input. Please enter again:  (Math/English/Engineering)");
            specification=scan.next();
        }
        switch(specification){
            case "Math": {
                try {
                    newStudent=new MathStudent(name,ID);
                } catch (InvalidInputException e) {
                    System.out.println("Sorry, your student ID should be of 8 digits. (Input 1 to enter again/ 2 to exit)");
                    String answer1=scan.next();
                    while(!answer1.equals("1")&&!answer1.equals("2")){
                        System.out.println("Invalid input. Please enter again:  (Input 1 to enter again/ 2 to exit)");
                        answer1=scan.next();
                    }
                    if(answer1.equals("1"))
                        return studentRegistrationSystem(lib);
                    else
                        return null;
                }
            }break;
            case "English": {
                try {
                    newStudent=new EnglishStudent(name,ID);
                } catch (InvalidInputException e) {
                    System.out.println("Sorry, your student ID should be of 8 digits. (Input 1 to enter again/ 2 to exit)");
                    String answer1=scan.next();
                    while(!answer1.equals("1")&&!answer1.equals("2")){
                        System.out.println("Invalid input. Please enter again:  (Input 1 to enter again/ 2 to exit)");
                        answer1=scan.next();
                    }
                    if(answer1.equals("1"))
                        return studentRegistrationSystem(lib);
                    else
                        return null;
                }
            }break;
            case "Engineering": {
                try {
                    newStudent=new EngineeringStudent(name,ID);
                } catch (InvalidInputException e) {
                    System.out.println("Sorry, your student ID should be of 8 digits. (Input 1 to enter again/ 2 to exit)");
                    String answer1=scan.next();
                    while(!answer1.equals("1")&&!answer1.equals("2")){
                        System.out.println("Invalid input. Please enter again:  (Input 1 to enter again/ 2 to exit)");
                        answer1=scan.next();
                    }
                    if(answer1.equals("1"))
                        return studentRegistrationSystem(lib);
                    else
                        return null;
                }
            }
        }
        for(Student a:lib.getStudentList()){
            if(a.equals(newStudent)){
                System.out.println("Either name or ID is overlapped.");
                System.out.println("Would you like to sign in directly/ input again to register/ exit (1 for sign in; 2 for input; 3 for exit)");
                String answer=scan.next();
                while(!answer.equals("1")&&!answer.equals("2")&&!answer.equals("3")){
                    System.out.println("Invalid input. Please enter again:  (1 for sign in; 2 for input; 3 for exit)");
                    answer=scan.next();
                }
                if(answer.equals("3"))
                    return null;
                if(answer.equals("1"))
                    return a;
                else
                    return studentRegistrationSystem(lib);
            }
        }
        lib.getStudentList().add(newStudent);
        setChanged();
        notifyObservers(newStudent);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Congratulations, "+newStudent.getSName()+", you are registered successfully. We are happy to have you here!");
        System.out.println("You need to know:");
        System.out.println("(1) You can not keep more than 5 books at the same time");
        System.out.println("(2) You have 50 credits at the beginning");
        System.out.println("(3) You have to return a book with in 10 days, otherwise you will receive credit deduction of 2");
        System.out.println("(4) You need to have not less than 5 credits for lending books of specification, and 3 credits for lending books of recreation.");
        System.out.println("(5) Every time you order a book, 10 credits will be subtracted.");
        System.out.println();
        System.out.println("Now we will send you to the service center.");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        return newStudent;
    }
    //REQUIRES: lib must be non-null
    //MODIFIES:this
    //EFFECTS: create and return a new librarian with unique ID
    public Librarian librarianRegistrationSystem(Library lib){
        Librarian newLibrarian=null;
        System.out.println("Please enter an ID: ");
        String ID=scan.next()+scan.nextLine();
        for(Librarian a:lib.getLibrarianList()){
            if(a.getID().equals(ID)){
                System.out.println("Sorry, ID already exists (1 for input again/ 2 for exits):");
                String answer=scan.nextLine();
                while(!answer.equals("1")&&!answer.equals("2")){
                    System.out.println("Invalid input. Please enter again:  (1 for input again/ 2 for exits)");
                    answer=scan.next();
                }
                if(answer.equals("1"))
                    return librarianRegistrationSystem(lib);
                else
                    return null;
            }
        }
        System.out.println("Available ID");
        System.out.println("Please enter your password (3 to 10 digits exclusive): ");
        String password=scan.next()+scan.nextLine();
        try {
            newLibrarian=new Librarian(ID,password);
        } catch (InvalidInputException e) {
            System.out.println("Sorry, password is not valid (1 for input again/ 2 for exits):");
            String answer=scan.next()+scan.nextLine();
            while(!answer.equals("1")&&!answer.equals("2")){
                System.out.println("Invalid input. Please enter again:  (1 for input again/ 2 for exits)");
                answer=scan.next();
            }
            if(answer.equals("2"))
                return null;
            System.out.println("Please enter your password (3 to 10 digits exclusive)::");
            password=scan.next()+scan.nextLine();
            while(password.length()<4||password.length()>9){
                System.out.println("Sorry, password is not valid (1 for input again/ 2 for exits):");
                String answer1=scan.nextLine();
                while(!answer1.equals("1")&&!answer1.equals("2")){
                    System.out.println("Invalid input. Please enter again:  (1 for input again/ 2 for exits)");
                    answer1=scan.next();
                }
                if(answer1.equals("2"))
                    return null;
                System.out.println("Please enter your password (3 to 10 digits exclusive):");
                password=scan.next()+scan.nextLine();
            }
        }

        lib.getLibrarianList().add(newLibrarian);
        setChanged();
        notifyObservers(newLibrarian);
        w.addObserver(newLibrarian);
        try {
            newLibrarian=new Librarian(ID,password);
            System.out.println("Registered successful!");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
        } catch (InvalidInputException e1) {
        }
        return newLibrarian;
    }
    //REQUIRES: lib is non-null
    //MODIFIES:this
    //EFFECTS: confirm and return user's information if is a former user, otherwise ask user to register or exit
    public static Object identityVerifySystem(Library lib){
        System.out.println("Are you student or librarian? (1 for student/ 2 for librarian)");
        String answer=scan.next()+scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1: student  2: librarian)");
            answer=scan.next()+scan.nextLine();
        }
        if(answer.equals("1")){
            String a="1";
            Object o=helpIdentityVerify(lib);
            while(o==null){
                System.out.println("Sorry, you are not in our student list. (1: Input again   2: register   3:exit)");
                a=scan.next()+scan.nextLine();
                while(!a.equals("1")&&!a.equals("2")&&!a.equals("3")){
                    System.out.println("Invalid input. Please enter again:  (1: Input again   2: register   3:exit)");
                    a=scan.next()+scan.nextLine();
                }
                if(a.equals("2")||a.equals("3"))
                    break;
                o=helpIdentityVerify(lib);
            }
            if(a.equals("2"))
                return w.studentRegistrationSystem(lib);
            if(a.equals("3"))
                return null;
            return o;
        }
        else{
            String a="1";
            Object o=helpIdentityVerify2(lib);
            while(o==null){
                System.out.println("Sorry, you are not in our librarian list. (1: Input again   2: register   3:exit)");
                a=scan.next()+scan.nextLine();
                while(!a.equals("1")&&!a.equals("2")&&!a.equals("3")){
                    System.out.println("Invalid input. Please enter again:  (1: Input again   2: register   3:exit)");
                    a=scan.next()+scan.nextLine();
                }
                if(a.equals("2")||a.equals("3"))
                    break;
                o=helpIdentityVerify2(lib);
            }
            if(a.equals("2")) {
                return w.librarianRegistrationSystem(lib);
            }
            if(a.equals("3"))
                return null;
            return o;
        }
    }
    //REQUIRES: lib and student are both non-null
    //MODIFIES: lib,student
    //EFFECTS:offer the service system for student
    public static void studentSystem(Library lib,Student student) throws IOException {
        System.out.println("Welcome to student service system! "+student.getSName());
        System.out.println("What kind of service do you want:");
        System.out.println("(1) Display all books in store");
        System.out.println("(2) Check for a specific book");
        System.out.println("(3) Check personal information");
        System.out.println("(4) Lend a book");
        System.out.println("(5) Return a book");
        System.out.println("(6) Specification recommendation");
        System.out.println("(7) Check librarian list");
        System.out.println("(8) Online Library");
        System.out.println("(9) exit");
        System.out.println("Enter 1/2/3/4/5/6/7/8/9 :");
        String answer=scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")&&!answer.equals("3")&&!answer.equals("4")&&!answer.equals("5")&&!answer.equals("6")&&!answer.equals("7")&&!answer.equals("8")&&!answer.equals("9")){
            System.out.println("Invalid input. Please enter again:  (Enter 1/2/3/4/5/6/7/8/9 ):");
            answer=scan.next();
        }
        switch(answer){
            case "1": lib.displayAvailableBooks();break;
            case "2": checkSingleBookHelper(lib);break;
            case "3": student.displayPrivateInformation();break;
            case "4": lendBookHelper(student,lib);break;
            case "5": returnBookHelper(student,lib);break;
            case "6": student.recommend(lib.getBookList());break;
            case "7": //student.checkLibrarianList(lib.getLibrarianList());break;
                lib.checkLibrarianList(lib.getLibrarianList());break;
            case "8": onlineLibHelper(lib);break;
            case "9":exit(0);
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            studentSystem(lib,student);
            return;
        }
        return;
    }

    //REQUIRES: lib and librarian are both non-null
    //MODIFIES: lib
    //EFFECTS:offer the service system for librarian
    public static void librarianSystem(Library lib,Librarian librarian){
        librarian.setStatus(true);
        System.out.println("Welcome to student service system! "+librarian.getID());
        System.out.println("What kind of service do you want:");
        System.out.println("(1) Buy in new books");
        System.out.println("(2) Display all students' information");
        System.out.println("(3) Check single student's information");
        System.out.println("(4) Log Out");
        System.out.println("(5) Exit without logging out");
        System.out.println("Enter 1/2/3/4/5");
        String answer=scan.next()+scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")&&!answer.equals("3")&&!answer.equals("4")&&!answer.equals("5")){
            System.out.println("Invalid input. Please enter again:  (Enter 1/2/3/4/5):");
            answer=scan.next()+scan.nextLine();
        }
        switch(answer){
            case "1": buyNewBooksHelper(librarian,lib);break;
            case "2": //librarian.displayStudentInformation(lib.getStudentList());break;
                lib.displayStudentInformation();break;
            case "3": checkSingleStudentHelper(lib);break;
            case "4": return;
            case "5":librarian.switchStatus();;return;
        }
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Another service? (1 for yes/ 2 for no):");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for yes/ 2 for no):");
            ans=scan.next();
        }
        if(ans.equals("1")){
            librarianSystem(lib,librarian);
            return;
        }
        return;
    }


    //REQUIRES：lib is non-null
    //EFFECTS: return the student if is in lib, otherwise return null
    public static Object helpIdentityVerify(Library lib){
        System.out.println("Please Enter Your Name:");
        String name=scan.next()+scan.nextLine();
        System.out.println("Please Enter Your ID: ");
        String ID=scan.next()+scan.nextLine();
        for(Student a:lib.getStudentList()){
            if(a.getSName().equals(name)&&a.getSID().equals(ID))
                return a;
        }
        return null;
    }
    //REQUIRES：lib is non-null
    //EFFECTS: return the librarian if is in lib, otherwise return null
    public static Object helpIdentityVerify2(Library lib){
        System.out.println("Please Enter Your ID:");
        String ID=scan.next()+scan.nextLine();
        System.out.println("Please Enter Your Password: ");
        String passWord=scan.next()+scan.nextLine();
        for(Librarian a:lib.getLibrarianList()){
            if(a.getID().equals(ID)&&a.getPassWord().equals(passWord)) {
                a.switchStatus();
                return a;
            }
        }
        return null;
    }
    //REQUIRES：lib is non-null
    //EFFECTS: display a single book's information
    public static void checkSingleBookHelper(Library lib){
        System.out.println("What book are you looking for? (1 for book name/ 2 for book ID): ");
        String answer=scan.next()+scan.nextLine();;
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for book name/ 2 for book ID)");
            answer=scan.next()+scan.nextLine();;
        }
        if(answer.equals("1")){
            System.out.println("Please enter book name:");
            String name=scan.next()+scan.nextLine();;
            Books a=lib.findBookByName(name);
            if(a==null) {
                System.out.println("Sorry, the book is not in store.");
                return;
            }
            lib.displaySingleBook(a);
        }
        else{
            System.out.println("Please enter book ID:");
            String ID=scan.next()+scan.nextLine();;
            Books a=lib.findBookByID(ID);
            if(a==null) {
                System.out.println("Sorry, the book is not in store.");
                return;
            }
            lib.displaySingleBook(a);
        }
    }
    //REQUIRES：l and s are both non-null
    //MODIFIES:this
    //EFFECTS: help student to finish lending a book from a given library
    public static void lendBookHelper(Student s,Library l){
        System.out.println("What book do you want to lend? (1 by name/ 2 by ID):");
        String answer=scan.next()+scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 by name/ 2 by ID)");
            answer=scan.next()+scan.nextLine();
        }
        if(answer.equals("1")){
            System.out.println("Please enter book name:");
            String name=scan.next()+scan.nextLine();
            Books book=l.findBookByName(name);
            if(book==null){
                System.out.println("Sorry, book is not in store.");
                return;
            }
            try {
                s.lendBook(book,l.getBookList());
                System.out.println("Lended successful!");
            }catch(CanNotLendTheSameBookException e){
                System.out.println("Sorry, you can not lend the same book twice");
            }catch (BookNotExistException e) {
            } catch (CreditNotEnoughException e) {
                System.out.println("Sorry, you do not have enough credit for lending the book.");
                return;
            } catch (NotEnoughBooksException e) {
                System.out.println("Sorry, there is 0 book left.");
                System.out.println("Would you like to contact a librarian for help or exit (1 for contacting librarian/ 2 for exits):");
                String answer1=scan.next()+scan.nextLine();
                while(!answer1.equals("1")&&!answer1.equals("2")){
                    System.out.println("Invalid input. Please enter again:  (1 for contacting librarian/ 2 for exits)");
                    answer1=scan.next()+scan.nextLine();
                }
                if(answer1.equals("2"))
                    return;
                try {
                    s.contactLibrarian(l);
                } catch (NoLibrarianAvailableException e1) {
                    System.out.println("Sorry, no librarian is now active. Please come next time.");
                    return;
                }
            } catch (MaximumBooksLendedException e) {
                System.out.println("Sorry, you have already kept 5 books at the same time, return a book before lending next one.");
                return;
            }finally{
                System.out.println("Caution: for all books you lend, remember to return them in 10 days.");
            }
        }
        else {
            System.out.println("Please enter book ID:");
            String ID = scan.next()+scan.nextLine();
            Books book = l.findBookByID(ID);
            if (book == null) {
                System.out.println("Sorry, book is not in store.");
                return;
            }
            try {
                s.lendBook(book, l.getBookList());
                System.out.println("Lended successful!");
            } catch(CanNotLendTheSameBookException e){
                System.out.println("Sorry, you can not lend the same book twice");
            }catch (BookNotExistException e) {
            } catch (CreditNotEnoughException e) {
                System.out.println("Sorry, you do not have enough credit for lending the book.");
                return;
            } catch (NotEnoughBooksException e) {
                System.out.println("Sorry, there is 0 book left.");
                System.out.println("Would you like to contact a librarian for help or exit (1 for contacting librarian/ 2 for exits):");
                String answer1 = scan.next()+scan.nextLine();
                while (!answer1.equals("1") && !answer1.equals("2")) {
                    System.out.println("Invalid input. Please enter again:  (1 for contacting librarian/ 2 for exits)");
                    answer1 = scan.next()+scan.nextLine();
                }
                if (answer1.equals("2"))
                    return;
                try {
                    //s.contactLibrarian(l.getLibrarianList(), l.getStudentList(), l.getBookList());
                    s.contactLibrarian(l);
                } catch (NoLibrarianAvailableException e1) {
                    System.out.println("Sorry, no librarian is now active. Please come next time.");
                    return;
                }
            } catch (MaximumBooksLendedException e) {
                System.out.println("Sorry, you have already kept 5 books at the same time, return a book before lending next one.");
                return;
            }
        }
    }
    //REQUIRES：l and s are both non-null
    //MODIFIES:this
    //EFFECTS: help student to finish returning a book from a given library
    public static void returnBookHelper(Student s,Library l){
        System.out.println("What book do you want to return? (1 by name/ 2 by ID):");
        String answer=scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 by name/ 2 by ID)");
            answer=scan.next();
        }
        if(answer.equals("1")){
            System.out.println("Please enter book name:");
            String name=scan.nextLine();
            Books book=l.findBookByName(name);
            if(book==null){
                System.out.println("Sorry, book is not in store.");
                return;
            }
            try {
                s.returnBook(book,l.getBookList());
                System.out.println("Return successfully!");
                return;
            } catch (BookNotExistException e) {
                System.out.println("Sorry, the book is not kept by you.");
                return;
            }
        }
        else{
            System.out.println("Please enter book ID:");
            String ID=scan.nextLine();
            Books book=l.findBookByID(ID);
            if(book==null){
                System.out.println("Sorry, book is not in store.");
                return;
            }
            try {
                s.returnBook(book,l.getBookList());
                System.out.println("Return successfully!");
                return;
            } catch (BookNotExistException e) {
                System.out.println("Sorry, the book is not kept by you.");
                return;
            }
        }
    }

    //REQUIRES：librarian and l are both non-null
    //MODIFIES:l
    //EFFECTS: help librarian finish buying books
    public static void buyNewBooksHelper(Librarian librarian,Library l){
        System.out.println("Do you want add to existing book or buy in new book? (1 for existing book/ 2 for new book)");
        String answer=scan.nextLine();
        while(!answer.equals("1")&&!answer.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for existing book/ 2 for new book)");
            answer=scan.next();
        }
        if(answer.equals("1")){
            System.out.println("Enter book name: ");
            String name=scan.next()+scan.nextLine();
            System.out.println("Enter book ID: ");
            String ID=scan.next()+scan.nextLine();
            Books a=null;
            for(Books book:l.getBookList()){
                if(book.getBookName().equals(name)&&book.getBookID().equals(ID))
                    a=book;
            }
            if(a==null){
                System.out.println("Sorry, the book is not in store");
                return;
            }
            System.out.println("How many books do you want to add to?");
            String amount=scan.next()+scan.nextLine();
            int amo=checkValue(amount);
            try {
                librarian.buyExistingBooks(l.getBookList(),a,amo);
                System.out.println("Books added successful!");
            } catch (InvalidInputException e) {
            } catch (BookNotExistException e) {
            }
        }
        else{
            System.out.println("Enter book name: ");
            String name=scan.next()+scan.nextLine();
            System.out.println("Enter book ID: ");
            String ID=scan.next()+scan.nextLine();
            Books a=null;
            for(Books book:l.getBookList()){
                if(book.getBookName().equals(name)||book.getBookID().equals(ID))
                    a=book;
            }
            if(a!=null){
                System.out.println("Sorry, book name or book ID already exists");
                return;
            }
            System.out.println("What type of book it is? (specification/recreation):");
            String answer2=scan.next()+scan.nextLine();
            while(!answer2.equals("specification")&&!answer2.equals("recreation")){
                System.out.println("Invalid input. Please enter again:  (specification/recreation)");
                answer2=scan.next()+scan.nextLine();
            }
            if(answer2.equals("recreation")){
                System.out.println("What subtype?");
                String subtype=scan.next()+scan.nextLine();
                try {
                    a=new BooksOfRecreation(name,subtype,ID);
                } catch (InvalidInputException e) {
                }
            }
            else{
                System.out.println("What specification (Math/English/Engineering):");
                String specification=scan.next()+scan.nextLine();
                while(!specification.equals("Math")&&!specification.equals("English")&&!specification.equals("Engineering")){
                    System.out.println("Invalid input. Enter again (Math/English/Engineering):");
                    specification=scan.next()+scan.nextLine();
                }
                try {
                    a=new BooksOfSpecification(name,specification,ID);
                } catch (InvalidInputException e) {
                }
            }
            System.out.println("How many books do you want to add to?");
            String amount=scan.next()+scan.nextLine();
            int amo=checkValue(amount);
            try {
                librarian.buyNewBooks(l.getBookList(),a,amo);
                System.out.println("Books added successful!");
            } catch (InvalidInputException e) {
            } catch (BookAlreadyExistsException e) {
            }
        }
    }

    //REQUIRES：lib and stu are both non-null
    //EFFECTS:display a single studen's information
    public static void checkSingleStudentHelper(Library l){
        Student s=null;
        System.out.println("Please enter student name: ");
        String name=scan.nextLine();
        System.out.println("Please enter student ID:");
        String ID=scan.nextLine();
        for(Student a:l.getStudentList()){
            if(a.getSName().equals(name)&&a.getSID().equals(ID))
                s=a;
        }
        if(s==null){
            System.out.println("Sorry, student is not registered.");
            return;
        }
        //lib.checkSingleStudent(s);
        l.checkSingleStudent(s);
    }

    //EFFECTS: convert a to positive integer if a is, otherwise ask for inputing positive integer
    public static Integer checkValue(String a) {
        Integer b;
        try {
            b = Integer.parseInt(a);
            if (!(b > 0)) {
                System.out.println("Invalid input value, please input a positive integer:");
                a = scan.next()+scan.nextLine();
                return checkValue(a);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input value, please input a positive integer:");
            a = scan.next()+scan.nextLine();
            return checkValue(a);
        }
        return b;
    }
    public static void onlineLibHelper(Library l) throws IOException {
        OnlineLibrary o=l.getOnlineLibrary();
        System.out.println("Input a book url or browse library website (1 for url/ 2 for browsing)");
        String an=scan.nextLine();
        while(!an.equals("1")&&!an.equals("2")){
            System.out.println("Invalid input. Please enter again:  (1 for input/ 2 for exit):");
            an=scan.next();
        }
        if(an.equals("2")){
            try {
                o.browse();
            } catch (URISyntaxException e) {
            }
            return;
        }
        System.out.println("Please enter the URL you want to access: ");
        String url=scan.nextLine();
        while(testUrl(url)==false){
            System.out.println("Sorry, the url is invalid (1 for input again/ 2 for exit)");
            String ans=scan.nextLine();
            while(!ans.equals("1")&&!ans.equals("2")){
                System.out.println("Invalid input. Please enter again:  (1 for input/ 2 for exit):");
                ans=scan.next();
            }
            if(ans.equals("1")) {
                System.out.print("Enter url:");
                url = scan.nextLine();
            }
            else
                return;
        }
        System.out.println("Valid URL.   Select a way to output:");
        System.out.println("1. Display its html file.");
        System.out.println("2. Open it in browser.");
        System.out.print("Your choice: ");
        String ans=scan.nextLine();
        while(!ans.equals("1")&&!ans.equals("2")){
            System.out.println("\nInvalid input. Please enter again:  (1 for input/ 2 for exit):");
            ans=scan.next();
        }
        if(ans.equals("1")) {
            try {
                OnlineLibrary ol= l.getOnlineLibrary();
                ol.printHTML(url);
            } catch (IOException e) {
            }
        }
        else {
            try {
                l.getOnlineLibrary().browse2(url);
            } catch (URISyntaxException e) {
            } catch (IOException e) {
            }
        }
    }
    public static boolean testUrl(String urlString)  {

        URL url;
        try {
            url = new URL(urlString);
            InputStream in = url.openStream();
            return true;
        } catch (Exception e1) {
            return false;
        }
    }

}





































//        List<Student> sList=new ArrayList<>();
//        try {
//                FileInputStream input=new FileInputStream("StudentDocument.txt");
//                ObjectInputStream input2=new ObjectInputStream(input);
//                while(input.available()>0){
//                sList.add((Student) input2.readObject());}
//                input.close();input2.close();
//
//        } catch (FileNotFoundException e) { }
//        try{
//            FileInputStream input=new FileInputStream("LibraryDocument.txt");
//            ObjectInputStream input2=new ObjectInputStream(input);
//            while(input.available()>0){
//                UBClibrary.addBook((Books) input2.readObject());}
//            input.close();input2.close();
//        }catch (FileNotFoundException e){};
//        System.out.println("Welcome to UBC Library, are you new here? (Y/N)");
//        String answer=scan.next();
//        if(answer.equals("Y"))
//            registration(sList);
//        else{
//            boolean b=false;
//            System.out.print("What's your student ID?");
//            int ID=scan.nextInt();
//            for(Student s:sList){
//                if(s.getSID().equals(ID)) {
//                    b=true;
//                    System.out.println("Hi, " + s.name + ", what kind of service do you need?");
//                    System(s);
//                }
//            }
//            if(b==false){
//                System.out.println("Sorry, you are not in our system, please register first.");
//                registration(sList);
//            }
//        }
//        FileOutputStream output=new FileOutputStream("StudentDocument.txt",false);
//        ObjectOutputStream output2=new ObjectOutputStream(output);
//        for(Student s:sList){
//            output2.writeObject(s);
//        }
//        output.close();
//        output2.close();
//        FileOutputStream output3=new FileOutputStream("LibraryDocument.txt",false);
//        ObjectOutputStream output4=new ObjectOutputStream(output3);
//        for(Books b:UBClibrary.getBookList()){
//            output4.writeObject(b);
//        }
//        output3.close();
//        output4.close();
//        }
//        //REQUIRES:s shoulb be a student with specified specification
//        //MODIFIES:this
//        //EFFECTS:organize the service system and invokes all methods when required by the user
//    public static void System(Student s){
//        Library LoveReading=new Library();
//        Scanner scan=new Scanner(System.in);
//        System.out.println("(1) "+"donate a new book");
//        System.out.println("(2) "+"lend a book");
//        System.out.println("(3) "+"return a new book");
//        System.out.println("(4) "+"check if has book");
//        System.out.println("(5) "+"display all the books");
//        System.out.println("(6) "+"specification recommendation");
//        System.out.print("Your choice: (enter 1/2/3/4/5)");
//        int input=scan.nextInt();
//        while(!(input==1||input==2||input==3||input==4||input==5||input==6)){
//            System.out.print("Invalid input, please enter again:");
//            input=scan.nextInt();
//        }
//        switch(input){
//            case 1:{
//                System.out.println("Please enter the book name:");
//                scan.nextLine();
//                String bookName=scan.nextLine();
//                System.out.println("Please enter the book specification:");
//                String specification=scan.nextLine();
//                UBClibrary.addBook(bookName,specification);
//            }break;
//            case 2:UBClibrary.lendBook();break;
//            case 3:UBClibrary.returnBook();break;
//            case 4:UBClibrary.checkHasBook();break;
//            case 5:UBClibrary.listAllBooks();break;
//            case 6:UBClibrary.specificationRecommendation(s);
//        }
//        System.out.println("Service finished. \n Another service (enter 1)          Exit(enter 0)");
//        int input2=scan.nextInt();
//        while(!(input2==0||input2==1)) {
//            System.out.print("Invalid input, please enter again:");
//            input2 = scan.nextInt();
//        }
//        if(input2==1) {
//            System(s);
//            return;
//        }
//        if(input2==0){
//            System.out.println("Thanks for using the system. Have a nice day.");}
//    }
//    public static void registration(List sList){
//        Student newStudent;
//        System.out.println("Welcome to registrationsystem! What's your major? (1 for Math; 2 for English; 3 for Engineering)");
//        int a=scan.nextInt();
//        if(a==1){
//            newStudent=new MathStudent();
//            newStudent.setSName(newStudent.askSName());
//            System.out.println("What's your student ID?");
//            int ID=scan.nextInt();
//            newStudent.setSID(ID);
//            sList.add(newStudent);
//            System.out.println("Registered successful " + newStudent.name + ", new to UBC LoveReading Library?");
//            System.out.println("Here's the rule you need to know");
//            rule();
//            System.out.println("What kind of service do you need?");
//            System(newStudent);
//            return;
//        }
//        if(a==2){
//            newStudent=new EnglishStudent();
//            newStudent.setSName(newStudent.askSName());
//            System.out.println("What's your student ID?");
//            int ID=scan.nextInt();
//            newStudent.setSID(ID);
//            sList.add(newStudent);
//            System.out.println("Registered successful, " + newStudent.name + ", new to UBC LoveReading Library?");
//            System.out.println("Here's the rule you need to know");
//            rule();
//            System.out.println("What kind of service do you need?");
//            System(newStudent);
//            return;
//        }
//        if(a==3){
//            newStudent=new EngineeringStudent();
//            newStudent.setSName(newStudent.askSName());
//            System.out.println("What's your student ID?");
//            int ID=scan.nextInt();
//            newStudent.setSID(ID);
//            sList.add(newStudent);
//            System.out.println("Registered successful, " + newStudent.name + ", new to UBC LoveReading Library?");
//            System.out.println("Here's the rule you need to know");
//            rule();
//            System.out.println("What kind of service do you need?");
//            System(newStudent);
//            return;
//        }
//        else{
//            System.out.println("Invalid input");
//            registration(sList);
//            return;
//        }
//    }
//    public static void rule(){
//        System.out.println("1. You'll start with 100 credits");
//        System.out.println("2. You can keep at most 5 books at a time");
//        System.out.println("3. Books should be returned in 10 days, or you'll receive a credit deduction of 5.");
//        System.out.println("4. When your credit comes 0, you are no longer allowed to borrow any books.");
//        System.out.println();


