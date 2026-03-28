package com.hibernate.crud;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.service.OwnerService;
import com.hibernate.crud.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    private OwnerService ownerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public App(OwnerService ownerService){
        this.ownerService=ownerService;
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            do {
                System.out.println("Welcome to Petistaan");
                int menuOption = InputUtil.acceptMenuOption(sc);
                switch (menuOption) {
                    case 1:
                        OwnerDTO ownerDTO = InputUtil.acceptOwnerDetailsToSave(sc);
                        ownerService.saveOwner(ownerDTO);
                        LOGGER.info("Owner has been saved successfully.");
                        break;
                    case 2:
                        String ownerId = String.valueOf(InputUtil.acceptOwnerIdToOperate(sc));
                        ownerDTO = ownerService.findOwner(ownerId);
                        LOGGER.info("Owner has been fetched successfully{}",ownerDTO);

                        break;
                    case 3:
                        ownerId = InputUtil.acceptOwnerIdToOperate(sc);
                        String petName = InputUtil.acceptPetDetailsToUpdate(sc);
                        ownerService.updatePetDetails(ownerId, petName);
                        LOGGER.info("Pet details of owner have been updated successfully.");
                        break;
                    case 4:
                        ownerId = InputUtil.acceptOwnerIdToOperate(sc);
                        ownerService.deleteOwner(ownerId);
                        LOGGER.info("Owner has been deleted successfully.");
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList = ownerService.findAllOwners();
                        ownerDTOList.forEach(owner->{
                            LOGGER.info("Owner Details {}",owner);
                        });

                        break;
                    default:
                        LOGGER.info("Invalid option entered.");
                }
            } while (InputUtil.wantToContinue(sc));

        } catch (Exception exception) {
            LOGGER.info(exception.getMessage());
        }
    }


}