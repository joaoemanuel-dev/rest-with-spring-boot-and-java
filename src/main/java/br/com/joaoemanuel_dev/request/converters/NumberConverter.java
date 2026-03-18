package br.com.joaoemanuel_dev.request.converters;

import br.com.joaoemanuel_dev.exception.UnsupportedMathOperationException;

public class NumberConverter {

    // Tratamento do número
    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()){
            return false; // se for nulo ou vazio
        }
        String number = strNumber.replace(",", "."); // troca as ocorrências de , por .
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // se atender a essa regex (o que ela valida) retorna true
    }

    public static Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

}
