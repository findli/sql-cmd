package JSS.w09_p01;

import JSS.w09_p01.currency.Currency;
import JSS.w09_p01.currency.CurrencyConvertor;
import JSS.w09_p01.currency.CurrencyConvertorSoap;

/**
 * @author Cyril Kadomsky
 */
public class CurrencyConverterSE {

    public static void main(String[] args) {
        CurrencyConvertorSoap converter = new CurrencyConvertor().getCurrencyConvertorSoap();
        double rate = converter.conversionRate(Currency.USD, Currency.UAH);
        System.out.println("rate = " + rate);
    }

}
