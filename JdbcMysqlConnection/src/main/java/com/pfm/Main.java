package main.java.com.pfm;

import main.java.com.pfm.services.CrudService;

public class Main {
    public static void main(String[] args) {

            CrudService crudService = new CrudService();
            crudService.createUser("Ruben", "Ruben@gmail.com", "1234567342");

            crudService.getUser(20);


        }
    }

