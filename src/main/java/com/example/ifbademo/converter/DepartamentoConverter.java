package com.example.ifbademo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.example.ifbademo.model.Departamento;
import com.example.ifbademo.service.DepartamentoService;

@Component
@ApplicationScope
@FacesConverter(value = "departamentoConverter")
public class DepartamentoConverter implements Converter{

    //Cria uma instancia do service para ter acesso ao metodo porId
    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Departamento retorno = null;

        //if(valor != null && !"".equals(valor)){
        if(value != null && ! value.isEmpty()){
            retorno = departamentoService.buscarPorId(Long.valueOf(value));
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if(o != null){
            Departamento depto = (Departamento) o;
            return depto.getId() == null ? null : depto.getId().toString();
        }
        return null;
    }
    
}

