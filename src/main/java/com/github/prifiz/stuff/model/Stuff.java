package com.github.prifiz.stuff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stuff", value = "stuff")
@AllArgsConstructor
@Data
@Builder
@Setter
public class Stuff {

    @Transient
    public static final String SEQUENCE_NAME = "stuff_sequence";

    @Id
    private Long id;

    private String name;
    private String manufacturer;
    private String model;
    private String description;

}
