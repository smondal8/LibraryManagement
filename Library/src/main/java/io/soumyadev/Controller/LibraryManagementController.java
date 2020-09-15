package io.soumyadev.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.soumyadev.LibraryNotFound;
import io.soumyadev.Model.Book;
import io.soumyadev.Model.Library;
import io.soumyadev.Services.LibraryRegistrationService;

@RestController
//@CrossOrigin()
public class LibraryManagementController {
	@Autowired
	LibraryRegistrationService libraryRegistrationService;
	
	@GetMapping("/library/{id}")
	public Library getLibraryDetails(@PathVariable("id") int id) {
		Library lib = libraryRegistrationService.findDetailsByLibraryId(id);
		if(lib == null) {
			throw new LibraryNotFound("Library not found for :"+id);
		}
		return lib;
	}
	
	@GetMapping("/library/book/{id}")
	public List<Book> getLibraryBookDetails(@PathVariable("id") int id) {
		List<Book> bookList = libraryRegistrationService.findAllBooksByLibraryId(id);
		if(bookList == null) {
			throw new LibraryNotFound("Library not found for :"+id);
		}
		return bookList;
	}
	
	@GetMapping("/library/listAll")
	public List<Library> getLibraryAll() {
		return libraryRegistrationService.getAll();
	}
	
	@PostMapping(path = "/library", consumes = "application/json")
	public ResponseEntity<Object> registerMovieDesc(@RequestBody Library library) {		
		Library lib = libraryRegistrationService.registraion(library);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lib.getId()).toUri();
		return ResponseEntity.created(location).build();  
	}
	@GetMapping("/books/listAll")
	public List<Book> getBooksAll() {
		return libraryRegistrationService.getAllBooks();
	}
	@PostMapping(path = "/updateBook/{libId}", consumes = "application/json")
	public ResponseEntity<Book> createOrUpdateBook(@RequestBody Book book, @PathVariable("libId") int id ) {		
		Book updated = libraryRegistrationService.createOrUpdateBook(book,id);		
		return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);  
	}
	@PostMapping(path = "/updateBook", consumes = "application/json")
	public ResponseEntity<Book> UpdateSingleBook(@RequestBody Book book) {		
		Book updated = libraryRegistrationService.UpdateSingleBook(book);	
		return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);  
	}
}
