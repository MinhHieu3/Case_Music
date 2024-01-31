package com.example.jwtspring3.controller;

import com.example.jwtspring3.model.PlayList;
import com.example.jwtspring3.service.IPlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/playlists")
public class PlaylistController {
    @Autowired
    IPlaylistService playlistService;

    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity<>(playlistService.findAll(), HttpStatus.OK);

    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody PlayList playList){
        return new ResponseEntity<>(playlistService.save(playList),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody  PlayList playList){
        playList.setId(id);
        return new ResponseEntity<>(playlistService.save(playList),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        playlistService.remove(id);
        return new ResponseEntity("done delete",HttpStatus.OK);
    }
}