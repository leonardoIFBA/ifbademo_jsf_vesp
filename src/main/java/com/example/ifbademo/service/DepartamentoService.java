package com.example.ifbademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Departamento;
import com.example.ifbademo.repository.IDepartamentoRepository;
import java.util.*;

@Service
@Transactional(readOnly = true)
public class DepartamentoService {

    @Autowired
    private IDepartamentoRepository repository;

    @Transactional(readOnly = false)
    public void salvar(Departamento departamento) {
        repository.save(departamento);
    }

    @Transactional(readOnly = false)
    public void editar(Departamento departamento) {
        repository.save(departamento);
    }

    @Transactional(readOnly = false)
    public boolean excluir(Long id) {
        if (!departamentoTemCargo(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private boolean departamentoTemCargo(Long id) {
        if (buscarPorId(id).getCargos().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public Departamento buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    public List<Departamento> buscarTodos() {
        return repository.findAll();
    }

}
