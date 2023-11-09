package com.example.ht13sessionscopeinternals.service;

import com.example.ht13sessionscopeinternals.dto.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class SecurityContextServiceProxy extends SecurityContextService{
    @Override
    public User getCurrentUser() {
        return getDelegate().getCurrentUser();
    }

    @Override
    public void setCurrentUser(User currentUser) {
        getDelegate().setCurrentUser(currentUser);
    }

    @Override
    public String toString(){
        return getDelegate().toString();
    }

    private SecurityContextService getDelegate(){
        var session = getSession();
        if(session.getAttribute(CUSTOM_ATTRIBUTE) != null){
            return (SecurityContextService) session.getAttribute(CUSTOM_ATTRIBUTE);
        } else {
            SecurityContextService delegate = new SecurityContextService();
            session.setAttribute(CUSTOM_ATTRIBUTE, delegate);
            return delegate;
        }
    }

    private static HttpSession getSession() {
        var attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        return attributes.getRequest().getSession();
    }
}
