package insper.com.pf.controller; // Ajuste para o pacote real

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Backend funcionando na AWS EC2!";
    }
}