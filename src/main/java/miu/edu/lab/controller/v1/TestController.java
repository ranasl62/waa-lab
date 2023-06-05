package miu.edu.lab.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/exception")
    public void testException() {
        throw new RuntimeException("Testing exception handling");
    }
}
