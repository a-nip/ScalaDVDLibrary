package com.example.dao //  package of the repository trait

import com.example.model.Director // Import the Director entity
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait DirectorRepository extends JpaRepository[Director, Long] {

}
