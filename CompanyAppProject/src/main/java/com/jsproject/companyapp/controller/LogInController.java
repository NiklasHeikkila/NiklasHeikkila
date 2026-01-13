package com.jsproject.companyapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsproject.companyapp.CompanyDatabase;
import com.jsproject.companyapp.dto.UserRequest;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogInController {
    
    @RequestMapping("/")
    public String index() {
        return "log-in.html";
    }
    
    @PostMapping("/api/login")
    public ResponseEntity<?> validateUser(@RequestBody UserRequest req, HttpSession session) {
        CompanyDatabase database = CompanyDatabase.getInstance();
        
        if (database.validateUser(req)) {
            session.setAttribute("AUTHENTICATED", true);
            session.setAttribute("USERNAME", req.getUsername());
            return ResponseEntity.ok().body(new LoginResponse(true, "Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse(false, "Invalid username or password"));
        }
    }

    @PostMapping("api/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok(new LoginResponse(true, "Logged out"));
    }
    
    // Inner class for login response
    public static class LoginResponse {
        private boolean success;
        private String message;
        
        public LoginResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
        
        public boolean isSuccess() {
            return success;
        }
        
        public String getMessage() {
            return message;
        }
    }
}
