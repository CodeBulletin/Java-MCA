package AP8;

import java.util.Scanner;

// Problem Statement
/*
Develop an employee pay generator that works on the following rules
    1. An employee gets paid (hours worked) × (base pay), for each hour up to 40 hours.
    2. For every hour over 40, they get overtime = (base pay) × 1.5.
    3. The base pay must not be less than the minimum wage ($8.00 an hour).
    4. If it is, print an error. If the number of hours is greater than 60, print an error message
*/

public class AP8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Eneter the hrsWorked and base pay: ");
        float HrsWord = sc.nextFloat();
        float BasePay = sc.nextFloat();
        try {
            Employee e1 = new Employee(HrsWord, BasePay);
            System.out.println(e1.generatePayment());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}

class Employee {
    public float hrsWorked = 0;
    public float basePay = 8.00f;

    public Employee(float hrsWorked, float basePay) throws Exception {
        if (hrsWorked > 60.0f) {
            throw new Exception("Worked more then 60hrs");
        } else if (basePay < 8.0f) {
            throw new Exception("Base pay less then minimum wage");
        }
        this.hrsWorked = hrsWorked;
        this.basePay = basePay;
    }

    public float generatePayment() {
        return Math.min(40.0f, hrsWorked) * basePay + Math.max(0.0f, hrsWorked - 40.0f) * basePay * 1.5f;
    }
}