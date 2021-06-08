package com.example.aufgabenverwaltung.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.aufgabenverwaltung.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByStatus(String status);
  List<Task> findByPerson(String person);

  List<Task> findByTitleContaining(String title);
  List<Task> findByDescriptionContaining(String description);
}