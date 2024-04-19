package com.example.dvdlibrary.dao

import com.example.dvdlibrary.model.DVD
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

import scala.collection.immutable.List

@Repository
trait DVDRepo extends JpaRepository[DVD, Long] {
  @Query(value = "SELECT * FROM dvd", nativeQuery = true)
  def findAllDVDs(): List[DVD]

  @Query(value = "SELECT * FROM dvd WHERE dvd_id = ?1", nativeQuery = true)
  def findDVDById(id: Long): DVD

  @Transactional
  @Query(value = "INSERT INTO dvd (title, release_date, director_id, studio_id, rating_id, user_rating_note) " +
    "VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
  def addNewDVD(title: String,
                release_date: java.sql.Date,
                director_id: Long,
                studio_id: Long,
                rating_id: Long,
                user_rating_note: String): Unit

  @Transactional
  @Query(value = "DELETE FROM dvd WHERE dvd_id = ?1", nativeQuery = true)
  def deleteDVDById(id: Long): Unit

  @Transactional
  @Query(value = "UPDATE dvd SET title = ?2, release_date = ?3, director_id = ?4, " +
    "studio_id = ?5, rating_id = ?6, user_rating_note = ?7 WHERE dvd_id = ?1", nativeQuery = true)
  def updateDVDById(id: Long, title: String, release_date: java.sql.Date, director_id: Long,
                    studio_id: Long, rating_id: Long, user_rating_note: String): Unit
}
