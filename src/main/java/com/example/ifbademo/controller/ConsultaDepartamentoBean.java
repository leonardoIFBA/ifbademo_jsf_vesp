package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Departamento;
import com.example.ifbademo.service.DepartamentoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaDepartamentoBean {
    @Getter
    private List<Departamento> departamentos;

    @Getter @Setter
    private Departamento deptoSelecionado;

    @Autowired
    private DepartamentoService departamentoService;

    @PostConstruct
    public void init(){
        departamentos = departamentoService.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a nd do banco de dados
        if (departamentoService.excluir(deptoSelecionado.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Cargo excluído com sucesso."));
            //consultar();
            departamentos = departamentoService.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Cargo vinculado a este Departamento."));
        }
    }
    
}
