
/**
 *
 * Description: Class that represents a point in time in terms of 24H format.
 *
 * @author Brent Garcia
 *
 * @version 1.0
 *
 */
public class Time {

    private int hour;
    private int min;

    public Time() {
        hour = 00;
        min = 00;
    }

    public Time(int initHour, int initMin) {
        hour = initHour;
        min = initMin;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return min;
    }

    public void addHours(int mHour) {
        hour += mHour;
    }

    public void addMinutes(int mMin) {
        min += mMin;
        if (min >= 60) {
            addHours(min / 60);
            min = (min % 60);
        }

    }

    public void addTime(Time mTime) {
        hour += mTime.getHour();
        min += mTime.getMinute();
        if (min >= 60) {
            this.addHours(min / 60);
            min = (min % 60);
        }
    }

    public Time getCopy() {

        Time copy = new Time(this.getHour(), this.getMinute());
        return copy;
    }

    public boolean isEarlierThan(Time time) {
        if (this.getHour() <= time.getHour()) {
            return true;
        } else if (this.getHour() <= time.getHour()) {
            if (this.getMinute() <= time.getMinute()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isSameTime(Time time) {
        if (this.getHour() == time.getHour()) {
            if (this.getMinute() == time.getMinute()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isLaterThan(Time time) {
        if (this.getHour() > time.getHour()) {
            return true;
        } else if (this.getHour() >= time.getHour()) {
            if (this.getMinute() > time.getMinute()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String amOrPm = "AM";
        int h;
        String m = String.format("%02d", min);
        String s;
        if (hour >= 12) {
            amOrPm = "PM";
            if (hour == 12) {
                h = 12;
                s = h + ":" + m + amOrPm;
            } else {
                h = hour - 12;
                s = h + ":" + m + amOrPm;
            }
        } else if (hour == 0) {
            h = 12;
            s = h + ":" + m + amOrPm;
        } else {
            h = hour;
            s = h + ":" + m + amOrPm;
        }
        return s;
    }

}
