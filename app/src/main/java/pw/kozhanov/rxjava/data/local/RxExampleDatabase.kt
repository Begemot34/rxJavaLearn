package pw.kozhanov.rxjava.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pw.kozhanov.rxjava.data.model.entity.CountryEntity


@Database(entities = [CountryEntity::class], version = 1, exportSchema = false)
abstract class RxExampleDatabase : RoomDatabase() {
    abstract fun countriesDAO(): CountriesDAO
}