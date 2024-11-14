import java.util.ArrayList;
import java.util.List;

abstract class OrganizationComponent {
    public String Name;
    public double Salary;

    public abstract void Add(OrganizationComponent component);
    public abstract void Remove(OrganizationComponent component);

    public String getName() {
        return Name;
    }

    public double getSalary() {
        return Salary;
    }

    public void DisplayInfo() {
        System.out.println("Name: " + Name + ", Salary: " + Salary);
    }
}

class Employee extends OrganizationComponent {

    public Employee(String name, double salary) {
        this.Name = name;
        this.Salary = salary;
    }

    @Override
    public void Add(OrganizationComponent component) {
    }

    @Override
    public void Remove(OrganizationComponent component) {

    }

    @Override
    public void DisplayInfo() {
        System.out.println("Employee: " + Name + ", Salary: " + Salary);
    }
}

class OrgElement extends OrganizationComponent {

    private List<OrganizationComponent> components;

    public OrgElement(String name) {
        this.Name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public void Add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void Remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public void DisplayInfo() {
        System.out.println("Organization Element: " + Name);
        for (OrganizationComponent component : components) {
            component.DisplayInfo();
        }
    }
}

public class Main_2 {
    public static void main(String[] args) {
        OrgElement organization = new OrgElement("RBK Bank");

        OrgElement department = new OrgElement("Accounting Department");
        department.Add(new Employee("Alice", 50000));
        department.Add(new Employee("Bob", 45000));

        OrgElement hrDepartment = new OrgElement("HR Department");
        hrDepartment.Add(new Employee("Charlie", 55000));

        organization.Add(department);
        organization.Add(hrDepartment);
        organization.DisplayInfo();
    }
}
