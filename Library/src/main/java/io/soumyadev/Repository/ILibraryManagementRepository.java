package io.soumyadev.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import io.soumyadev.Model.Library;
import io.soumyadev.Model.User;

public interface ILibraryManagementRepository extends JpaRepository<Library,Integer>{
	Optional<Library> findById(int id);
	
}
