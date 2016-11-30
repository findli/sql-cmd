package ru.javajoy.jps.w3;

public class ChildTime extends Time {

    public ChildTime(int hour, int minute, int second) {
        super(hour, minute, second);
    }

    //Печать времени в текстовом виде
    @Override
    public String toString() {
        return numbCheck(getHour()) + " часов: "
                + numbCheck(getMinute()) + " минут: "
                + numbCheck(getSecond()) + " секунд";
    }

    //Определение времени суток
    public String timeOfDay() {

        String timeOfDay;

        if ((secondTotal() >= SECOND_IN_22H && secondTotal() <= SECOND_IN_24H - 1) || (secondTotal() >= SECOND_IN_0H && secondTotal() <= SECOND_IN_4H - 1))
            timeOfDay = "Ночь";
        else if (secondTotal() >= SECOND_IN_4H && secondTotal() <= SECOND_IN_12H - 1)
            timeOfDay = "Утро";
        else if (secondTotal() >= SECOND_IN_12H && secondTotal() <= SECOND_IN_16H - 1)
            timeOfDay = "День";
        else if (secondTotal() >= SECOND_IN_16H && secondTotal() <= SECOND_IN_24H - 1)
            timeOfDay = "Вечер";
        else timeOfDay = "Такого времени суток несуществует";

        return timeOfDay;

    }

}
