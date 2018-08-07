package walpaper.appchan.com.appchan.Helper;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

/**
 * Created by Uriel on 07/08/2018.
 */

public class saveImageHelper  implements Target{

    private Context context;
    private WeakReference<AlertDialog> alertDialogWeakReference;
    private WeakReference<ContentResolver>contentResolverWeakReference;
    private String name ,description;


    public saveImageHelper(Context context,AlertDialog alertDialog, ContentResolver contentResolver, String name, String description) {
        this.context = context;
        this.alertDialogWeakReference = new WeakReference<AlertDialog>(alertDialog);
        this.contentResolverWeakReference =new  WeakReference<ContentResolver>(contentResolver);
        this.name = name;
        this.description = description;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {

        ContentResolver r = contentResolverWeakReference.get();
        AlertDialog alertDialog = alertDialogWeakReference.get();
        if (r!=null)
            MediaStore.Images.Media.insertImage(r,bitmap,name,description);
        alertDialog.dismiss();
        Toast.makeText(context, "DowlooandSuces", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
