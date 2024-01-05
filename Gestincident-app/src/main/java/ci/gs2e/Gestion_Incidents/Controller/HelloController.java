package ci.gs2e.Gestion_Incidents.Controller;


import ci.gs2e.Gestion_Incidents.Dto.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloController {
    @GetMapping("/hello")
    public HelloResponse hello() {
        return new HelloResponse("Hello from JWT Authorization");
    }
}
