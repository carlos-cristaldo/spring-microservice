package com.example.springmicroservices.service.impl;

import com.example.springmicroservices.model.InmuebleEntity;
import com.example.springmicroservices.repository.IInmuebleRepository;
import com.example.springmicroservices.service.IInmuebleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImpl implements IInmuebleService {

    private final IInmuebleRepository inmuebleRepository;

    public InmuebleServiceImpl(IInmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public InmuebleEntity saveInmueble(InmuebleEntity inmueble){

        inmueble.setFechaCreacion(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);

    }

    @Override
    public void deleteInmueble(Long id){
        inmuebleRepository.deleteById(id);
    }

    @Override
    public List<InmuebleEntity> getAllInmuebles(){
        return inmuebleRepository.findAll();
    }
}
