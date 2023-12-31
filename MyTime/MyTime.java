package Lab6.MyTime;

public class MyTime {
    private int hour, minute, second;

    public MyTime(int hour, int minute, int second) {
        this.setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        try {
            if ((hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59)
                    && (second >= 0 && second <= 59)) {
                this.hour = hour;
                this.minute = minute;
                this.second = second;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid hour, minute, or second!");
        }
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toString() {
        String min = Integer.toString(this.getMinute());
        String sec = Integer.toString(this.getSecond());
        String hr = Integer.toString(this.getHour());
        if (this.getMinute() < 10) {
            min = "0" + Integer.toString(this.getMinute());
        }
        if (this.getSecond() < 10) {
            sec = "0" + Integer.toString(this.getSecond());
        }
        if (this.getHour() < 10) {
            hr = "0" + Integer.toString(this.getHour());
        }
        return (hr + ":" + min + ":" + sec);
    }

    public MyTime nextSecond() {
        if (this.getSecond() != 59) {
            this.setSecond(this.getSecond() + 1);
        } else {
            this.setSecond(0);
            if (this.getMinute() != 59) {
                this.setMinute(this.getMinute() + 1);
            } else {
                this.setMinute(0);
                if (this.getHour() != 23) {
                    this.setHour(this.getHour() + 1);
                } else {
                    this.setHour(0);
                }
            }
        }
        return this;
    }

    public MyTime nextMinute() {
        if (this.getMinute() != 59) {
            this.setMinute(this.getMinute() + 1);
        } else {
            this.setMinute(0);
            if (this.getHour() != 23) {
                this.setHour(this.getHour() + 1);
            } else {
                this.setHour(0);
            }
        }
        return this;
    }

    public MyTime nextHour() {
        if (this.getHour() != 23) {
            this.setHour(this.getHour() + 1);
        } else {
            this.setHour(0);
        }
        return this;
    }

    public MyTime previousSecond() {
        if (this.getSecond() != 0) {
            this.setSecond(this.getSecond() - 1);
            return this;
        } else {
            this.setSecond(59);
            if (this.getMinute() != 0) {
                this.setMinute(this.getMinute() - 1);
                return this;
            } else {
                this.setMinute(59);
                if (this.getHour() != 0) {
                    this.setHour(this.getHour() - 1);
                    return this;
                } else {
                    this.setHour(23);
                }
            }
        }
        return this;
    }

    public MyTime previousMinute() {
        if (this.getMinute() != 0) {
            this.setMinute(this.getMinute() - 1);
        } else {
            this.setMinute(59);
            if (this.getHour() != 0) {
                this.setHour(this.getHour() - 1);
            } else {
                this.setHour(23);
            }
        }
        return this;
    }

    public MyTime previousHour() {
        if (this.getHour() != 0) {
            this.setHour(this.getHour() - 1);
        } else {
            this.setHour(23);
        }
        return this;
    }
}