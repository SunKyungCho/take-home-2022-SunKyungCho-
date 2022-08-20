package me.test.takehome2022sunkyungcho.controller;


import lombok.RequiredArgsConstructor;
import me.test.takehome2022sunkyungcho.application.DataWriteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CharPageController {

    private final DataWriteService dataWriteService;

    @GetMapping("/")
    public String getCharPage() {
        dataWriteService.writeData();
        return "index";
    }
}
