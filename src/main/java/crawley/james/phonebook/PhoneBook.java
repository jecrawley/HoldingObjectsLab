package crawley.james.phonebook;

import java.util.*;

/**
 * Created by jamescrawley on 9/28/16.
 */
public class PhoneBook {

    private Map<String, String> namesAndNumbers = new TreeMap<>();

    public void add (String name, String number) {

        namesAndNumbers.put(name, number);

    }

    public void remove (String name) {

        namesAndNumbers.remove(name);

    }

    public String lookup (String name) {

        return namesAndNumbers.get(name);

    }

    public String[] listNames () {

        return (namesAndNumbers.keySet()).toArray(new String[0]);

    }

    public String[] listNumbers () {

        return (namesAndNumbers.values()).toArray(new String[0]);

    }
}
