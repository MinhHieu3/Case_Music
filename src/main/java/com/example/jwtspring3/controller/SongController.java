package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.Song;
import com.example.jwtspring3.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    ISongService songService;
    @GetMapping
    public ResponseEntity findAll(String name, String albumName, String singerName){
        return new ResponseEntity<>(songService.findAll(name,albumName,singerName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Song song){
        return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Song song, @PathVariable Long id){
        song.setId(id);
        return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
    songService.remove(id);
    return new ResponseEntity<>("delete done", HttpStatus.OK);
    }
}