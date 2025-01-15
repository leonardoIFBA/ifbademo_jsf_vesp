package com.example.ifbademo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ifbademo.model.Funcionario;

public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>{
    // Pesquisa por nome de funcionario
    public Funcionario findByNome(String nome);

    //pesquisa por salario
    public Funcionario findBySalario(BigDecimal salario);

    public Funcionario findByNomeAndSalario(String nome, BigDecimal salario);

    public List<Funcionario> findBySalarioBetween(BigDecimal ini, BigDecimal fim);

    
}
