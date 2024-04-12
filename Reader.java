public class Reader {
    private String fullName;
    /*a String that represents the full name of the buyer. Validation
    Rule: The length of the full name must be at least 3 characters and no longer than 20
    characters */
    private int yearOfBirth;
    /* an integer that represents the year of birth of the buyer. Validation
    Rule: The year of birth must be between 1923 and 2013. For instance, 1923 is a valid year
    of birth while 2014 is not a valid year of birth.
    */
    private int zipCode; //a 5-digit integer that represents the zipCode where the buyer lives.

    public void setFullName(String f) { //sets the name of the reader, at least 3 letters and at most 20
        if(f.length() >= 3 && f.length() <= 20) {
            this.fullName = f;
        }
        
    }
    public String getFullName() { //returns the name of the reader
        return this.fullName;
    }
    
    public void setYearOfBirth(int y) { //sets the year of birth of the reader, at least 1923 and at most 2013
        if(y >= 1923 && y <= 2013) {
            this.yearOfBirth = y;
        }
    }
    public int getYearOfBirth() { //returns year of birth of the reader
        return this.yearOfBirth;
    }

    public void setZipCode(int z) { //sets the zip code of the reader, only 5 digit numbers allowed
        if(Integer.toString(z).length() == 5) {
            this.zipCode = z;
        }
    }
    public int getZipCode() { //returns the zipcode
        return this.zipCode;
    }

    public Reader (String fullN, int yearOB, int zipC) { //constructor method that assigns the readers information
        setFullName(fullN);
        setYearOfBirth(yearOB);
        setZipCode(zipC);
    }
}