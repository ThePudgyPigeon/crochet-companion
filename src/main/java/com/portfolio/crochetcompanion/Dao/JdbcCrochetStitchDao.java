package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.CrochetStitch;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcCrochetStitchDao implements CrochetStitchDao {


    private final String SQL_BASE_SELECTOR = "SELECT crochet_stitch_id, stitch_name, " +
            "stitch_description, stitch_abbreviation FROM crochet_stitch";
    private final JdbcTemplate jdbcTemplate;

    public JdbcCrochetStitchDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public CrochetStitch getStitchById(int id) {
        CrochetStitch crochetStitch = null;
        String sql = SQL_BASE_SELECTOR + " WHERE crochet_stitch_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                crochetStitch = mapRowToCrochetStitch(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            //throw new DaoException("Unable to connect to server or database", e);
        }

        return crochetStitch;
    }

    @Override
    public List<CrochetStitch> getCrochetStitches() {
        return null;
    }

    private CrochetStitch mapRowToCrochetStitch(SqlRowSet rs) {
        CrochetStitch crochetStitch = new CrochetStitch();
        crochetStitch.setCrochetStitchId(rs.getInt("crochet_stitch_id"));
        crochetStitch.setStitchName(rs.getString("stitch_name"));
        crochetStitch.setStitchDescription(rs.getString("stitch_description"));
        crochetStitch.setStitchAbbreviation(rs.getString("stitch_abbreviation"));
        return crochetStitch;
    }

}
