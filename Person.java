public class Person {

    /**
     * Creating person class
     */
    String name;
    String surname;
    int telephoneNumber;
    String emailAddress;
    String physicalAddress;

    /**
     * Creating constructor
     */
    public Person(String name,String surname, int telephoneNumber, String emailAddress, String physicalAddress) {

        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
        this.physicalAddress = physicalAddress;

    }
    /**
     * Creating setters for editing purposes
     */
    public void setTelephoneNumber (int telephoneNumber) {

        this.telephoneNumber = telephoneNumber       ;
    }
    public void setEmailAddress (String emailAddress){

        this.emailAddress = emailAddress;

    }

    /**
     * Creating toString method
     */
    public String toString() {
        String output = "";
        output += "\nName: " + name + " "+ surname;
        output += "\nTelephone Number: " + telephoneNumber;
        output += "\nEmail Address: " + emailAddress;
        output += "\nPhysical Address: " + physicalAddress;
        return output;
    }
}





