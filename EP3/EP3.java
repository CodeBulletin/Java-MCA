import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class EP3 {
    public static void main(String[] args) {
        ArrayList<AddressBookEntry> entries = new ArrayList<>();
        entries.add(new AddressBookEntry("Alice", "123 Main St", "555-1212"));
        entries.add(new AddressBookEntry("Bob", "456 Oak Ave", "555-1212"));
        entries.add(new AddressBookEntry("Charlie", "789 Pine St", "555-1212"));

        Collections.sort(entries);

        for (AddressBookEntry entry : entries) {
            entry.print();
        }
    }
}

class AddressBookEntry implements Comparable<AddressBookEntry> {
    private String name;
    private String address;
    private String phone;

    public AddressBookEntry(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    @Override
    public int compareTo(AddressBookEntry other) {
        return this.name.compareTo(other.name);
    }
}
