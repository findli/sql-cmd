package JSS.w10.rs.bookstore;

import JSS.w10.rs.bookstore.dao.BookDAO;
import JSS.w10.rs.bookstore.vo.Book;
import JSS.w10.rs.bookstore.vo.BookList;

import javax.activation.MimeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Path("books")
public class BookResource {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes("*/*")
    public BookList getBookQuery(@QueryParam("name") String name, @QueryParam("author") String author) {
        return new BookList(getBooksHelper(name, author));
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public BookList getBookForm(@QueryParam("name") String name, @QueryParam("author") String author) {
        return new BookList(getBooksHelper(name, author));
    }

    protected List<Book> getBooksHelper(String name, String author) {
        name = name == null ? "" : name;
        author = author == null ? "" : author;

        List<Book> bookList = null;
        try {
            bookList = BookDAO.getInstance().getAsList(URLDecoder.decode(name, "UTF-8"), URLDecoder.decode(author, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return bookList;
    }
}
