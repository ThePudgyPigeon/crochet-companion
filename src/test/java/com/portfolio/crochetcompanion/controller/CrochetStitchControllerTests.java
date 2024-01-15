package com.portfolio.crochetcompanion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.service.CrochetStitchService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CrochetStitchController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class CrochetStitchControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CrochetStitchService stitchService;

    @Autowired
    private ObjectMapper objectMapper;

    private final CrochetStitch STITCH_1 = new CrochetStitch(1L, "Single Crochet", "sc");
    private final CrochetStitch STITCH_2 = new CrochetStitch(2L, "Slip Stitch", "ss");
    private final CrochetStitch STITCH_3 = new CrochetStitch(3L, "Chain Stitch", "ch");


    @Test
    public void list_returnsAllScripts() throws Exception {
            List<CrochetStitch> stitches = List.of(STITCH_1, STITCH_2, STITCH_3);
        when(stitchService.getAllStitches(Mockito.any(), Mockito.any()))
                .thenReturn(stitches);

        ResultActions response = mockMvc.perform(get("/api/crochet-stitches"));


        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.size()", CoreMatchers.is(3)));
    }

    @Test
    public void getScript_returnsScript() throws Exception {
        when(stitchService.getCrochetStitch(Mockito.anyLong()))
                .thenReturn(STITCH_1);

        ResultActions response = mockMvc.perform(get("/api/crochet-stitches/{id}", "1"));

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.stitchName", CoreMatchers.is(STITCH_1.getStitchName())));

    }

}
