package ua.edu.ucu.apps.task1;

import java.time.LocalDate;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Student meow = Student.builder()
        .firstName("Viktor")
        .lastName("Pakholok")
        .dob(LocalDate.of(2006, 1, 1))
        .mice(List.of("Mickey"))
        .mouse("lol")
        .mark(1)
        .mark(3)
        .height(185)
        .build();
  }
}