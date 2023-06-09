//package com.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="categories")
//public class PostCategories {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
//    private String name;
//    @ManyToMany(mappedBy = "categories")
//    private List<Post> posts;
//
//
//}
