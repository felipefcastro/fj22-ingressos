package br.com.caelum.ingresso.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import br.com.caelum.ingresso.model.Compra;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;


@Component
@SessionScope
public class Carrinho {
	
	private List<Ingresso> ingressos = new ArrayList<>();
	
	public void add(Ingresso ingresso){
		ingressos.add(ingresso);
	}
	
	public Compra toCompra(){
		return new Compra(ingressos);
	}
	
	
	

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	
	
	public boolean isSelecionado(Lugar lugar){
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}
	
	public BigDecimal getTotal(){
		return ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

}
