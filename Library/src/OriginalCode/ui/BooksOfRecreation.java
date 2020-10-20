package OriginalCode.ui;

import OriginalCode.Exception.*;
public class BooksOfRecreation extends Books {
    private String subtype;
    //EFFECTS: construct a recreation book with given name,subtype and bookID. Throw InvalidInputException when name is null, subtype is null.
    public BooksOfRecreation(String bookName, String subtype, String bookID) throws InvalidInputException {
        super(bookName, "recreation", bookID);
        if(subtype==null)
            throw new InvalidInputException();
        this.subtype=subtype;
    }
    //getter
    public String getRecreationBookSubtype(){
        return subtype;
    }
}
