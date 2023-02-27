package com.library.library.service;

import com.library.library.entity.Author;
import com.library.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> getAll(){
       return authorRepository.findAll();
    }
    public Author add(Author  author){
       return authorRepository.save(author);
    }
    public void delete(Long id){
       authorRepository.deleteById(id);
    }

   public void updateAuthor(Author author){
        authorRepository.save(author);
   }

   public Optional<Author> finByID(Long id){
       return authorRepository.findById(id);

   }
}
