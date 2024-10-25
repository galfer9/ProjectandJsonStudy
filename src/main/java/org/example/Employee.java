package org.example;
//직원 클래스
public class Employee {
    private long id;
    private String name;
    private String email;

    public Employee() {}  //생성자 오버로드해서 두개 만듬
    public Employee(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //get,set매소드 만들기


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
