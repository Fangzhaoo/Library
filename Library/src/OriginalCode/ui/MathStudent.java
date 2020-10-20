package OriginalCode.ui;

import OriginalCode.Exception.*;
import java.util.List;

public class MathStudent extends Student{
    //REQUIRES: name is non-null
    //EFFECTS:construct a MathStudent with given name and ID if ID has 8 digits, otherwise throw InvalidInputException
    public MathStudent(String name, String ID) throws InvalidInputException {
        super(name,ID,"Math");
    }
//    @Override
//    //REQUIRES:bookList must be non-null
//    //EFFECTS: print the book of math specification
//    public void recommend(List<Books> bookList) {
//        System.out.println("Welcome to Math Faculty, here are books recommended to you:");
//        for(Books book:bookList){
//            if(book.getBookType().equals("specification")){
//                if(((BooksOfSpecification)book).getSBooksSpecification().equals("Math"))
//                    //System.out.println("Book Name: "+book.getBookName()+"     Book ID: "+book.getBookID());
//                    System.out.printf("Book Name: %-20s        Book ID: %-20s\n",book.getBookName(),book.getBookID());
//            }
//        }
//    }

}