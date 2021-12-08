package entities;

import java.time.LocalDate;

/**
 * Class which is describing an entity Human
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Department
 */
public class Human {

    private int ID;
    private String name;
    private String gender;
    private Department department;
    private int salary;
    private String birthday;

    /** Default constructor for an object of the Human class */
    public Human() {
        this.ID = 0;
        this.name = "";
        this.gender = "";
        this.department = null;
        this.salary = 0;
        this.birthday = null;
    }

    /** Constructor with parameters for an object of the Human class */
    public Human(int ID, String name, String gender, Department department, int salary, String birthday) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthday = birthday;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ID: " + this.getID() +
                "\nИмя: " + this.getName() +
                "\nПол: " + this.getGender() +
                "\nЗарплата: " + this.getSalary() +
                "\nДата рождения: " + this.getBirthday();
    }
}
