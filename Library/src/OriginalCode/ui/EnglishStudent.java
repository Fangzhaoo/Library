package OriginalCode.ui;

import java.util.List;
import OriginalCode.Exception.*;
public class EnglishStudent extends Student{
    //REQUIRES: name is non-null
    //EFFECTS:construct a MathStudent with given name and ID if ID has 8 digits, otherwise throw InvalidInputException
    public EnglishStudent(String name, String ID) throws InvalidInputException {
        super(name,ID,"English");
    }

    //@Override
    //REQUIRES:bookList must be non-null
    //EFFECTS: print the book of english specification
//    public void recommend(List<Books> bookList) {
//        System.out.println("Welcome to English Faculty, here are books recommended to you:");
//        for(Books book:bookList){
//            if(book.getBookType().equals("specification")){
//                if(((BooksOfSpecification)book).getSBooksSpecification().equals("English"))
//                    //System.out.println("Book Name: "+book.getBookName()+"     Book ID: "+book.getBookID());
//                System.out.printf("Book Name: %-20s        Book ID: %-20s\n",book.getBookName(),book.getBookID());
//            }
//        }
//    }
}