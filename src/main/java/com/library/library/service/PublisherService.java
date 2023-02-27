package com.library.library.service;

import com.library.library.entity.Publisher;
import com.library.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Iterable<Publisher> getAll(){
        return publisherRepository.findAll();
    }
    public Publisher addPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void deletePublusher(Long id){
        publisherRepository.deleteById(id);
    }

}
