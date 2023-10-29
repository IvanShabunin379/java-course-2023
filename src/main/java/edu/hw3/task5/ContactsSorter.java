package edu.hw3.task5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class ContactsSorter {
    private final static Comparator<Contact> CONTACT_COMPARATOR = (contact1, contact2) -> {
        String comparingName1 = contact1.lastName + contact1.firstName;
        String comparingName2 = contact2.lastName + contact2.firstName;

        return comparingName1.compareTo(comparingName2);
    };

    private ContactsSorter() {
    }

    public static List<Contact> parseContacts(String[] contactNames, SortOrder order) {
        if (contactNames == null || contactNames.length == 0) {
            return new ArrayList<Contact>();
        }

        List<Contact> contacts = new ArrayList<>(contactNames.length);

        for (String name : contactNames) {
            String[] partsOfName = name.split(" ");
            String firstName = partsOfName[0];
            String lastName = (partsOfName.length > 1) ? partsOfName[1] : "";
            contacts.add(new Contact(firstName, lastName));
        }

        if (order.equals(SortOrder.ASC)) {
            contacts.sort(CONTACT_COMPARATOR);
        } else if (order.equals(SortOrder.DESC)) {
            contacts.sort(CONTACT_COMPARATOR.reversed());
        }

        return contacts;
    }
}
