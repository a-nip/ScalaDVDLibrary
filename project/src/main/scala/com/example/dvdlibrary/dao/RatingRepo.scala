package com.example.dvdlibrary.dao //package of the repository trait

import com.example.dvdlibrary.model.Rating
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait RatingRepo extends JpaRepository[Rating, Long] {

}
