package library.author.org.dxctraining.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import library.author.org.dxctraining.entities.Author;
import library.author.org.dxctraining.exceptions.AuthorNotFoundException;
import library.book.org.dxctraining.entities.Book;

@Repository
public class AuthorDaoImpl implements IAuthorDao{
	private Map<String, Author> store = new HashMap<>();

	private int generatedId=1;

	private String generateId() {
		Integer a=generatedId++;
		String b=a.toString();
		return b;
	}
	@Override
	public void add(Author author) {
		String id = generateId();
		store.put(id, author);
		author.setId(id);
	}
	@Override
	public Author findById(String id) {
		Author author = store.get(id);
		if (author == null) {
			throw new AuthorNotFoundException("author not found for id=" + id);
		}
		return author;
	}

}
