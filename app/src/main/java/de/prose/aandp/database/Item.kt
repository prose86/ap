package de.prose.aandp.database

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Philip on 16.12.2017.
 */
@Entity
data class Item(@ColumnInfo(name = "item_name") var itemName: String) {
    @PrimaryKey(autoGenerate = true) var uid: Long = 0
}