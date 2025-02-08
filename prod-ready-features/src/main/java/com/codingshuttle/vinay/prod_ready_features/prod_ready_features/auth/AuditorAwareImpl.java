package com.codingshuttle.vinay.prod_ready_features.prod_ready_features.auth;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		// get security context
		//get authentication
		//get the principle
		//get the username
		return Optional.of("Vinay Singh Rawat");
	}

}
