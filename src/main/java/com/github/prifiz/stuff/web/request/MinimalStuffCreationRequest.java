package com.github.prifiz.stuff.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinimalStuffCreationRequest {

    private String name;
    private String manufacturer;
    private String model;
}
