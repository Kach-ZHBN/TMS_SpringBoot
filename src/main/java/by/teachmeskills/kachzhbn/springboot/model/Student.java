package by.teachmeskills.kachzhbn.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "courseIsPaid")
    private boolean courseIsPaid;

    @Column(name = "universityGroup")
    private String universityGroup;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCourseIsPaid() {
        return courseIsPaid;
    }

    public void setCourseIsPaid(boolean courseIsPaid) {
        this.courseIsPaid = courseIsPaid;
    }

    public String getUniversityGroup() {
        return universityGroup;
    }

    public void setUniversityGroup(String universityGroup) {
        this.universityGroup = universityGroup;
    }
}
