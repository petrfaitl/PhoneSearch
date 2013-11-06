/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import java.util.Scanner;
import phonebook.*;

/**
 *
 * @author Petr
 */
public class YellowPages
{
    private PhoneBook book;
    private Scanner reader;
    
    public YellowPages()
    {
        this.book = new PhoneBook();
        this.reader = new Scanner(System.in);
        
    }   
    
    public void start()
    {
        printMenu();
        while(true)
        {
            System.out.print("command: ");
            
            if(reader.hasNext("x"))
            {
                break;
            }
            
            try
            {
                int command = Integer.parseInt(reader.nextLine());
                if(command == 1){addNumber();}
                if(command == 2){searchANumber(reader);}
                if(command == 3){searchPersonByNumber(reader);}
                if(command == 4){addAddress(reader);}
                if(command == 5){searchPersonalInfo(reader);}
                if(command == 6){deletePersonalInfo(reader);}
                if(command == 7){filteredListing(reader);}
            }catch (Exception e)
            {
                System.out.println("Enter a valid command");
            }
            
            
            
            
        }
    }
    
    private void addNumber()
    {
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        this.book.addPhonenumber(name, number);
        System.out.println();
    }
    
    private void searchANumber(Scanner reader)
    {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.println(this.book.searchPhoneByPerson(name));
    }
    
    private void searchPersonByNumber(Scanner reader)
    {
        System.out.print("number: ");
        String number = reader.nextLine();
        System.out.println(this.book.searchPersonByPhone(number));
    }
    
    private void addAddress(Scanner reader)
    {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        this.book.addAddress(name, street, city);
        System.out.println();
    }
    private void searchPersonalInfo(Scanner reader)
    {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        System.out.println(this.book.personalInfoSearch(name));
        
    }
    
    private void deletePersonalInfo(Scanner reader)
    {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        this.book.removePerson(name);
    }
    
    private void filteredListing(Scanner reader)
    {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        System.out.println(this.book.keywordSearch(keyword));
    }
    
    private void printMenu()
    {
        System.out.println("phone search\n"
                          +"available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        System.out.println();
    }
}
