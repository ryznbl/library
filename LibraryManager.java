public class LibraryManager {
    //Test your code
    public static void main(String[] args) {

        { //Creating Scope for Test 1
            Library myLibrary = new Library("La Pleiade", "1234, Abc Street, Fairfax");
            Book book1 = new Book("Harry Potter", "J.K. Rowling", 1997, 1000000000);
            Book book2 = new Book("Yazan Autobiography1", "Yazan A. Alshoroogi", 2018, 1020000321123l);
            Book book3 = new Book("Yazan Autobiography2", "Yazan A. Alshoroogi", 2018, 1020000321123l);
            Book book4 = new Book("Yazan Autobiography3", "Yazan A. Alshoroogi2", 2019, 1020000310123l);
            Book book5 = new Book("Yazan Autobiography4", "Yazan A. Alshoroogi3", 2020, 1020000320123l);
            Book book6 = new Book("Yazan Autobiography5", "Yazan A. Alshoroogi4", 2021, 1020000330123l);
            Book book7 = new Book("Yazan Autobiography6", "Yazan A. Alshoroogi5", 2022, 1020000340123l);
            Book book8 = new Book("Yazan Autobiography7", "Yazan A. Alshoroogi6", 2023, 1020000350123l);
            Reader yazan1 = new Reader("Yazan1 Alshoroogi", 2001, 20164);
            Reader yazan2 = new Reader("Yazan2 Alshoroogi", 2000, 20163);
            Reader yazan3 = new Reader("Yiasdfasadfaffadf", 1999, 20162);
            Reader yazan4 = new Reader("Yazan4 Alshoroogi", 1998, 20111);

            //System.out.println(myLibrary);
            //System.out.println(myLibrary.displayBooks());
            myLibrary.addBook(book1);
            myLibrary.addBook(book2);
            myLibrary.addBook(book3);
            myLibrary.addBook(book4);
            myLibrary.addBook(book5);
            myLibrary.addBook(book6);
            myLibrary.addBook(book7);
            myLibrary.addBook(book8);
            myLibrary.rentBook(4, yazan1);
            myLibrary.returnBook(book4, 1);
            myLibrary.rentBook(4, yazan2);
            myLibrary.returnBook(book4, 2);
            myLibrary.rentBook(4, yazan3);
            myLibrary.returnBook(book4, 5);
            myLibrary.rentBook(4, yazan4);
            myLibrary.returnBook(book4, 4);
            System.out.println(myLibrary);
            System.out.println(myLibrary.displayBooks());
            //System.out.println(Arrays.toString(myLibrary.getAvailableBooks()));
            book1.archive();
            book2.archive();
            book8.archive();
            //System.out.println(Arrays.toString(myLibrary.getAvailableBooks()));
            myLibrary.removeBook(book8);
            //myLibrary.removeBook(book1);
            //System.out.println(book7.getLastReader());
            //System.out.println(book7.getRating());
            //System.out.println(myLibrary.removeBook(book2));
            //setFullName
            //setYearOfBirth
            //setZipCode
            //getFullName
            //getYearOfBirth
            //getZipCode
            //setName
            //getName
            //setAddress
            //getAddress
            //getAvailableBooks
            //addBook
            //removeBook
            //rentBook
            //returnBook
            //toString
            //setTitle(string)
            //getTitle
            //setAuthor(string)
            //getAuthor
            //setPublicationYear(int)
            //getPublicationYear
            //setIsbn(long)
            //getIsbn
            //setStatus(string)
            //getStatus
            //getRating
            //archive
            //rent(Reader)
            //getLastReader
            //addRating(Reader, int)
            //Book toString
            //setName(string)
            //getName
            //setAddress(string)
            //getAddress
            //getAvailableBooks
            //addBook(Book)
            //removeBook(Book)
            //rentBook(int, Reader)
            //returnBook(Book, int)
            //Library toString()
            //displayBooks
            System.out.println(myLibrary);
            System.out.println(myLibrary.displayBooks());
        }

        {
            //Book book1 = new Book("Harry Potter", "J. Rowling", 1997, 1000000000);
            //book1.setAuthor("J.K. Rowling");
            //System.out.println(book1.toString());
        }

    }
}