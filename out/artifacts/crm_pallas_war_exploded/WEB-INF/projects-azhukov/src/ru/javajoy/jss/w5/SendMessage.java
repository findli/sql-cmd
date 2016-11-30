package ru.javajoy.jss.w5;

/**
 * 1. Напишите сервлет, который отображает календарь на месяц  в виде таблицы с выделенными праздниками и выходными.
 * Год и месяц передавайте в сервлет с помощью параметров GET-запроса. Считать, что список праздников от года не зависит, и задан константно.
 * 2.  Добавьте в сервлет счетчик посещений
 *
 * @author Artem Zhukov
 * */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SendMessage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = new PrintWriter(resp.getWriter());

        out.println(
                "<html>" +
                        "<head>" +
                        "<title>Send Message</title>" +
                        "</head>" +
                        "<body bgcolor='#aabbff'> " +
                        "<form name=Form1 method=POST action=http://localhost:8080/jss/calendar>" +
                        "Enter date (mm-yyyy):    " +
                        "<input type=text name=userData><p>" +
                        "<input type=submit value=\"Send\">" +
                        "</form>" +
                        "</body>" +
                        "</html>"
        );
        out.close();
    }
}
