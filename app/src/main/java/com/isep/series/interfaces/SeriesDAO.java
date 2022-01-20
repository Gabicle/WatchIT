package com.isep.series.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.isep.series.models.Entities.Series;

import java.util.List;

@Dao
public interface SeriesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(Series series);

    @Query("DELETE FROM  TV_Series")
     void DeleteAll();

    @Query("SELECT DISTINCT * FROM TV_Series")
     LiveData<List<Series>> getAllTvSeries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertAll(List<Series>SeriesEntities);

}
