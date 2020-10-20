package OriginalCode.ui;

import OriginalCode.Exception.*;
import OriginalCode.Interface.Credit;
import OriginalCode.Interface.Specification;

import java.io.Serializable;
import java.util.*;

public abstract class Student implements Credit, Specification,Serializable{
    //** fields
    protected String name;
    protected String ID;
    protected Map<Books,Long> bookRecord;
    //protected List<Books> keepBook;
    //protected List<Long> keepBookTime;
    protected int credit;
    protected String specification;

    //**constructor
    //REQUIRES: name must be non-null
    //EFFECTS: construct a student with given name and ID if ID is of 8 digits, otherwise throw InvalidInputException
    public Student(String name,String ID,String specification) throws InvalidInputException {
        this.name=name;
        if(!(ID.length()==8)) {
            throw new InvalidInputException();
        }
        this.ID=ID;
//           keepBook=new ArrayList<>(5);
//           keepBookTime=new ArrayList<>(5);
        credit=50;
        bookRecord=new HashMap<>();
        this.specification=specification;
        assert(this.specification.equals("Math")||this.specification.equals("English")||this.specification.equals("Engineering"));
    }
    //**getters
    public String getSName(){
        return name;
    }
    public String getSID(){
        return ID;
    }
    //    public List<Books> getKeepBookList(){
//        return keepBook;
//    }
//    public List<Long> getKeepBookTimeList(){
//        return keepBookTime;
//    }
    public int getStudentCredit(){
        return credit;
    }
    public String getSpecification(){
        return specification;
    }
    public Map<Books,Long> getBookRecord(){
        return bookRecord;
    }
    //**methods
    //REQUIRES:b is non-null
    //MODIFIES:this,b
    //EFFECTS: lend book if the student have enough credits and lend no more than 4 books and book is bookList and there
    // is more than one book and do not lend the same book before, otherwise throw CreditNotEnoughException and MaximumBooksLendedException and
    // BookNotExistException and NotEnoughBooksException and CanNotLendTheSameBookException respectively
    public void lendBook(Books b,List<Books> bookList) throws BookNotExistException, CreditNotEnoughException, NotEnoughBooksException, MaximumBooksLendedException, CanNotLendTheSameBookException {
        if(!bookList.contains(b))
            throw new BookNotExistException();
        if(getStudentCredit()<b.getBookCredit())
            throw new CreditNotEnoughException();
        if(b.getBookQuantity()<1)
            throw new NotEnoughBooksException();
        if(!(bookRecord.size()<5))
            throw new MaximumBooksLendedException();
        if(bookRecord.containsKey(b))
            throw new CanNotLendTheSameBookException();
        try {
            b.subtractBook(1);
        } catch (InvalidInputException e) {
        }
        bookRecord.put(b,System.currentTimeMillis());
        //keepBook.add(b);
        b.addLendedBy(this);
        //keepBookTime.add(System.currentTimeMillis());

        //assert(keepBook.size()==getKeepBookTimeList().size());
    }

    //REQUIRES:b must be non-null
    //MODIFIES:this,b
    //EFFECTS:return a book if both the book is in the bookList and the student kepps the book, otherwise throws BookNotExistException
    public void returnBook(Books b,List<Books> bookList) throws BookNotExistException {
        if(!bookList.contains(b))
            throw new BookNotExistException();
        if(!bookRecord.containsKey(b))
            throw new BookNotExistException();
        //int index=keepBook.indexOf(b);
        if(convertToDay((System.currentTimeMillis()-bookRecord.get(b)))>10){
            try {
                System.out.println("You have kept this book for more than 10 days and will receive credit deduction of 2.");
                minusCredit(2);
            } catch (InvalidInputException e) {
            } catch (CreditNotEnoughException e) {
                System.out.println("Your credit is reduced to 0 now.");
            }
        }
        bookRecord.remove(b);
        //keepBook.remove(b);
        b.removeLendedBy(this);

//        keepBookTime.remove(index);
//        assert(keepBook.size()==keepBookTime.size());
        try {
            b.addBook(1);
        } catch (InvalidInputException e) {
        }
    }
    //EFFECTS: display student's personal information
    public void displayPrivateInformation(){
        System.out.println();
        System.out.println("Name: "+getSName());
        System.out.println("ID: "+getSID());
        System.out.println("Specification: "+getSpecification());
        System.out.println("Current credit: "+getStudentCredit());
        System.out.println("Books kept currently:");
        Iterator<Books> it=bookRecord.keySet().iterator();
        while(it.hasNext()){
            Books b=it.next();
            System.out.printf("Name: %-30s  ID:%-10s  Credit:%-20d  Quantity:%-20d  ",b.getBookName(),b.getBookID(),b.getBookCredit(),b.getBookQuantity());
            if(b instanceof BooksOfSpecification)
                //System.out.printf("Name: %-30s  ID:%-10s  Specification:%-20s  Credit:%-20d  Quantity:%-20d\n",b.getBookName(),b.getBookID(),((BooksOfSpecification)b).getSBooksSpecification(),b.getBookCredit(),b.getBookQuantity());
                System.out.printf("Specification:%-20s\n",((BooksOfSpecification)b).getSBooksSpecification());
            else
                //System.out.printf("Name: %-30s  ID:%-10s  Type:%-29s  Credit:%-20d  Quantity:%-20d\n",b.getBookName(),b.getBookID(),((BooksOfRecreation)b).getRecreationBookSubtype(),b.getBookCredit(),b.getBookQuantity());
                System.out.printf("Type:%-20s\n",((BooksOfRecreation)b).getRecreationBookSubtype());


//            System.out.printf("%-20s       ",b.getBookName());
//            System.out.printf("ID:%-17s       ",b.getBookID());
//            System.out.printf("Days left:%-10d       \n",10-convertToDay((System.currentTimeMillis()-bookRecord.get(b))));
        }
//        for(int i=0;i<bookRecord.size();i++){
//            System.out.printf("%-20s       ",(Books)(bookRecord.keySet().toArray()[i]).);
//            System.out.printf("ID:%-17s       ",keepBook.get(i).getBookID());
//            System.out.printf("Days left:%-10d       \n",10-convertToDay((System.currentTimeMillis()-keepBookTime.get(i))));
//        }
    }
    //REQUIRES:bookList must be non-null
    //EFFECTS: print the list of books recommended for students' specification
    //public abstract void recommend(List<Books> bookList);
    public void recommend(List<Books> bookList){
        System.out.printf("Welcome to %s Faculty, here are books recommended to you:\n",specification);
        for(Books book:bookList){
            if(book.getBookType().equals("specification")){
                if(((BooksOfSpecification)book).getSBooksSpecification().equals(specification))
                    System.out.printf("Book Name: %-20s        Book ID: %-20s\n",book.getBookName(),book.getBookID());
            }
        }
    }
    //REQUIRES:librarianList,studentList and bookList are all non-null
    //MODIFIES:this,bookList
    //EFFECTS:help students with the situation that they can not lend their desired books.
//    public void contactLibrarian(List<Librarian> librarianList,List<Student> studentList,List<Books> booksList) throws NoLibrarianAvailableException {
//        Librarian a=getLibrarian(librarianList);
//        if(a==null)
//            throw new NoLibrarianAvailableException();
//        System.out.println("There is librarian "+a.getID()+" serving for you.");
//        try {
//            a.reply(this,studentList,booksList);
//        } catch(CanNotLendTheSameBookException e){
//            System.out.println("Sorry, you can not lend the same book twice");
//        }catch (InvalidInputException e) {
//            System.out.println("Sorry, input is invalid.");
//        } catch (BookNotExistException e) {
//            System.out.println("Sorry, the book is not kept here.");
//        } catch (BookAlreadyExistsException e) {
//            System.out.println("Sorry, the book is kept here.");
//        } catch (MaximumBooksLendedException maximumBooksLended) {
//            System.out.println("Sorry, you have already kept 5 book in total, please return one before lending a new book.");
//        } catch (CreditNotEnoughException e) {
//            System.out.println("Sorry, you do not have enough credits to order.");
//        } catch (NotEnoughBooksException e) {
//            System.out.println("Sorry, there are no enough books");
//        }
//
//    }
    public void contactLibrarian(Library lib) throws NoLibrarianAvailableException {
        Librarian a=lib.getLibrarian(lib.getLibrarianList());
        if(a==null)
            throw new NoLibrarianAvailableException();
        System.out.println("There is librarian "+a.getID()+" serving for you.");
        try {
            a.reply(this,lib.getStudentList(),lib.getBookList());
        } catch(CanNotLendTheSameBookException e){
            System.out.println("Sorry, you can not lend the same book twice");
        }catch (InvalidInputException e) {
            System.out.println("Sorry, input is invalid.");
        } catch (BookNotExistException e) {
            System.out.println("Sorry, the book is not kept here.");
        } catch (BookAlreadyExistsException e) {
            System.out.println("Sorry, the book is kept here.");
        } catch (MaximumBooksLendedException maximumBooksLended) {
            System.out.println("Sorry, you have already kept 5 book in total, please return one before lending a new book.");
        } catch (CreditNotEnoughException e) {
            System.out.println("Sorry, you do not have enough credits to order.");
        } catch (NotEnoughBooksException e) {
            System.out.println("Sorry, there are no enough books");
        }

    }
    //EFFECTS: display all the librarians
//    public void checkLibrarianList(List<Librarian> librarianList){
//        for(Librarian librarian:librarianList){
//            if(librarian.isActive())
//            System.out.printf("ID:%-20s          Status: on\n",librarian.getID());
//            else
//                System.out.printf("ID:%-20s          Status: off\n",librarian.getID());
//        }
//    }
    //**helper method
    //REQUIRES:librarianList is non-null.
    //EEFECTS: get the first active librarian in a given librarian list.
//    private Librarian getLibrarian(List<Librarian> librarianList){
//        boolean noOneActive=true;
//        for(Librarian a:librarianList)
//            if(a.isActive())
//                noOneActive=false;
//        if(noOneActive==true)
//            return null;
//        int randomNumber=(int)(Math.random()*librarianList.size());
//        while(!librarianList.get(randomNumber).isActive()){
//            randomNumber=(int)(Math.random()*librarianList.size());
//        }
//        return librarianList.get(randomNumber);
//
//    }
    //**helper method
    //REQUIRES: a must be positive value
    //EFFECTS: convert from milliseconds to days
    static public int convertToDay(long a){
        //return (int)(a/(1000*60*60*24));
        return (int) ((System.currentTimeMillis() - a) / (1000 * 3600)) / 24;
    }
    //MODIFIES:this
    //EFFECTS:deduce number from students' credits if students have enough credits and number is not less than 0, otherwise throw CreditNotEnoughException or InvalidInputException respectively
    public void minusCredit(int number) throws InvalidInputException, CreditNotEnoughException {
        if(number<0)
            throw new InvalidInputException();
        if(number>credit){
            credit=0;
            throw new CreditNotEnoughException();}

        credit-=number;
        assert(!(credit<0));
    }


    @Override
    //EFFECTS: compare two students based on their name and student ID
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null||!(o instanceof Student))
            return false;
        Student s=(Student) o;
        return getSName().equals(s.getSName())||getSID().equals(s.getSID());
    }
    @Override
    //EFFECTS: return hash code based on students' names and IDs
    public int hashCode(){
        return Objects.hash(getSName(),getSID());
    }
}

