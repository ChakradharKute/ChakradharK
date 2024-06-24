package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book.entity.Book;
import com.book.service.BookService;



@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping()
    public String saySorry() {
    return "Sorry";
    }

  @PostMapping("/add")
  public Book addBook(@RequestBody Book book)
  {
	  return bookService.addBook(book);
	  
	  
  }
  
//  @GetMapping("/get")
//  public List<Book> getBooks() {
//	  return bookService.getBooks();
//  }
  
  @GetMapping("/get/{id}")
  public Book getBookById(@PathVariable int id) {
	  return bookService.getBookById(id);
  }
  
  @DeleteMapping("/{id}")
  public String deleteBookById(@PathVariable int id) {
	  bookService.deleteBookById(id);
	  return "Deleted Successfully";
  }
  
  @PutMapping("/{id}")
  public Optional<Book> updateBookById(@RequestBody Book book, @PathVariable ("id") int id)
  {
	 Optional<Book> b=  bookService.updateBookById(book, id);
	return b;
	  
  }
  
  @GetMapping("/h")
  public String welcome() {
	  return "Hi";
  }
	  
  }

