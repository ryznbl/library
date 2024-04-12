public class Library {
    private String name;
    /* represents the name of the store. Validation rules: The library name
    must be at least 9 characters and no longer than 20 characters.
     */
    private String address;
    /*
    represents the address of the store. Validation rules: The library
    address must be at least 10 characters and no longer than 25 characters. 
     */
    private Book[] books;
    /* representing the list of books. Validation rules: A
    rented book stays on this list. If not null, must always be full: i.e., the length of this array
    is always the number of books (rented, available or archived books) in this array. Increase
    the size by one when adding a new book. Decrease the size by one when one book is
    removed from the list.
     */

    public void setName(String n) { //sets name of library to specifications (at least 9 letters and at most 20)
        if (n.length() >= 9 && n.length() <= 20) {
            this.name = n;
        }
    }
    public String getName() { //returns name of library
        return this.name;
    }

    public void setAddress(String a) { //sets the address of the library to specifications (at least 10 letters and at most 25)
        if(a.length() >= 10 && a.length() <= 25) {
            this.address = a;
        }
    }
    public String getAddress() { //returns the address of the library
        return this.address;
    }

    public Library(String na, String ad) { //constructor method
        setName(na);
        setAddress(ad);
        
    }

    public Book[] getAvailableBooks() {
        if(this.books == null) { //check if the array is empty
            return null;
        } else {
            int countAvail = 0; //counts the available books
            for(int i = 0; i < this.books.length; i++) {
                if(books[i].getStatus().equals("Available")) { //run getstatus to check if it is available
                    countAvail += 1;
                }
            }
            Book[] availBooks = new Book[countAvail]; //create a new array with size countavail
            int iterat = 0;
            for(int j = 0; j < this.books.length; j++) {
                if (books[j].getStatus().equals("Available")) { //if there is an available book put it into the availbooks array
                    availBooks[iterat] = books[j]; //manually iterate through availbooks 
                    iterat += 1;
                }
            }
            //for loop to return list of all available books
            return availBooks;
        }
    }

    public boolean addBook(Book book) { //adds a book to the array
        if(!(book.getStatus().equals("Available"))) { //if the book does not equal available stop here
            return false;
        }

        if(this.books != null) { //if it is not null this runs
            for(int j = 0; j < this.books.length; j++) { //check if the book is already in the array
                if(books[j] == book) { //if you find it stop here
                    return false;
                }
            }

            Book[] tempBooks = new Book[this.books.length + 1];  //create a temp array that is 1 size bigger
            for(int i = 0; i < this.books.length; i++) { //copies values from books to tempbooks
                tempBooks[i] = this.books[i];
            }
            this.books = tempBooks; //replace values of books with values of tempbooks
            this.books[this.books.length - 1] = book; //assign the new book to the end of the array
            return true;
        } else {
            Book[] tempBooks = new Book[1]; //just create an array and assign the book in the first value
            this.books = tempBooks; //replace array of books with array of tempbooks
            this.books[this.books.length - 1] = book;
            return true;
        }
        
    }

    public boolean removeBook(Book book) { //this will remove a book from the library
        if(book.getStatus().equals("Rented") || book.getStatus().equals("Available")) { // only works if the book is archived
            return false;
        }
        int index = 0; //initialize an index position for the book in the library
        for(int j = 0; j < this.books.length; j++) {
            if(books[j].equals(book)) { //find the position
                index = j;
            }
        }
        Book[] tempBooks = new Book[this.books.length - 1]; //create a new array that is 1 size less
        for(int i = 0; i < tempBooks.length; i++) { //a for loop that skips over the value we want to remove
            if(i >= index) { //if we hit the index change the condition
                tempBooks[i] = this.books[i + 1]; //adding one skips the position
            } else {
            tempBooks[i] = this.books[i];
            }
        }
        this.books = tempBooks; //change the value of books to the value of tempbooks
        return true;
    }

    public boolean rentBook(int i, Reader reader) { //this is called to rent a book
        if (reader == null || this.books == null) { //first check if either the array is null or the reader is null
            return false;
        } else if(this.books.length < i || i <= 0) { //then check if i is too big for the array or if it is less than or equal to 0
            return false;
        } else { //if you pass those just run it
            books[i - 1].rent(reader); //call the rent method with i-1 because thats the actual index
            books[i - 1].setStatus("Rented"); //set the status of the book to rented
            return true;
        }
    }

    public boolean returnBook(Book book, int rating) { //called if the renter returns the book
        if(book.getStatus().equals("Rented")) { //can only be done if the book is rented
            book.addRating(book.getLastReader(), rating); //calls addrating method too add the rating to ratinghistory and update the average rating of the book
            book.setStatus("Available"); //since the book is returned it is now available
            return true;
        } else { //if it is not rented you cannot continue
            return false;
        }
    }

    public String toString() { //puts the library information in a string format
        if(this.books == null) { //if it is null you cannot check the length so i put it like this
            return "Library " + this.name + " has 0 book available"; //btw 0 books is gramatically correct but gradescope said 0 book
        } else {
            if(this.books.length >= 2) { //if it is 2 or more books you say books, otherwise book
                return "Library " + this.name + " has " + this.books.length + " books available\n";
            } else {
                return "Library " + this.name + " has " + this.books.length + " book available\n";
            }
        }
    }

    public String displayBooks() { //prints the books in the library in format
        String result = "List of books:\n";
        if(this.books == null) { //if it is null you say there are no books
            return result + "There are no books";
        }
        for(int i = 0; i < this.books.length; i++) { //loop through the books
            if(i == this.books.length - 1) { //i checked if we got to the last one to make the whitespace neater
                result += "\t" + books[i].toString();
            } else {
                result += "\t" + books[i].toString() + "\n";
            }
        }
        return result;
    }
}