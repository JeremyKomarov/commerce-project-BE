package commerce.commerce.service;

import commerce.commerce.security.model.AuthenticationRequest;
import commerce.commerce.security.model.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception;
}