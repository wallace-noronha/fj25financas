package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDao dao = new ContaDao(manager);
		
		Conta conta = new Conta();
		conta.setTitular("Wallace");
		conta.setBanco("Bradesco");
		conta.setAgencia("0123");
		conta.setNumero("123456-6");
		
		manager.getTransaction().begin();
		
		dao.salva(conta);
		
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Conta gravada com sucesso");
		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) + "ms");
	}
	
}
