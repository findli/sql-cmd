package JSS.w10.rs.bookstore;

import JSS.w10.rs.bookstore.dao.BookDAO;
import JSS.w10.rs.bookstore.vo.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Path("/book")
public class BookResource {

    // Request - content negtiating
    // SecurityContext - пользователь, группа, роли, использование https
    @GET
    @Path("/uri")
    @Produces(MediaType.TEXT_HTML)
    @Consumes("*/*")
    public Response uriInfo(@Context UriInfo uriInfo) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters();
        for (List<String> queryParam :
                queryParams.values()) {
            // todo impl
        }
        System.out.println(queryParams);
        System.out.println(pathParams);

        return Response.ok(queryParams).build();
    }

    @GET
    @Path("/httpHeaders")
    @Produces(MediaType.TEXT_HTML)
    @Consumes("*/*")
    public Response ttpHeadersInfo(@Context HttpHeaders headers) {
        MultivaluedMap<String, String> queryParams = headers.getRequestHeaders();
        Map<String, Cookie> pathParams = headers.getCookies();

        System.out.println(queryParams);
        System.out.println(pathParams);

        return Response.ok().build();
    }

    @GET
    @Path("/get/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    // "text/html" from BookHtmlProvider
    @Consumes("*/*")
    public Response getBook(@PathParam("id") long id) {
        Book book = null;

        try {
            book = BookDAO.getInstance().get(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_HTML)
                    .entity(String.format("<h2>Book not found</h2><br/> id=%d", id)).build();
        } else {
            return Response.ok(book).expires(new Date(System.currentTimeMillis() + 3000)).build();
        }
    }

    @POST
    @Path("/add")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // + "text/html"
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response addBook(@FormParam("name") String name, @FormParam("author") String author) {
        Book book = null;
        try {
            if (name == null || name.isEmpty() || author == null || author.isEmpty()) {
                throw new IllegalAccessException();
            }

            book = new Book(name, author);
            BookDAO.getInstance().add(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (book == null || book.getId() <= 0) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_HTML)
                    .entity(String.format("<h2>Book not created</h2><br/>")).build();
        } else {
            return Response.created(URI.create("book/" + book.getId())).build();
        }
    }

    @PUT
    @Path("/{id}/edit")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // + "text/html"
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateBook(@FormParam("id") long id, @FormParam("name") String name, @FormParam("author") String author) {
        Book book = null;
        try {
            if (id <= 0 || name == null || name.isEmpty() || author == null || author.isEmpty()) {
                throw new IllegalAccessException();
            }

            book = new Book(id, name, author);
            BookDAO.getInstance().update(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (book == null || book.getId() <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.TEXT_HTML)
                    .entity(String.format("<h2>Book not updated</h2><br/>")).build();
        } else {
            return Response.ok(book).build();
        }
    }

    @DELETE
    @Path("/{id}/delete")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // + "text/html"
    @Consumes("*/*")
    public Response deleteBook(@FormParam("id") long id) {
        boolean success = false;
        try {
            if (id <= 0) {
                throw new IllegalAccessException();
            }

            BookDAO.getInstance().remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!success) {
            return Response.notModified().build();
        } else {
            return Response.ok().entity("Delete successfully").build();
        }
    }
}
