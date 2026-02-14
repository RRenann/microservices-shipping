package com.univas.sd.service_b;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/slow")
    public String slow(@RequestParam long ms) throws InterruptedException {
        Thread.sleep(ms);
        return "resposta lenta após " + ms + "ms";
    }
}
