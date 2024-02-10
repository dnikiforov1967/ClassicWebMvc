package org.example;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class EasyRest
        implements IEasyRest
{

    @PostMapping("/easy")
    //No constrain declare
    public Integer easy(@RequestBody Horse horse, @RequestParam(required = false) Integer paramA) {
        return paramA;
    }
}
