package com.github.prifiz.stuff.web.controller;

import com.github.prifiz.stuff.model.Stuff;
import com.github.prifiz.stuff.service.StuffNotFoundException;
import com.github.prifiz.stuff.service.StuffService;
import com.github.prifiz.stuff.web.converter.*;
import com.github.prifiz.stuff.web.request.*;
import com.github.prifiz.stuff.web.response.StuffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class StuffControllerImpl implements StuffController {

    private final MinimalStuffCreationRequestToStuffConverter minimalStuffCreationRequestToStuffConverter;
    private final ExtendedStuffCreationRequestToStuffConverter extendedStuffCreationRequestToStuffConverter;
    private final StuffPartialUpdateRequestToStuffConverter stuffPartialUpdateRequestToStuffConverter;
    private final StuffUpdateOrCreateRequestToStuffConverter stuffUpdateOrCreateRequestToStuffConverter;
    private final StuffToStuffResponseConverter stuffToStuffResponseConverter;
    private final StuffSearchByFieldsRequestToStuffConverter stuffSearchByFieldsRequestToStuffConverter;

    private final StuffService stuffService;

    @Override
    public ResponseEntity<?> createMinimalStuff(MinimalStuffCreationRequest request) {
        stuffService.create(minimalStuffCreationRequestToStuffConverter.convert(request));
        return ResponseEntity.ok("Successfully created");
    }

    @Override
    public ResponseEntity<?> createExtendedStuff(ExtendedStuffCreationRequest request) {
        stuffService.create(extendedStuffCreationRequestToStuffConverter.convert(request));
        return ResponseEntity.ok("Successfully created");
    }

    @Override
    public ResponseEntity<?> deleteStuff(long id) {
        stuffService.delete(id);
        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public ResponseEntity<?> updateStuff(long id, StuffPartialUpdateRequest request) {
        try {
            Stuff result = stuffService.update(id, stuffPartialUpdateRequestToStuffConverter.convert(request));
            return ResponseEntity.ok("Updated");
        } catch (StuffNotFoundException ex) {
            return new ResponseEntity<>("Couldn't update stuff", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> updateOrCreateStuff(long id, StuffUpdateOrCreateRequest request) {
        stuffService.updateOrCreate(id, stuffUpdateOrCreateRequestToStuffConverter.convert(request));
        return ResponseEntity.ok("Successfully updated");
    }

    @Override
    public ResponseEntity<?> getStuffById(long id) {
        try {
            Stuff stuff = stuffService.find(id);
            StuffResponse response = stuffToStuffResponseConverter.convert(stuff);
            return ResponseEntity.ok(Objects.requireNonNull(response));
        } catch (StuffNotFoundException ex) {
            return new ResponseEntity<>("Couldn't find stuff", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public StuffResponse getStuff(String name, String manufacturer, String model)
            throws StuffNotFoundException {
        Stuff stuff = stuffService.findStuff(name, manufacturer, model);
        return stuffToStuffResponseConverter.convert(stuff);
    }

    // TODO
    /*
     tests
     */

}
