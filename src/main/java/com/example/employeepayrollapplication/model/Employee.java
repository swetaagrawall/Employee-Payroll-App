package com.example.employeepayrollapplication.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//Auto-generated ID

    private String name;
    private Double salary;
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "department")
    private List<String> department;

    public Employee(String name, Double salary, String gender, LocalDate startDate, String note, String profilePic, List<String> department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.department = department;
    }
}