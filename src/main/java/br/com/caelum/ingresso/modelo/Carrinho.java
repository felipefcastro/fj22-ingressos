package br.com.caelum.ingresso.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.com.caelum.ingresso.model.Ingresso;


@Component
@SessionScope
public class Carrinho {
	
	private List<Ingresso> ingressos = new ArrayList<>();
	
	public void add(Ingresso ingresso){
		ingressos.add(ingresso);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	
	

}
