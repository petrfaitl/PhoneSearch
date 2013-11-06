/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

/**
 *
 * @author Petr
 */
public class PersonAddress
{
    private String street;
    private String city;
    public PersonAddress(String street, String city)
    {
        this.street = street;
        this.city = city;
    }
    
    public String getCity()
    {
        return this.city;
    }
    
    @Override
    public String toString()
    {
        return this.street + " " + this.city;
    }
}
