package ru.javajoy.jps.w3;

public class Time implements Cloneable {

    ////Время переведено в секунды
    public static final int SECOND_IN_0H = 0;
    public static final int SECOND_IN_4H = 14400;
    public static final int SECOND_IN_12H = 43200;
    public static final int SECOND_IN_16H = 57600;
    public static final int SECOND_IN_22H = 79200;
    public static final int SECOND_IN_24H = 86400;
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //Следующие 3 метода обозначания времени
    private static String numb(int dig) {
        switch (dig) {
            case 0:
                return "ноль";
            case 1:
                return "один";
            case 2:
                return "два";
            case 3:
                return "три";
            case 4:
                return "четыре";
            case 5:
                return "пять";
            case 6:
                return "шесть";
            case 7:
                return "семь";
            case 8:
                return "восемь";
            case 9:
                return "девять";
            default:
                return null;
        }
    }

    private String wordTwentyToSixty(int dig) {

        switch (dig) {
            case 2:
                return "двадцать ";
            case 3:
                return "тридцать ";
            case 4:
                return "сорок ";
            case 5:
                return "пятьдесят ";
            case 6:
                return "шестьдесят ";
            default:
                return null;

        }
    }

    private String wordTenToNineteen(int dig) {

        switch (dig) {
            case 10:
                return "десять ";
            case 11:
                return "одинадцать ";
            case 12:
                return "двенадцать ";
            case 13:
                return "тринадцать ";
            case 14:
                return "четырнадцать ";
            case 15:
                return "пятнадцать ";
            case 16:
                return "шестнадцать ";
            case 17:
                return "семнадцать";
            case 18:
                return "восемнадцать";
            case 19:
                return "девятнадцать";
            default:
                return null;

        }
    }

    //Метод подбора значений для текстового вида
    protected String numbCheck(int digital) {

        if (digital < 10) {
            return numb(digital);
        }
        if (digital > 9 && digital < 20) {
            return wordTenToNineteen(digital);
        }
        return wordTwentyToSixty(digital / 10) + numb(digital % 10);

    }

    //Печать времени
    @Override
    public String toString() {
        return hour + ":"
                + minute + ":"
                + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Time)) {
            return false;
        }
        Time nTime = (Time) obj;
        return (secondTotal() == nTime.secondTotal());

    }

    //Метод клонирования объекта
    public Time clone() throws CloneNotSupportedException {
        return (Time) super.clone();

    }

    //Перевод времение в секунды
    public int secondTotal() {
        return hour * 3600 + minute * 60 + second;

    }

    //Расчет времени в секундах между переменными
    public int differenceOfTime(Time t) {

        int dif = 0;
        if (this.secondTotal() > t.secondTotal()) {
            dif = this.secondTotal() - t.secondTotal();
        } else if (this.secondTotal() < t.secondTotal()) {
            dif = Math.abs(this.secondTotal() - t.secondTotal());
        }
        return dif;

    }

    //Метод определения времени суток для перечисления
    public PeriodOfDay whichPeriod(Time t) {

        for (PeriodOfDay periodOfDay : PeriodOfDay.values()) {
            int startTime = periodOfDay.getStartTime();
            int endTime = periodOfDay.getEndTime();
            if (this.secondTotal() >= startTime && this.secondTotal() <= endTime) {
                return periodOfDay;
            }
        }
        return null;

    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
