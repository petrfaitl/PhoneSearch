PhoneSearch
===========

Application to manage people phone numbers and addresses.


1 adding a phone number to the relative person
2 phone number search by person
3 name search by phone number
4 adding an address to the relative person
5 personal information search (search for a person's address and phone number)
6 removing a person's information
7 filtered search by keyword (retrieving a list which must be sorted by name in alphabetic order), the keyword can appear in the name or address

An example of how the program works:

phone search
available operations:
 1 add a number
 2 search for a number
 3 search for a person by phone number
 4 add an address
 5 search for personal information
 6 delete personal information
 7 filtered listing
 x quit

command: 1
whose number: pekka
number: 040-123456

command: 2
whose number: jukka
  not found

command: 2
whose number: pekka
 040-123456

command: 1
whose number: pekka
number: 09-222333

command: 2
whose number: pekka
 040-123456
 09-222333

command: 3
number: 02-444123
 not found

command: 3
number: 09-222333
 pekka

command: 5
whose information: pekka
  address unknown
  phone numbers:
   040-123456
   09-222333

command: 4
whose address: pekka
street: ida ekmanintie
city: helsinki

command: 5
whose information: pekka
  address: ida ekmanintie helsinki
  phone numbers:
   040-123456
   09-222333

command: 4
whose address: jukka
street: korsontie
city: vantaa

command: 5
whose information: jukka
  address: korsontie vantaa
  phone number not found

command: 7
keyword (if empty, all listed): kk

 jukka
  address: korsontie vantaa
  phone number not found

 pekka
  address: ida ekmanintie helsinki
  phone numbers:
   040-123456
   09-222333

command: 7
keyword (if empty, all listed): vantaa

 jukka
  address: korsontie vantaa
  phone number not found

command: 7
keyword (if empty, all listed): seppo
 keyword not found

command: 6
whose information: jukka

command: 5
whose information: jukka
  not found

command: x
Some remarks:

Because of the tests, it is essential that the user interface works exactly as in the example above. The application can optionally decide in which way invalid inputs are handled. The tests contain only valid inputs.
The program has to start when the main method is executed; you can only create one Scanner object.
Do not use static variables, the tests execute your program many different times, and the static variable values left from the previous execution would possibly disturb them!
In order to make things easier, we assume the name is a single string; if we want to print our lists sorted by surname in alphabetic order, the name has to be given in the form surname name.
A person can have more than one phone number and address. However, these are not necessarily stored.
If a person is deleted, no search should retrieve them.
