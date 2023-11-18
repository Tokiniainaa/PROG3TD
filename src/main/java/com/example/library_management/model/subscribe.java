package com.example.library_management.model;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@ToString
public class subscribe extends user{
    public subscribe(int id, String name, String gender) {
        super(id, name, gender);
    }
}
