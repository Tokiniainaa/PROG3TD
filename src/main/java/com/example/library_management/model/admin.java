package com.example.library_management.model;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class admin extends user{
    public admin(int id, String name, String gender) {
        super(id, name, gender);
    }
}
