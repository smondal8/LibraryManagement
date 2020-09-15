package io.soumyadev.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import io.soumyadev.Repository.IBookRegistrationJPAInterface;
import io.soumyadev.Repository.ILibraryManagementRepository;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import io.soumyadev.Model.Library;
import io.soumyadev.Services.LibraryRegistrationService;


@WebMvcTest(LibraryManagementController.class)
public class LibraryManagementControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private LibraryRegistrationService libraryRegistrationService;
	@MockBean
	private ILibraryManagementRepository mockILibraryManagementRepository;
	@MockBean
	private IBookRegistrationJPAInterface mockIBookRegistrationJPAInterface;
	@Test
	public void testgetLibraryAll() throws Exception {
		Library lib1 = new Library();
		Library lib2 = new Library();
		lib1.setName("Mumbai");
		lib2.setName("Bangalore");
		lib1.setId(101);
		lib2.setId(102);
		List<Library> listBook = new ArrayList<>();
		listBook.add(lib1);
		listBook.add(lib2);
		when(libraryRegistrationService.getAll()).thenReturn(listBook);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/library/listAll")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())		
		.andReturn();
		JSONAssert.assertEquals("[{\"id\":101,\"name\":\"Mumbai\",\"collection\":null},{\"id\":102,\"name\":\"Bangalore\",\"collection\":null}]", result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testgetLibraryDetails() throws Exception {
		Library lib1 = new Library();
		Library lib2 = new Library();
		lib1.setName("Mumbai");
		lib2.setName("Bangalore");
		lib1.setId(101);
		lib2.setId(102);
		List<Library> listBook = new ArrayList<>();
		listBook.add(lib1);
		listBook.add(lib2);
		when(libraryRegistrationService.findDetailsByLibraryId(101)).thenReturn(lib1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/library/{id}",101)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andReturn();
		JSONAssert.assertEquals("{\"id\":101,\"name\":\"Mumbai\",\"collection\":null}", result.getResponse().getContentAsString(), false);
	}
}
