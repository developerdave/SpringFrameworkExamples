package com.developerdave.spring5webapp.bootstrap;

import com.developerdave.spring5webapp.model.Author;
import com.developerdave.spring5webapp.model.Book;
import com.developerdave.spring5webapp.model.Publisher;
import com.developerdave.spring5webapp.repository.AuthorRepository;
import com.developerdave.spring5webapp.repository.BookRepository;
import com.developerdave.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
		this.bookRepository = bookRepository;
	}

	private BookRepository bookRepository;


	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {

		// Eric
		Author eric = new Author("Eric", "Evans");
		Publisher harperCollins = new Publisher("Harper Collins", "An Address");
		Book ddd = new Book("Domain Driven Design", "1234");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(harperCollins);

		authorRepository.save(eric);
		publisherRepository.save(harperCollins);
		bookRepository.save(ddd);

		// Rod
		Author rod = new Author("Rod", "Johnson");
		Publisher worx = new Publisher("Worx", "Another address");
		Book noEJB = new Book("J2EE Development without EJB", "23444");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(worx);

		authorRepository.save(rod);
		publisherRepository.save(worx);
		bookRepository.save(noEJB);
	}
}
