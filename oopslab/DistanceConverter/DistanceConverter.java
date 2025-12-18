package DistanceConverter;

public class DistanceConverter {
    public double metertokm(double met){
        double km = met/1000;
        return km;
    }
    public double kmtometer(double km){
        double met = km*1000;
        return met;
    }
    public double milestokm(double mil){
        double km = mil*1.60934;
        return km;
    }
    public double kmtomiles(double km){
        double mil = km / 1.60934;
        return mil;
    }
};

