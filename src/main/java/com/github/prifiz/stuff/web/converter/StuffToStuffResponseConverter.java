package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.web.response.StuffResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StuffToStuffResponseConverter implements Converter<Stuff, StuffResponse> {
    @Override
    public StuffResponse convert(Stuff source) {
        return StuffResponse.builder()
                .name(source.getName())
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .description(source.getDescription())
                .build();
    }
}
