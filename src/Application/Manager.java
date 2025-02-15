package Application;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Manager {
    Scanner scanner= new Scanner(System.in);
    private int optionSelected;

    private int max=50;
    private double totalSalary=0;
    private int count=0;
    private String namePosition;
private int namePosiNumber;
private int selectedNew;
    Employe[] employe =new Employe[max];
    public  void options(){
        System.out.println("----Options Menu:----");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Display Employee Details");
        System.out.println("5. Find Employee By Name Or Position");
        System.out.println("6. Calculate Total Salary");
        System.out.println("7. Sort Employee By Salary");
        System.out.println("8. Exit");
optionSelected=scanner.nextInt();
    }

    public int getOptionSelected() {
        return optionSelected;
    }

    public void AddEmployee(){
    System.out.println("Enter Employee ID: ");
    int id= scanner.nextInt();
    scanner.nextLine();
        System.out.println("Enter Employee Name: ");
      String   name= scanner.nextLine();
        System.out.println("Enter Employee Position: ");
         String position= scanner.nextLine();
        System.out.println("Enter Employee Salary: ");
         Double salary= scanner.nextDouble();
        scanner.nextLine();
         if (count<employe.length){
             employe[count]=new Employe(id,name,position,salary);
             count++;
         }
         else{
             System.out.println("Cannot Add More Employees");
         }


}
public void UpdateEmployee(){
    System.out.println("List of Employees: ");
    for (int i=0;i<count;i++){
        System.out.println("Employe Number: "+(i+1));
        System.out.println(employe[i]);

    }
    System.out.println("Pick The Number Of The Employee You Want To Update: ");
    selectedNew=scanner.nextInt()-1;
    scanner.nextLine();
        System.out.println("Enter New Employee ID: ");
        int newId= scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter New Employee Name: ");
        String newName= scanner.nextLine();
        System.out.println("Enter New Employee Position: ");
        String newPosition= scanner.nextLine();
        System.out.println("Enter New Employee Salary: ");
        Double newSalary= scanner.nextDouble();
        scanner.nextLine();
        employe[selectedNew].setEmpID(newId);
        employe[selectedNew].setEmpName(newName);
        employe[selectedNew].setEmpPosition(newPosition);
        employe[selectedNew].setEmpSalary(newSalary);
    System.out.println("Employee Updated");
}
public void DeleteEmployee(){
    System.out.println("List of Employees: ");
    for (int i=0;i<count;i++){
        System.out.println("Employe Number:"+ (i + 1));
        System.out.println(employe[i]);

    }
        System.out.println("Enter Employee Number you want to Delete: ");
    selectedNew=scanner.nextInt()-1;
    scanner.nextLine();
    if(selectedNew<0|| selectedNew>count){
        System.out.println("Invalid Employee Number");
        return;
    }
    for (int i=selectedNew;i<count-1;i++){
        employe[i]=employe[i+1];
    }
    employe[count-1]=null;
    count--;
    System.out.println("Employee Deleted");
}
public void DisplayEmployees(){
        for (int i=0;i<count;i++){
//            System.out.println("Employe Number: "+i+1);
            System.out.println(employe[i]);

        }
}
public void findEmployee(){
        System.out.println("Do you want to Find Employee By Name Or Position?: ");
    System.out.println("Type 1 For Name And 2 For Position");

    namePosiNumber=scanner.nextInt();
    scanner.nextLine();
    if(namePosiNumber==1){
        System.out.println("Enter Employee Name: ");
        namePosition=scanner.nextLine();
        for (int i=0;i<count;i++){
            if (employe[i].getEmpName().equals(namePosition)){
                System.out.println(employe[i]);
            }
        }
    } else if (namePosiNumber==2) {
        System.out.println("Enter Employee Position: ");
        namePosiNumber=scanner.nextInt();
        scanner.nextLine();
        namePosition=scanner.nextLine();
        for (int i=0;i<count;i++){
            if (employe[i].getEmpPosition().equals(namePosition)){
                System.out.println(employe[i]);
            }
        }

    }else {
        System.out.println("Invalid Employee Position");
    }

}
public void CalculateSalary(){
    System.out.println(count);
    System.out.println("Total Salary Of All Employees: ");
    for (int i=0;i<count;i++){

            totalSalary+=employe[i].getEmpSalary();

        System.out.println("Total Salary: "+totalSalary);
    }
}
    public void sortEmployees() {
        // Ask the user for their choice of sorting order
        System.out.println("Choose sorting order:");
        System.out.println("1. Ascending Order (Lowest to Highest Salary)");
        System.out.println("2. Descending Order (Highest to Lowest Salary)");

        int choice = scanner.nextInt();
        scanner.nextLine();

        boolean ordreCroissant = false;

        // Set ordreCroissant based on user's choice
        if (choice == 1) {
            ordreCroissant = true;  // Ascending
        } else if (choice == 2) {
            ordreCroissant = false;  // Descending
        } else {
            System.out.println("Invalid choice. Sorting in ascending order by default.");
            ordreCroissant = true;  // Default to ascending if input is invalid
        }

        // Comparator to sort by salary
        boolean finalOrdreCroissant = ordreCroissant;
        Comparator<Employe> salaryComparator = new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                // Sorting based on ordreCroissant
                if (finalOrdreCroissant) {
                    return Double.compare(e1.getEmpSalary(), e2.getEmpSalary());
                } else {
                    return Double.compare(e2.getEmpSalary(), e1.getEmpSalary());
                }
            }
        };

        // Sort the array of employees
        Arrays.sort(employe, 0, count, salaryComparator);

        // Display sorted employees
        System.out.println("Employees sorted by salary (" + (ordreCroissant ? "ascending" : "descending") + "):");
        for (int i = 0; i < count; i++) {
            System.out.println("Employee " + (i + 1) + ": " + employe[i].getEmpName() + ", Salary: " + employe[i].getEmpSalary());
        }
    }
}
