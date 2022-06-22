package com.codingdojo.bookclub.controllers;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.UserService;
import com.codingdojo.bookclub.services.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {
	
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    
    @GetMapping("/")
    public String index(Model model) { 
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        User user = userService.register(newUser, result);
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        session.setAttribute("uuid", user.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
    	if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        
    	session.setAttribute("uuid", user.getId());

        return "redirect:/dashboard";
    }
    
    @GetMapping(value="/dashboard")
    public String dashboard(Model model, Book book, HttpSession session) {
    	if(session.getAttribute("uuid") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("user", userService.findUser((Long) session.getAttribute("uuid")));
    	List<Book> books = bookService.allBooks();
    	model.addAttribute("books", books);
    	return "dashboard.jsp";
    }
    
    @GetMapping(value="/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("uuid");
    	return "redirect:/";
    }
}
