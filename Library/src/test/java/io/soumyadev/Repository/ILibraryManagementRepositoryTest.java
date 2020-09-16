package io.soumyadev.Repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import io.soumyadev.Model.Library;

@DataJpaTest
class ILibraryManagementRepositoryTest {
	
	@Autowired
	private ILibraryManagementRepository repos;
	@Test
	void testcount() {
		long count = repos.count();
		assertEquals(2, count);
	}
	
	@Test
	void testfindById() {
		Optional<Library> item = repos.findById(101);
		Library lib = new Library();
		lib.setId(101);
		lib.setName("Mumbai");
		assertEquals(lib.getName(), item.get().getName());
	}

}
