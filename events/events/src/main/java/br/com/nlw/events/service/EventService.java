package br.com.nlw.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.repository.EventRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	public Event addNewEvent(Event event) {		
		/* 
		 * Gerando o pretty name
		 * pegando o titulo = Augusto Events Time
		 * e retirando os espaços por - e transformando o titulo em minusculo.
		 * */
		event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
		return eventRepo.save(event);
	}
	
	public List<Event> getAllEvents(){
		return (List<Event>)eventRepo.findAll();
	}
	
	public Event getByPrettyName(String prettyname) {
		return eventRepo.findByPrettyName(prettyname);
		
	}
	
}
