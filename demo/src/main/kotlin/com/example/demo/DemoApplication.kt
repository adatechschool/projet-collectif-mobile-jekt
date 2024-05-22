package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class LoutreController(val service: LoutreService) {
    @GetMapping("/")
    fun index(): List<TableLoutre> = service.findLoutre()

    @GetMapping("/{id}")
    fun index(@PathVariable id: String): List<TableLoutre> =
        service.findLoutreById(id)

    @PostMapping("/")
    fun post(@RequestBody message: TableLoutre) {
        service.save(message)
    }
}

interface LoutreRepository : CrudRepository<TableLoutre, String>

@Table("LOUTRES")
data class TableLoutre(@Id var id: String?, val nom: String, val image: String, val lieu: String)

@Service
class LoutreService(val db: LoutreRepository) {
    fun findLoutre(): List<TableLoutre> = db.findAll().toList()

    fun findLoutreById(id: String): List<TableLoutre> = db.findById(id).toList()

    fun save(message: TableLoutre) {
        db.save(message)
    }

    fun <T : Any> Optional<out T>.toList(): List<T> =
        if (isPresent) listOf(get()) else emptyList()
}
