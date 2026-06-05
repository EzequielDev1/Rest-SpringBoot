package br.erudio.Repository;

import br.erudio.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstudanteRepository extends JpaRepository<Estudante, UUID> {


}
