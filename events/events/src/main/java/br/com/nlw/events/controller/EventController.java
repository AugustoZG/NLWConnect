package br.com.nlw.events.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.nlw.events.model.Event;
import br.com.nlw.events.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService service;
	
	/*
	 * Função para fazer o post/envio do novo evento para
	 * o sistema salvar no banco de dados 
	*/
	@PostMapping("/events")
	public Event addNewEvent(@RequestBody Event newEvent) {
		return service.addNewEvent(newEvent);
	}
	
	/*
	 * Nesta função é chamado todos os eventos já criados 
	 * e com suas respectivas informações
	*/
	@GetMapping("/events")
	public List<Event> getAllEvents(){
		return service.getAllEvents();
	}
	
	/* Nesta função ele retorna caso encontre o prettyname ou seja 
	 * o nome do evento e retorna, mas caso não 
	 * encontre ele entrega um notFound 404
	*/
	@GetMapping("/events/{prettyName}")
	public ResponseEntity<Event> getEventByPrettyName(@PathVariable String prettyName) {
		Event evt = service.getByPrettyName(prettyName); 
		if(evt != null) {
			return ResponseEntity.ok().body(evt);
		}
		return ResponseEntity.notFound().build(); 
	}
}
