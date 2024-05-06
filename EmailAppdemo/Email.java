import java.util.Scanner;

public class Email {
    
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "mycompany.com";

    //constructor to recieve first and last name 
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("email"+this.firstName+this.lastName); 
        
        //calling a method asking the department        
        this.department = setDepartment();
        System.out.println("Department"+this.department);

        //calling a method to generate random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("your password"+this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() +lastName.toLowerCase() + "@" + department+"."+ companySuffix;
        System.out.println("Your email is:" + email);

    }

    //Ask for the department 
    private String setDepartment(){
        System.out.println(" Enter the department choice \n 1 for sales \n 2 for department \n 3 for accounting");
        Scanner in = new Scanner(System.in);
        int depChoice =in.nextInt();

        if(depChoice == 1){ return "sales";}
        else if(depChoice == 2){ return "development";}
        else if(depChoice == 3){ return "acconting";}
        else {return "";}
    }

    //generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOP0123456789@!";
        char password[] = new char[length];
        for(int i=0; i< length ; i++){
            int rand = (int)(Math.random()*passwordSet.length());
            password[i]=passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set the mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword() { return password;}

    public String showInfo(){
        return ("DISPLAY NAME:"+ firstName +""+lastName + "COMPANY EMAIL:" + email + "MAILBOX CAPACITY: "+ mailboxCapacity + "mb");
    } 


}
