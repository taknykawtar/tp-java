package Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();


do {

manager.options();

switch (manager.getOptionSelected()){
    case 1: manager.AddEmployee();
    break;
    case 2: manager.UpdateEmployee();
    break;
    case 3: manager.DeleteEmployee();
    break;
    case 4: manager.DisplayEmployees();
    break;
    case 5: manager.findEmployee();
    break;
    case 6: manager.CalculateSalary();
    break;
case 7: manager.sortEmployees();
break;
case 8:
    System.out.println("Exit");
    break;
}

}
while ( manager.getOptionSelected() != 8);
    }
}