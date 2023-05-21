package id.giansar.demo.services

import id.giansar.demo.dtos.ResponseDto
import id.giansar.demo.dtos.UserDto
import id.giansar.demo.entities.User
import id.giansar.demo.repositories.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {
    companion object {
        private val logger = LoggerFactory.getLogger(UserService::class.java)
    }

    fun newUser(newUserData: UserDto): ResponseEntity<ResponseDto> {
        logger.info("New user data: $newUserData")
        val user = User(
            name = newUserData.name!!,
            email = newUserData.email!!
        )
        logger.info("New user: $user")
        userRepository.save(user)
        return ResponseEntity.ok(ResponseDto("Hello World!"))
    }

    fun getAllUsers(): ResponseEntity<ResponseDto> {
        val users = userRepository.findAll()
        logger.info("Users: $users")
        val userList = mutableListOf<UserDto>()
        users.forEach { user ->
            userList.add(UserDto(user.id, user.name, user.email))
        }
        logger.info("User list: $userList")
        return ResponseEntity.ok(ResponseDto("success", userList))
    }
}