package com.adingrt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gian_
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {
    private Integer idTarifa;
    private String tipoVehiculo;
    private String tipoTarifa;
    private Double montoTarifa;
}
