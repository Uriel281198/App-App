package walpaper.appchan.com.appchan.Model;

/**
 * Created by Uriel on 04/08/2018.
 */

public class WallpaperItem {
    public String imageLink;
    public String categoryid;

    public WallpaperItem() {
    }

    public WallpaperItem(String imageUrl, String category_id) {
        this.imageLink = imageUrl;
        this.categoryid = category_id;
    }

    public String getImageUrl() {
        return imageLink;
    }

    public void setImageUrl(String imageUrl) {
        this.imageLink = imageUrl;
    }

    public String getCategory_id() {
        return categoryid;
    }

    public void setCategory_id(String category_id) {
        this.categoryid = category_id;
    }
}
