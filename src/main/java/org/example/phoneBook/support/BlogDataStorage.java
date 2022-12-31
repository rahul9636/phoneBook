package org.example.phoneBook.support;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "blog_data_storage")
@Data
public class BlogDataStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", unique = true)
    private Integer id;

    @Column(name = "blog_name")
    private String blogName;
}
