package com.example.dvdlibrary.service

import com.example.dvdlibrary.dao.DVDRepo
import com.example.dvdlibrary.model.{DVD, Rating}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class DVDService {

  @Autowired
  private var dvdRepo: DVDRepo = scala.compiletime.uninitialized

  @Autowired
  def this(dvdRepo: DVDRepo) = {
    this()
    this.dvdRepo = dvdRepo
  }

  def getAllDvds: java.util.List[DVD] =
    dvdRepo.findAll()

  def findById(id: Long): DVD = {
    try {
      val dvd = dvdRepo.findById(id).orElse(null)
      if (dvd != null) {
        dvd
      } else {
        throw new DVDNotFoundException()
      }
    } catch {
      case e: DataAccessException =>
        throw new DVDDataAccessException("Error accessing DVD data", e)
    }
  }

  def addDVD(dvd: DVD): DVD = {
    try {
      (dvd.getId, dvd.getTitle, dvd.getReleaseDate) match {
        case (id: Long, title: String, releaseDate: LocalDate)
          if title != null && releaseDate !=null => dvdRepo.save(dvd)
        case (_, _, _) =>
          throw new DVDDataInputException("DVD Data input was invalid")
      }
    } catch {
      case e: Exception =>
        throw new DVDCreationException()
    }
  }

  def deleteDVD(id: Long): Unit = {
    dvdRepo.deleteById(id)
  }

  def updateDVD(id: Long, dvd: DVD): DVD = {
    try {
      val foundDvd = dvdRepo.findById(id)
      if (dvd.getId == foundDvd.get().getId) {
        dvdRepo.save(dvd)
      }
      else {
        throw new DVDDataAccessException("DVD not updated")
      }
    } catch {
      case e: DataAccessException =>
        throw new DVDDataAccessException("DVD not updated, Error accessing DVD data", e)
    }
  }

  private class DVDNotFoundException(message: String) extends DataAccessException(message) {
    def this() = this("DVD is not found by ID")
    override def fillInStackTrace(): Throwable = this
  }

  private class DVDDataAccessException(message: String, cause: Throwable) extends DataAccessException(message, cause) {
    def this(message: String) = this(message, null)

    def this() = this("Error accessing DVD data", null)
    override def fillInStackTrace(): Throwable = this
  }

  private class DVDDataInputException(message: String, cause: Throwable) extends DataAccessException(message, cause) {
    def this(message: String) = this(message, null)

    def this() = this("Input is invalid", null)
    override def fillInStackTrace(): Throwable = this
  }

  private class DVDCreationException(message: String, cause: Throwable) extends DataAccessException(message, cause) {
    def this(message: String) = this(message, null)
    def this() = this("Error creating DVD", null)
    override def fillInStackTrace(): Throwable = this
  }
}
