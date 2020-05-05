package com.hdmagno.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdmagno.workshopmongo.domain.User;
import com.hdmagno.workshopmongo.dto.UserDTO;
import com.hdmagno.workshopmongo.repository.UserRepository;
import com.hdmagno.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
}
