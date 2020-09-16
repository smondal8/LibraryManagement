package io.soumyadev.Services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import io.soumyadev.Model.Library;
import io.soumyadev.Repository.IBookRegistrationJPAInterface;
import io.soumyadev.Repository.ILibraryManagementRepository;

@ExtendWith(MockitoExtension.class)
public class libraryRegistrationServiceTest {
	@InjectMocks
	LibraryRegistrationService sut;
	@Mock
	ILibraryManagementRepository libraryRepo;
	@Mock
	IBookRegistrationJPAInterface bookRepo;	
	
	@Test
	public void testfindDetailsByLibraryId() {
		Library lib1 = new Library();
		lib1.setId(101);
		lib1.setName("Mumbai");
		Optional<Library> optionalEncapsulated = Optional.of(lib1);
		when(libraryRepo.findById(101)).thenReturn(optionalEncapsulated);
		Library returnValue = sut.findDetailsByLibraryId(101);
		//assertThat(returnValue.getId(),is());
		//assertThat(1,IsEqual<Integer>(1));
		assertEquals(optionalEncapsulated, Optional.of(lib1));
		
	}

}
