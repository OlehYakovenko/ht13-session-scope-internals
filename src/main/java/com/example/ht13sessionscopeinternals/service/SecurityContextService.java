package com.example.ht13sessionscopeinternals.service;

import com.example.ht13sessionscopeinternals.dto.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityContextService {
    public static final String CUSTOM_ATTRIBUTE = "customScope.SecurityContextService";
    private User currentUser;
}
