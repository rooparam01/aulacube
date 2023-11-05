package com.aulacube.department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String departmentId;
    private String departmentName;
    private Date createdAt;
    private Date updatedAt;

}

