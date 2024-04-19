package com.example.dvdlibrary.model
import java.time.LocalDate
import javax.persistence._
@Entity
@Table(name = "mpaa_rating")
class Rating {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ratingID", nullable = false)
  var id: Long = _

  @Column(name = "rating", nullable = false)
  var rating: String = _

  // Getters
  def getId: Long = id
  def getRating: String = rating

  // Setters
  def setId(id: Long): Unit = this.id = id
  def setRating(rating: String): Unit = this.rating = rating
}