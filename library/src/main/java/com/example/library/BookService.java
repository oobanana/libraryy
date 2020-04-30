package com.example.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Optional<Book> getBookById(Integer id){
        return bookRepo.findById(id);
    }

    public void deleteById(Integer id){
        bookRepo.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepo.save(book);
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }

    public List<Book> getStatus(String status){
       return bookRepo.findBookByStatus(status);
    }

    public List<Book> getBooks()
    {
        return(List<Book>) bookRepo.findAll();
    }


    /*
    public void save (Book book){
        bookRepo.save(book);
    }
    @EventListener(ApplicationReadyEvent.class)//po uruchomieniu aplikacji na starcie w bazie danych  elementy dodane ponizej
    public void  fillDB(){ //dodawanie do bazy danych
        save(new Book(1L,"przeminelo z wiatrem", "autorX", 1968,"na stanie"));
        save(new Book(2L,"slepnac od swiatel", "autorY", 2018, "wypozyczona"));
        save(new Book(3L,"yyy", "autorB", 2017, "na stanie"));
    }*/
}
