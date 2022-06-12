package com.soyeonkim.todolist.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    private String name;

    @Setter
    private Integer number;

    @Setter
    private Integer badScore;

    @Setter
    private String accountId;

    @Setter
    private String password;
}
