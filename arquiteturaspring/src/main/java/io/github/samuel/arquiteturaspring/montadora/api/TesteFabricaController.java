package io.github.samuel.arquiteturaspring.montadora.api;


import io.github.samuel.arquiteturaspring.montadora.CarroStatus;
import io.github.samuel.arquiteturaspring.montadora.Chave;
import io.github.samuel.arquiteturaspring.montadora.HondaHRV;
import io.github.samuel.arquiteturaspring.montadora.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carro")
public class TesteFabricaController {

    @Autowired
    @Turbo
    private Motor motorTurbo;

    @Autowired
    @Eletrico
    private Motor motorEletrico;

    @Autowired
    @Aspirado
    private Motor motorAspirado;

    @PostMapping
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        var carro = new HondaHRV(motorEletrico);
        return carro.darIgnicao(chave);
    }
}
