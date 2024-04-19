package com.example.dao

import com.example.model.DVD
import org.springframework.data.jpa.repository.JpaRepository

trait DVDRepository extends JpaRepository[DVD, Long] {

}
