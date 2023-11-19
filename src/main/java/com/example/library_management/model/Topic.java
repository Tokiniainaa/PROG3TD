package com.example.library_management.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Topic {
    private String topic;
    @Override
    public String toString() {
        return this.topic;
    }
}
