package br.erudio.service;

import br.erudio.Repository.EstudanteRepository;
import br.erudio.exception.hadler.ResourceNotFoundException;
import br.erudio.model.Estudante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstudanteService {

    private Logger logger = LoggerFactory.getLogger(EstudanteService.class);

    @Autowired
    EstudanteRepository repository;

    // Buscar Por Todos!
    public List<Estudante> buscarTodos(){
        return repository.findAll();
    }

    // Criando Estudante No Banco De Dados
    public Estudante create(Estudante estudante){
        return repository.save(estudante);
    }

    // Buscando Por Id
    public Estudante buscarId(UUID id){
       return  repository.findById(id).orElseThrow(() -> new
               RuntimeException("Estudante não Encontrado!"));
    }

    // Deletar Estudante
    public void delete(UUID id) {

        Estudante estudante = repository.findById(id).orElseThrow(() -> new
            ResourceNotFoundException("Estudante não Encontrado!"));

    repository.delete(estudante);
    }

    // Atualizar Estudante
    public Estudante atualizar(Estudante stude, UUID id){

        Estudante estudante = repository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Não Encontrado!"));

        estudante.setNome(stude.getNome());
        estudante.setIdade(stude.getIdade());
        estudante.setCor(stude.getCor());
      return repository.save(estudante);
      }


}
