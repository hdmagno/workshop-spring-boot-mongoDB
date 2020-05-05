package com.hdmagno.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdmagno.workshopmongo.domain.Post;
import com.hdmagno.workshopmongo.repository.PostRepository;
import com.hdmagno.workshopmongo.services.exception.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
}
