package com.github.prifiz.stuff.repository;

import com.github.prifiz.stuff.model.Stuff;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StuffRepository extends MongoRepository<Stuff, Long> {

    Optional<Stuff> findByNameAndManufacturerAndModel(String name, String manufacturer, String model);

}
