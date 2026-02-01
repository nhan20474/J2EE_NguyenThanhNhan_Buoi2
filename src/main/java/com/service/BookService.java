package com.service;

import org.springframework.stereotype.Service;

import com.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    // Khởi tạo danh sách lưu trữ sách trong bộ nhớ
    private List<Book> books = new ArrayList<>();

    // Lấy toàn bộ danh sách sách
    public List<Book> getAllBooks() {
        return books;
    }

    // Tìm kiếm sách theo ID
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm một cuốn sách mới vào danh sách
    public void addBook(Book book) {
        books.add(book);
    }

    // Cập nhật thông tin sách dựa trên ID
    public void updateBook(int id, Book updatedBook) {
        books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updatedBook.getTitle()); // Cập nhật tiêu đề
                    book.setAuthor(updatedBook.getAuthor()); // Cập nhật tác giả
                });
    }

    // Xóa sách khỏi danh sách theo ID
    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }
}