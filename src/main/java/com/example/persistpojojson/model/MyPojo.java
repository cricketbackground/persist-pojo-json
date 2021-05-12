package com.example.persistpojojson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MyPojo {

    private LocalDate nextDeliveryDate;

    @Builder.Default
    private Boolean skipDelivery = Boolean.FALSE;

}
