import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

// Problem statement

// Model Person with name and age.Manage instances of Person by ensuring that no two instances are duplicated?

public class EP2 {
    public static void main(String[] args) {
        ComparablePerson cp1 = new ComparablePerson("john", 12);
        ComparablePerson cp2 = new ComparablePerson("doe", 12);
        ComparablePerson cp3 = new ComparablePerson("john", 13);
        ComparablePerson cp4 = new ComparablePerson("mark", 15);

        ArrayList<ComparablePerson> cpersons =
            new ArrayList<ComparablePerson>();
        cpersons.add(cp1);
        cpersons.add(cp2);
        cpersons.add(cp3);
        cpersons.add(cp4);

        Collections.sort(cpersons);

        System.out.println(cpersons);

        System.out.println(
            "Finding John 12: " +
            Collections.binarySearch(
                cpersons,
                new ComparablePerson("john", 12)));
    }
}

class Person {
    public String Name;
    public int Age;

    public Person(String name, int age) {
        Name = name;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s is %d years old", Name, Age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (this.Age == other.Age && this.Name == other.Name)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.Age ^ this.Name.hashCode();
    }
}

class ComparablePerson extends Person implements Comparable<ComparablePerson> {
    public ComparablePerson(String name, int age) {
        super(name, age);
    }

    @Override
    public int compareTo(ComparablePerson o) {
        return this.toString().compareTo(o.toString());
    }
}

