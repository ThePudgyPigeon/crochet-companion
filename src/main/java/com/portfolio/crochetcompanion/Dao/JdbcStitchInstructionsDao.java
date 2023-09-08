package com.portfolio.crochetcompanion.Dao;

import com.portfolio.crochetcompanion.Model.StitchInstructions;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcStitchInstructionsDao implements StitchInstructionsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcStitchInstructionsDao(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<StitchInstructions> getStitchInstructions(int crochetStitchId) {
        List<StitchInstructions> stitchInstructions = new ArrayList<>();
        StitchInstructions stitchInstruction;
        String sql = "SELECT row, number FROM stitch_instructions " +
                "WHERE crochet_stitch_id = ? " +
                "ORDER BY number ASC;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, crochetStitchId);
            while (results.next()) {
                stitchInstruction = mapRowToStitchInstructions(results);
                stitchInstructions.add(stitchInstruction);
            }
        } catch (CannotGetJdbcConnectionException e) {

        }

        return stitchInstructions;
    }

    private StitchInstructions mapRowToStitchInstructions(SqlRowSet rs) {
        StitchInstructions instruction = new StitchInstructions();
        instruction.setInstructionsId(rs.getInt("stitch_instructions_id"));
        instruction.setCrochetStitchId(rs.getInt("crochet_stitch_id"));
        instruction.setText(rs.getString("text"));
        instruction.setLineNumber(rs.getInt("number"));
        return instruction;
    }

}
