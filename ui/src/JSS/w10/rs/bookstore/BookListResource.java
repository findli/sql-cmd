package JSS.w10.rs.bookstore;

import JSS.w10.rs.bookstore.dao.BookDAO;
import JSS.w10.rs.bookstore.vo.Book;
import JSS.w10.rs.bookstore.vo.BookList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Path("books")
public class BookListResource {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes("*/*")
    public Response getBookQuery(@QueryParam("name") String name, @QueryParam("author") String author) {
//        return new BookList(getBooksHelper(name, author));
        return getBooksHelperExtended(name, author);
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getBookForm(@QueryParam("name") String name, @QueryParam("author") String author) {
//        return new BookList(getBooksHelper(name, author));
        return getBooksHelperExtended(name, author);
    }

    protected Response getBooksHelperExtended(String name, String author) {
        name = name == null ? "" : name;
        author = author == null ? "" : author;

        List<Book> bookList = null;
        try {
            bookList = BookDAO.getInstance().getAsList(URLDecoder.decode(name, "UTF-8"), URLDecoder.decode(author, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        if (bookList == null || bookList.isEmpty()) {
            // make error response
            return Response.status(Response.Status.BAD_REQUEST).entity("empty list").build();
        } else {
            // normal response with BookList
            Response.ResponseBuilder responseBuilder = Response.ok(new BookList(bookList));
            return responseBuilder.build();        }
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
