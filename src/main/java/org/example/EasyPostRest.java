package org.example;

import org.springframework.web.bind.annotation.*;


@RestController
public class EasyPostRest
        implements IEasyPostRest
{
    @PostMapping("/easy")
    public String postExample(@RequestBody Body2Pass body) {
        return body.getName();
    }

}
