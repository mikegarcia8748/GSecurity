package org.rmj.guanzongroup.appdriver.Data;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

//@Database(entities = {
//        EItinerary.class}, version = 1)
public abstract class GGC_SecSysDb extends RoomDatabase {
    private static final String TAG = GGC_SecSysDb.class.getSimpleName();

    private static GGC_SecSysDb instance;

//    public abstract DAccountInfo accountDao();

    public static synchronized GGC_SecSysDb getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            GGC_SecSysDb.class, "GGC_ISysDBF.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static final Callback roomCallBack = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.e(TAG, "Local database has been created.");
        }
    };
}
