package library.author.org.dxctraining.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.author.org.dxctraining.dao.AuthorDaoImpl;
import library.author.org.dxctraining.dao.IAuthorDao;
import library.author.org.dxctraining.entities.Author;
import library.author.org.dxctraining.exceptions.AuthorNotFoundException;
import library.book.org.dxctraining.dao.IBookDao;
import library.book.org.dxctraining.dao.BookDaoImpl;
import library.book.org.dxctraining.entities.Book;
import library.book.org.dxctraining.exceptions.InvalidArgumentException;
@Service
public class AuthorServiceImpl implements IAuthorService {
	@Autowired
	private IAuthorDao dao;
	
	@Override
	public Author findById(String id) {
		checkId(id);
		Author author = dao.findById(id);
		return author;
	}
	@Override
	public void add(Author author) {
		checkAuthor(author);
		dao.add(author);
		
	}
	public void checkAuthor(Author author) {
		if(author==null) {
			throw new InvalidArgumentException("Author cant be null or empty");
				
		}
	}


	private void checkId(String id) {
		int idno=Integer.parseInt(id);
		if (idno < 1) {
			throw new InvalidArgumentException("id cant be negative, id passed="+id);
		}
		
	}

}
