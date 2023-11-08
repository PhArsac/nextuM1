package com.nextu.exo11.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"/", ""})
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("");
    }

}
