package com.github.prifiz.stuff.repository;

import com.github.prifiz.stuff.model.Stuff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StuffRepository extends MongoRepository<Stuff, Long> {

}
