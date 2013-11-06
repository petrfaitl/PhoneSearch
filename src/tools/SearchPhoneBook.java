/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import phonebook.*;

/**
 *
 * @author Petr
 */
public class SearchPhoneBook
{
    
    
    public String phoneByPerson(Map<String, Person> book,String name)
    {
        String output = " ";
        if(!book.containsKey(name))
        {
            return "  not found\n";
        }
        for(String number : book.get(name).getNumbers())
        {
            output += number +"\n ";
        }
        return output;
    }
    
    public String personByPhone(Map<String, String> reversedBook, String number)
    {
        if(!reversedBook.containsKey(number))
        {
            return "  not found\n";
        }
        return " " + reversedBook.get(number) + "\n";
    }
    
    public String keyword(Map<String,Person> book, String keyword)
    {
        
       // Set<String> keys = book.keySet();
        Collection<Person> bookValues = book.values() ;
        List<String> found = new ArrayList<String>();
        String output = "";
//        for(String key : keys)
//        {
//            if(key.contains(keyword))
//            {
//                found.add(key);
//            }
//        }
        found.addAll(personInfo(book, keyword));
        
        if(!keyword.isEmpty())
        {
            for(Person person : bookValues)
            {
                List<String> foundAddresses = person.getAddress();
                for(String address : foundAddresses)
                {
                   if(address.contains(keyword))
                   {
                       found.add(person.getName());
                   }
                }
             }
        }
        Collections.sort(found);
        if(found.isEmpty())
        {
            output += " not found";
        }else
        {
            for(String foundKey : found)
            {
               output += " " + foundKey + "\n" + book.get(foundKey) + "\n";
            }
        }
        return output;
    }
    
    public String searchPersonInfo(Map<String,Person> book, String name)
    {
        List<String> found = new ArrayList<String>();
        String output = "";
        found.addAll(personInfo(book, name));
        Collections.sort(found);
        if(found.isEmpty())
        {
            output += " not found";
        }else
        {
            for(String foundKey : found)
            {
               output += " " + book.get(foundKey) + "\n";
            }
        }
        return output;
        
    }
    
    public List<String> personInfo(Map<String, Person> book, String name)
    {
        Set<String> keys = book.keySet();
        List<String> found = new ArrayList<String>();
        for(String key : keys)
        {
            if(key.contains(name))
            {
                found.add(key);
            }
        }
        return found;
    }
}
