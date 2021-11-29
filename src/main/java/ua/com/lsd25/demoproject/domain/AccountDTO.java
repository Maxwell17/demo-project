package ua.com.lsd25.demoproject.domain;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.List;

public record AccountDTO(@JsonSetter("username") String username,
                         @JsonSetter("password") String password,
                         @JsonSetter("matchPassword") String matchPassword,
                         @JsonSetter("roles") List<Role> roles) implements Serializable {
}
