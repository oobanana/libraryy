package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookApi {

    @Autowired
    private BookService bookService;
    public BookApi(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/list")
    public String getBooks(Model model){
        model.addAttribute("book",bookService.getBooks());
        return "book";
    }
    @GetMapping("/status_wypozyczone")
    public String getStatus(Model model)
    {
        model.addAttribute("book",bookService.getStatus("wypożyczona"));
        return "book";
    }
    @GetMapping("/status_nastanie")
    public String getStatusCheckedOut(Model model)
    {
        model.addAttribute("book",bookService.getStatus("na stanie"));
        return "book";
    }
    @GetMapping("/home")
    public String hello()
    {
        return "home";
    }

    @GetMapping("/single")
    @ResponseBody
    public Optional<Book> getBookById(Integer id, Model model ) {
       // model.addAttribute("single", bookService.getBookById(id));
        return bookService.getBookById(id);
    }

    @RequestMapping(value="/edit", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String updateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:/list";
    }

    @RequestMapping(value="/add", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/list";
    }

    @RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.GET})
    public String deleteBook(Integer Id) {
        bookService.deleteById(Id);
        return "redirect:/list";
    }
}
