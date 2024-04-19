package com.example.dvdlibrary.dao

import com.example.dvdlibrary.model.DVD
import org.springframework.data.jpa.repository.{JpaRepository, Query}
import org.springframework.stereotype.Repository

import java.util.List

@Repository
trait DVDRepo extends JpaRepository[DVD, Long] {
  @Query(value = "SELECT * FROM dvd WHERE director_id = ?1", nativeQuery = true)
  def findDVDsByDirectorId(directorId: Long): List[DVD]

  @Query(value = "SELECT * FROM dvd WHERE title = ?1", nativeQuery = true)
  def findDVDsByTitle(title: String): List[DVD]

  @Query(value = "SELECT * FROM dvd WHERE YEAR(release_date) = ?1", nativeQuery = true)
  def findDVDsByReleaseYear(year: Int): List[DVD]

  @Query(value = "SELECT dvd.* " +
    "FROM dvd " +
    "JOIN director ON dvd.director_id = director.director_id " +
    "WHERE director.director_name = ?1", nativeQuery = true)
  def findDVDsByDirectorName(directorName: String): List[DVD]

  @Query(value = "SELECT dvd.* " +
    "FROM dvd " +
    "JOIN studio ON dvd.studio_id = studio.studio_id " +
    "WHERE studio.studio_name = ?1", nativeQuery = true)
  def findDVDsByStudioName(studioName: String): List[DVD]

  @Query(value = "SELECT dvd.* " +
    "FROM dvd " +
    "JOIN mpaa_rating ON dvd.rating_id = mpaa_rating.rating_id " +
    "WHERE mpaa_rating.rating = ?1", nativeQuery = true)
  def findDVDsByRating(ratingTag: String): List[DVD]
}

