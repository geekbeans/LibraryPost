package com.myczhproject.springbootlibrary.repository;

import com.myczhproject.springbootlibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//两个泛型，第一个是实体类，第二个是主键类型
public interface BookRepository extends JpaRepository<Book,Integer> {
}
