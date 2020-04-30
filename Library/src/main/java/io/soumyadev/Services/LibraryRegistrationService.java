package io.soumyadev.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import io.soumyadev.BookNotFound;
import io.soumyadev.LibraryNotFound;
import io.soumyadev.Model.Book;
import io.soumyadev.Model.Library;
import io.soumyadev.Repository.IBookRegistrationJPAInterface;
import io.soumyadev.Repository.ILibraryManagementRepository;


@Service
public class LibraryRegistrationService {
	@Autowired
	ILibraryManagementRepository libraryRepo;
	@Autowired
	IBookRegistrationJPAInterface bookRepo;
	/**
	 * Service method to save the data in library table
	 * @param movieDetails
	 */
	public Library registraion(Library library) {
		return libraryRepo.save(library);
	}
	/**
	 * Find the wholistic library details
	 * @param id
	 * @return
	 */
	public Library findDetailsByLibraryId(int id) {
		Optional<Library> lib = libraryRepo.findById(id);
		if(lib.isPresent()) {
			return lib.get();
		}
		else {
			
			return null;
		}
	}
	/**
	 * Finds all the books from library id 
	 * @param id
	 * @return
	 */
	public List<Book> findAllBooksByLibraryId(int id){
		Optional<Library> lib = libraryRepo.findById(id);
		if(lib.isPresent()) {
			return lib.get().getCollection();
		}
		else {
			
			return null;
		}
	}
	/**
	 * Get all library details
	 * @return
	 */
	public List<Library> getAll() {
		return libraryRepo.findAll();
	}
	/**
	 * get all book details
	 * @return
	 */
	public List<Book> getAllBooks(){
		return bookRepo.findAll();		
	}
	/**
	 * updates a book considering it is already added to a library
	 * @param book
	 * @return
	 */
	public Book UpdateSingleBook(Book book) {
		Optional<Book> returnedBook = bookRepo.findById(book.getId());        
        if(returnedBook.isPresent()) 
        {
        	Book existingEntity = returnedBook.get();
        	existingEntity.setName(book.getName());
        	existingEntity.setAuthor(book.getAuthor());
        	existingEntity = bookRepo.save(existingEntity);             
            return existingEntity;
        } else {
        	throw new BookNotFound("The book is not found!");
        }
	}
	/**
	 * This method will create a book and put it in library code id or else update the existing book only
	 * @param book
	 * @param id
	 * @return
	 */
	public Book createOrUpdateBook(Book book, int id) {
		Optional<Book> returnedBook = bookRepo.findById(book.getId());
        
        if(returnedBook.isPresent()) 
        {
        	Book existingEntity = returnedBook.get();
        	existingEntity.setName(book.getName());
        	existingEntity.setAuthor(book.getAuthor());
        	existingEntity = bookRepo.save(existingEntity);             
            return existingEntity;
        } else {
        	Book newEntity = bookRepo.save(book); 
        	Optional<Library> lib = libraryRepo.findById(id);
        	if(lib.isPresent()) {
    			lib.get().getCollection().add(newEntity);
    			libraryRepo.save(lib.get());
    		}
    		else {
    			throw new LibraryNotFound("Books created but library is not found!");
    		}
            return newEntity;
        }
	}
}
