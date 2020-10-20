# Library

The project is modeling a simplified library system, which is coded in Java. This is a project done for CPSC 210 Software Construction course.

The whole project includes two identities: student and librarian. It accepts both new users (sign up) and returning users (log in) by having a registration system. A student is recognized by his/her ID, password, and major (math/ English/ Engineering) and can use nine functions including displaying all books in store, lending a book, returning a book, etc. A librarian is recognized by his/her ID and password. Librarians possess rights to buy in new books, investigate all students' information, etc. Dependencies exist between the books added by librarians and the content of booklist the students can consult, and also between students' personal profile and what can be accessed by librarians through clicking "display all students' information." Further, students can ask for help when any librarian is available by clicking "check librarian list." There are also other subtle dependencies between these two systems.

With respect to the application, the project is constructed to model a simplified library system by having only two identities and many other restrictions, such as limited choices of majors for students and lacking in some real-life library system functions such as reserving books for specific usage. However, the main and elementary functions of a library are modelled by this project and further improvements can be made based on existing code.

Please run WelcomeToLibraryGUI in src/Project11 to start the library system. Some functions can be visualized below:

Starting page:

 ![image](https://github.com/Fangzhaoo/Library/blob/main/Library/images/initialPage.png)
 
Select identities:

 ![image](https://github.com/Fangzhaoo/Library/blob/main/Library/images/idnetities.png)

Registration system (take librarian for example):

 ![image](https://github.com/Fangzhaoo/Library/blob/main/Library/images/librarianReg.png)
 
 Student Functions:
 
 ![image](https://github.com/Fangzhaoo/Library/blob/main/Library/images/student.png)
  
 Librarian Functions:
 
 ![image](https://github.com/Fangzhaoo/Library/blob/main/Library/images/librarian.png)
