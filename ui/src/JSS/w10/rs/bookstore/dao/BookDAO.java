package JSS.w10.rs.bookstore.dao;

import JSS.w10.rs.bookstore.vo.Book;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class BookDAO {

    LinkedHashMap<Long, Book> data = new LinkedHashMap<>(10);
    static long maxID = 0;

    static BookDAO instance;

    public static BookDAO getInstance() {
        if (instance == null) {
            instance = new BookDAO();
        }

        return instance;
    }

    private BookDAO() {
        data.put(1l, new Book(1, "Romeo and Juliet", "Shakespear"));
        data.put(2l, new Book(2, "Sonnets", "Shakespear"));
        data.put(3l, new Book(3, "Sherlock Holmes", "Conan Doyle"));
        maxID = 3l;
    }

    public Book get(long id) {
        if (!data.containsKey(id)) {
            throw new InvalidParameterException();
        }
        return data.get(id);
    }

    public List<Book> getAsList(String name, String author) {
        List<Book> list = new ArrayList<>(10);
        for (Book book : data.values()) {
            if ((name == null || name.isEmpty()) || book.getName().equals(name) &&
                    (author == null || author.isEmpty()) || book.getAuthor().equals(author)) {
                list.add((Book) book.clone());
            }
        }
        return list;
    }

    public Book add(Book book) {
        book.setId(++maxID);
        data.put(book.getId(), book);
        return book;
    }

    public Book remove(Book book) {
        if (book.getId() > 0 && data.containsKey(book.getId())) {
            data.remove(book.getId());
        }

        book.setId(-1);
        return book;
    }

    public Book update(Book book) {
        if (book.getId() > 0 && data.containsKey(book.getId())) {
            data.put(book.getId(), book);
        }
        return book;
    }
}
