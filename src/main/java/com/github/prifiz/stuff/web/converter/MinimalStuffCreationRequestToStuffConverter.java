package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.service.SequenceGeneratorService;
import com.github.prifiz.stuff.web.request.MinimalStuffCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MinimalStuffCreationRequestToStuffConverter implements Converter<MinimalStuffCreationRequest, Stuff> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Stuff convert(MinimalStuffCreationRequest source) {
        return Stuff.builder()
                .id(sequenceGeneratorService.generateSequence(Stuff.SEQUENCE_NAME))
                .name(source.getName())
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .build();
    }
}
