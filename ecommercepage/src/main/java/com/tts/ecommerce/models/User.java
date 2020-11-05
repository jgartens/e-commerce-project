package com.tts.ecommerce.models;

import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    @NotEmpty(message = "Cannot be empty")
    private String username;

    @NotEmpty(message = "Cannot be empty")
    private String password;

    @ElementCollection
    private Map<Product, Integer> cart;

    // @Transient
    // private boolean accountNonExpired = true;
    // @Transient
    // private boolean accountNonLocked = true;
    // @Transient
    // private boolean credentialsNonExpired = true;
    // @Transient
    // private boolean enabled = true;
    // @Transient
    // private Collection<GrantedAuthority> authorities = null;

    public User() {
    }

    public User(Long id, @NotEmpty(message = "Cannot be empty") String username,
            @NotEmpty(message = "Cannot be empty") String password, Map<Product, Integer> cart) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User [cart=" + cart + ", id=" + id + ", password=" + password + ", username=" + username + "]";
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return null;
    }

    @Override
    public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
    }

    
    
    

    




}
