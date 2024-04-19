package com.example.dvdlibrary.controller
import com.example.dvdlibrary.model.DVD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import com.example.dvdlibrary.service.DVDService

@RestController
@RequestMapping("/dvd")
@CrossOrigin
class DVDController {

  @Autowired
  private var dvdService: DVDService = scala.compiletime.uninitialized

  @GetMapping(path = Array("/dvds"))
  def allDVDs(): ResponseEntity[java.util.List[DVD]] = {
    val dvds = dvdService.getAllDvds
    ResponseEntity.status(HttpStatus.OK).body(dvds)
  }

  @GetMapping(path = Array("/{id}"))
  def getDVDById(@PathVariable("id") id: Long): ResponseEntity[DVD] = {
    val dvd = dvdService.findById(id)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }

  @PostMapping("/add")
  def addNewDVD(@RequestBody dvd: DVD): ResponseEntity[Unit] = {
    dvdService.addDVD(dvd)
    ResponseEntity.status(HttpStatus.CREATED).build()
  }

  @DeleteMapping("/{id}")
  def deleteDVD(@PathVariable("id") id: Long): ResponseEntity[Unit] = {
    dvdService.deleteDVD(id)
    new ResponseEntity[Unit](HttpStatus.NO_CONTENT)
  }

  @PutMapping("/{id}")
  def updateDVD(@PathVariable("id") id: Long, @RequestBody dvd: DVD): ResponseEntity[DVD] = {
    dvdService.updateDVD(id, dvd)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }
}
