package com.example.restapi.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//By default user table is created unless it is given a name
@Table(name = "Student")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "userName")
    private String userName;
    @Column
    private String fullName;
    @Column
    private String password;





}
