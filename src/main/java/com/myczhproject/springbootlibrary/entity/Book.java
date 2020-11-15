package com.myczhproject.springbootlibrary.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    //因为前端是json数据传进后端的是String类型，没有自增功能，所以添加注解设置id为自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
}
