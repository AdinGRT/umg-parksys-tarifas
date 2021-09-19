package com.adingrt.service;

import com.adingrt.model.Tarifa;
import java.util.List;

/**
 *
 * @author gian_
 */
public interface TarifaService {
    int actualizar(Tarifa t);
    List<Tarifa> listarTodo();
    Tarifa buscarPorId(Integer id);
}
