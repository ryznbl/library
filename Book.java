public class Book {
    private String title; //cannot be null and must be at least 2 characters long
    private String author; //cannot be null and must be at least 5 characters long
    private int publicationYear; //must be between 1700 and 2023 (inclusive)
    private float rating; // average rating of book
    private long isbn; //if published before 2007, isbn must be 10 digit long. if 2007 and later, isbn must be 13 digit long.
    private String status; //can only be Available, Rented, or Archived. Archived by default when first created, only an available book can be rented, a rented book cannot be archived, an archived book cannot become available.
    private Reader[] readersHistory; // When a book instance is created, this variable should point to null. The size of this array must always be the same as the number of items it contains
    private int[] ratingsHistory; //: The reader must provide a rating from 1 to 5 (inclusive). A rating of 0 signifies that no rating was provided by the reader (and should not be used when calculating the average rating). When a book instance is created, this variable should point to null. The size of this array must always be the same as the number of items it contains. The rating value inserted at index i of this array is the rating provided by the reader found at index i of the array readersHistory. In the illustration below, reader 3 provided a rating of 5 to the book.

    public void setTitle(String t) { //set the title of the book
        if (t!= null && t.length() >= 2) { //cannot be null and has to be at least 2 characters long
            this.title = t;
        }
    }
    public String getTitle() { //returns the current title
        return this.title;
    }

    public void setAuthor(String a) { //set the author of the book
        if (a!= null && a.length() >= 5) { //cannot be null and has to be at least 5 characters long
            this.author = a;
        }
        
    }
    public String getAuthor() { //returns the current author
        return this.author;
    }

    public void setPublicationYear(int p) { //sets the publication year of the book
        if(p >= 1700 && p <= 2023) { //has to be in between the years 1700 and 2023
            this.publicationYear = p;
        }
    }
    public int getPublicationYear() { //returns the current publication year
        return this.publicationYear;
    }

    public void setIsbn(long i) { //sets the isbn number of the book
        if(getPublicationYear() < 2007){ //if it is before 2007 then it has to be 10 characters long
            if(String.valueOf(i).length() == 10) {
                this.isbn = i;
            }
        } else { //otherwise any year after 2007 it has to be 13 characters long
            if(String.valueOf(i).length() == 13) {
                this.isbn = i;
            }
        }
    }
    public long getIsbn() { //returns the current isbn
        return this.isbn;
    }

    public void setStatus(String s) { //sets the status of the book, either Available, Rented, or Archived
        if(s.equals("Available")){ //if you want to set it to Available, it cannot be Archived
            if(!getStatus().equals("Archived")) {
                this.status = "Available";
            }
        } else if(s.equals("Rented")){ //if you want to set it to Rented, it has to be Available
            if(getStatus().equals("Available")) {
                this.status = s;
            }
        } else if(s.equals("Archived")){ //if you want to set it to Archived, it cannot be Rented
            if(!getStatus().equals("Rented")) {
                this.status = s;
            }
        }
    }
    public String getStatus() { //returns the current status of the book
        return this.status;
    }
    
    public float getRating() { //returns the current rating of the book
        return this.rating;
    }

    public Book(String titl, String auth, int pubYear, long isbnInp) { //construction method, all the specifications for the book 
        setTitle(titl); // sets title 
        setAuthor(auth); //sets author
        setPublicationYear(pubYear); //sets publication year
        setIsbn(isbnInp); //sets isbn, have to put l after if it is over 10 digits
        this.status = "Available"; //initializes status to available
    }
    
    public boolean archive() { //archives the book
        setStatus("Archived"); //runs set status and makes it archived
        if (getStatus().equals("Archived")) { //if it works return true, otherwise return false
            return true; 
        } else { 
            return false;
        }
    }

    public boolean rent(Reader reader) { //updates readershistory to include a new reader of the book
        if(this.readersHistory == null) { //if the array is empty set it equal to 1
            this.readersHistory = new Reader[1];
        } else {
            Reader[] tempArrayReader = new Reader[this.readersHistory.length + 1]; //make the array 1 size bigger
            for(int i = 0; i < this.readersHistory.length; i++) { //copy the array over
                tempArrayReader[i] = this.readersHistory[i];
            }
            this.readersHistory = tempArrayReader; //replace readershistory with the temparray values
        }
        this.readersHistory[this.readersHistory.length - 1] = reader; //put the new reader at the end of the array
        if(getLastReader().equals(reader)) { //check if the reader was added to the array properly
            return true;
        } else {
            return false;
        }
    }

    public Reader getLastReader() { //returns the last reader in the array readersHistory
        if(this.readersHistory == null) { //if its null just return null
            return null;
        } else {
            return this.readersHistory[this.readersHistory.length - 1]; 
        }
    }

    public boolean addRating(Reader reader, int rate) { //this will update the ratingshistory and rating
        if(rate > 5 || rate < 0) { //rate can only be between 0 and 5
            return false;
        }
        int check = 0; 
        int index = 0;
        for(int i = 0; i < this.readersHistory.length; i++) { //for loop checking where reader is
            if(this.readersHistory[i].equals(reader)) {
                check += 1; //to check if there is a reader
                index = i; //to find the index so we can match up the arrays
            }
        }
        if (check == 0) { //if it isnt in the array then stop here
            return false;
        }
        if(this.ratingsHistory == null) { //if it is null then set it equal to one
            this.ratingsHistory = new int[1];
            this.ratingsHistory[0] = rate; //set the value to the rate since there is only 1 value
            this.rating = rate; //no need to average one value
            return true;
        } else {
            int[] tempArrayRating = new int[this.ratingsHistory.length + 1]; //create a new array that is one bigger
            //this for loop has to have an empty space on the index variable so there is space for the rating
            for(int i = 0; i < this.ratingsHistory.length; i++) {
                if(i >= index) { //once you get to the index you add 1 so there is a gap
                    tempArrayRating[i + 1] = this.ratingsHistory[i];
                } else {
                    tempArrayRating[i] = this.ratingsHistory[i];
                }
            }
            this.ratingsHistory = tempArrayRating; //set temparray as ratings history
            
            this.ratingsHistory[index] = rate; //change the index to rate
            int noRateCount = 0; //check how many zeros there are for the average
            this.rating = 0; //clear rating to not mess up the average
            for(int i = 0; i < this.ratingsHistory.length; i++) { //this for loop checks if the index's value is 0, if so it adds 1 to noRateCount
                if(this.ratingsHistory[i] == 0) {
                    noRateCount += 1;
                } else {
                    this.rating += this.ratingsHistory[i]; 
                }
            }
            
            this.rating = this.rating/(this.ratingsHistory.length - noRateCount); //formula for average
            if(this.ratingsHistory[index] != rate && this.readersHistory[index] != reader) { //if it didnt work it returns false
                return false;
            } else {
                return true;
            }
        }
    }

    public String toString() { //puts the books specifications in an organized manner in a string
        String result = "\"" + getTitle() + "\" by " + getAuthor() + " (" + getPublicationYear() + ") -- Rating:" + getRating() + " -- " + getStatus() + "\n";
        return result;
    }
}