package ru.javajoy.jps.w3;

public enum PeriodOfDay {

    //Время переведено в секунды
    MORNING(14400, 43199),
    DAY(43200, 57599),
    EVENING(57600, 79199),
    NIGHT(79200, 14399);

    public int startTime;
    private int endTime;

    PeriodOfDay(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

}
