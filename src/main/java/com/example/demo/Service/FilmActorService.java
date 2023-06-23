package com.example.demo.Service;

import com.example.demo.Entity.FilmActor;
import com.example.demo.Entity.FilmActorId;
import com.example.demo.Repository.FilmActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmActorService {
    @Autowired
    FilmActorRepository filmActorRepository;

    public FilmActor getFilmActorByIds(FilmActorId id){
        return filmActorRepository.findFilmActorById(id);
    }

    public List<FilmActor> getFilmActorsByFilmId(Integer filmId){
        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setFilmId(filmId);
        return filmActorRepository.findFilmActorsById_FilmId(filmActorId);
    }

    public List<FilmActor> getFilmActorsAll(){
        return (List<FilmActor>) filmActorRepository.findAll();
    }

    public List<FilmActor> getFilmActorsByActorId(Integer actorId){
        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(actorId);
        return filmActorRepository.findFilmActorsById_ActorId(filmActorId);
    }

    public FilmActor saveFilmActor(FilmActor filmActor){
        return filmActorRepository.save(filmActor);
    }

    public FilmActor updateFilmActor(Integer filmId, Integer acotrId, FilmActor filmActor){
        FilmActor filmActorFindByIds = filmActorRepository.findFilmActorById(new FilmActorId(acotrId,filmId));
        FilmActorId filmActorId = new FilmActorId(acotrId,filmId);
        filmActorFindByIds.setId(filmActorId);
        filmActorFindByIds.setLastUpdate(filmActor.getLastUpdate());

        return filmActorRepository.save(filmActorFindByIds);
    }

    public void deleteFilmActor(Integer filmId, Integer actorId){
        filmActorRepository.deleteFilmActorById(new FilmActorId(actorId,filmId));

    }


}
