package library.author.org.dxctraining.service;

import library.author.org.dxctraining.entities.Author;
import library.book.org.dxctraining.entities.Book;

public interface IAuthorService {
	Author findById(String id);
	void add(Author author);
}
