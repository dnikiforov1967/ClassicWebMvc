package org.example;

import org.springframework.web.bind.annotation.*;


@RestController
public class EasyRest
        implements IEasyRest
{

    @PostMapping("/easy")
    //No constrain declare
    public Integer easy(@RequestBody(required = false) Horse horse, @RequestParam(required = false) Integer paramA) {
        return paramA;
    }
}
