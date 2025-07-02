package com.library.library.listOfBooks.mapper;

import com.library.library.listOfBooks.dto.BookDto;
import com.library.library.listOfBooks.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
}
