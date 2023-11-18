package com.example.library_management.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class book {
    private int idBook;

    private String bookName;

    private  int pageNumbers;

    private  String topic;

    private String releaseDate;

    private author author;


}
