package com.assignment.movies.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.assignment.movies.database.entities.Movies;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MoviesDao_Impl implements MoviesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movies> __insertionAdapterOfMovies;

  public MoviesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovies = new EntityInsertionAdapter<Movies>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movies` (`rowid`,`title`,`year`,`rated`,`released`,`runTIme`,`genre`,`director`,`writer`,`actors`,`plot`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movies value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getYear() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getYear());
        }
        if (value.getRated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRated());
        }
        if (value.getReleased() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReleased());
        }
        if (value.getRunTIme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRunTIme());
        }
        if (value.getGenre() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGenre());
        }
        if (value.getDirector() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDirector());
        }
        if (value.getWriter() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getWriter());
        }
        if (value.getActors() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getActors());
        }
        if (value.getPlot() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPlot());
        }
      }
    };
  }

  @Override
  public Object saveMovies(final List<Movies> movies,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMovies.insert(movies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object getAll(final Continuation<? super List<Movies>> continuation) {
    final String _sql = "SELECT * FROM movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Movies>>() {
      @Override
      public List<Movies> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "rowid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRated = CursorUtil.getColumnIndexOrThrow(_cursor, "rated");
          final int _cursorIndexOfReleased = CursorUtil.getColumnIndexOrThrow(_cursor, "released");
          final int _cursorIndexOfRunTIme = CursorUtil.getColumnIndexOrThrow(_cursor, "runTIme");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfWriter = CursorUtil.getColumnIndexOrThrow(_cursor, "writer");
          final int _cursorIndexOfActors = CursorUtil.getColumnIndexOrThrow(_cursor, "actors");
          final int _cursorIndexOfPlot = CursorUtil.getColumnIndexOrThrow(_cursor, "plot");
          final List<Movies> _result = new ArrayList<Movies>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movies _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRated;
            if (_cursor.isNull(_cursorIndexOfRated)) {
              _tmpRated = null;
            } else {
              _tmpRated = _cursor.getString(_cursorIndexOfRated);
            }
            final String _tmpReleased;
            if (_cursor.isNull(_cursorIndexOfReleased)) {
              _tmpReleased = null;
            } else {
              _tmpReleased = _cursor.getString(_cursorIndexOfReleased);
            }
            final String _tmpRunTIme;
            if (_cursor.isNull(_cursorIndexOfRunTIme)) {
              _tmpRunTIme = null;
            } else {
              _tmpRunTIme = _cursor.getString(_cursorIndexOfRunTIme);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpDirector;
            if (_cursor.isNull(_cursorIndexOfDirector)) {
              _tmpDirector = null;
            } else {
              _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            }
            final String _tmpWriter;
            if (_cursor.isNull(_cursorIndexOfWriter)) {
              _tmpWriter = null;
            } else {
              _tmpWriter = _cursor.getString(_cursorIndexOfWriter);
            }
            final String _tmpActors;
            if (_cursor.isNull(_cursorIndexOfActors)) {
              _tmpActors = null;
            } else {
              _tmpActors = _cursor.getString(_cursorIndexOfActors);
            }
            final String _tmpPlot;
            if (_cursor.isNull(_cursorIndexOfPlot)) {
              _tmpPlot = null;
            } else {
              _tmpPlot = _cursor.getString(_cursorIndexOfPlot);
            }
            _item = new Movies(_tmpId,_tmpTitle,_tmpYear,_tmpRated,_tmpReleased,_tmpRunTIme,_tmpGenre,_tmpDirector,_tmpWriter,_tmpActors,_tmpPlot);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Object findByActorName(final String actorName,
      final Continuation<? super List<Movies>> continuation) {
    final String _sql = "SELECT * FROM movies WHERE actors LIKE '%'||?||'%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (actorName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, actorName);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Movies>>() {
      @Override
      public List<Movies> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "rowid");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfRated = CursorUtil.getColumnIndexOrThrow(_cursor, "rated");
          final int _cursorIndexOfReleased = CursorUtil.getColumnIndexOrThrow(_cursor, "released");
          final int _cursorIndexOfRunTIme = CursorUtil.getColumnIndexOrThrow(_cursor, "runTIme");
          final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
          final int _cursorIndexOfDirector = CursorUtil.getColumnIndexOrThrow(_cursor, "director");
          final int _cursorIndexOfWriter = CursorUtil.getColumnIndexOrThrow(_cursor, "writer");
          final int _cursorIndexOfActors = CursorUtil.getColumnIndexOrThrow(_cursor, "actors");
          final int _cursorIndexOfPlot = CursorUtil.getColumnIndexOrThrow(_cursor, "plot");
          final List<Movies> _result = new ArrayList<Movies>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movies _item;
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpYear;
            if (_cursor.isNull(_cursorIndexOfYear)) {
              _tmpYear = null;
            } else {
              _tmpYear = _cursor.getString(_cursorIndexOfYear);
            }
            final String _tmpRated;
            if (_cursor.isNull(_cursorIndexOfRated)) {
              _tmpRated = null;
            } else {
              _tmpRated = _cursor.getString(_cursorIndexOfRated);
            }
            final String _tmpReleased;
            if (_cursor.isNull(_cursorIndexOfReleased)) {
              _tmpReleased = null;
            } else {
              _tmpReleased = _cursor.getString(_cursorIndexOfReleased);
            }
            final String _tmpRunTIme;
            if (_cursor.isNull(_cursorIndexOfRunTIme)) {
              _tmpRunTIme = null;
            } else {
              _tmpRunTIme = _cursor.getString(_cursorIndexOfRunTIme);
            }
            final String _tmpGenre;
            if (_cursor.isNull(_cursorIndexOfGenre)) {
              _tmpGenre = null;
            } else {
              _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
            }
            final String _tmpDirector;
            if (_cursor.isNull(_cursorIndexOfDirector)) {
              _tmpDirector = null;
            } else {
              _tmpDirector = _cursor.getString(_cursorIndexOfDirector);
            }
            final String _tmpWriter;
            if (_cursor.isNull(_cursorIndexOfWriter)) {
              _tmpWriter = null;
            } else {
              _tmpWriter = _cursor.getString(_cursorIndexOfWriter);
            }
            final String _tmpActors;
            if (_cursor.isNull(_cursorIndexOfActors)) {
              _tmpActors = null;
            } else {
              _tmpActors = _cursor.getString(_cursorIndexOfActors);
            }
            final String _tmpPlot;
            if (_cursor.isNull(_cursorIndexOfPlot)) {
              _tmpPlot = null;
            } else {
              _tmpPlot = _cursor.getString(_cursorIndexOfPlot);
            }
            _item = new Movies(_tmpId,_tmpTitle,_tmpYear,_tmpRated,_tmpReleased,_tmpRunTIme,_tmpGenre,_tmpDirector,_tmpWriter,_tmpActors,_tmpPlot);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
