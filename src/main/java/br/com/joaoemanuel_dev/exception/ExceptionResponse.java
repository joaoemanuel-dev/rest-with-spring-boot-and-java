package br.com.joaoemanuel_dev.exception;

import java.util.Date;

// Estrutura do JSON que vai retornar o erro
public record ExceptionResponse(Date timestamp, String message, String details) {

}
