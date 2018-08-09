package walpaper.appchan.com.appchan.Database.LocalDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import walpaper.appchan.com.appchan.Database.Recents;

/**
 * Created by Uriel on 09/08/2018.
 */
@Dao
public interface RecentsDAO {
    @Query("SELECT + FROM recents ORDER BY saveTime DESC LIMIT 10")
    Flowable<List<Recents>> getAllRecents();

    @Insert
    void insertRecents (Recents... recents);

    @Update
    void uptadateRecents (Recents... recents);

    @Delete
    void deleteRecents (Recents... recents);


    void deleteAllRecents ();

}
