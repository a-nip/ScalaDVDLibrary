package com.example.dvdlibrary.controller
import com.example.dvdlibrary.dao.DVDRepo
import com.example.dvdlibrary.model.DVD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation._
import com.example.dvdlibrary.service.DVDservice


@RestController
@RequestMapping(Array("/dvd"))
@CrossOrigin
class DVDController {

  @Autowired
  private var dvdService: DVDservice = _
  @GetMapping(Array("/dvds"))
  def allDVDs(): ResponseEntity[java.util.List[DVD]] = {
    val dvds = dvdService.getAllDvds
    ResponseEntity.status(HttpStatus.OK).body(dvds)
  }
  @GetMapping(Array("/{id}"))
  def getDVDById(@PathVariable("id") id: Long): ResponseEntity[DVD] = {
    val dvd = dvdService.findById(id)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }

  @PostMapping(Array("/add"))
  def addNewDVD(@RequestBody dvd: DVD): ResponseEntity[Unit] = {
    dvdService.addDVD(dvd)
    ResponseEntity.status(HttpStatus.CREATED).build()
  }


  @DeleteMapping(Array("/{id}"))
  def deleteDVD(@PathVariable("id") id: Long): ResponseEntity[Unit] = {
    dvdService.deleteDVD(id)
    new ResponseEntity[Unit](HttpStatus.NO_CONTENT)
  }

  @PutMapping(Array("/{id}"))
  def updateDVD(@PathVariable("id") id: Long, @RequestBody dvd: DVD): ResponseEntity[DVD] = {
    dvdService.updateDVD(id, dvd)
    new ResponseEntity[DVD](dvd, HttpStatus.OK)
  }
}
