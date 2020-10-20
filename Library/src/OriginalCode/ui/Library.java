package OriginalCode.ui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    //fields
    private List<Books> bookList;
    private List<Student> studentList;
    private List<Librarian> librarianList;
    private OnlineLibrary onlineLib;

    private static Library libraryInstance=new Library();

    private Library(){
        bookList=new ArrayList<>();
        studentList=new ArrayList<>();
        librarianList=new ArrayList<>();
        onlineLib=new OnlineLibrary();

    }

    public static Library getInstance(){
        return libraryInstance;
    }
//     //fields
//     private List<Books> bookList;
//     private List<Student> studentList;
//     private List<Librarian> librarianList;
//     private OnlineLibrary onlineLib;
    //constructor
    //EFFECTS: construct a new library if not recorded before, otherwise reload the existing library
//     public Library(){
//             bookList=new ArrayList<>();
//             studentList=new ArrayList<>();
//             librarianList=new ArrayList<>();
//             onlineLib=new OnlineLibrary();
//    }

    //load and save
    //EFFECTS: return a library if recorded before, otherwise return null
    public Library loadLibrary(){
        FileInputStream input;
        try {
            input = new FileInputStream("LibraryDocument.txt");
        } catch (FileNotFoundException e) {
            return null;
        }
        ObjectInputStream input2;
        try {
            input2 = new ObjectInputStream(input);
            if(input.available()>0) {
                return (Library)input2.readObject();
            }
        } catch (IOException e) {
            return null;
        }catch (ClassNotFoundException e) {
            return null;
        }
        try {
            input.close();
            input2.close();
        } catch (IOException e) {
        }
        return null;
    }
    //EFFECTS:record the library
    public void saveLibrary(){
        FileOutputStream output=null;
        ObjectOutputStream output1=null;
        try {
            output = new FileOutputStream("LibraryDocument.txt", false);
            output1 = new ObjectOutputStream(output);
            output1.writeObject(this);
        }catch(FileNotFoundException e){
        }catch(IOException e){
        }
        try {
            output.close();
            output1.close();
        } catch (IOException e) {
        }
    }

    //Getters
    public List<Books> getBookList(){
        return bookList;
    }
    public List<Student> getStudentList(){
        return studentList;
    }
    public List<Librarian> getLibrarianList(){
        return librarianList;
    }
    public int getBookListSize(){
        return bookList.size();
    }
    public int getStudentListSize(){
        return studentList.size();
    }
    public int getLibrarianListSize(){
        return librarianList.size();
    }
    public OnlineLibrary getOnlineLibrary(){ return onlineLib;}

    //display books
    //EFFECTS: display all books kept
    public void displayAvailableBooks(){
        if(bookList.size()==0) {
            System.out.println("There is no book currently.");
            return;
        }
//         System.out.println("Books Of Specification:");
//         for(Books a:bookList){
//             if(a.getBookType().equals("specification")) {
//                 System.out.printf("Name: %-30s  ID:%-10s  Specification:%-20s  Credit:%-20d  Quantity:%-20d\n",a.getBookName(),a.getBookID(),((BooksOfSpecification)a).getSBooksSpecification(),a.getBookCredit(),a.getBookQuantity());
//             }
//         }
//         System.out.println("\nBooks For Recreation:");
//         for(Books a:bookList){
//             if(a.getBookType().equals("recreation")) {
//                 System.out.printf("Name: %-30s  ID:%-10s  Type:%-29s  Credit:%-20d  Quantity:%-20d \n",a.getBookName(),a.getBookID(),((BooksOfRecreation)a).getRecreationBookSubtype(),a.getBookCredit(),a.getBookQuantity());
//             }
//         }
        for(Books a:bookList)
            displaySingleBook(a);
    }
    //EEFCTS:display information of a single book
    public void displaySingleBook(Books a) {
//         if(a.getBookType().equals("specification")) {
//             System.out.printf("Name: %-30s  ID:%-10s  Specification:%-20s  Credit:%-20d  Quantity:%-20d\n",a.getBookName(),a.getBookID(),((BooksOfSpecification)a).getSBooksSpecification(),a.getBookCredit(),a.getBookQuantity());
//         }
//         if(a.getBookType().equals("recreation")) {
//             System.out.printf("Name: %-30s  ID:%-10s  Type:%-29s  Credit:%-20d  Quantity:%-20d\n",a.getBookName(),a.getBookID(),((BooksOfRecreation)a).getRecreationBookSubtype(),a.getBookCredit(),a.getBookQuantity());
//         }
        System.out.printf("Name: %-30s  ID:%-10s  Credit:%-20d  Quantity:%-20d",a.getBookName(),a.getBookID(),a.getBookCredit(),a.getBookQuantity());
        if(a.getBookType().equals("specification")) {
            System.out.printf(" Specification:%-20s\n",((BooksOfSpecification)a).getSBooksSpecification());
        }
        if(a.getBookType().equals("recreation")) {
            System.out.printf(" Type:%-29s\n",((BooksOfRecreation)a).getRecreationBookSubtype());
        }
    }

    //findBooks
    // REQUIRE:bookName must be non-null
    //EFFECTS: return a book if it is kept,otherwise return null
    public Books findBookByName(String bookName){
        for(Books e:bookList){
            if(e.getBookName().equals(bookName))
                return e;
        }
        return null;
    }
    //EFFECTS: return a book if it is kept,otherwise return null
    public Books findBookByID(String bookID){
        for(Books e:bookList){
            if(e.getBookID().equals(bookID))
                return e;
        }
        return null;
    }
    //EFFECTS:check whether a book is in the list
    public boolean checkHasBook(Books book){
        return bookList.contains(book);
    }
    //EFFECTS: display all the librarians
    public void checkLibrarianList(List<Librarian> librarianList){
        for(Librarian librarian:librarianList){
//            if(librarian.isActive())
//                System.out.printf("ID:%-20s          Status: on\n",librarian.getID());
//            else
//                System.out.printf("ID:%-20s          Status: off\n",librarian.getID());
            System.out.printf("ID:%-20s          Status: ",librarian.getID());
            if(librarian.isActive())
                System.out.println("on");
            else
                System.out.println("off");
        }
        if(librarianList.size()==0)
            System.out.println("No librarian is registered in the library.");
    }
    //REQUIRES:librarianList is non-null.
    //EEFECTS: get the first active librarian in a given librarian list.
    public Librarian getLibrarian(List<Librarian> librarianList){
        boolean noOneActive=true;
        for(Librarian a:librarianList)
            if(a.isActive())
                noOneActive=false;
        if(noOneActive==true)
            return null;
        int randomNumber=(int)(Math.random()*librarianList.size());
        while(!librarianList.get(randomNumber).isActive()){
            randomNumber=(int)(Math.random()*librarianList.size());
        }
        return librarianList.get(randomNumber);

    }
    public void displayStudentInformation() {
        if (studentList.size() == 0) {
            System.out.println("There is now no student registered");
            return;
        }
        for (Student s : studentList) {
//            System.out.printf("Student name: %-20s   Student ID: %-20s   Specification: %-20s   Current Credit: %-20d   \n", s.getSName(), s.getSID(), s.getSpecification(), s.getStudentCredit());
////            List<Books> bookList = s.getKeepBookList();
////            List<Long> timeList = s.getKeepBookTimeList();
////            assert (bookList.size() == timeList.size());
//            if (s.bookRecord.size() == 0) {
//                System.out.println("The student keeps no book currently");
//            } else {
//                System.out.println("The student keeps " + s.bookRecord.size() + " books in total:");
//                Iterator<Books> it=s.bookRecord.keySet().iterator();
//                while(it.hasNext()){
//                    Books bo=it.next();
//                    int time = Student.convertToDay(System.currentTimeMillis()-s.bookRecord.get(bo));
//                    System.out.printf("Book Name: %-20s  Book ID:%-20s  KeptTime:%-10d days \n", bo.getBookName(), bo.getBookID(), time);
//                }
////                for (int i = 0; i < bookList.size(); i++) {
////                    Books b = bookList.get(i);
////                    int time = (int) ((System.currentTimeMillis() - timeList.get(i)) / 1000) / (3600 * 24);
////                    System.out.printf("Book Name: %-20s  Book ID:%-20s  KeptTime:%-20d days \n", b.getBookName(), b.getBookID(), time);
////                }
//            }
//            System.out.println();
            s.displayPrivateInformation();
        }
    }
    //REQUIRES: student is non-null
    //EFFECTS:display information of a given single student including the information of books they have borrowed
    public boolean checkSingleStudent(Student s) {
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
        if(studentList.contains(s)) {
            s.displayPrivateInformation();
            return true;
        }
        return false;
    }




}
