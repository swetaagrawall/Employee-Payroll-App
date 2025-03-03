package com.example.employeepayrollapplication.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}(\\s[A-Z][a-zA-Z]+)*$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;
    @NotNull(message = "Salary cannot be null")
    @Min(value = 5000, message = "Salary must be greater than or equal to 5000")
    private Double salary;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start Date should be in the past or present")
    private LocalDate startDate;

    private String note;
    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;
}