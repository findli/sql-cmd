package JSS.w09_p02;

import JSS.w09_p02.weather.Weather;
import JSS.w09_p02.weather.WeatherDescription;
import JSS.w09_p02.weather.WeatherReturn;
import JSS.w09_p02.weather.WeatherSoap;

import java.util.List;

/**
 * @author Cyril Kadomsky
 */
public class WeatherClient {

    public static void main(String[] args) {
        WeatherSoap port = new Weather().getWeatherSoap();
        List<WeatherDescription> winfo = port.getWeatherInformation().getWeatherDescription();
        WeatherReturn result = port.getCityWeatherByZIP("90001");

        int weatherID = result.getWeatherID();
        WeatherDescription descr = null;

        for (WeatherDescription item : winfo) {
            if (item.getWeatherID() == weatherID) {
                descr = item;
            }
        }


        System.out.println(result.getCity());
        System.out.println(descr.getDescription() + " : " + descr.getPictureURL());
        System.out.println("Temperature : " + result.getTemperature());
        System.out.println("Pressure : " + result.getPressure());




    }
}
