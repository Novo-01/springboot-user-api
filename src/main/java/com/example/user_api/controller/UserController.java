package com.example.user_api.controller;

import java.util.List;
import com.example.user_api.entity.User;
import com.example.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.user_api.exception.EntityNotFoundException;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public String createUser(@RequestBody UserRequest userRequest) {
        // ① Userエンティティに変換
        User user = new User(userRequest.getName(), userRequest.getEmail());
        // ② データベースに保存
        userRepository.save(user);
        // ③ 保存成功のメッセージを返す
        return "User saved successfully: " + userRequest.getName() + "," + userRequest.getEmail();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());

        userRepository.save(user);

        return "User updated successfully: " + user.getName() + ", " + user.getEmail();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + " のユーザーは存在しません"));

        userRepository.delete(user);

        return "ユーザーを削除しました: " + user.getName();
    }

    // リクエストデータ用のクラス(内部クラス)
    static class UserRequest {
        private String name;
        private String email;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    }
}
