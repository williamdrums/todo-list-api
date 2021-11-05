package com.wlnascimento.todolist.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemCampo {
    private String nome;
    private String mensagem;
}
