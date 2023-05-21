package id.giansar.demo.controllers

import id.giansar.demo.dtos.ResponseDto
import id.giansar.demo.dtos.UserDto
import id.giansar.demo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController @Autowired constructor(private val userService: UserService) {
    @PostMapping("/new")
    fun newUser(@RequestBody newUserData: UserDto): ResponseEntity<ResponseDto> {
        return userService.newUser(newUserData);
    }

    @PostMapping("/all")
    fun allUsers(): ResponseEntity<ResponseDto> {
        return userService.getAllUsers();
    }
}