package com.hibernate.crud.repository;

import com.hibernate.crud.entity.Owner;
import java.util.List;
import java.util.UUID;

public interface OwnerRepository {

    void saveOwner(Owner owner);

   // Owner findOwner(int ownerId);
    Owner findOwner(UUID ownerId);

   // void updatePetDetails(int ownerId, String petName);
    void updatePetDetails(UUID ownerId, String petName);

   // void deleteOwner(int ownerId);
    void deleteOwner(UUID ownerId);

    List<Owner> findAllOwners();
}