package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "post_categories",
//    joinColumns = {@JoinColumn(name = "post_id")},
//            inverseJoinColumns = {@JoinColumn(name = "category_id")}
//    )
//     private List<PostCategories> categories;


    public Post(String title,String body) {
        this.title = title;
        this.body = body;
    }



//    public Post() {
//
//    }

//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
////    public Post(String title, String body) {
////        this.title = title;
////        this.body = body;
////
////
////    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
}
