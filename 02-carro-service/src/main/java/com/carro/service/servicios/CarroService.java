package com.carro.service.servicios;

import com.carro.service.entidades.Carro;
import com.carro.service.repositorio.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;


    public List<Carro> getAll() {
        return carroRepository.findAll();
    }


    public Carro getCarroById(Integer id) {
        return carroRepository.findById( id ).orElse( null );
    }

    public Carro save(Carro carro) {
        Carro nuevoCarro = carroRepository.save( carro );
        return nuevoCarro;
    }

    public List<Carro> byUsuarioId(Integer usuarioId) {
        return carroRepository.findByUsuarioId( usuarioId );
    }



}
