package com.api.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bookstore.domain.Categoria;
import com.api.bookstore.domain.Livro;
import com.api.bookstore.repositories.CategoriaRepository;
import com.api.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Aventura", "Livro de Aventura");
		
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "O Silmarillion", "J.K Tolkien", "Lorem Ipsum", cat1);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1,l2));
	}
	
}
