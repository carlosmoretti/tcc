package com.payment.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.payment.entity.EntityBase;
import com.payment.payment.service.ServiceBase;

public abstract class BaseController<E extends EntityBase, T> {
	
	abstract ServiceBase<E, T> getServiceBase(); 
	
	@GetMapping()
	private List<E> obterTodos() {
		return getServiceBase().obterTodos();
	}
	
	@GetMapping("/{id}")
	private E obter(@PathVariable("id") T id) {
		return getServiceBase().obter(id);
	}
	
	@PostMapping()
	private void adicionar(@RequestBody() E obj) {
		getServiceBase().cadastrar(obj);
	}
	
	@PutMapping()
	private void atualizar(@RequestBody() E obj) {
		getServiceBase().atualizar(obj);
	}
	
	@DeleteMapping()
	private void remover(@RequestBody() E obj) {
		getServiceBase().remover(obj);
	}
}
