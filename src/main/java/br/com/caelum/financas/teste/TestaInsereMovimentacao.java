package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Conta de Luz - abril/2010");
		movimentacao.setValor(BigDecimal.valueOf(50.0));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		
		manager.close();
	}
	
}
