package pw.kozhanov.rxjava.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable
import pw.kozhanov.rxjava.data.model.entity.CountryEntity
@Dao
interface CountriesDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countryItems: List<CountryEntity>)

    @Query("SELECT * FROM countries")
    fun getCourses(): Flowable<List<CountryEntity>>
}