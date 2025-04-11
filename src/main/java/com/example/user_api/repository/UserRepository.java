package com.example.user_api.repository;

import com.example.user_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// データベース操作のためのインターフェース
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}