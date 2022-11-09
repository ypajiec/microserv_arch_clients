package com.gmail.ypajiec.micro_serv_arch.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "client", uniqueConstraints = { @UniqueConstraint(columnNames = {"first_name", "last_name"})})
public class Client extends AbstractPersistable<Long> {

    @Column(name = "login", unique = true)
    String login;

    @Column(name = "pass")
    String pass = "qwerty";

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone")
    String phone;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        Active, Unactive
    }
}
