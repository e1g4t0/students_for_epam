package Models;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String group;
    private int year;

    public Student(String name, String surname, String group, int year) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.year = year;
    }

    public Student(int id, String name, String surname, String group, int year) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "{" +
                " \"id\" : " + id +
                ", \"name\" : \"" + name + '"' +
                ", \"surname\" :\"" + surname + '"' +
                ", \"group\" : \"" + group + '"' +
                ", \"year\" :" + year +
                '}';
    }
}
