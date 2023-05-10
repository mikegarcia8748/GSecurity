package org.rmj.guanzongroup.appdriver.Data.Dao;

import androidx.room.Dao;
import androidx.room.Insert;

import org.rmj.guanzongroup.appdriver.Data.Entity.EItinerary;

@Dao
public interface DItinerary {

    @Insert
    void Save(EItinerary val);
}
