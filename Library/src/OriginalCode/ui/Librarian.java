package OriginalCode.ui;

import OriginalCode.Exception.*;

import java.io.Serializable;
import java.util.*;

public class Librarian implements Serializable, Observer {
    //fields
    private final String ID;
    private final String passWord;
    private boolean status;

    //constructor
    //EFFECTS: construct a librarian with given ID and password between 3 to 10 digits(exclusive),otherwise throw InvalidInputException
    public Librarian(String ID, String password) throws InvalidInputException {
        if (password.length() <= 3 || password.length() >= 10) {
            throw new InvalidInputException();
        }
        this.ID = ID;
        this.passWord = password;
    }
    //setters
    public void setStatus(boolean b){
        status=b;
    }
    //getters
    //EFFECTS:return librarian ID
    public String getID(){
        return ID;
    }
    //EFFECTS:return librarian password
    public String getPassWord(){
        return passWord;
    }
    //EFFECTS:return librarian status
    public boolean isActive(){
        return status;
    }

    //methods
    //MODIFIES:this
    //EFFECTS:switch the status to opposite one
    public void switchStatus() {
        status = !status;
    }

    //MODIFIES:b
    //EFFECTS:add one book if it is in the booklist, otherwise throw BookNotExistException
    public void buyExistingBooks(List<Books> bookList, Books b,int quantity) throws InvalidInputException, BookNotExistException {
        if (bookList.contains(b)) {
            b.addBook(quantity);
        }
        else
            throw new BookNotExistException();
    }

    //MODIFIES:bookList,b
    //EFFECTS:add given number of book if it is not in the booklist,otherwise throw InvalidInputException when the number is negative and BookAlreadyExistsException when book is in the list
    public void buyNewBooks(List<Books> bookList, Books b, int quantity) throws InvalidInputException, BookAlreadyExistsException {
        if (!(bookList.contains(b))) {
            bookList.add(b);
            b.addBook(quantity);
        } else {
            throw new BookAlreadyExistsException();
        }
        ;
    }

    //REQUIRES:studentList is non-null
    //EFFECTS:display information of all students in the student list including the information of books they have borrowed
//    public void displayStudentInformation(List<Student> studentList) {
//        if (studentList.size() == 0) {
//            System.out.println("There is now no student registered");
//            return;
//        }
//        for (Student s : studentList) {
////            System.out.printf("Student name: %-20s   Student ID: %-20s   Specification: %-20s   Current Credit: %-20d   \n", s.getSName(), s.getSID(), s.getSpecification(), s.getStudentCredit());
//////            List<Books> bookList = s.getKeepBookList();
//////            List<Long> timeList = s.getKeepBookTimeList();
//////            assert (bookList.size() == timeList.size());
////            if (s.bookRecord.size() == 0) {
////                System.out.println("The student keeps no book currently");
////            } else {
////                System.out.println("The student keeps " + s.bookRecord.size() + " books in total:");
////                Iterator<Books> it=s.bookRecord.keySet().iterator();
////                while(it.hasNext()){
////                    Books bo=it.next();
////                    int time = Student.convertToDay(System.currentTimeMillis()-s.bookRecord.get(bo));
////                    System.out.printf("Book Name: %-20s  Book ID:%-20s  KeptTime:%-10d days \n", bo.getBookName(), bo.getBookID(), time);
////                }
//////                for (int i = 0; i < bookList.size(); i++) {
//////                    Books b = bookList.get(i);
//////                    int time = (int) ((System.currentTimeMillis() - timeList.get(i)) / 1000) / (3600 * 24);
//////                    System.out.printf("Book Name: %-20s  Book ID:%-20s  KeptTime:%-20d days \n", b.getBookName(), b.getBookID(), time);
//////                }
////            }
////            System.out.println();
//            s.displayPrivateInformation();
//        }
//    }

    //REQUIRES: student is non-null
    //EFFECTS:display information of a given single student including the information of books they have borrowed
//    public void checkSingleStudent(Student s) {
//        System.out.printf("Student name: %-20s   Student ID: %-20s   Specification: %-20s   Current Credit: %-20d   \n\n", s.getSName(), s.getSID(), s.getSpecification(), s.getStudentCredit());
////        List<Books> bookList = s.getKeepBookList();
////        List<Long> timeList = s.getKeepBookTimeList();
////        assert (bookList.size() == timeList.size());
//        if (s.bookRecord.size() == 0) {
//            System.out.println("The student keeps no book currently");
//        } else {
//            System.out.println("The student keeps " + s.bookRecord.size() + " books in total:");
//            Iterator<Books> it=s.bookRecord.keySet().iterator();
//            while(it.hasNext()){
//                Books bo=it.next();
//                int time = Student.convertToDay(System.currentTimeMillis()-s.bookRecord.get(bo));
//                System.out.printf("Book Name: %-20s  Book ID:%-20s  KeptTime:%-10d days \n", bo.getBookName(), bo.getBookID(), time);
//            }
////            for (int i = 0; i < bookList.size(); i++) {
////                Books b = bookList.get(i);
////                int time = (int) ((System.currentTimeMillis() - timeList.get(i)) / 1000) / (3600 * 24);
////                System.out.printf("Book Name: %-30s  Book ID:%-30d  KeptTime:%-2d days \n", b.getBookName(), b.getBookName(), time);
////            }
//        }
//    }
    @Override
    public void update(Observable o, Object ob){
        if(!isActive())
            return;
        if(ob instanceof Student){
            Student s=(Student) ob;
            System.out.println("\nNotification");
            System.out.println("librarian "+getID()+" is notified that student "+s.getSName()+" is newly registered.");
            System.out.print("Student Information: ");
            s.displayPrivateInformation();
        }
        if(ob instanceof Librarian){
            Librarian l=(Librarian) ob;
            System.out.println("librarian "+getID()+" is notified that colleague "+l.getID()+" is newly registered.");
        }
    }


    //REQUIRES: stu,studentList,bookList are non-null
    //MODIFIES:stu,bookList
    //EFFECTS: return the time needed for the book the student want to be returned, if the student want it right now, buy in a book and lend it to student while subtracting 10 credits of the student.
    //Will through InvalidInputException whenever the input is not valid, throw bookNotExistException when student says it exists but in fact not, throw BookAlreadyExistsException when student says it is a new book but in fact it is kept by the library.
    public void reply(Student stu, List<Student> studentList,List<Books> bookList) throws InvalidInputException, BookNotExistException, BookAlreadyExistsException, MaximumBooksLendedException, CreditNotEnoughException, NotEnoughBooksException, CanNotLendTheSameBookException {
        Scanner scan = new Scanner(System.in);
        //System.out.println("Hi, what kind of book are you looking for? (1: book kept in library/ 2: new book)");
//        String s = scan.next();
//        while (!(s.equals("1") || s.equals("2"))) {
//            System.out.println("Invalid input. Please intput again (1: book kept in library/ 2: new book):");
//            s = scan.next();
//        }
        String s= getAnswer("Hi, what kind of book are you looking for? (1: book kept in library/ 2: new book)","book kept in library","new book");
        if (s.equals("1")) {
            Books book = null;
//            System.out.println("Which book are you looking for? (1: by book name/ 2: by book ID)");
//            int choice1 = scan.nextInt();
//            while (!(choice1 == 1 || choice1 == 2)) {
//                System.out.println("Invalid input. Please intput again (1: by book name/ 2: by book ID):");
//                choice1 = scan.nextInt();
//            }
            String choice= getAnswer("Which book are you looking for? (1: by book name/ 2: by book ID)","by book name","by book ID");
            if (choice.equals(1)) {
                System.out.println("Enter book name here:");
                String bookName = scan.next() + scan.nextLine();
                book = checkBookExistbyName(bookName, bookList);
            }
            else{
                System.out.println("Enter book ID here:");
                String bookID = scan.next() + scan.nextLine();
                book = checkBookExistbyID(bookID, bookList);
            }
            if (book == null) {
                System.out.println("Sorry, the book is never in the library");
                return;
            }
            else {
//                    List<Long> in = new ArrayList<>();
//                    for (Student student : studentList) {
//                        if (student.bookRecord.containsKey(book)) {
//                            in.add(student.bookRecord.get(book));
//                        }
//                    }
//                    long a = in.get(0);
//                    for (long b : in) {
//                        if (b > a)
//                            a = b;
//                    }
//                    int time = 10 - (int) ((System.currentTimeMillis() - a) / (1000 * 3600)) / 24;
                int time=checkReturnTime(studentList,book);
                System.out.println("It is checked that the book will likely be returned within " + time + " days");
//                    System.out.println("Would you like to wait or require for a book now, which will consume 10 credits (1 for waiting/2 for requiring):");
//                    String input = scan.nextLine();
//                    while (!(input.equals("1") || input.equals("2"))) {
//                        System.out.println("Invalid input, please input again (1 for waiting/2 for requiring):");
//                        input = scan.nextLine();
//                    }
                String input= getAnswer("Would you like to wait or require for a book now, which will consume 10 credits (1 for waiting/2 for requiring):","waiting","requiring");
                if (input.equals("1")) {
                    System.out.println("Sorry for waiting, please remember to come back to check in " + time + " days");
                } else {
                    try {
                        stu.minusCredit(10);
                    } catch (CreditNotEnoughException e) {
                        System.out.println("Sorry, you do not have enough credit to require for this book.");
                        return;
                    }
                    this.buyExistingBooks(bookList, book,1);
                    stu.lendBook(book, bookList);
                    System.out.println("Lend successfully. 10 credits are deduced. Remember to return it in time!");
                    return;
                }
            }
//            }
//            else {
//                System.out.println("Enter book ID here:");
//                String bookID = scan.next()+scan.nextLine();
//                boolean bool = true;
//                int ID=0;
//                while (bool) {
//                    try {
//                        ID = Integer.parseInt(bookID);
//                        if (ID <= 0) {
//                            System.out.println("Invalid input, please enter a positive integer:");
//                            bookID = scan.nextLine();
//                        }
//                        else {
//                            bool = false;
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid input, please enter a positive integer:");
//                        bookID = scan.nextLine();
//                    }
//                }
//                for (Books b : bookList) {
//                    if (b.getBookID().equals(ID+""))
//                        book = b;
//                }
//                if (book == null) {
//                    System.out.println("Sorry, the book is never in the library");
//                    return;
//                } else {
//                    assert (book.getBookQuantity() == 0);
//                    List<Long> in = new ArrayList<>();
//                    for (Student student : studentList) {
//                        if (student.bookRecord.containsKey(book)) {
//                            in.add(student.bookRecord.get(book));
//                        }
//                    }
//                    long a = in.get(0);
//                    for (long b : in) {
//                        if (b > a)
//                            a = b;
//                    }
//                    int time = 10 - (int) ((System.currentTimeMillis() - a) / (1000 * 3600)) / 24;
//                    System.out.println("It is checked that the book will likely be returned within " + time + " days");
////                    System.out.println("Would you like to wait or require for a book now, which will consume 10 credits (1 for waiting/2 for requiring):");
////                    String input = scan.nextLine();
////                    while (!(input.equals("1") || input.equals("2"))) {
////                        System.out.println("Invalid input, please input again (1 for waiting/2 for requiring):");
////                        input = scan.nextLine();
////                    }
//                    String input= getAnswer("Would you like to wait or require for a book now, which will consume 10 credits (1 for waiting/2 for requiring):","waiting","requiring");
//                    if (input.equals("1")) {
//                        System.out.println("Sorry for waiting, please remember to come back to check in " + time + " days");
//                    } else {
//                        assert (input.equals("2"));
//                        try {
//                            stu.minusCredit(10);
//                        } catch (CreditNotEnoughException e) {
//                            System.out.println("Sorry, you do not have enough credit to require for this book.");
//                            return;
//                        }
//                        this.buyExistingBooks(bookList, book,1);
//                        stu.lendBook(book, bookList);
//                        System.out.println("Lended successfully. 10 credits are deduced. Remember to return it in time!");
//                        return;
//                    }
//                }
//                    }
        }
        else{
            System.out.println("Please enter book name:");
            String bookName=scan.nextLine();
            for(Books b:bookList){
                if(b.getBookName().equals(bookName))
                    System.out.println("Sorry, this book is already existing in the library.");
                return;
            }
//                    System.out.println("It is a new book, would you want to require for it now, which will consume 10 cresits (1 for yes/2 for no):");
//                    String answer=scan.nextLine();
//                    while(!(answer.equals("Y")||answer.equals("N"))){
//                        System.out.println("Invalid input. Please input again (Y/N):");
//                        answer=scan.nextLine();
//                    }
            String answer= getAnswer("It is a new book, would you want to require for it now, which will consume 10 cresits (1 for yes/2 for no):","yes","no");
            if(answer.equals("2")){
                System.out.println("Sorry for not carrying this book.");
                return;
            }
            else{
                try {
                    stu.minusCredit(10);
                } catch (CreditNotEnoughException e) {
                    System.out.println("Sorry, you do not have enough credit to require for this book.");
                    return;
                }
//                        System.out.println("What kind of book it is? (1 for specification/2 for recreation):");
//                        String answer2=scan.nextLine();
//                        while(!(answer2.equals("S")||answer.equals("R"))){
//                            System.out.println("Invalid input. Please input again (S/R):");
//                            answer=scan.nextLine();
//                        }
                String answer2= getAnswer("What kind of book it is? (1 for specification/2 for recreation):","specification","recreation");
                Books newBook=null;
                if(answer2.equals("1")) {
                    System.out.println("What specification it belongs to? (EG for engineering/EN for english/MT for math):");
                    String subtype = scan.nextLine();
                    while (!(subtype.equals("EG") || answer.equals("EN") || answer.equals("MT"))) {
                        System.out.println("Invalid input. Please input again (EG for engineering/EN for english/MT for math):");
                        answer = scan.nextLine();
                    }
                    newBook = new BooksOfSpecification(bookName, subtype, bookList.size() + "");
                }
                else {
                    System.out.println("What subtype it belongs to? :");
                    String subtype = scan.nextLine();
                    newBook = new BooksOfRecreation(bookName, subtype, bookList.size() + "");
                }
                this.buyNewBooks(bookList,newBook,1);
                stu.lendBook(newBook,bookList);
                System.out.println("Lend successfully. 10 credits are deduced. Remember to return it in time!");
                return;
//                        }
//                        else{
//                            System.out.println("What subtype it belongs to? :");
//                            String subtype=scan.nextLine();
//                            Books newBook=new BooksOfRecreation(bookName,subtype,bookList.size()+"");
//                            this.buyNewBooks(bookList,newBook,1);
//                            stu.lendBook(newBook,bookList);
//                            System.out.println("Lend successfully. 10 credits are deduced. Remember to return it in time!");
//                            return;
//                        }
            }
        }
    }

    //**helper method
    //EFFECTS: ask for user input based on given question and check for input validation
    private String getAnswer(String question, String requireFor1, String requireFor2){
        System.out.println(question);
        Scanner scan=new Scanner(System.in);
        String input = scan.nextLine();
        while (!(input.equals("1") || input.equals("2"))) {
            System.out.printf("Invalid input, please input again (1 for %s/2 for %s):\n",requireFor1,requireFor2);
            input = scan.nextLine();
        }
        return input;
    }
    //EFFECTS: check whether a book with given name is in bookList, if it is, return the book, otherwise return null
    private Books checkBookExistbyName(String bookName,List<Books> bookList){
        for(Books book:bookList)
            if(book.getBookName().equals(bookName))
                return book;
        return null;
    }
    //EFFECTS: check whether a book with given ID is in the bookList, if it is, return the book, otherwise return null
    private Books checkBookExistbyID(String bookID,List<Books> bookList){
        for(Books book:bookList)
            if(book.getBookID().equals(bookID))
                return book;
        return null;
    }
    //EFFECTS: check for the nearest returning time for a given book
    private int checkReturnTime(List<Student> students,Books book){
        List<Long> in = new ArrayList<>();
        for (Student student : students) {
            if (student.bookRecord.containsKey(book)) {
                in.add(student.bookRecord.get(book));
            }
        }
        long a = in.get(0);
        for (long b : in) {
            if (b > a)
                a = b;
        }
        //int time = 10 - (int) ((System.currentTimeMillis() - a) / (1000 * 3600)) / 24;
        int time=10-Student.convertToDay(a);
        return time;
    }
    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(o==null||o.getClass()!=getClass())
            return false;
        return ((Librarian)o).getID()!=null?((Librarian)o).getID().equals(getID()):getID()==null;
    }
    @Override
    public int hashCode(){
        return getID().hashCode();
    }
}

