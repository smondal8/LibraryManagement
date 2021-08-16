package io.soumyadev.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Book")
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;	
	String name;
	String author;
	
}
