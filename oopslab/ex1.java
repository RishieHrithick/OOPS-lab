import java.io.FileOutputStream; 
import java.io.PrintStream;
import java.util.Scanner;

public class ex1 {
    public static class electricitybill {
        int c_no;
        String c_name;
        int p_monthreading;
        int c_monthreading;
        String type_eb;
        double bill_amount;
        int units;
        PrintStream console = System.out;  

        public void input() {
            Scanner inp = new Scanner(System.in);

            while (true) {
                console.println("Enter the consumer number:");
                if (inp.hasNextInt()) {
                    c_no = inp.nextInt();
                    System.out.println("Consumer Number: " + c_no);
                    if (c_no >= 0) break;
                    else console.println("Consumer number cannot be negative.");
                } else {
                    console.println("Invalid input. Please enter a number.");
                    inp.next();
                }
            }
            inp.nextLine();

            console.println("Enter the consumer name:");
            c_name = inp.nextLine();
            System.out.println("Consumer Name: " + c_name);

            while (true) {
                console.println("Enter the previous month reading:");
                if (inp.hasNextInt()) {
                    p_monthreading = inp.nextInt();
                    System.out.println("Previous Reading: " + p_monthreading);
                    if (p_monthreading >= 0) break;
                    else console.println("Previous reading cannot be negative.");
                } else {
                    console.println("Invalid input. Please enter a number.");
                    inp.next();
                }
            }

            while (true) {
                console.println("Enter the current month reading:");
                if (inp.hasNextInt()) {
                    c_monthreading = inp.nextInt();
                    System.out.println("Current Reading: " + c_monthreading);
                    if (c_monthreading >= 0) {
                        if (c_monthreading >= p_monthreading) break;
                        else console.println("Current reading must be greater than or equal to previous reading.");
                    } else console.println("Current reading cannot be negative.");
                } else {
                    console.println("Invalid input. Please enter a number.");
                    inp.next();
                }
            }
            inp.nextLine();

            while (true) {
                console.println("Enter the type of EB connection:");
                type_eb = inp.nextLine();
                System.out.println("EB Type: " + type_eb);
                if (type_eb != null && !type_eb.trim().isEmpty()) break;
                else console.println("EB Connection type cannot be empty.");
            }

            units = c_monthreading - p_monthreading;
            inp.close();
        }

        public void billing() {
            if (type_eb.equalsIgnoreCase("domestic")) {
                if (units <= 100) {
                    bill_amount = units;
                } else if (units <= 200) {
                    bill_amount = 100 + ((units - 100) * 2.5);
                } else if (units < 500) {
                    bill_amount = 100 + (100 * 2.5) + ((units - 200) * 4);
                } else {
                    bill_amount = 100 + (100 * 2.5) + (300 * 4) + ((units - 500) * 6);
                }
            } else if (type_eb.equalsIgnoreCase("commercial")) {
                if (units <= 100) {
                    bill_amount = units * 2;
                } else if (units <= 200) {
                    bill_amount = 200 + ((units - 100) * 4.5);
                } else if (units < 500) {
                    bill_amount = 200 + (100 * 4.5) + ((units - 200) * 6);
                } else {
                    bill_amount = 200 + (100 * 4.5) + (300 * 6) + ((units - 500) * 7);
                }
            } else {
                System.out.println("Unknown EB connection type. No bill calculated.");
            }
        }

        public void display() {
            billing();
            System.out.println(""); 
            System.out.println("The electricity bill for the month is " + bill_amount + ".");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            PrintStream logStream = new PrintStream(new FileOutputStream("log.txt", true));
            System.setOut(logStream);   
            System.setErr(logStream);

            electricitybill eb = new electricitybill();
            eb.input();     
            eb.display();   

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}



