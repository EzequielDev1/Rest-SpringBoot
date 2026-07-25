package br.erudio.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PersonDtoV1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Nome Obrigatorio")
    private String firstName;

    @NotBlank(message = "Adicione o sobrenome")
    private String lastName;

    @NotBlank(message = "Adicipone o endereço")
    private String address;

    @Email
    @NotNull
    private String email;

    @NotBlank(message = "Agenda")
    private String gender;

    @JsonIgnore
    private String password;

    @JsonFormat(pattern = "dd/mm/yyyy")
    @JsonProperty("Data_Nascimento")
    private String dataNasc;

}
