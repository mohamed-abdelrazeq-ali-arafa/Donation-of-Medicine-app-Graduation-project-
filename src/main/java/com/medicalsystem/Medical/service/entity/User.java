package com.medicalsystem.Medical.service.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection="users")
public class User implements UserDetails {
    @Id
    private String id;
    private String email;
    private String password;
    private String phone;
    private String username;
    private Location location;





    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    private enum type{
        DONATOR,
        USER;
    };
    private type enumType;


    private String diseaseId;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

