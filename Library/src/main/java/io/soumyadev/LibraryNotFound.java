package io.soumyadev;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LibraryNotFound extends RuntimeException {
	public LibraryNotFound(String message) {
		super(message);
	}

}
