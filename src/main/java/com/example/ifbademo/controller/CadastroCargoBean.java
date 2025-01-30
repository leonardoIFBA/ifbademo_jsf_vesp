package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Cargo;
import com.example.ifbademo.model.Departamento;
import com.example.ifbademo.service.CargoService;
import com.example.ifbademo.service.DepartamentoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroCargoBean {
    @Getter @Setter
    private Cargo cargo = new Cargo();

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;
    @Getter
    private List<Departamento> todosDepartamentos;

    @PostConstruct
    public void init(){
        todosDepartamentos = departamentoService.buscarTodos();
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance();
        cargoService.salvar(cargo);
        //Prepara para cadastrar um novo lancamento
        cargo = new Cargo();

        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado.",
                "Cargo cadastrado com sucesso.");
        context.addMessage(null, mensagem);
             
    }

    public void prepararCadastro(){
        cargo = cargoService.buscarPorId(cargo.getId());
    }
    
}
