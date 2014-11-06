package de.datepoller.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dsy on 30.10.14.
 */

@Entity(name = "user")
public class User {

    @Id
    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne(mappedBy = "user", cascade={CascadeType.ALL})
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
