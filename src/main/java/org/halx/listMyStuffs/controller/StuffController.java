package org.halx.listMyStuffs.controller;

import org.halx.listMyStuffs.repository.StuffRepository;
import org.halx.listMyStuffs.model.Stuff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://listMyStuffs.alexandrebarbez.com:8080")
@RestController
public class StuffController {

    private final StuffRepository repo;

    public StuffController(StuffRepository repo) {
        this.repo = repo;
    }

    //MultipleItems
    @GetMapping("/stuffs")
    List<Stuff> all(){
        return repo.findAll();
    }

    @PostMapping("/stuffs")
    Stuff newStuff(@RequestBody Stuff newStuff){
        return repo.save(newStuff);
    }

    //SingleItem
    @GetMapping("/stuffs/{id}")
    Stuff one(@PathVariable Long id){
        return repo.findById(id).orElseThrow(() -> new StuffNotFoundException(id));
    }

    @PutMapping("stuffs/{id}")
    Stuff replaceStuff(@RequestBody Stuff newStuff, @PathVariable Long id){

        return repo.findById(id)
                .map(stuff -> {
                    stuff.setNom(newStuff.getNom());
                    stuff.setDescription(newStuff.getDescription());
                    stuff.setQuantite(newStuff.getQuantite());
                    stuff.setPrix(newStuff.getPrix());
                    return repo.save(stuff);
                }).orElseGet(() -> {
                    newStuff.setId(id);
                    return repo.save(newStuff);
                });
    }

    @DeleteMapping("/stuffs/{id}")
    void deleteStuff(@PathVariable Long id) {
        repo.deleteById(id);
    }

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
//    @GetMapping("myStuffs")
//    public String listStuffs(){
//        return "myStuffs";
//    }
}
