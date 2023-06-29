package com.ladera.utcl.vo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckVo {

    private Long truckId;

    @NotNull
    @Pattern(regexp = "^[A-Z|a-z]{2}\\s?[0-9]{1,2}\\s?[A-Z|a-z]{1,2}\\s?[0-9]{4}$",message = "invalid truck number")
    private String truckNumber;

}
