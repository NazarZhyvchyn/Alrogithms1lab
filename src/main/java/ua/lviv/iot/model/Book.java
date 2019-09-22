package ua.lviv.iot.model;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

public class Book {

    public Integer pagesNumber;

    public String author;

    public Integer price;

    public Book(String author, int pagesNumber,  int price) {
        this.pagesNumber = pagesNumber;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "pagesNumber=" + pagesNumber +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

}
