package com.example.dvdlibrary.dao //  package of the repository trait

import com.example.dvdlibrary.model.Director
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait DirectorRepo extends JpaRepository[Director, Long] {

}
