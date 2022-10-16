package com.usa.misiontic.ProyectoCiclo3.controller;


import com.usa.misiontic.ProyectoCiclo3.entities.Message;
import com.usa.misiontic.ProyectoCiclo3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody  Message p){
        return messageService.save(p);
    }
    
    @GetMapping("/id")
    public Optional<Message> getMessage(@PathVariable("id")int id){
        return messageService.getMessage(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody  Message p){
        return messageService.update(p);
    }
    
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int messageId){
        return messageService.deleteMessage(messageId);
    }
}
