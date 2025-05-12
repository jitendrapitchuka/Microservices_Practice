package com.jitendra.redis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(indexName = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {

    @Id
    private String id;
    private String name;
    private String email;




}
