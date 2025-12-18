package employee;

import java.io.FileWriter;
import java.io.IOException;

public class AssociateProfessor extends Employee {
    double bpay;
    String des;

    public AssociateProfessor(String name, int id, String address, String mail, int phone, double bPay) {
        super(name, id, address, mail, phone);
        this.bpay = bPay;
        this.des = "Associate Professor";
    }

    @Override
    public void paySlip(FileWriter log) throws IOException{
        double da = 0.97 * bpay;
        double hra = 0.10 * bpay;
        double pf = 0.12 * bpay;
        double club = 0.001 * bpay;
        double gross = bpay + da + hra;
        double net = gross - pf - club;

        System.out.println("Designation : " + des);
        log.write("Designation : " + des + "\n");

        System.out.println("Basic Pay   : " + bpay);
        log.write("Basic Pay   : " + bpay + "\n");

        System.out.println("Gross Pay   : " + gross);
        log.write("Gross Pay   : " + gross + "\n");

        System.out.println("Net Pay     : " + net);
        log.write("Net Pay     : " + net + "\n");
    }
}