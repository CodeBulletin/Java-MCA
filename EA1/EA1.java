import java.util.HashSet;
import java.util.Set;

public class EA1 {

    static String department = "";
    static float sum = 0.0f;
    static int i = 0;

    public static void main(String[] args) {
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("E1", "IT", 10000, 20, 10, 5));
        employees.add(new Employee("E2", "HR", 12000, 25, 15, 6));
        employees.add(new Employee("E3", "IT", 11000, 22, 12, 5));
        employees.add(new Employee("E4", "HR", 13000, 26, 16, 6));
        employees.add(new Employee("E5", "IT", 10000, 20, 10, 5));


        // Sort the employees by department
        department = "";
        sum = 0.0f;
        i = 0;
        employees.stream()
            .sorted()
            .forEach(e -> {
                if (department != e.getDepartment()) {
                    if(department != "") {
                        System.out.println(
                            "Department avg: " +
                            (sum / i) + "\n"
                        );
                    }
                    department = e.getDepartment();
                    System.out.println("Department: " + e.getDepartment());
                    System.out.println(
                        "| EMPNO | BASIC\t   | HRA" +
                        "   | DA    | PF   | NET_SALARY |"
                    );
                }
                System.out.println(
                    String.format(
                        "|    %s | %.2f | %.2f |" + 
                        " %.2f | %.2f | %.2f   |",
                        e.getEmpno(), e.getBasic(), e.getHraPercent(),
                        e.getDaPercent(), e.getPfPercent(), e.getNetSalary())
                    );
                i++;
                sum += e.getNetSalary();
            });
        if(sum != 0) {
            System.out.println("Department avg: " + (sum / i));
        }
    }
}

class Employee implements Comparable<Employee> {
    private String empno;
    private String department;
    private float basic;
    private float hraPercent;
    private float daPercent;
    private float pfPercent;

    public Employee(String empno, String department, float basic,
        float hraPercent, float daPercent, float pfPercent) {
        this.empno = empno;
        this.department = department;
        this.basic = basic;
        this.hraPercent = hraPercent;
        this.daPercent = daPercent;
        this.pfPercent = pfPercent;
    }

    public String getEmpno() {
        return empno;
    }

    public String getDepartment() {
        return department;
    }

    public Float getBasic() {
        return basic;
    }

    public Float getHraPercent() {
        return hraPercent;
    }

    public Float getDaPercent() {
        return daPercent;
    }

    public Float getPfPercent() {
        return pfPercent;
    }

    public Float getNetSalary() {
        return basic + (basic * hraPercent / 100) +
            (basic * daPercent / 100) - (basic * pfPercent / 100);
    }

    @Override
    public int compareTo(Employee other) {
        return this.department.compareTo(other.department);
    }
}