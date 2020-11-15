package com.myczhproject.springbootlibrary.controller;

import com.myczhproject.springbootlibrary.entity.Book;
import com.myczhproject.springbootlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page - 1, size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if(result != null){
            return "保存成功";
        }else {
            return "保存失败";
        }
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        //bookRepository.findById(id)返回的是Option，必须调用里面的get()方法才能拿到
        return bookRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result != null){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
