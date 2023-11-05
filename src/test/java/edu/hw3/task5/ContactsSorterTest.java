package edu.hw3.task5;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ContactsSorterTest {
    @Test
    public void whenAscSortOrderShouldReturnContactsListSortedByLastNameInAscOrder() {
        String[] inputContactNames = new String[]{"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        List<Contact> expectedParcedContacts = new ArrayList<>(){{
            add(new Contact ("Thomas", "Aquinas"));
            add(new Contact ("Rene", "Descartes"));
            add(new Contact ("David", "Hume"));
            add(new Contact ("John", "Locke"));
        }};

        assertThat(ContactsSorter.parseContacts(inputContactNames, SortOrder.ASC)).isEqualTo(expectedParcedContacts);
    }

    @Test
    public void whenDescSortOrderShouldReturnContactsListSortedByLastNameInDescOrder() {
        String[] inputContactNames = new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        List<Contact> expectedParcedContacts = new ArrayList<>(){{
            add(new Contact ("Carl", "Gauss"));
            add(new Contact ("Leonhard", "Euler"));
            add(new Contact ("Paul", "Erdos"));
        }};

        assertThat(ContactsSorter.parseContacts(inputContactNames, SortOrder.DESC)).isEqualTo(expectedParcedContacts);
    }

    @Test
    public void whenContactHasNoLastNameShouldUseFirstNameForContactsSort() {
        String[] inputContactNames = new String[]{"Leo Messi", "Zinedine Zidane", "Ronaldinho", "Cafu"};
        List<Contact> expectedParcedContacts = new ArrayList<>(){{
            add(new Contact ("Cafu", ""));
            add(new Contact ("Leo", "Messi"));
            add(new Contact ("Ronaldinho", ""));
            add(new Contact ("Zinedine", "Zidane"));
        }};

        assertThat(ContactsSorter.parseContacts(inputContactNames, SortOrder.ASC)).isEqualTo(expectedParcedContacts);
    }

    @Test
    public void whenNullNamesArrayShouldReturnEmptyContactsList() {
        assertThat(ContactsSorter.parseContacts(null, SortOrder.ASC)).isEmpty();
    }

    @Test
    public void whenEmptyNamesArrayShouldReturnEmptyContactsList() {
        assertThat(ContactsSorter.parseContacts(new String[]{}, SortOrder.ASC)).isEmpty();
    }
}
