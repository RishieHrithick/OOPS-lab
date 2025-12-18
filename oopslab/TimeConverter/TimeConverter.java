package TimeConverter;

public class TimeConverter {
    public double hourstominutes(double hour){
        double minu = hour*60;
        return minu;
    }
    public double minutestohours(double minu){
        double hour = minu/60;
        return hour;
    }
    public double hourstoseconds(double hour){
        double sec = hour*60*60;
        return sec;
    }
    public double secondstohours(double sec){
        double hour = sec/60/60;
        return hour;
    }
};

