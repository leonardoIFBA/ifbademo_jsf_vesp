package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Cargo;
import com.example.ifbademo.model.Funcionario;
import com.example.ifbademo.service.CargoService;
import com.example.ifbademo.service.DepartamentoService;
import com.example.ifbademo.service.FuncionarioService;

import lombok.*;

@Component
@Scope("view")
public class ConsultaFuncionarioBean {
    @Getter
    @Setter
    private List<Funcionario> funcionarios;

    @Getter @Setter
    private Funcionario funcionarioSelecionado;

    @Getter
    private List<Cargo> todosCargos;

    @Autowired
    private CargoService cargoService;
    @Autowired
    private FuncionarioService funcionarioService;

    @PostConstruct
    public void init(){
        funcionarios = funcionarioService.buscarTodos();
        todosCargos = cargoService.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        funcionarioService.excluir(funcionarioSelecionado.getId());
        context.addMessage(null, new FacesMessage("Exclusão", "Cargo excluído com sucesso."));
        
        funcionarios = funcionarioService.buscarTodos();
        
    }


}
