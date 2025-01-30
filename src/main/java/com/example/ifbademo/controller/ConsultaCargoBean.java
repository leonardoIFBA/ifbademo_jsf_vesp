package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Cargo;
import com.example.ifbademo.service.*;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class ConsultaCargoBean {
    @Getter
    private List<Cargo> cargos;

    @Getter @Setter
    private Cargo cargoSelecionado;

    @Autowired
    private CargoService cargoService;

    @PostConstruct
    public void init(){
        cargos = cargoService.buscarTodos();
    }

    public void excluir(){
         FacesContext context = FacesContext.getCurrentInstance();
        //remove a nd do banco de dados
        if (cargoService.excluir(cargoSelecionado.getId())){
            context.addMessage(null, new FacesMessage("Exclusão", "Cargo excluído com sucesso."));
            //consultar();
            cargos = cargoService.buscarTodos();
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe Funcionário vinculado a este Cargo."));
        }
    }
    
}
