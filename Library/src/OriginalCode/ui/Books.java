package OriginalCode.ui;

import OriginalCode.Exception.InvalidInputException;
import OriginalCode.Exception.NotEnoughBooksException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public abstract class Books implements Serializable{
    private final String bookName;
    private final String bookID;
    private final int credit;
    private int quantity;
    private final String type;
    private List<Student> lendedBy=new ArrayList<>();
    //EFFECTS: construct a book with given name,type and bookID. Throw InvalidInputException when name is null, type is not "specification" or "recreation".
    public Books(String bookName,String type,String bookID ) throws InvalidInputException {
        if(bookName==null||!(type=="specification"||type=="recreation")){
            throw new InvalidInputException();
        }
        this.bookName=bookName;
        this.type=type;
        this.bookID=bookID;
        if(type.equals("specification")){
            credit=5;
        }
        else
            credit=3;
    }
    //setters
    //REQUIRES:s is non-null
    //MODIFIES:this
    //EFFECTS:add student to the list if it is not there before and it lends the book
    public void addLendedBy(Student s){
        if(lendedBy==null&&s.bookRecord.containsKey(this))
            lendedBy.add(s);
        else if(!lendedBy.contains(s)&&s.bookRecord.containsKey(this))
            lendedBy.add(s);
    }
    //REQUIRES:s is non-null
    //MODIFIES:this
    //EFFECTS:remove student from the list if it is there before and it returns the book
    public void removeLendedBy(Student s){
        if(lendedBy.contains(s)&&!s.bookRecord.containsKey(this))
            lendedBy.remove(s);
    }
    //getters
    public String getBookName(){
        return bookName;
    }
    public String getBookID() {
        return bookID;
    }
    public int getBookCredit(){
        return credit;
    }
    public int getBookQuantity(){
        return quantity;
    }
    public String getBookType(){
        return type;
    }
    public List<Student> getLendedBy(){
        return lendedBy;
    }
    //MODIFIES:this
    //EFFECTS:add book of given quantity when quantity is positive,otherwise throw invalidInputException
    public void addBook(int howMany) throws InvalidInputException {
        if(howMany<=0)
            throw new InvalidInputException();
        quantity+=howMany;
    }
    //MODIFIES:this
    //EFFECTS:subtract book of given quantity if quantity is positive and there are enough books,otherwise throw invalidIputException and notEnoughBookException respectively
    public boolean subtractBook(int howMany) throws InvalidInputException, NotEnoughBooksException {
        if(howMany<=0)
            throw new InvalidInputException();
        if(quantity<howMany)
            throw new NotEnoughBooksException();
        quantity-=howMany;
        return true;
    }






    @Override
    //EFFECTS: compare two books by their names and IDs
    public boolean equals(Object o){
        if(o==this)
            return true;
        if(o==null||getClass()!=o.getClass())
            return false;
        return ((Books)o).getBookName().equals(getBookName())||((Books)o).getBookID()==getBookID();
    }
    @Override
    //EFFECTS:return hashCode by name
    public int hashCode(){
        return Objects.hash(getBookName());
    }
}
