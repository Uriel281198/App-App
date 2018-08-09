package walpaper.appchan.com.appchan.Database.DataSource;

import java.util.List;

import io.reactivex.Flowable;
import walpaper.appchan.com.appchan.Database.Recents;

/**
 * Created by Uriel on 09/08/2018.
 */

public interface IRecentsDataSource {


    Flowable<List<Recents>> getAllRecents();
    void insertRecents (Recents... recents);
    void uptadateRecents (Recents... recents);
    void deleteRecents (Recents... recents);
    void deleteAllRecents ();

}
