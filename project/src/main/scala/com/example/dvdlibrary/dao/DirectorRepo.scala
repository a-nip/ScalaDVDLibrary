package com.example.dvdlibrary.dao //  package of the repository trait

import com.example.dvdlibrary.model.Director // Import the Director entity
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait DirectorRepo extends JpaRepository[Director, Long] {

}
