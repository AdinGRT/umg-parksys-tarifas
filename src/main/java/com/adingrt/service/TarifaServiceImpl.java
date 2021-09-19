package com.adingrt.service;

import com.adingrt.datos.TarifaDao;
import com.adingrt.model.Tarifa;
import java.util.List;

/**
 *
 * @author gian_
 */
public class TarifaServiceImpl implements TarifaService {
    
    TarifaDao tarifaDao = new TarifaDao();
    private List<Tarifa> listar = tarifaDao.listarTodo();
    
    @Override
    public int actualizar(Tarifa t) {
        return tarifaDao.actualizarTarifa(t);
    }

    @Override
    public List<Tarifa> listarTodo() {
        return listar;
    }

    @Override
    public Tarifa buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
