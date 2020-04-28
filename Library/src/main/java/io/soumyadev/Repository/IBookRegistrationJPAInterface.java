package io.soumyadev.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.soumyadev.Model.Book;

@Component
public interface IBookRegistrationJPAInterface extends JpaRepository<Book, Integer>{

	//List<Book> findAllBook(String movieName);		
}
