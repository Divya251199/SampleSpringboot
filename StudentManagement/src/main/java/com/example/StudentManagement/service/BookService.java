package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Book;
import com.example.StudentManagement.model.Book;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.IBookRepository;
import com.example.StudentManagement.repository.IStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    IStudentsRepository studentsRepository;

    public String addBook(Book book) {

        if ( book != null ) {
            Long studentId = book.getStudent().getStudentId();
            Optional<Student> student = studentsRepository.findById(studentId);
                if ( student.isPresent() ) {
                    book.setStudent(student.get());
                    bookRepository.save(book);
                    return "Book added successfully";
                }

            }

        return "Enter valid details";
    }

    public List<Book> getBook(Long bookId) {
        List<Book> books = new ArrayList<>();
        if ( bookId != null ) {
            books.add(bookRepository.findById(bookId).get()) ;
            return books;
        }
        return bookRepository.findAll();

    }

    public String removeBook(Long bookId) {
        Optional<Book> books = bookRepository.findById(bookId);
        if (books.isEmpty()) {
            return "Book does not exist";
        }
        else {
            bookRepository.deleteById(bookId);
            return "Book deleted successfully...!!!";
        }

    }

    public String updateBook(Long bookId, Book book) {
        Optional<Book> books = bookRepository.findById(bookId);
        Long studentId = book.getStudent().getStudentId();
        Optional<Student> student = studentsRepository.findById(studentId);

        if (books.isEmpty()) {
            return "Book does not exist";
        }
        else {
            if ( student.isPresent() ) {
                book.setBookId(bookId);
                book.setStudent(student.get());
                bookRepository.save(book);
                return "Book updated successfully";
            }
            else {
                return "Book cannot be added";
            }

        }
    }
}
