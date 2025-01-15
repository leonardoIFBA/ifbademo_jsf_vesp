package com.example.ifbademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Cargo;
import com.example.ifbademo.repository.ICargoRepository;
import java.util.*;

@Service
@Transactional(readOnly = false)
public class CargoService {
    @Autowired
    private ICargoRepository repository;

    public void salvar(Cargo cargo){
        repository.save(cargo);
    }

    public void editar(Cargo cargo){
        repository.save(cargo);
    }

    public boolean excluir(Long id){
        if (! cargoTemFuncionario(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Transactional(readOnly = true)
    public boolean cargoTemFuncionario(Long id){
        if (buscarPorId(id).getFuncionarios().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id){
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos(){
        return repository.findAll();
    }
}
