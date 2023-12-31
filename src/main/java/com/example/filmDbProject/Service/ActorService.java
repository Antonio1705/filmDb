package com.example.filmDbProject.Service;

import com.example.filmDbProject.Entity.Actor;

import java.util.List;

public interface ActorService {

    Actor getActor(Integer idActor);
    Actor getActorByFirstAndLastName(String firstname, String lastname);
    List<Actor> findByFirstName(String firstName);
    List<Actor> findByLastName(String lastName);
    Actor saveActor(Actor actor);
    void  delete(Integer id);
    Actor updateActor(Integer idActor, Actor actor);
    List<Actor> getActors();
}
