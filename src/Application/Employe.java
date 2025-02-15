package Application;

public class Employe {
    private int empID;
    private String empName;
    private String empPosition;
    private Double empSalary;


    public Employe() {
        this.empID = 0;
        this.empName = "Unknown";
        this.empPosition = "Unassigned";
        this.empSalary = 0.0;
    }

    public Employe(int empID, String empName, String empPosition, Double empSalary) {
        this.empID = empID ;
        this.empName = empName;
        this.empPosition = empPosition;
        this.empSalary = empSalary;
    }

    public int getEmpID() {
        return empID;
    }


    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }
    @Override
    public String toString() {
        return "Employe{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                ", empSalary=" + empSalary +
                '}';
    }

}
