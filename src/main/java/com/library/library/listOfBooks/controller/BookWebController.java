package com.library.library.listOfBooks.controller;

import com.library.library.listOfBooks.dto.BookDto;
import com.library.library.listOfBooks.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BookWebController {

    private final BookService bookService;

    // 1) главная страница — список книг
    @GetMapping({"/", "/books"})
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    // 2) форма для создания новой книги
    @GetMapping("/books/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "books/form";
    }

    // 3) обработка создания
    @PostMapping("/books")
    public String createBook(@Valid @ModelAttribute("book") BookDto bookDto,
                             BindingResult br) {
        if (br.hasErrors()) {
            return "books/form";
        }
        bookService.createBook(bookDto);
        return "redirect:/books";
    }

    // 4) форма для редактирования
    @GetMapping("/books/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        BookDto dto = bookService.getBookById(id);
        model.addAttribute("book", dto);
        return "books/form";
    }

    // 5) обработка обновления
    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Integer id,
                             @Valid @ModelAttribute("book") BookDto bookDto,
                             BindingResult br) {
        if (br.hasErrors()) {
            return "books/form";
        }
        bookService.updateBook(id, bookDto);
        return "redirect:/books";
    }

    // 6) удаление
    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
