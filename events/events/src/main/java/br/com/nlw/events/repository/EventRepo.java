package br.com.nlw.events.repository;



import org.springframework.data.repository.CrudRepository;

import br.com.nlw.events.model.Event;
/*
 * O Repository serve para fazer essa conversa do sistema com o 
 * banco assim enviando as informações salvas no Model chegar no Banco MySQL,
 * ou seja convertendo os dados enviados por aqui em comandos feitos no Banco
 * */
public interface EventRepo extends CrudRepository<Event, Integer>{
	public Event findByPrettyName(String prettyname);
}
