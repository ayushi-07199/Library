package library.book.org.dxctraining.ui;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import library.book.org.dxctraining.ui.*;
import library.author.org.dxctraining.entities.Author;
import library.author.org.dxctraining.service.AuthorServiceImpl;
import library.author.org.dxctraining.service.IAuthorService;
import library.book.org.dxctraining.entities.Book;
import library.book.org.dxctraining.exceptions.*;
import library.book.org.dxctraining.service.BookServiceImpl;
import library.book.org.dxctraining.service.IBookService;

public class LibraryMain {
	public static void main(String args[]) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(JavaConfig.class);
        context.refresh();
	}
	
}
