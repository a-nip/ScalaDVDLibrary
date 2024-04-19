package com.example.dvdlibrary.dao //package of the repository trait

import com.example.dvdlibrary.model.Studio
import org.springframework.data.jpa.repository.JpaRepository // Importing JpaRepository

trait StudioRepo extends JpaRepository[Studio, Long] {

}
