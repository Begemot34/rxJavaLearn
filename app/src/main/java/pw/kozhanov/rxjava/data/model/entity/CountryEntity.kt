package pw.kozhanov.rxjava.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    val image: String,
    @PrimaryKey
    val name: String,
    val capital: String,
    val population: String,
    val nativeName: String
)