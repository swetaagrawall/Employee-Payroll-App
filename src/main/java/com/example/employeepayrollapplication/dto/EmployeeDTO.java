package com.example.employeepayrollapplication.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name cannot be Blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}(\\s[A-Z][a-zA-Z]+)*$", message = "Name must start with a capital letter and have at least 3 characters")
    private String name;

    @NotNull(message = "Salary cannot be null")
    @Min(value = 5000, message = "Salary must be greater than or equal to 5000")
    private Double salary;

    @NotEmpty(message = "Gender cannot be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date cannot be null")
    @PastOrPresent(message = "Start Date should be in the past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile Picture URL cannot be Blank")
    private String profilePic;

    @NotEmpty(message = "At least one department is required")
    private List<String> department;
}