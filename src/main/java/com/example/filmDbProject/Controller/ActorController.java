package com.example.filmDbProject.Controller;

import com.example.filmDbProject.Entity.Actor;
import com.example.filmDbProject.Entity.ActorProjectionClass;
import com.example.filmDbProject.Entity.Film;
import com.example.filmDbProject.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/{id}")
    public ResponseEntity<ActorProjectionClass> getActor(@PathVariable int id){
        return new ResponseEntity<>(new ActorProjectionClass(actorService.getActor(id)),HttpStatus.OK);
    }

    @GetMapping("firstName/{name}")
    public ResponseEntity<List<Actor>> getActorByFirstName(@PathVariable String name){
        return new ResponseEntity<>(actorService.findByFirstName(name),HttpStatus.OK);
    }

    @GetMapping("lastName/{name}")
    public ResponseEntity<List<Actor>> getActorByLastName(@PathVariable String name){
        return new ResponseEntity<>(actorService.findByLastName(name),HttpStatus.OK);
    }

    @GetMapping("id/{id}/films")
    public ResponseEntity<List<Film>> getActorFilms(@PathVariable int id){
        return new ResponseEntity<>(actorService.getActor(id).getFilmList(),HttpStatus.OK);
    }

    @GetMapping("firstname/{firstname}/lastname/{lastname}/films")
    public ResponseEntity<List<Film>> getActorFilmsByFirstAndLastName(@PathVariable String firstname, @PathVariable String lastname){
        return new ResponseEntity<>(actorService.getActorByFirstAndLastName(firstname,lastname).getFilmList(),HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor){
        return new ResponseEntity<>(actorService.saveActor(actor),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor, @PathVariable int id){
        return new ResponseEntity<>(actorService.updateActor(id,actor),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        actorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}