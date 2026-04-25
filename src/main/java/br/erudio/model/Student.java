package br.erudio.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@NoArgsConstructor // Constructor Vazio
@AllArgsConstructor // Constructtor Com Dados

public class Student { private Long id;private String name;private Integer age;}
