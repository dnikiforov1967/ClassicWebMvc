package org.example;

import org.springframework.web.bind.annotation.*;


@RestController
public class EasyRest
        implements IEasyRest
{

    @PostMapping("/easy")
    //No constrain declare
    public Integer easy(@RequestBody Horse horse, @RequestParam Integer paramA) {
        return paramA;
    }
}
