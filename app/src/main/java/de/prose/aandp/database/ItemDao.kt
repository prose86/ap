package de.prose.aandp.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * Created by Philip on 16.12.2017.
 */
@Dao
interface ItemDao {

    @Query("SELECT * from item")
    fun getAllItems() : Flowable<List<Item>>

    @Insert
    fun insertAll(vararg users: Item)

    @Query("DELETE from item")
    fun deleteAll()

}