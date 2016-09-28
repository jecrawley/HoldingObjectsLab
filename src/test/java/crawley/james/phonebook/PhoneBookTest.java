package crawley.james.phonebook;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jamescrawley on 9/28/16.
 */
public class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    public void lookupTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");

        assertEquals("Joseph Brown should be added with the number (111) 222-3333",
                      "(111) 222-3333", phoneBook.lookup("Joseph Brown"));

    }

    @Test
    public void removeTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.remove("Joseph Brown");

        assertNull("Joseph Brown not be in the phone book.", phoneBook.lookup("Joseph Brown"));

    }

    @Test
    public void listNamesTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.add("Benny Green", "(333) 222-1111");
        String[] names = {"Benny Green", "Joseph Brown"};

        assertArrayEquals("Benny should come before Joseph.", names, phoneBook.listNames());

    }

    @Test
    public void listNumbersTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.add("Benny Green", "(333) 222-1111");
        String[] numbers = {"(333) 222-1111", "(111) 222-3333"};

        assertArrayEquals("(111) 222-3333 should come before (333) 222-1111.", numbers, phoneBook.listNumbers());

    }

}
