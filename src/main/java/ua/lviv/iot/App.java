package ua.lviv.iot;

import ua.lviv.iot.model.Book;
import ua.lviv.iot.model.Tracker;
import ua.lviv.iot.services.impl.BooksSortingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App
{
    public static void main(String[] args) {
        BooksSortingService liftSortingService = new BooksSortingService();
        List<Book> books = getTestData();

        System.out.println("Insertion sort:");
        Tracker tracker = new Tracker();
        System.out.println(liftSortingService.insertionSort(books, Comparator.comparingInt(Book::getPagesNumber).reversed(), tracker));
        tracker.showStats();

        System.out.println("\n\nMerge sort:");
        tracker.init();
        System.out.println(liftSortingService.mergeSort(books, Comparator.comparingInt(Book::getPrice).reversed(), tracker));
        tracker.showStats();
    }

    private static List<Book> getTestData() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("J.K.Rowling", 425, 400));
        books.add(new Book("J.K.Rowling", 875, 700));
        books.add(new Book("J.K.Rowling", 287, 390));
        books.add(new Book("J.K.Rowling", 278, 780));
        books.add(new Book("J.K.Rowling", 375, 570));
        books.add(new Book("J.K.Rowling", 785, 540));
        books.add(new Book("J.K.Rowling", 524, 800));
        books.add(new Book("J.K.Rowling", 257, 150));
        return books;
    }
}
