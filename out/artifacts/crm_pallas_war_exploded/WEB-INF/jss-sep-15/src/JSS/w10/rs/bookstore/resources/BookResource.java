package JSS.w10.rs.bookstore.resources;

import JSS.w10.rs.bookstore.dao.BookDAO;
import JSS.w10.rs.bookstore.vo.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Date;

/**
 * @author Cyril Kadomsky
 */
@Path("/book")
public class BookResource {

    @GET
    @Path("/get/{id}")
    @Produces({"application/xml","application/json","text/html"})
    @Consumes("*/*")
    public Response getBook(@PathParam("id") long id) {
        Book book = null;

        try {
            book = BookDAO.getInstance().get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (book==null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .type("text/html")
                    .entity(String.format("<h2>Book not found </h3> <br> id=%d",id))
                    .build();

        } else {
            return Response.ok(book)
                            .expires(new Date(System.currentTimeMillis() + 3000))
                            .build();
        }
    }

    // To add html representation
    // separate @GET method not needed, because BookHtmlProvider may be used by Response.ok(book).build()
//    @GET
//    @Path("/get/{id}")
//    @Produces({"text/html"})
//    @Consumes("*/*")
//    public Book getAsHtml(@PathParam("id") long id) {
//        return BookDAO.getInstance().get(id);
//    }


    @POST
    @Path("/add")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public Response addBook(@FormParam("name") String name, @FormParam("author") String author) {

        Book book = null;
        try {
            if ( name==null || name.isEmpty() || author==null || author.isEmpty()) {
                throw new IllegalArgumentException();
            }

            book = new Book(name,author);
            book = BookDAO.getInstance().add(book);

        }  catch (Exception e) {
            e.printStackTrace();
        }

        if (book==null || book.getId()<=0) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .type("text/html")
                    .entity(String.format("<h2>Book not created </h3> <br> "))
                    .build();

        } else {
            return Response.created(URI.create("book/" + book.getId())).build();
        }
    }

    @PUT
    @Path("/{id}/edit")
    @Produces({"application/xml","application/json"})  // + "text/html"
    @Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
    public Response updateBook(@FormParam("id") long id, @FormParam("name") String name, @FormParam("author") String author) {

        Book book = null;
        try {
            if ( id<=0 || name==null || name.isEmpty() || author==null || author.isEmpty()) {
                throw new IllegalArgumentException();
            }

            book = new Book(id,name,author);
            book = BookDAO.getInstance().update(book);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        if (book==null || book.getId()<=0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .type("text/html")
                    .entity(String.format("<h2>Book not updated </h3> <br> "))
                    .build();

        } else {
            return Response.ok(book).build();
        }
    }

    @DELETE
    @Path("/{id}/del")
    @Produces({"application/xml","application/json"})  // + "text/html"
    @Consumes("*/*")
    public Response deleteBook(@PathParam("id") long id) {

        boolean success = false;
        try {
            success = BookDAO.getInstance().remove(id);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        if (!success) {
            return Response.notModified().build();
        } else {
            return Response.ok().entity("Deleted successfully").build();
        }
    }


}
