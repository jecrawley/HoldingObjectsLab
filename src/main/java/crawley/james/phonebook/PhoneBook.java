package crawley.james.phonebook;

import java.util.*;

/**
 * Created by jamescrawley on 9/28/16.
 */
public class PhoneBook {

    private Map<String, List<String>> namesAndNumbers = new TreeMap<>();
    //private List<String> numbers = new ArrayList<>();

    public void add (String name, String number) {

        List<String> numbers;

        if (namesAndNumbers.containsKey(name)) {
            numbers = namesAndNumbers.get(name);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(number);

        namesAndNumbers.put(name, numbers);

    }

    public void remove (String name, String number) {

        namesAndNumbers.get(name).remove(number);

    }

    public void removeRecord (String name) {

        namesAndNumbers.remove(name);

    }

    public List<String> lookup (String name) {

        return namesAndNumbers.get(name);

    }

    public String reverseLookup (String number) {

        String name = null;
        Set<String> names = namesAndNumbers.keySet();

        for (String lookupName : names) {

            if (namesAndNumbers.get(lookupName).contains(number))  {
                name = lookupName;
                break;
            }
        }

        return name;

    }

    public String[] listNames () {

        return (namesAndNumbers.keySet()).toArray(new String[0]);

    }

    public String listNumbers () {

        String listOfNumbers = "";

        for (List<String> personNumbers: namesAndNumbers.values()) {

            listOfNumbers += personNumbers.toString() + " ";
        }

        return listOfNumbers.substring(0, listOfNumbers.length() - 1);

    }
}
