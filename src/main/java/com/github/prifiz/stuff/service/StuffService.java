package com.github.prifiz.stuff.service;

import com.github.prifiz.stuff.model.Stuff;
import org.springframework.web.bind.annotation.RequestParam;

public interface StuffService {

    Stuff create(Stuff stuff);

    void delete(long id);

    Stuff update(long id, Stuff stuff) throws StuffNotFoundException;

    Stuff updateOrCreate(long id, Stuff stuff);

    Stuff find(long id) throws StuffNotFoundException;

    Stuff findStuff(String name, String manufacturer, String model) throws StuffNotFoundException;
}
