public class CP9 {
    public static void main(String[] args) {
        StringObject str1 = new StringObject("hello");
        StringObject str2 = new StringObject("world");
        Book book1 = new Book("The Great Gatsby", 180);
        Book book2 = new Book("War and Peace", 1225);
        
        System.out.println(str1.isLargerThan(str2)); // false
        System.out.println(book1.isLargerThan(book2)); // false
        System.out.println(book2.isLargerThan(book1)); // true
    }
}

interface Relatable {
    boolean isLargerThan(Relatable other);
}

class StringObject implements Relatable {
    private String str;
    
    public StringObject(String str) {
        this.str = str;
    }
    
    public String getString() {
        return str;
    }
    
    @Override
    public boolean isLargerThan(Relatable other) {
        if (other instanceof StringObject) {
            StringObject otherString = (StringObject) other;
            return str.length() > otherString.getString().length();
        }
        return false;
    }
}

class Book implements Relatable {
    private String title;
    private int numPages;
    
    public Book(String title, int numPages) {
        this.title = title;
        this.numPages = numPages;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getNumPages() {
        return numPages;
    }
    
    @Override
    public boolean isLargerThan(Relatable other) {
        if (other instanceof Book) {
            Book otherBook = (Book) other;
            return numPages > otherBook.getNumPages();
        }
        return false;
    }
}