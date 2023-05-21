package id.giansar.demo.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @Column(name = "id", nullable = false, length = 36)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "name", nullable = false, length = 64)
    val name: String,

    @Column(name = "email", nullable = false, length = 64)
    val email: String = ""
)
