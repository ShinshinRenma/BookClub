package com.codingdojo.bookclub.services;
import java.util.List;
import java.util.Optional;
import com.codingdojo.bookclub.repositories.BookRepository;
import org.springframework.stereotype.Service;
import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;

@Service
public class BookService {
    // adding the book repository as a dependency
	private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the ninjas
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a ninja
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    // Updates a Book
    public Book updateBook(Long id, String title, String author, String thoughts, User user) {
    	Book book = findBook(id);
    	if(book != null) {
    		book.setTitle(title);
    		book.setAuthor(author);
    		book.setThoughts(thoughts);
    		book.setUser(user);
    	}
    	return bookRepository.save(book);
    }
    
    // Overloaded method to update expense with expense object
    public Book updateBook(Book b) {
        return bookRepository.save(b);
    }
    // Deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

