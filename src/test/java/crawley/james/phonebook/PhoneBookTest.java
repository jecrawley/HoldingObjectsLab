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
                      "(111) 222-3333", phoneBook.lookup("Joseph Brown").get(0));

    }

    @Test
    public void removeTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.add("Joseph Brown", "(333) 222-1111");
        phoneBook.remove("Joseph Brown", "(111) 222-3333");

        assertEquals("Only (333) 222-1111 should be in the phone book.", "(333) 222-1111",
                      phoneBook.lookup("Joseph Brown").get(0));

    }

    @Test
    public void removeRecordTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.removeRecord("Joseph Brown");

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
        phoneBook.add("Benny Green", "(332) 222-1111");
        String numbers = "[(333) 222-1111, (332) 222-1111] [(111) 222-3333]";

        assertEquals("(111) 222-3333 should come before (333) 222-1111.", numbers, phoneBook.listNumbers());

    }

    @Test
    public void reverseLookupTest () {

        phoneBook.add("Joseph Brown", "(111) 222-3333");
        phoneBook.add("Benny Green", "(333) 222-1111");

        assertEquals("Joseph Brown should be found using the number (111) 222-3333",
                "Joseph Brown", phoneBook.reverseLookup("(111) 222-3333"));
    }

}
