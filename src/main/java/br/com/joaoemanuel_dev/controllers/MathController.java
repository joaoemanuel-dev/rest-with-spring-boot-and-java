package br.com.joaoemanuel_dev.controllers;

import br.com.joaoemanuel_dev.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne, // pega da url e salva aqui
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // Tratamento do número
    private static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()){
            return false; // se for nulo ou vazio
        }
        String number = strNumber.replace(",", "."); // troca as ocorrências de , por .
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // se atender a essa regex (o que ela valida) retorna true
    }

    private static Double convertToDouble(String strNumber) throws IllegalArgumentException{
        if(strNumber == null || strNumber.isEmpty()){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

}
