public class Clock {
    private int hour;
    private int minute;
    private int second;

    public Clock(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public void setClock(int hour, int minute, int second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        while(second >= 60){
            if(second >= 120){
                minute++;
                second = second - 60;
            }else{
                second = second%60;
                minute++;
            }
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        while(minute >= 60){
            if(minute >= 120){
                hour++;
                minute = minute - 60;
            }else{
                minute = minute%60;
                hour++;
            }
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        if(hour >= 24){
            hour = hour%24;
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
        if(hour > 23 && minute > 59 && second > 59){
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
    }
    public int getHour(){return hour;}
    public int getMin(){return minute;}
    public int getSec(){return second;}
}
