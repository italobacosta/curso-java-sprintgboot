package br.com.italobacosta.controllers;

import br.com.italobacosta.exception.UnsupportedMathOperationException;
import br.com.italobacosta.math.SimpleMath;
import br.com.italobacosta.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();
    // http://localhost:8080/math/sum/10/20
    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }
    // http://localhost:8080/math/subtraction/10/20
    @GetMapping(value = "/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/multiplication/10/20
    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/division/10/20
    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/mean/10/20
    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }

    // http://localhost:8080/math/squareRoot/20
    @GetMapping(value = "/squareRoot/{numberOne}")
    public Double squareRoot(
            @PathVariable("numberOne") String numberOne
            ) throws UnsupportedMathOperationException {
        if(NumberConverter.isNumeric(numberOne)) {
            double number = NumberConverter.convertToDouble(numberOne);
            return math.squareRoot(number);
        } else{
            throw new UnsupportedMathOperationException("Please set a number value");
        }
    }
}
