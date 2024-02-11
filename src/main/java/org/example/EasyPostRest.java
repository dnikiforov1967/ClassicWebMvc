package org.example;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class EasyPostRest
        implements IEasyPostRest
{
    @PostMapping("/easy")
    public String postExample(@RequestBody(required = false) Body2Pass body) {
        return body.getName();
    }

}
