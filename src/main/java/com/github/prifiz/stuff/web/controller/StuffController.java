package com.github.prifiz.stuff.web.controller;

import com.github.prifiz.stuff.web.request.ExtendedStuffCreationRequest;
import com.github.prifiz.stuff.web.request.MinimalStuffCreationRequest;
import com.github.prifiz.stuff.web.request.StuffPartialUpdateRequest;
import com.github.prifiz.stuff.web.request.StuffUpdateOrCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stuff")
public interface StuffController {

    @PostMapping(path = "/createSimple")
    @ResponseBody
    @Operation(description = "Adds minimal stuff")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully added"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Something went wrong"
            )
    })
    ResponseEntity<?> createMinimalStuff(@RequestBody MinimalStuffCreationRequest request);

    @PostMapping(path = "/createExtended")
    @ResponseBody
    ResponseEntity<?> createExtendedStuff(@RequestBody ExtendedStuffCreationRequest request);

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    ResponseEntity<?> deleteStuff(@PathVariable long id);

    @PatchMapping(path = "/{id}")
    @ResponseBody
    ResponseEntity<?> updateStuff(@PathVariable long id, @RequestBody StuffPartialUpdateRequest request);

    @PutMapping(path = "/{id}")
    @ResponseBody
    ResponseEntity<?> updateOrCreateStuff(@PathVariable long id, @RequestBody StuffUpdateOrCreateRequest request);

    @GetMapping(path = "/{id}")
    @ResponseBody
    ResponseEntity<?> getStuff(@PathVariable long id);
}
