/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Petr
 */
public class Person implements Comparable<Person>
{
    private String name;
    private List<String> phoneNumbers;
    private List<PersonAddress> addresses;
    
    public Person(String name) 
    {
        this.name = name;
        this.phoneNumbers = new ArrayList<String>();
        this.addresses = new ArrayList<PersonAddress>();
    }
    
    public void addPhoneNumber(String number)
    {
        this.phoneNumbers.add(number);
    }
    
    public void addAddress(String street, String city)
    {
        this.addresses.add(new PersonAddress(street, city));
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public List<String> getNumbers()
    {
        return this.phoneNumbers; 
    }
    
    public List<String> getAddress()
    {
        List<String> output = new ArrayList<String>();
        for(PersonAddress address : this.addresses)
        {
            output.add(address.toString());
        }
        return output;
    }
    
    @Override
    public String toString()
    {
        String output = "";
        if(this.addresses.isEmpty())
        {
            output += "  address unknown \n";
        }else
        {
            output += "  address: ";
            for(PersonAddress address : this.addresses)
            {
                output += address + ", ";
            }
            
            output = output.substring(0,output.length()-2);
            
            output += "\n";
        }
        if(this.phoneNumbers.isEmpty())
        {
            output += "  phone number not found\n";
        }else
        {
            output += "  phone numbers:\n";
            for(String num : this.phoneNumbers)
            {
                output += "   " + num + "\n";
            }
        }
        return output;
    }
    
    @Override
    public int compareTo(Person compared)
    {
        return this.name.compareTo(compared.name);
    }
}
