package ua.edu.ucu.apps.task1;

import lombok.Singular;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
public class Student extends Human {
  private LocalDate dob;
  @Singular("mark")
  private List<Integer> grades;
  @Singular
  private List<String> mice;
  private int height;
}