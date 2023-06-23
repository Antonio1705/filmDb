package com.example.demo.ActorController;

import com.example.demo.Entity.Actor;
import com.example.demo.Service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActor(@PathVariable int id){
        return new ResponseEntity<>(actorService.getActor(id),HttpStatus.OK);
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
