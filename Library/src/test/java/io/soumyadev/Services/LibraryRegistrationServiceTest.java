package io.soumyadev.Services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import io.soumyadev.Model.Library;
import io.soumyadev.Repository.IBookRegistrationJPAInterface;
import io.soumyadev.Repository.ILibraryManagementRepository;

@RunWith(SpringRunner.class)
public class LibraryRegistrationServiceTest {
	
	LibraryRegistrationService libServices = new LibraryRegistrationService();
	@Mock
	ILibraryManagementRepository libraryRepo;
	@Mock
	IBookRegistrationJPAInterface bookRepo;
	@org.junit.Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void findDetailsByLibraryIdTest() {
		int id = 100;
		Library lib = new Library();
		lib.setId(100);
		lib.setName("Hyderabad");
		lib.setCollection(null);
		ArrayList<Library> lst = new ArrayList<>();
		lst.add(lib);
		Optional<Library> opt = lst.stream().findFirst();
		//Mockito.when(libraryRepo.findById(100)).thenReturn(opt);
		assertEquals(null, libServices.findDetailsByLibraryId(100));
	}
}
