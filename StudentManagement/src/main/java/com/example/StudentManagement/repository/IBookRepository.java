package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
