package walpaper.appchan.com.appchan.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import io.reactivex.annotations.NonNull;

/**
 * Created by Uriel on 09/08/2018.
 */
@Entity (tableName = "recents",primaryKeys = {"imageLink","categoryId"})
public class Recents  {

    @ColumnInfo(name ="imageLink")
    @NonNull
    private String imageLink;


    @ColumnInfo(name ="categoryId")
    @NonNull
    private String categoryid;


    @ColumnInfo(name ="saveTime")
    private String saveTime;

    public Recents(String imageLink, String categoryid, String saveTime) {
        this.imageLink = imageLink;
        this.categoryid = categoryid;
        this.saveTime = saveTime;
    }


    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }
}
