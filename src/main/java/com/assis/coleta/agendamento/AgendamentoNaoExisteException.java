package com.assis.coleta.agendamento;

@org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
public class AgendamentoNaoExisteException extends RuntimeException {
    public AgendamentoNaoExisteException(Integer agendamentoId) {
        super("Agendamento não existe " + agendamentoId);
    }
}


@org.springframework.web.bind.annotation.ResponseStatus(value = org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY)
class AgendamentoJaAssociadoException extends RuntimeException {
    public AgendamentoJaAssociadoException(Integer agendamentoId) {
        super("Agendamento ja esta com outro coletor " + agendamentoId);
    }
}
