package id.giansar.demo.repositories

import id.giansar.demo.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, UUID>