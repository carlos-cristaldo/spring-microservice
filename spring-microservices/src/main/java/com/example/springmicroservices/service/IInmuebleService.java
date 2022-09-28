package com.example.springmicroservices.service;

import com.example.springmicroservices.model.InmuebleEntity;

import java.util.List;

public interface IInmuebleService{

    InmuebleEntity saveInmueble(InmuebleEntity inmueble);

    void deleteInmueble(Long id);

    List<InmuebleEntity> getAllInmuebles();

}
