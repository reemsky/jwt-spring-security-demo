package org.zerhusen.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.zerhusen.model.security.User;


@ConfigurationProperties("jwt")
@Configuration
public class ConfigUsers {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return this.users;
    }
}
