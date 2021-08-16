package io.soumyadev.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Library")
public @Data class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;	
	String name;
	@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
	List<Book> collection;	
}
