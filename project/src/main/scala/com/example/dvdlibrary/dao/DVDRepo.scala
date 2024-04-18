package com.example.dvdlibrary.dao

import com.example.dvdlibrary.model.DVD
import org.springframework.data.jpa.repository.JpaRepository

trait DVDRepo extends JpaRepository[DVD, Long] {

}
