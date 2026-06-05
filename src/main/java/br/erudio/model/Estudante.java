package br.erudio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table

public class Estudante implements Serializable{

    private static final Long idImplementado = 1L;
    @Id
    @UuidGenerator
    private UUID id;

    @Column(nullable = false, length = 30 )
    private String nome;
    @Column(nullable = false, length = 3 )
    private int idade;
    @Column(nullable = false, length = 25 )
    private String cor;
    
}
