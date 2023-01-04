import java.util.HashSet;

// Problem statement

// Model Person with name and age.Manage instances of Person by ensuring that no two instances are duplicated?

public class EP1 {
    public static void main(String[] args) {
        Person p1 = new Person("john", 12);
        Person p2 = new Person("john", 12);
        Person p3 = new Person("doe", 12);
        Person p4 = new Person("john", 13);
        Person p5 = new Person("Mark", 15);

        HashSet<Person> persons = new HashSet<Person>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);

        System.out.println(persons);
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
        return this.Age + this.Name.hashCode();
    }
}