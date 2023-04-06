package br.com.springkotlin.springkotlin.controller

import br.com.springkotlin.springkotlin.model.Hello
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    @RequestMapping("/hello")
    fun HelloSpring(): Hello{
        return Hello(id = 1, nome = "Samuel Farias")
    }


}