package JSS.w09_p01;

import JSS.w09_p01.currency.Currency;
import JSS.w09_p01.currency.CurrencyConvertor;
import JSS.w09_p01.currency.CurrencyConvertorSoap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cyril Kadomsky
 */
@WebServlet(name = "CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrencyConvertorSoap port = new CurrencyConvertor().getCurrencyConvertorSoap();
        double rate = port.conversionRate(Currency.USD,Currency.GBP);
        response.getWriter().format("USD to UAH is %f",rate);

    }
}
