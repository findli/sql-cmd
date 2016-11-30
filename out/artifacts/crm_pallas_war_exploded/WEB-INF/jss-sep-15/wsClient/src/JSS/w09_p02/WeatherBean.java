package JSS.w09_p02;

import JSS.w09_p02.weather.Weather;
import JSS.w09_p02.weather.WeatherDescription;
import JSS.w09_p02.weather.WeatherReturn;
import JSS.w09_p02.weather.WeatherSoap;

import java.util.List;

/**
 * @author Cyril Kadomsky
 */
public class WeatherBean {

    WeatherSoap port = null;
    List<WeatherDescription> winfo = null;
    String zipCode = "";



    public WeatherBean() {
        port = new Weather().getWeatherSoap();
        winfo = port.getWeatherInformation().getWeatherDescription();
    }

    public WeatherDescription getWeatherInfo(int id) {
        WeatherDescription descr = null;
        for (WeatherDescription item : winfo) {
            if (item.getWeatherID() == id) {
                descr = item;
            }
        }
        return descr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public WeatherReturn getWeather() {
        return port.getCityWeatherByZIP(zipCode);
    }

    public String getWeatherTemperature() {
        return port.getCityWeatherByZIP(zipCode).getTemperature();
    }

}

