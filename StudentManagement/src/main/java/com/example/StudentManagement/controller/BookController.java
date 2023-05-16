package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Book;
import com.example.StudentManagement.service.BookService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping()
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping()
    public List<Book> getBook(@Nullable @RequestParam Long bookId) {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{BookId}")
    public String removeBook(@PathVariable Long bookId) {
        return bookService.removeBook(bookId);
    }

    @PutMapping("/{BookId}")
    public String updateStudent(@PathVariable Long bookId , @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

}
