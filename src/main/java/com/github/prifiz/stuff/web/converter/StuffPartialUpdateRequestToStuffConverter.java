package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.web.request.StuffPartialUpdateRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StuffPartialUpdateRequestToStuffConverter
        implements Converter<StuffPartialUpdateRequest, Stuff> {

    @Override
    public Stuff convert(StuffPartialUpdateRequest source) {
        return Stuff.builder()
                .name(source.getName())
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .description(source.getDescription())
                .build();
    }
}
