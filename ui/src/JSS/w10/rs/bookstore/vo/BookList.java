package JSS.w10.rs.bookstore.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/*JAXB: <bookList>
* <book id="1" ... />
* <book id="2" ... />
* <book id="3" ... />
* </bookList>
* */
@XmlRootElement(name = "bookList")
public class BookList {
    private List<Book> bookList;

    // it must have default constructor
    public BookList() {
    }

    public BookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @XmlElement(name = "book")
    public List<Book> getBookList() {
        if (bookList == null) {
            bookList = new ArrayList<Book>(10);
        }

        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
