package JSS.w10.rs.bookstore.resources;

import JSS.w10.rs.bookstore.vo.Book;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Cyril Kadomsky
 */
@Provider
@Produces("text/html")
public class BookHtmlProvider implements MessageBodyWriter<Book> {
    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Book book, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo( Book book,
                         Class<?> aClass, Type type, Annotation[] annotations,
                         MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap,
                         OutputStream outputStream ) throws IOException, WebApplicationException {

        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("<html> <h2> Book </h2> <br> <font face='courier new' color='gray'> " +
                "<b>Name</b> = " + book.getName() + "<br>" +
                "<b>Author</b> = " + book.getAuthor() + "<br>" +
                " </font></html>");
        writer.close();

    }
}
