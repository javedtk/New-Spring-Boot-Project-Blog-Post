package com.ProjectBlogProject.repository;

import com.ProjectBlogProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
