package com.example.ifbademo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Funcionario;
import com.example.ifbademo.repository.IFuncionarioRepository;
import java.util.*;

@Service
public class FuncionarioService {
    @Autowired
    private IFuncionarioRepository repository;

    @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario){
        repository.save(funcionario);
    }

    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario){
        repository.save(funcionario);
    }

    @Transactional(readOnly = false)
    public void excluir(Long id){
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id){
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos(){
        return repository.findAll();
    }

    
}
