package io.soumyadev.Model;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class AuthenticationResponse {
	private String token;
	
}
