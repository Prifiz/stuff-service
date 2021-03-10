package com.github.prifiz.stuff.web.converter;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.service.SequenceGeneratorService;
import com.github.prifiz.stuff.web.request.ExtendedStuffCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExtendedStuffCreationRequestToStuffConverter implements Converter<ExtendedStuffCreationRequest, Stuff> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Stuff convert(ExtendedStuffCreationRequest source) {
        return Stuff.builder()
                .id(sequenceGeneratorService.generateSequence(Stuff.SEQUENCE_NAME))
                .manufacturer(source.getManufacturer())
                .model(source.getModel())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
