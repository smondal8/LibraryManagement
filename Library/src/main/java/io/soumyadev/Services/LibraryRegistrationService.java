package io.soumyadev.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
	
	public Library findDetailsByLibraryId(int id) {
		Optional<Library> lib = libraryRepo.findById(id);
		if(lib.isPresent()) {
			return lib.get();
		}
		else {
			
			return null;
		}
	}
	
	public List<Book> findAllBooksByLibraryId(int id){
		Optional<Library> lib = libraryRepo.findById(id);
		if(lib.isPresent()) {
			return lib.get().getCollection();
		}
		else {
			
			return null;
		}
	}

	public List<Library> getAll() {
		return libraryRepo.findAll();
	}
	
	public Book createOrUpdateBook(Book book) {
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
            return newEntity;
        }
	}
}
