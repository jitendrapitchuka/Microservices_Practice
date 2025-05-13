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
public class PersonElasticEntity {

    @Id
    private int id;
    private String name;
    private String email;




}
