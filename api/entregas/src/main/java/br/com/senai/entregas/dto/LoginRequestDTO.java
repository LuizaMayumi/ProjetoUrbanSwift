package br.com.senai.entregas.dto;

import lombok.Data;

@Data
// Ja cria getter, setter e construtor como obrigatorios
public class LoginRequestDTO {

    private String email;
    private String senha;
}
