package org.example;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class EasyGetRest
        implements IEasyGetRest
{

    @GetMapping("/easy")
    public Integer getExample(@RequestParam(required = false) Integer param) {
        return param;
    }
}
