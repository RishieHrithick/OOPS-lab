import employee.*;
import java.io.*;
import java.util.*;

public class ex3 {
    public static void main(String[] args) {
        try {
            FileWriter log = new FileWriter("log3.txt", true);
            Scanner sc = new Scanner(System.in);
            ArrayList<Employee> empList = new ArrayList<>();

            
            System.out.println("Enter number of employees:");
            log.write("Enter number of employees:\n");
            int n = Integer.parseInt(sc.nextLine());
            log.write(n + "\n");

            for (int i = 0; i < n; i++) {
                
                System.out.println("\nEnter Employee Type (1: Programmer, 2: Assistant Prof, 3: Associate Prof, 4: Professor):");
                log.write("\nEnter Employee Type (1: Programmer, 2: Assistant Prof, 3: Associate Prof, 4: Professor):\n");
                int type = Integer.parseInt(sc.nextLine());
                log.write(type + "\n");

               
                System.out.println("Enter Name:");
                log.write("Enter Name:\n");
                String name = sc.nextLine();
                log.write(name + "\n");

              
                System.out.println("Enter ID:");
                log.write("Enter ID:\n");
                int id = Integer.parseInt(sc.nextLine());
                log.write(id + "\n");

               
                System.out.println("Enter Address:");
                log.write("Enter Address:\n");
                String address = sc.nextLine();
                log.write(address + "\n");

                
                System.out.println("Enter Mail ID:");
                log.write("Enter Mail ID:\n");
                String mail = sc.nextLine();
                log.write(mail + "\n");


                System.out.println("Enter Mobile No:");
                log.write("Enter Mobile No:\n");
                int phone = Integer.parseInt(sc.nextLine());
                log.write(phone + "\n");

              
                System.out.println("Enter Basic Pay:");
                log.write("Enter Basic Pay:\n");
                double bpay = Double.parseDouble(sc.nextLine());
                log.write(bpay + "\n");

               
                switch (type) {
                    case 1:
                        empList.add(new Programmer(name, id, address, mail, phone, bpay));
                        break;
                    case 2:
                        empList.add(new AssistantProfessor(name, id, address, mail, phone, bpay));
                        break;
                    case 3:
                        empList.add(new AssociateProfessor(name, id, address, mail, phone, bpay));
                        break;
                    case 4:
                        empList.add(new Professor(name, id, address, mail, phone, bpay));
                        break;
                    default:
                        System.out.println("Invalid Employee Type");
                        log.write("Invalid Employee Type\n");
                        break;
                }
            }

            for (Employee emp : empList) {
                emp.display(log);
                emp.paySlip(log);
            }

            log.close();
            sc.close();
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
