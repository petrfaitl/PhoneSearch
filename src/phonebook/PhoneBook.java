/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tools.SearchPhoneBook;

/**
 *
 * @author Petr
 */
public class PhoneBook 
{
    Map<String, Person> phonebook;
    Map<String, String> reversedBook;
    
    public PhoneBook()
    {
        this.phonebook = new HashMap<String, Person>(); 
        this.reversedBook = new HashMap<String, String>();
    }
    
    public void addPerson(String name)
    {
        if(!personCheck(name))
        {
            this.phonebook.put(name, new Person(name));
        }
        
    }
    
    
    public void addPhonenumber(String name, String number)
    {
        if(!personCheck(name))
        {
            addPerson(name);
            
        }
        
        Person person = this.phonebook.get(name);
        person.addPhoneNumber(number);
        this.reversedBook.put(number,name);
        
    }
    
    
    public void addAddress(String name, String street, String city)
    {
       if(!personCheck(name))
       {
           addPerson(name);
       }
       
       Person person = this.phonebook.get(name);
       person.addAddress(street, city);
       
    }
    
    public boolean personCheck(String name)
    {
        if(this.phonebook.containsKey(name))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString()
    {
        String output ="";
        List<Person> persons = new ArrayList<Person>(phonebook.values());
        Collections.sort(persons);
        for(Person person : persons)
        {
            output += " "+ person.getName() + "\n" + person + "\n";
        }
        return output;
    }
    
    
    public String searchPhoneByPerson(String name)
    {
        SearchPhoneBook search = new SearchPhoneBook();
        return search.phoneByPerson(this.phonebook, name);
    }
    
    public String searchPersonByPhone(String number)
    {
        SearchPhoneBook search = new SearchPhoneBook();
        return search.personByPhone(this.reversedBook, number);
    }
    
    public String keywordSearch(String keyword)
    {
        SearchPhoneBook search = new SearchPhoneBook();
        return search.keyword(this.phonebook, keyword);
    }
    
    public String personalInfoSearch(String name)
    {
        SearchPhoneBook search = new SearchPhoneBook();
        return search.searchPersonInfo(this.phonebook, name);
    }
    
    public void removePerson(String name)
    {
        List<String> existingNumbers = this.phonebook.get(name).getNumbers();
        for(String number : existingNumbers)
        {
            this.reversedBook.remove(number);
        }
        this.phonebook.remove(name);
    }
}
