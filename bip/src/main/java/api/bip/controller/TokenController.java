package api.bip.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api.bip.flows.AuthService;

@RestController
@RequestMapping("/api")
public class TokenController {

    private AuthService authService;

    @GetMapping("/token")
    public ResponseEntity<String> getTokenEfi() {
        try {
            String token = authService.getTokenEfi();
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao obter o token: " + e.getMessage());
        }
    }
}