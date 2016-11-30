package JSS.w10.rs.bookstore.vo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


// JAXB : <book id="10" name="fjfjjf" author="eyeyey"/>
@XmlRootElement(name="book")
public class Book implements Cloneable {

    private long id = -1;
    private String name = null;
    private String author = null;

    public Book() { }   // Must have dafault constructor to return it in Responce


    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author) {
        this.id = -1;
        this.name = name;
        this.author = author;
    }

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public Object clone() {
        return new Book(id,name,author);
    }

    @Override
    public String toString() {
        return "book{ name = " + getName() + ", author =  " + getAuthor() + "}";
    }
}
