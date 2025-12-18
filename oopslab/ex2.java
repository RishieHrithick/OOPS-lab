
import CurrencyConverter.CurrencyConverter;
import DistanceConverter.DistanceConverter;
import TimeConverter.TimeConverter;
import java.util.Scanner;
public class ex2 {
    public static void main(String[] args) {
        CurrencyConverter c_conv = new CurrencyConverter();
        DistanceConverter d_conv = new DistanceConverter();
        TimeConverter t_conv = new TimeConverter();
        Scanner input= new Scanner(System.in);
        System.out.println("Enter the corresponding number :");
        System.out.println("1.Currency Conversion.  2.Distance Conversion.  3.Time Conversion.");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("1.dollor to inr.   2.inr to dollor   3.euro to inr   4.inr to euro   5.yen to inr   6.inr to yen");
                int choose1=input.nextInt();
                switch (choose1) {
                    case 1:
                        System.out.println("Enter the number in dollor:");
                        double dol=input.nextInt();
                        System.out.println("Inr :"+c_conv.dollortoinr(dol));
                        break;
                    case 2:
                        System.out.println("Enter the number in inr:");
                        double inr=input.nextInt();
                        System.out.println("Dollor :"+c_conv.inrtodollor(inr));
                        break;
                    case 3:
                        System.out.println("Enter the number in euro:");
                        double euro=input.nextInt();
                        System.out.println("inr :"+c_conv.eurotoinr(euro));
                        break;
                    case 4:
                        System.out.println("Enter the number in inr:");
                        double inr1=input.nextInt();
                        System.out.println("euro :"+c_conv.inrtoeuro(inr1));
                        break;
                    case 5:
                        System.out.println("Enter the number in yen:");
                        double yen=input.nextInt();
                        System.out.println("Inr :"+c_conv.yentoinr(yen));
                        break;
                    case 6:
                        System.out.println("Enter the number in inr:");
                        double inr2=input.nextInt();
                        System.out.println("yen :"+c_conv.inrtoyen(inr2));
                        break;            
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
                break;
            case 2:
                System.out.println("1.meter to km   2.km to meter   3.miles to km   4.km to miles ");
                int choose2=input.nextInt();
                switch (choose2) {
                    case 1:
                        System.out.println("Enter the number in meter:");
                        double met=input.nextInt();
                        System.out.println("km : "+d_conv.metertokm(met));
                        break;
                    case 2:
                        System.out.println("Enter the number in km:");
                        double km=input.nextInt();
                        System.out.println("meter : "+d_conv.kmtometer(km));
                        break;
                    case 3:
                        System.out.println("Enter the number in miles:");
                        double mil=input.nextInt();
                        System.out.println("km : "+d_conv.milestokm(mil));
                        break;
                    case 4:
                        System.out.println("Enter the number in km:");
                        double km1=input.nextInt();
                        System.out.println("miles : "+d_conv.kmtomiles(km1));
                        break;           
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
                break;
            case 3:
                System.out.println("1.hours to minutes   2.minutes to hours   3.hours to seconds   4.seconds to hours");
                int choose3=input.nextInt();
                switch (choose3) {
                    case 1:
                        System.out.println("Enter the number in hours:");
                        double hour=input.nextInt();
                        System.out.println("minutes : "+t_conv.hourstominutes(hour));
                        break;
                    case 2:
                        System.out.println("Enter the number in minutes:");
                        double minu=input.nextInt();
                        System.out.println("hours : "+t_conv.minutestohours(minu));
                        break;
                    case 3:
                        System.out.println("Enter the number in hours:");
                        double hour1=input.nextInt();
                        System.out.println("seconds : "+t_conv.hourstoseconds(hour1));
                        break;
                    case 4:
                        System.out.println("Enter the number in seconds:");
                        double sec=input.nextInt();
                        System.out.println("hours : "+t_conv.secondstohours(sec));
                        break;           
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
                break;
            default:
                System.out.println("Invalid Number .");    
        }
        input.close();
    }
       
}