package CurrencyConverter;

public class CurrencyConverter {
    public double dollortoinr(double dol){
        double inr = dol*85.74;
        return inr;
    }
    public double inrtodollor(double inr){
        double dol = inr/85.74;
        return dol;
    }
    public double eurotoinr(double eur){
        double inr = eur * 98.05;
        return inr;
    }
    public double inrtoeuro(double inr){
        double eur = inr / 98.05;
        return eur;
    }
    public double yentoinr(double yen){
        double inr = yen*0.5788;
        return inr;
    }
    public double inrtoyen(double inr){
        double yen = inr / 0.5788;
        return yen;
    }
}
