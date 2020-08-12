package library.author.org.dxctraining.dao;

import library.author.org.dxctraining.entities.Author;
import library.book.org.dxctraining.entities.Book;

public interface IAuthorDao {
	Author findById(String id);
	void add(Author author);
}
