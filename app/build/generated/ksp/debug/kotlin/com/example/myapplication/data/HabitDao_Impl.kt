package com.example.myapplication.`data`

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class HabitDao_Impl(
  __db: RoomDatabase,
) : HabitDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfHabit: EntityInsertAdapter<Habit>

  private val __deleteAdapterOfHabit: EntityDeleteOrUpdateAdapter<Habit>

  private val __updateAdapterOfHabit: EntityDeleteOrUpdateAdapter<Habit>
  init {
    this.__db = __db
    this.__insertAdapterOfHabit = object : EntityInsertAdapter<Habit>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `habits` (`id`,`userId`,`habitType`,`quantityOrDuration`,`unit`,`notes`,`date`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Habit) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.userId.toLong())
        statement.bindText(3, entity.habitType)
        statement.bindText(4, entity.quantityOrDuration)
        statement.bindText(5, entity.unit)
        statement.bindText(6, entity.notes)
        statement.bindLong(7, entity.date)
      }
    }
    this.__deleteAdapterOfHabit = object : EntityDeleteOrUpdateAdapter<Habit>() {
      protected override fun createQuery(): String = "DELETE FROM `habits` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Habit) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
    this.__updateAdapterOfHabit = object : EntityDeleteOrUpdateAdapter<Habit>() {
      protected override fun createQuery(): String =
          "UPDATE OR ABORT `habits` SET `id` = ?,`userId` = ?,`habitType` = ?,`quantityOrDuration` = ?,`unit` = ?,`notes` = ?,`date` = ? WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: Habit) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindLong(2, entity.userId.toLong())
        statement.bindText(3, entity.habitType)
        statement.bindText(4, entity.quantityOrDuration)
        statement.bindText(5, entity.unit)
        statement.bindText(6, entity.notes)
        statement.bindLong(7, entity.date)
        statement.bindLong(8, entity.id.toLong())
      }
    }
  }

  public override suspend fun insertHabit(habit: Habit): Unit = performSuspending(__db, false, true)
      { _connection ->
    __insertAdapterOfHabit.insert(_connection, habit)
  }

  public override suspend fun deleteHabit(habit: Habit): Unit = performSuspending(__db, false, true)
      { _connection ->
    __deleteAdapterOfHabit.handle(_connection, habit)
  }

  public override suspend fun updateHabit(habit: Habit): Unit = performSuspending(__db, false, true)
      { _connection ->
    __updateAdapterOfHabit.handle(_connection, habit)
  }

  public override fun getHabitById(id: Int): Flow<Habit?> {
    val _sql: String = "SELECT * FROM habits WHERE id = ?"
    return createFlow(__db, false, arrayOf("habits")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfHabitType: Int = getColumnIndexOrThrow(_stmt, "habitType")
        val _columnIndexOfQuantityOrDuration: Int = getColumnIndexOrThrow(_stmt,
            "quantityOrDuration")
        val _columnIndexOfUnit: Int = getColumnIndexOrThrow(_stmt, "unit")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: Habit?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUserId: Int
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId).toInt()
          val _tmpHabitType: String
          _tmpHabitType = _stmt.getText(_columnIndexOfHabitType)
          val _tmpQuantityOrDuration: String
          _tmpQuantityOrDuration = _stmt.getText(_columnIndexOfQuantityOrDuration)
          val _tmpUnit: String
          _tmpUnit = _stmt.getText(_columnIndexOfUnit)
          val _tmpNotes: String
          _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          _result =
              Habit(_tmpId,_tmpUserId,_tmpHabitType,_tmpQuantityOrDuration,_tmpUnit,_tmpNotes,_tmpDate)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getAllHabits(userId: Int): Flow<List<Habit>> {
    val _sql: String = "SELECT * FROM habits WHERE userId = ? ORDER BY date DESC"
    return createFlow(__db, false, arrayOf("habits")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfHabitType: Int = getColumnIndexOrThrow(_stmt, "habitType")
        val _columnIndexOfQuantityOrDuration: Int = getColumnIndexOrThrow(_stmt,
            "quantityOrDuration")
        val _columnIndexOfUnit: Int = getColumnIndexOrThrow(_stmt, "unit")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: MutableList<Habit> = mutableListOf()
        while (_stmt.step()) {
          val _item: Habit
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUserId: Int
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId).toInt()
          val _tmpHabitType: String
          _tmpHabitType = _stmt.getText(_columnIndexOfHabitType)
          val _tmpQuantityOrDuration: String
          _tmpQuantityOrDuration = _stmt.getText(_columnIndexOfQuantityOrDuration)
          val _tmpUnit: String
          _tmpUnit = _stmt.getText(_columnIndexOfUnit)
          val _tmpNotes: String
          _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          _item =
              Habit(_tmpId,_tmpUserId,_tmpHabitType,_tmpQuantityOrDuration,_tmpUnit,_tmpNotes,_tmpDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getHabitsByType(userId: Int, type: String): Flow<List<Habit>> {
    val _sql: String = "SELECT * FROM habits WHERE userId = ? AND habitType = ? ORDER BY date DESC"
    return createFlow(__db, false, arrayOf("habits")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId.toLong())
        _argIndex = 2
        _stmt.bindText(_argIndex, type)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfHabitType: Int = getColumnIndexOrThrow(_stmt, "habitType")
        val _columnIndexOfQuantityOrDuration: Int = getColumnIndexOrThrow(_stmt,
            "quantityOrDuration")
        val _columnIndexOfUnit: Int = getColumnIndexOrThrow(_stmt, "unit")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: MutableList<Habit> = mutableListOf()
        while (_stmt.step()) {
          val _item: Habit
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUserId: Int
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId).toInt()
          val _tmpHabitType: String
          _tmpHabitType = _stmt.getText(_columnIndexOfHabitType)
          val _tmpQuantityOrDuration: String
          _tmpQuantityOrDuration = _stmt.getText(_columnIndexOfQuantityOrDuration)
          val _tmpUnit: String
          _tmpUnit = _stmt.getText(_columnIndexOfUnit)
          val _tmpNotes: String
          _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          _item =
              Habit(_tmpId,_tmpUserId,_tmpHabitType,_tmpQuantityOrDuration,_tmpUnit,_tmpNotes,_tmpDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getHabitsByDateRange(
    userId: Int,
    startDate: Long,
    endDate: Long,
  ): Flow<List<Habit>> {
    val _sql: String =
        "SELECT * FROM habits WHERE userId = ? AND date BETWEEN ? AND ? ORDER BY date DESC"
    return createFlow(__db, false, arrayOf("habits")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId.toLong())
        _argIndex = 2
        _stmt.bindLong(_argIndex, startDate)
        _argIndex = 3
        _stmt.bindLong(_argIndex, endDate)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfHabitType: Int = getColumnIndexOrThrow(_stmt, "habitType")
        val _columnIndexOfQuantityOrDuration: Int = getColumnIndexOrThrow(_stmt,
            "quantityOrDuration")
        val _columnIndexOfUnit: Int = getColumnIndexOrThrow(_stmt, "unit")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: MutableList<Habit> = mutableListOf()
        while (_stmt.step()) {
          val _item: Habit
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUserId: Int
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId).toInt()
          val _tmpHabitType: String
          _tmpHabitType = _stmt.getText(_columnIndexOfHabitType)
          val _tmpQuantityOrDuration: String
          _tmpQuantityOrDuration = _stmt.getText(_columnIndexOfQuantityOrDuration)
          val _tmpUnit: String
          _tmpUnit = _stmt.getText(_columnIndexOfUnit)
          val _tmpNotes: String
          _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          _item =
              Habit(_tmpId,_tmpUserId,_tmpHabitType,_tmpQuantityOrDuration,_tmpUnit,_tmpNotes,_tmpDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getRecentHabits(userId: Int): Flow<List<Habit>> {
    val _sql: String = "SELECT * FROM habits WHERE userId = ? ORDER BY date DESC LIMIT 5"
    return createFlow(__db, false, arrayOf("habits")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUserId: Int = getColumnIndexOrThrow(_stmt, "userId")
        val _columnIndexOfHabitType: Int = getColumnIndexOrThrow(_stmt, "habitType")
        val _columnIndexOfQuantityOrDuration: Int = getColumnIndexOrThrow(_stmt,
            "quantityOrDuration")
        val _columnIndexOfUnit: Int = getColumnIndexOrThrow(_stmt, "unit")
        val _columnIndexOfNotes: Int = getColumnIndexOrThrow(_stmt, "notes")
        val _columnIndexOfDate: Int = getColumnIndexOrThrow(_stmt, "date")
        val _result: MutableList<Habit> = mutableListOf()
        while (_stmt.step()) {
          val _item: Habit
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUserId: Int
          _tmpUserId = _stmt.getLong(_columnIndexOfUserId).toInt()
          val _tmpHabitType: String
          _tmpHabitType = _stmt.getText(_columnIndexOfHabitType)
          val _tmpQuantityOrDuration: String
          _tmpQuantityOrDuration = _stmt.getText(_columnIndexOfQuantityOrDuration)
          val _tmpUnit: String
          _tmpUnit = _stmt.getText(_columnIndexOfUnit)
          val _tmpNotes: String
          _tmpNotes = _stmt.getText(_columnIndexOfNotes)
          val _tmpDate: Long
          _tmpDate = _stmt.getLong(_columnIndexOfDate)
          _item =
              Habit(_tmpId,_tmpUserId,_tmpHabitType,_tmpQuantityOrDuration,_tmpUnit,_tmpNotes,_tmpDate)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
