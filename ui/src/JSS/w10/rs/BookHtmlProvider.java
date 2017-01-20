package JSS.w10.rs;

import JSS.w10.rs.bookstore.vo.Book;

import javax.ws.rs.Consumes;
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

@Provider
@Produces(MediaType.TEXT_HTML)
@Consumes(MediaType.TEXT_HTML)
public class BookHtmlProvider implements MessageBodyWriter<Book> {
    @Override
    public void writeTo(Book book, Class aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("<html><h2>Book</h2>br" +
                "Name = " + book.getName() + "<br>" +
                "Author = " + book.getAuthor() + "</html>");
        writer.close();
    }

    @Override
    public boolean isWriteable(Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        if (mediaType.equals(MediaType.TEXT_HTML)) {
            return true;
        }
        return false;
    }

    @Override
    public long getSize(Book book, Class aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}
