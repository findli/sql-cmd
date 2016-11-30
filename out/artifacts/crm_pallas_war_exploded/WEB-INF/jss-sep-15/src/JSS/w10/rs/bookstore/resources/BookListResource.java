package JSS.w10.rs.bookstore.resources;

import JSS.w10.rs.bookstore.dao.BookDAO;
import JSS.w10.rs.bookstore.vo.Book;
import JSS.w10.rs.bookstore.vo.BookList;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author Cyril Kadomsky
 */
@Path("books")
public class BookListResource {


    @GET
    @Produces({"application/xml","application/json"})
    @Consumes("*/*")
    public Response getBooksQuery(@QueryParam("name") String name, @QueryParam("author") String author) {
        //return new BookList(getBooksHelper(name,author));
        return getBooksHelperEx(name, author);
    }


    @POST
    @Produces({"application/xml","application/json"})
    @Consumes("application/x-www-form-urlencoded")   // %20 %D1
    public Response getBooksForm(@FormParam("name") String name, @FormParam("author") String author) {
        //return new BookList(getBooksHelper(name,author));
        return getBooksHelperEx(name, author);
    }

    protected List<Book> getBooksHelper(String name, String author) {

        name = name == null? "" : name;
        author = author == null? "" : author;

        List<Book> bookList = null;
        try {
            bookList = BookDAO.getInstance().getAsList( URLDecoder.decode(name,"UTF-8"), URLDecoder.decode(author,"UTF-8") );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;

    }


    protected Response getBooksHelperEx(String name, String author) {

        name = name == null? "" : name;
        author = author == null? "" : author;

        List<Book> bookList = null;
        try {
            bookList = BookDAO.getInstance().getAsList( URLDecoder.decode(name,"UTF-8"), URLDecoder.decode(author,"UTF-8") );

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bookList == null || bookList.isEmpty()) {
            // Construct response with error message
            return Response.status(Response.Status.BAD_REQUEST).entity("Empty List").build();
        } else {
            // Construct response with BookList
            Response.ResponseBuilder rb = Response.ok(new BookList(bookList));
            Response response = rb.build();
            return response;
        }
    }


}
