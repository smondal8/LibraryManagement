package io.soumyadev.Model;

import lombok.Data;

@Data
public class AuthenticationRequest {
	private String username;
	private String password;
}
