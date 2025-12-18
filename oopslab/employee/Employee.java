package employee;
import java.io.*;
public class Employee{
    String Emp_name;
    int Emp_id;
    String Address;
    String Mail_id;
    int Mobile_no;

    public Employee(String Emp_name, int Emp_id, String Address, String Mail_id, int Mobile_no) {
        this.Emp_name = Emp_name;
        this.Emp_id = Emp_id;
        this.Address = Address;
        this.Mail_id = Mail_id;
        this.Mobile_no = Mobile_no;
    }

    public void display(FileWriter log) throws IOException{
        System.out.println("Employee ID: " + Emp_id);
       log.write("Employee ID: " + Emp_id + "\n");

       System.out.println("Name       : " + Emp_name);
       log.write("Name       : " + Emp_name + "\n");

       System.out.println("Address    : " + Address);
       log.write("Address    : " + Address + "\n");

       System.out.println("Email      : " + Mail_id);
       log.write("Email      : " + Mail_id + "\n");

       System.out.println("Mobile No. : " + Mobile_no);
       log.write("Mobile No. : " + Mobile_no + "\n");

    }
    
    public void paySlip(FileWriter log) throws IOException{
        System.out.println("no data");
    }
    
    
}







