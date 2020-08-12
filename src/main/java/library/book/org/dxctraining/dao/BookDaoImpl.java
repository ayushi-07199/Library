package library.book.org.dxctraining.dao;

import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import library.book.org.dxctraining.entities.Book;
import library.book.org.dxctraining.exceptions.BookNotFoundException;

@Repository
public class BookDaoImpl implements IBookDao {
	private Map<String, Book> store = new HashMap<>();

	private int generatedId=1;

	private String generateId() {
		Integer a=generatedId++;
		String b=a.toString();
		return b;
	}

	@Override
	public Book findById(String id) {
		Book book = store.get(id);
		if (book == null) {
			throw new BookNotFoundException("customer not found for id=" + id);
		}
		return book;
	}

	@Override
	public List<Book> findAll() {
		Collection<Book> values = store.values();
		List<Book> list = new ArrayList<>();
		for (Book value : values) {
			list.add(value);
		}
		return list;
	}
	@Override
	public void add(Book book) {
		String id = generateId();
		store.put(id, book);
		book.setId(id);
	}

@Override
	public Book updateCost(String id, double newCost) {
		Book book = findById(id);
		book.setCost(newCost);
		return book;
	}

	@Override
	public void remove(String id) {
		store.remove(id);
	}
}
