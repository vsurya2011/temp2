package com.hibernate.crud.service;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.exception.DuplicateOwnerFoundException;
import com.hibernate.crud.exception.OwnerNotFoundException;

import java.util.List;

public interface OwnerService {

    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerFoundException;

    //OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;
    OwnerDTO findOwner(String ownerId) throws OwnerNotFoundException;

   // void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;
    void updatePetDetails(String ownerId, String petName) throws OwnerNotFoundException;

    //void deleteOwner(int ownerId) throws OwnerNotFoundException;
    void deleteOwner(String ownerId) throws OwnerNotFoundException;

    List<OwnerDTO> findAllOwners();
}