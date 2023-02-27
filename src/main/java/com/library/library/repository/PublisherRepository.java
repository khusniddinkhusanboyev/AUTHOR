package com.library.library.repository;

import com.library.library.entity.Publisher;
import com.sun.jdi.LongValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
