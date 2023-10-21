package hr.kingict.springbootakademija2023_2.controller;

import hr.kingict.springbootakademija2023_2.dto.VegetableDto;
import hr.kingict.springbootakademija2023_2.form.VegetableForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class TestController {

    @GetMapping(value = "/vegetables")
    public ResponseEntity<List<String>> getVegetables() {
        return ResponseEntity
                .ok()
                .header("moj header", "bla bla")
                .body(Arrays.asList("Jabuke", "Kruške"));
    }

    @GetMapping(value = "vegetables/{sifra}")
    public ResponseEntity<String> getVegetable(@PathVariable String sifra) {

        if (sifra == null) {
            return ResponseEntity
                    .badRequest()
                    .build();
        }

        if (sifra.equalsIgnoreCase("MRK")) {
            return ResponseEntity
                    .ok()
                    .body("Mrkva");
        }

        return ResponseEntity
                .badRequest()
                .build();

    }

    @PostMapping(value = "/vegetables")
    public ResponseEntity<VegetableDto> saveVegetable(@RequestBody @Valid VegetableForm vegetableForm) {

        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setName(vegetableForm.getName());
        vegetableDto.setColor(vegetableForm.getColor());
        vegetableDto.setOrganic(vegetableForm.getOrganic());

        return ResponseEntity
                .ok()
                .body(vegetableDto);
    }
}
