package io.soumyadev.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Library")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;	
	String name;
	@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
	List<Book> collection;
	public List<Book> getCollection() {
		return collection;
	}
	public void setCollection(List<Book> collection) {
		this.collection = collection;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
