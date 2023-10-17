package com.liutian.designPatterns.iterator;

import java.util.ArrayList;

public class BookShelf implements Aggregate {

    int length = 0;
    private ArrayList<Book> books;

    public BookShelf(int n) {
        books = new ArrayList<>(n);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        length++;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
