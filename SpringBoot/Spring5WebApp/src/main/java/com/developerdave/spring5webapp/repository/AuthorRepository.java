package com.developerdave.spring5webapp.repository;

import com.developerdave.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
