package library.book.org.dxctraining.dao;

import java.util.List;

import library.book.org.dxctraining.entities.Book;

public interface IBookDao {
	Book findById(String id);
	List<Book> findAll() ;
	void add(Book book);
	Book updateCost(String id,double newCost);
	void remove(String id);
}
