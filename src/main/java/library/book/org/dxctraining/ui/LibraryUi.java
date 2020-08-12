package library.book.org.dxctraining.ui;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import library.author.org.dxctraining.entities.Author;
import library.author.org.dxctraining.service.AuthorServiceImpl;
import library.author.org.dxctraining.service.IAuthorService;
import library.book.org.dxctraining.entities.Book;
import library.book.org.dxctraining.exceptions.BookNotFoundException;
import library.book.org.dxctraining.exceptions.InvalidArgumentException;
import library.book.org.dxctraining.service.BookServiceImpl;
import library.book.org.dxctraining.service.IBookService;

@Component
public class LibraryUi {
	@Autowired
	private IBookService service;
	@Autowired
	private IAuthorService service2;
	@PostConstruct
	private void runapp() {
		try {
		Author author1=new Author("Anuj");
		service2.add(author1);
		Author author2=new Author("Ankit");
		service2.add(author2);
		Author author3=new Author("Ayushi");
		service2.add(author3);
		Author author4=new Author("Muskaan");
		service2.add(author4);
		Book book1=new Book("java",111,author1);
		service.add(book1);
		Book book2=new Book("python",222,author1);
		service.add(book2);
		Book book3=new Book("python",333,author2);
		service.add(book3);
		Book book4=new Book("C++",444,author3);
		service.add(book4);
		Book book5=new Book("Ruby",555,author4);
		service.add(book5);
		Book fetched=service.findById("2");
		service.updateCost("1", 800);
		service.remove("3");
		display(fetched);
		displayAll();
		}catch(InvalidArgumentException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		catch(BookNotFoundException e) {
			 e.printStackTrace();
			 System.out.println(e.getMessage());
		}
		
		catch(Exception e) {
		 e.printStackTrace();
		 System.out.println("some thing went wrong");
		}
	}
	public void displayAll() {
		List<Book> list = service.findAll();
		for (Book book : list) {
			display(book);
		}
	}
	public void display(Book book) {
		Author author = book.getAuthor();
		System.out.println("Id : " + book.getId() + " Name : " + book.getName()+" Cost : "+book.getCost()+" Authorid =" + author.getId() + " AuthorName : " + author.getName());
	}

}
