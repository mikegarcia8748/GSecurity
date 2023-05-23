package org.rmj.guanzongroup.appdriver.Data.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.rmj.guanzongroup.appdriver.Data.Entity.EBuildingVisit;

import java.util.List;

@Dao
public interface DItinerary {

    @Query("SELECT * FROM Building_Visit")
    LiveData<List<EBuildingVisit>> GetItinerary();
}
