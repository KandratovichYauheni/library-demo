package com.library.library.listOfBooks.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Integer id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    @NonNull @Min(1)
    private Integer pages;
    @NotBlank(message = "Genre cannot be blank")
    private String genre;
    @NotBlank(message = "Language cannot be blank")
    private String language;
    private Integer year;
}
