package org.halx.listMyStuffs.controller;

public class StuffNotFoundException extends RuntimeException {
    public StuffNotFoundException(Long id) {
        super("Objet n°"+id+" non trouvé.");
    }
}