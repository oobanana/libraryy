package com.example.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String tytul;
    private String autor;
    private int rok;
    private String status;


    public Book(){

    }
    public Book(Integer id,String tytul, String autor, int rok,String status){
        this.id=id;
        this.tytul=tytul;
        this.autor=autor;
        this.rok=rok;
        this.status=status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public String getStatus(){return status;}

    public void setStatus(String status){this.status=status;}

}

