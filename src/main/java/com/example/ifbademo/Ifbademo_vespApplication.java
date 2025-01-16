package com.example.ifbademo;


import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

/*import com.example.ifbademo.model.Cargo;
import com.example.ifbademo.model.Departamento;
import com.example.ifbademo.model.Endereco;
import com.example.ifbademo.model.Funcionario;
import com.example.ifbademo.model.UF;
import com.example.ifbademo.service.CargoService;
import com.example.ifbademo.service.DepartamentoService;
import com.example.ifbademo.service.FuncionarioService;*/
import com.example.ifbademo.util.ViewScope;
import com.google.common.collect.ImmutableMap;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;



@SpringBootApplication
public class Ifbademo_vespApplication implements ServletContextAware {

	public static void main(String[] args) {
		SpringApplication.run(Ifbademo_vespApplication.class, args);
	}

	@Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
        return configurer;
    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new FacesServlet(), "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        // Iniciar el contexto de JSF
        // http://stackoverflow.com/a/25509937/1199132
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
    }



	//obtem uma saída para o console

	/*@Bean
	//public CommandLineRunner demo(Departamentos dep) {
	public CommandLineRunner demo(DepartamentoService depService, 
				CargoService carService, FuncionarioService funService) {
		return (args) -> {
			Departamento d = new Departamento();
			d.setNome("Tecnologia da Informação");
			depService.salvar(d);
			System.out.println(depService.buscarTodos());
			
			Cargo c = new Cargo();
			c.setNome("Programador Java Jr");
			c.setDepartamento(d);
			carService.salvar(c);
			System.out.println(carService.buscarTodos());

			Endereco e = new Endereco();
			e.setLogradouro("Rua A");
			e.setNumero(10);
			e.setBairro("Centro");
			e.setCep("46100000");
			e.setComplemento("casa");
			e.setCidade("Brumado");
			e.setUf(UF.BA);

			Funcionario f = new Funcionario();
			f.setNome("leonardo");
			f.setDataEntrada(LocalDate.now());
			f.setSalario(new BigDecimal("1000.00"));
			f.setEndereco(e);
			funService.salvar(f);
		};
	}*/

}
