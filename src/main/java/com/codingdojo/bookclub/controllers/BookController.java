package com.codingdojo.bookclub.controllers;
import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookController {
    
	@Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, HttpSession session, Model model) {
    	model.addAttribute("user", userService.findUser((Long) session.getAttribute("uuid")));
        return "/newbook.jsp";
    }
    
    @GetMapping("/books/{id}")
    public String getOne(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("book", book);
    	return "displaybook.jsp";
    }
    
    // Note: We'll be altering this a bit after we introduce data binding.
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session ) {
    	if (result.hasErrors()) {
            return "/newbook.jsp";
        } else {
        	User user = userService.findUser((Long)session.getAttribute("uuid"));
        	book.setUser(user);
            bookService.createBook(book);
            return "redirect:/dashboard";
        }
    }
    
    @RequestMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/edit.jsp";
    }
    
    @RequestMapping(value="/editbook/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, HttpSession session, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/expenses/edit/{id}";
        } else {
            bookService.updateBook(book);
            return "redirect:/";
        }
    }

    @PutMapping(value="/books/update/{id}")
    public Book update(
    		@PathVariable("id") Long id, 
    		@RequestParam(value="title") String title,
    		@RequestParam(value="author") String author,
    		@RequestParam(value="thought") String thoughts,
    		@RequestParam(value="user") User user) {
        Book book = bookService.updateBook(id, title, author, thoughts, user);
        return book;
    }
    
    @DeleteMapping(value="/books/delete/{id}")
    public String destroy(@PathVariable("id") Long id, HttpSession session) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
}
