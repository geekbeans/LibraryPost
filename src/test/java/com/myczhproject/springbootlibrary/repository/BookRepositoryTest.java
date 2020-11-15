package com.myczhproject.springbootlibrary.repository;

import com.myczhproject.springbootlibrary.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Test
    void findAllTest(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("春风吹又生");
        book.setAuthor("江南");
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1).get();
        System.out.println(book);
    }

    @Test
    void update(){
        //先new一个对象出来
        Book book = new Book();
        book.setId(126);
        book.setName("淦淦淦");
        //其中save也是更新方法
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
    }

    @Test
    void delete(){
        bookRepository.deleteById(126);
    }
}