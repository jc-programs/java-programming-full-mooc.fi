/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Book {
    
    private String title;
    private int pages;
    private int year;
    
    public Book(String title,int pages, int year){
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }
    
    @Override
    public String toString(){
        return this.title + ", " + this.pages + " pages, " + this.year;
    }
}
