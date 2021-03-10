package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.web.request.StuffUpdateOrCreateRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StuffUpdateOrCreateRequestToStuffConverter implements Converter<StuffUpdateOrCreateRequest, Stuff> {

    @Override
    public Stuff convert(StuffUpdateOrCreateRequest source) {
        return Stuff.builder()
                .name(source.getName())
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .description(source.getDescription())
                .build();
    }
}
