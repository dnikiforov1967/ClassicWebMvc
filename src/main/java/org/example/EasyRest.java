package org.example;

import org.springframework.web.bind.annotation.*;


@RestController
public class EasyRest
        implements IEasyRest
{
    @PostMapping("/easy")
    public String postExample(@RequestBody Body2Pass body) {
        return body.getName();
    }

    @GetMapping("/easy")
    public Integer getExample(@RequestParam Integer param) {
        return param;
    }
}
