package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
		
	}

 

	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
		
	}



	public Book getBookById(int id) {
	    Optional<Book> optional = bookRepository.findById(id);
	    
	    if (optional.isPresent()) {
	        return optional.get();
	    }
	    
	    // You can either return null or throw an exception
	    // return null; // Option 1: Return null
	    throw new NoSuchElementException("not found: " + id); // Option 2: Throw an exception
	}



	public String deleteBookById(int id) {
	    Optional<Book> optional = bookRepository.findById(id);
	    
	    if (optional.isPresent()) {
	        bookRepository.deleteById(id);
	        return "Book deleted successfully.";
	    }
	    
	    return "Book not found with id: " + id;
	}



	public Optional<Book> updateBookById(Book book, int id) {
	    Optional<Book> optional = bookRepository.findById(id);
	    
	    if (optional.isPresent()) {
	        Book existingBook = optional.get();
	        existingBook.setAuthor(book.getAuthor());
	        existingBook.setName(book.getName());
	        // Update other fields as necessary

	        bookRepository.save(existingBook); // Save the updated book

	        return Optional.of(existingBook);
	    }

	    throw new NoSuchElementException("Book not found with id: " + id);
	}

	


}

	
	

//	private static List<Book> list = new ArrayList<>();
//
//	static {
//		list.add(new Book(1, "Chakradhar", "Java"));
//		list.add(new Book(2, "Deepak", "Full Stack"));
//		list.add(new Book(1, "Ram", "Kotlin"));
//		list.add(new Book(1, "Visnu", "Westrn"));
//	}
//
//	public List<Book> getAllBooks() {
//		return list;
//	}
//
//	public Book getBook(int id) {
//		Book book = null;
//		return book = list.stream().filter(e -> e.getId() == id).findFirst().get();
//
//	}
//
//	// Not working Properly beacuase of some problem
//	public static Book addBook(Book book) {
//		list.add(book);
//		return book;
//	}
//
//	public void deleteBookById(int id) {
//		List<Book> list2 = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
//
//	}
//
//	public Book updateBookById(Book book, int id) {
//
//		list= list.stream().map(c->{
//			if(c.getId()==id) {
//				c.setAuthor(book.getAuthor());
//				c.setName(book.getName());
//			}
//			return c;
//		}).collect(Collectors.toList());
//		return book;
	
	





