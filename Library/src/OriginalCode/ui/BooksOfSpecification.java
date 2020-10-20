package OriginalCode.ui;

import OriginalCode.Exception.*;
public class BooksOfSpecification extends Books {
    private String specification;
    //EFFECTS: construct a book with given name,type and bookID. Throw InvalidInputException when name is null, specification is not equal to "Math" or "English" or "Engineering".
    public BooksOfSpecification(String bookName, String specification, String bookID) throws InvalidInputException {
        super(bookName, "specification", bookID);
        if(!specification.equals("Math")&&!specification.equals("English")&&!specification.equals("Engineering")) {
            throw new InvalidInputException();
        }
        this.specification=specification;
    }
    //getter
    public String getSBooksSpecification(){
        return specification;
    }
}