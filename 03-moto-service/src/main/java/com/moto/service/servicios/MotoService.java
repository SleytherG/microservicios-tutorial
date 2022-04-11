package com.moto.service.servicios;

import com.moto.service.entidades.Moto;
import com.moto.service.repositorio.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    @Autowired
    public MotoRepository motoRepository;

    public List<Moto> getAll() {
        return motoRepository.findAll();
    }


    public Moto getMotoById(Integer id) {
        return motoRepository.findById(id).orElse(null);
    }

    public Moto save(Moto moto) {
        Moto nuevaMoto = motoRepository.save(moto);
        return nuevaMoto;
    }

    public List<Moto> byUsuarioId(Integer usuarioId) {
        return motoRepository.findByUsuarioId(usuarioId);
    }
}
