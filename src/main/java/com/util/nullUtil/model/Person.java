package com.util.nullUtil.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class Person {
    Integer id;
    String name;
    LocalDate birthdate;
    List<Person> children;
    Boolean male;
    Occupation occupation;

}
