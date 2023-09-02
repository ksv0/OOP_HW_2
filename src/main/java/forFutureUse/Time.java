package forFutureUse;


public class Time {
    private static Integer hour;
    private static Integer minute;
    private static Period period;

    public Time(Integer hour, Integer minute) throws Exception {
        setHour(hour);
        setMinute(minute);
    }

    public Time(Integer hour) throws Exception {
        this(hour, 0);
    }

    public Time() throws Exception {
        this(0);
    }

    private static void setHour(Integer hour) throws Exception {
        if (hour >= 0 && hour < 24) {
            Time.hour = hour;
            setPeriod();
        } else {
            throw new Exception("параметр час(hour) должен находится в  пределах [0..24)");
        }
    }

    private static void setMinute(Integer minute) throws Exception {
        if (minute >= 0 && minute < 60) {
            Time.minute = minute;
        } else {
            throw new Exception("параметр минута(minute) должен находится в  пределах [0..60)");
        }
    }

    public void changeTime(Integer minute) throws Exception {
        if (minute >= 0) {
            int temp = this.hour * 60 + this.minute + minute;
            if (temp > 1440) {
                temp %= 1440;
            }
            setHour(temp / 60);
            setMinute(temp % 60);
        } else {
            throw new Exception("в отсутствии машины времени мы можем двигаться только вперед, параметр minute должен быть >= 0");
        }
    }

    private static void setPeriod() throws Exception {
        switch (hour) {
            case 0, 1, 2, 3, 4, 5, 6, 22, 23 -> {
                period = Period.NIGHT;
            }
            case 7, 8, 9, 10, 11 -> {
                period = Period.MORNING;
            }
            case 12 -> {
                period = Period.NOON;
            }
            case 13, 14, 15, 16, 17, 18, 19, 20, 21 -> {
                period = Period.AFTERNOON;
            }
            default -> {
                throw new Exception("параметр час(hour) не задан либо находится вне диапазона [0..24)");
            }
        }
    }


    static enum Period {
        NIGHT, MORNING, NOON, AFTERNOON;
    }
}
