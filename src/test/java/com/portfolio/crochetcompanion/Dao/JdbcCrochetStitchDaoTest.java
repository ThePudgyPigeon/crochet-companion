package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.CrochetStitch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcCrochetStitchDaoTest extends BaseDaoTest {


    private final CrochetStitch STITCH_1 = new CrochetStitch(1, "Stitch1", "Test Description 1", "t1");

    private final CrochetStitch STITCH_2 = new CrochetStitch(2, "TestStitch2", "Test Description 2", null);

    private final CrochetStitch STITCH_3 = new CrochetStitch(3, "TestStitch3", "Test Description 3", "t3");

    private JdbcCrochetStitchDao dao;

    @Before
    public void setup() {
        dao = new JdbcCrochetStitchDao(dataSource);
    }

    @Test
    public void getStitchById_returns_correct_stitch_for_id() {
        CrochetStitch crochetStitch = dao.getStitchById(1);
        assertCrochetStitchesMatch(STITCH_1, crochetStitch);

        crochetStitch = dao.getStitchById(3);
        assertCrochetStitchesMatch(STITCH_3, crochetStitch);

    }

    @Test
    public void getCrochetStitches_returns_list_of_all_necessary_stitches() {
        List<CrochetStitch> testStitches = new ArrayList<>();
        testStitches.add(STITCH_1);
        testStitches.add(STITCH_2);
        testStitches.add(STITCH_3);

        List<CrochetStitch> retrievedStitches = dao.getCrochetStitches();
        Assert.assertEquals("Retrieved crochet stitches should have correct number of stitches.", testStitches.size(), retrievedStitches.size());
    }
//
//    @Test
//    public void getStitchesByAbbreviation_returns_correct_stitches() {
//        String abbreviation = "j";
//        List<CrochetStitch> testStitches = new ArrayList<>();
//        testStitches.add(STITCH_1);
//        testStitches.add(STITCH_3);
//
//        List<CrochetStitch> retrievedStitches = dao.getStitchesByAbbreviation(abbreviation);
//        Assert.assertEquals("Retrieved crochet stitches should have correct number of stitches", testStitches.size(), retrievedStitches.size());
//    }
//
//    @Test
//    public void getStitchesByName_should_return_correct_stitches() {
//        String name = "test";
//        List<CrochetStitch> testStitches = new ArrayList<>();
//        testStitches.add(STITCH_2);
//        testStitches.add(STITCH_3);
//
//        List<CrochetStitch> retrievedStitches = dao.getStitchesByName(name);
//        Assert.assertEquals("Retrieved crochet stitches should have correct number of stitches", testStitches.size(), retrievedStitches.size());
//    }

    private void assertCrochetStitchesMatch(CrochetStitch expected, CrochetStitch actual) {
        Assert.assertEquals(expected.getCrochetStitchId(), actual.getCrochetStitchId());
        Assert.assertEquals(expected.getStitchName(), actual.getStitchName());
        Assert.assertEquals(expected.getStitchDescription(), actual.getStitchDescription());
        Assert.assertEquals(expected.getStitchAbbreviation(), actual.getStitchAbbreviation());
    }

}
