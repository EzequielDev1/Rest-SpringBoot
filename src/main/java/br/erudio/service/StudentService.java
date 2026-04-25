package br.erudio.service;

import br.erudio.model.Person;
import br.erudio.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class StudentService {
    // Contador Automático
    private final AtomicLong counter = new AtomicLong();

    // Metodo De Enviar Dados(Tipo: System)
    private final Logger logger = Logger.getLogger(StudentService.class.getName());

    // Array De Students
    private  List<Student> students = new ArrayList<>();


    public Student BuscarPorId(String id) {

        logger.info("Finding One Student");

    return  students.stream()
            .filter(student -> student.getId().equals(Long.parseLong(id)))
            .findFirst()
            .orElse(null);
    }

    public Student create(Student student){
        logger.info("Creating one Student!");
        students.add(student);
        return student;
    }

    public List<Student> Listar(){
        logger.info("Listing Students");
        return students;
    }

    public Student atualizar(String id, Student student){
        logger.info("Updating Student");

        Student verification = BuscarPorId(id);

        if (verification != null){
            verification.setName(student.getName());
            verification.setAge(student.getAge());
        }
        return verification;
    }

    public void Delete(String id){
        logger.info("Deleting One Student");
        students.removeIf(student -> student.getId().equals(Long.parseLong(id)));

    }
}