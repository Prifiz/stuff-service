package com.github.prifiz.stuff.web.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class StuffResponse {

    private String name;
    private String manufacturer;
    private String model;
    private String description;
}
