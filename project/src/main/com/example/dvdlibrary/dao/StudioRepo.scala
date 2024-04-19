package com.example.dao //package of the repository trait

import com.example.model.Studio // Import the Studio entity
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait StudioRepository extends JpaRepository[Studio, Long] {

}
