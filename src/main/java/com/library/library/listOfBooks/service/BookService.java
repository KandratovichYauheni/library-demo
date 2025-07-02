package com.library.library.listOfBooks.service;

import com.library.library.listOfBooks.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();
    BookDto getBookById(Integer id);
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(Integer id, BookDto bookDto);
    void deleteBook(Integer id);
}
