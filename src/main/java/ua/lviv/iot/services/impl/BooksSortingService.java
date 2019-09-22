package ua.lviv.iot.services.impl;

import ua.lviv.iot.model.Book;
import ua.lviv.iot.model.Tracker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BooksSortingService {

    public List<Book> insertionSort(List<Book> books, Comparator<Book> comparator, Tracker tracker) {
        int length = books.size();
        for (int i = 1; i < length; i++) {
            Book tmp = books.get(i);
            int pointer = i;
            while ((pointer > 0) && comparator.compare(books.get(pointer - 1), tmp) > 0) {
                tracker.comparisionCount++;
                tracker.exchangeCount++;
                books.set(pointer, books.get(pointer - 1));
                pointer--;
            }
            tracker.exchangeCount++;
            books.set(pointer, tmp);
        }
        return books;
    }

    
    public List<Book> mergeSort(List<Book> books, Comparator<Book> comparator, Tracker tracker) {
        List<Book> left;
        List<Book> right;

        if (books.size() < 2) {
            return books;
        } else {
            int center = books.size() / 2;
            left = new ArrayList<>(books.subList(0, center));
            right =  new ArrayList<>(books.subList(center, books.size()));

            left = mergeSort(left, comparator, tracker);
            right = mergeSort(right, comparator, tracker);

            merge(left, right, books, comparator, tracker);
        }

        return books;
    }

    private void merge(List<Book> left, List<Book> right, List<Book> books, Comparator<Book> comparator, Tracker tracker) {
        int leftIndex = 0;
        int rightIndex = 0;
        int booksIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            tracker.comparisionCount++;
            tracker.exchangeCount++;
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                books.set(booksIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                books.set(booksIndex, right.get(rightIndex));
                rightIndex++;
            }
            booksIndex++;
        }

        List<Book> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            rest = right;
            restIndex = rightIndex;
        } else {
            rest = left;
            restIndex = leftIndex;
        }

        for (int i = restIndex; i < rest.size(); i++) {
            tracker.exchangeCount++;
            books.set(booksIndex, rest.get(i));
            booksIndex++;
        }
    }
} 