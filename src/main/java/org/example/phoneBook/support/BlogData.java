package org.example.phoneBook.support;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "blog_data")
@Data
public class BlogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_data_id", unique = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "blog_id", nullable = false)
    @JsonBackReference
    BlogDataStorage blogId;

    @Column(name = "page_id")
    int pageId;

    @Column(name = "page_data")
    String data;
}
