package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.web.request.StuffSearchByFieldsRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StuffSearchByFieldsRequestToStuffConverter implements Converter<StuffSearchByFieldsRequest, Stuff> {

    @Override
    public Stuff convert(StuffSearchByFieldsRequest source) {
        return Stuff.builder()
                .name(source.getName())
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .build();
    }
}
