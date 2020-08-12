package library.book.org.dxctraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.book.org.dxctraining.dao.IBookDao;
import library.book.org.dxctraining.dao.BookDaoImpl;
import library.book.org.dxctraining.entities.Book;
import library.book.org.dxctraining.exceptions.InvalidArgumentException;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private IBookDao dao;

	@Override
	public Book findById(String id) {
		checkId(id);
		Book book = dao.findById(id);
		return book;
	}



	@Override
	public List<Book> findAll() {
		List<Book>list=dao.findAll();
		return list;
	}

	
	
	public void checkId(String id) {
		int idno=Integer.parseInt(id);
		if (idno < 1) {
			throw new InvalidArgumentException("id cant be negative, id passed="+id);
		}
	}

	public void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidArgumentException("name cant be null or empty");
		}
	}
	
	public void checkBook(Book book) {
		if(book==null) {
			throw new InvalidArgumentException("Book cant be null");
				
		}
	}
	public void checkCost(double cost) {
	 Double newCost=cost;
	 if(newCost==null) {
		 throw new InvalidArgumentException("cost cant be null");
	 }
	}

	

	@Override
	public Book updateCost(String id,double newCost) {
		checkId(id);
		checkCost(newCost);
		Book book = dao.updateCost(id, newCost);
	    return book;
	}

	@Override
	public void add(Book book) {
		checkBook(book);
		dao.add(book);
		
	}

	@Override
	public void remove(String id) {
	  checkId(id);	
	  dao.remove(id);		
	}

}
