package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.CrochetStitch;

import java.util.List;

public interface CrochetStitchDao {

    CrochetStitch getStitchById(int id);

    List<CrochetStitch> getCrochetStitches();

    List<CrochetStitch> getStitchesByName(String name);

    List<CrochetStitch> getStitchesByAbbreviation(String abbreviation);


}