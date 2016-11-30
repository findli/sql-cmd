<%--
  Created by IntelliJ IDEA.
  User: Cyrill
  Date: 19.12.2015
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weather</title>
</head>
<body>

    <jsp:useBean id="weatherBean" class="JSS.w09_p02.WeatherBean"/>
    <jsp:setProperty name="weatherBean" property="zipCode" value="90001"/>
    City for ${weatherBean.zipCode} is ${weatherBean.weather.city} <br>
    Weather : <br>
    ${weatherBean.getWeatherInfo(weatherBean.weather.weatherID).description} <br>
    Temperature = <jsp:getProperty name="weatherBean" property="weatherTemperature"/> <br>
    Pressure = ${weatherBean.weather.pressure}


</body>
</html>
