package com.example.dao //package of the repository trait

import com.example.model.Rating // Import the Rating entity
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait RatingRepository extends JpaRepository[Rating, Long] {

}
