package com.example.myapplication.`data`

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class UserDao_Impl(
  __db: RoomDatabase,
) : UserDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfUser: EntityInsertAdapter<User>
  init {
    this.__db = __db
    this.__insertAdapterOfUser = object : EntityInsertAdapter<User>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `users` (`id`,`username`,`passwordHash`,`weight`,`height`,`dailyWaterGoal`,`dailyStepGoal`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: User) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.username)
        statement.bindText(3, entity.passwordHash)
        val _tmpWeight: Float? = entity.weight
        if (_tmpWeight == null) {
          statement.bindNull(4)
        } else {
          statement.bindDouble(4, _tmpWeight.toDouble())
        }
        val _tmpHeight: Float? = entity.height
        if (_tmpHeight == null) {
          statement.bindNull(5)
        } else {
          statement.bindDouble(5, _tmpHeight.toDouble())
        }
        statement.bindLong(6, entity.dailyWaterGoal.toLong())
        statement.bindLong(7, entity.dailyStepGoal.toLong())
      }
    }
  }

  public override suspend fun insertUser(user: User): Long = performSuspending(__db, false, true) {
      _connection ->
    val _result: Long = __insertAdapterOfUser.insertAndReturnId(_connection, user)
    _result
  }

  public override suspend fun getUserByUsername(username: String): User? {
    val _sql: String = "SELECT * FROM users WHERE username = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, username)
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUsername: Int = getColumnIndexOrThrow(_stmt, "username")
        val _columnIndexOfPasswordHash: Int = getColumnIndexOrThrow(_stmt, "passwordHash")
        val _columnIndexOfWeight: Int = getColumnIndexOrThrow(_stmt, "weight")
        val _columnIndexOfHeight: Int = getColumnIndexOrThrow(_stmt, "height")
        val _columnIndexOfDailyWaterGoal: Int = getColumnIndexOrThrow(_stmt, "dailyWaterGoal")
        val _columnIndexOfDailyStepGoal: Int = getColumnIndexOrThrow(_stmt, "dailyStepGoal")
        val _result: User?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUsername: String
          _tmpUsername = _stmt.getText(_columnIndexOfUsername)
          val _tmpPasswordHash: String
          _tmpPasswordHash = _stmt.getText(_columnIndexOfPasswordHash)
          val _tmpWeight: Float?
          if (_stmt.isNull(_columnIndexOfWeight)) {
            _tmpWeight = null
          } else {
            _tmpWeight = _stmt.getDouble(_columnIndexOfWeight).toFloat()
          }
          val _tmpHeight: Float?
          if (_stmt.isNull(_columnIndexOfHeight)) {
            _tmpHeight = null
          } else {
            _tmpHeight = _stmt.getDouble(_columnIndexOfHeight).toFloat()
          }
          val _tmpDailyWaterGoal: Int
          _tmpDailyWaterGoal = _stmt.getLong(_columnIndexOfDailyWaterGoal).toInt()
          val _tmpDailyStepGoal: Int
          _tmpDailyStepGoal = _stmt.getLong(_columnIndexOfDailyStepGoal).toInt()
          _result =
              User(_tmpId,_tmpUsername,_tmpPasswordHash,_tmpWeight,_tmpHeight,_tmpDailyWaterGoal,_tmpDailyStepGoal)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getUserById(userId: Int): Flow<User?> {
    val _sql: String = "SELECT * FROM users WHERE id = ?"
    return createFlow(__db, false, arrayOf("users")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, userId.toLong())
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _columnIndexOfUsername: Int = getColumnIndexOrThrow(_stmt, "username")
        val _columnIndexOfPasswordHash: Int = getColumnIndexOrThrow(_stmt, "passwordHash")
        val _columnIndexOfWeight: Int = getColumnIndexOrThrow(_stmt, "weight")
        val _columnIndexOfHeight: Int = getColumnIndexOrThrow(_stmt, "height")
        val _columnIndexOfDailyWaterGoal: Int = getColumnIndexOrThrow(_stmt, "dailyWaterGoal")
        val _columnIndexOfDailyStepGoal: Int = getColumnIndexOrThrow(_stmt, "dailyStepGoal")
        val _result: User?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          val _tmpUsername: String
          _tmpUsername = _stmt.getText(_columnIndexOfUsername)
          val _tmpPasswordHash: String
          _tmpPasswordHash = _stmt.getText(_columnIndexOfPasswordHash)
          val _tmpWeight: Float?
          if (_stmt.isNull(_columnIndexOfWeight)) {
            _tmpWeight = null
          } else {
            _tmpWeight = _stmt.getDouble(_columnIndexOfWeight).toFloat()
          }
          val _tmpHeight: Float?
          if (_stmt.isNull(_columnIndexOfHeight)) {
            _tmpHeight = null
          } else {
            _tmpHeight = _stmt.getDouble(_columnIndexOfHeight).toFloat()
          }
          val _tmpDailyWaterGoal: Int
          _tmpDailyWaterGoal = _stmt.getLong(_columnIndexOfDailyWaterGoal).toInt()
          val _tmpDailyStepGoal: Int
          _tmpDailyStepGoal = _stmt.getLong(_columnIndexOfDailyStepGoal).toInt()
          _result =
              User(_tmpId,_tmpUsername,_tmpPasswordHash,_tmpWeight,_tmpHeight,_tmpDailyWaterGoal,_tmpDailyStepGoal)
        } else {
          _result = null
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
