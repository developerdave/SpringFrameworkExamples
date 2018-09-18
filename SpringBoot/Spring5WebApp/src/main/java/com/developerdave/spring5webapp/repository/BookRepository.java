package com.developerdave.spring5webapp.repository;

import com.developerdave.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
