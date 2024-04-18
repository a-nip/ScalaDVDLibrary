package com.example.dvdlibrary.model
import java.time.LocalDate
import javax.persistence._

@Entity
@Table(name = "studio")
class Studio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "studioID", nullable = false)
  var id: Long = _

  @Column(name = "studioName", nullable = false)
  var name: String = _

  // Getters
  def getId: Long = id
  def getName: String = name

  // Setters
  def setId(id: Long): Unit = this.id = id
  def setName(name: String): Unit = this.name = name
}