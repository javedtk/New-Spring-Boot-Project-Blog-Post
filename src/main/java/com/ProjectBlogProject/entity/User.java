package com.ProjectBlogProject.entity;

import jakarta.persistence.*;
//import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
//import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name="usertables")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String password;
    private String about;
}
