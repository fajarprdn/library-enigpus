package com.enigma.enigpusboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchDTO {
    private String searchBookByTitle;
    private String searchBookByAuthor;
    private String searchBookByPublisher;
}
