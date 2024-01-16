package com.portfolio.crochetcompanion.service;

import com.portfolio.crochetcompanion.model.CrochetStitch;
import com.portfolio.crochetcompanion.repository.CrochetStitchRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrochetStitchServiceTest {

    private final CrochetStitch STITCH_1 = new CrochetStitch();
    private final CrochetStitch STITCH_2 = new CrochetStitch();
    private final CrochetStitch STITCH_3 = new CrochetStitch();

    @Mock
    private CrochetStitchRepository stitchRepository;

    @InjectMocks
    private CrochetStitchService stitchService;

    @Test
    public void getAllStitches_returnsAllStitches() {
        when(stitchRepository.findAll()).thenReturn(List.of(STITCH_1, STITCH_2, STITCH_3));

        List<CrochetStitch> stitches = stitchService.getAllStitches(String.valueOf(""), String.valueOf(""));

        Assertions.assertThat(stitches).hasSize(3);
    }

    @Test
    public void getAllStitches_returnsPartialListWithAbbrvSearch() {
        when(stitchRepository.findStitchByStitchAbbreviation(String.valueOf("slip")))
                .thenReturn(List.of(STITCH_1));

        List<CrochetStitch> stitches = stitchService.getAllStitches(String.valueOf(""), String.valueOf("slip"));

        Assertions.assertThat(stitches).hasSize(1);
    }

    @Test
    public void getAllStitches_returnsPartialListWithNameSearch() {
        when(stitchRepository.findStitchByStitchName(String.valueOf("half")))
                .thenReturn(List.of(STITCH_2, STITCH_3));

        List<CrochetStitch> stitches = stitchService.getAllStitches(String.valueOf("half"), String.valueOf(""));

        Assertions.assertThat(stitches).hasSize(2);
    }

    @Test
    public void getCrochetStitch_returnsCorrectStitch() {
        STITCH_1.setStitchName("Slip Stitch");
        when(stitchRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.ofNullable(STITCH_1));

        CrochetStitch retrievedStitch = stitchService.getCrochetStitch(Mockito.anyLong());

        Assertions.assertThat(retrievedStitch).isEqualTo(STITCH_1);
    }

    @Test
    public void getCrochetStitch_respondsWithNotFoundOnMissingStitch() {
        Assertions.assertThatThrownBy(() -> stitchService.getCrochetStitch(5L))
                .isInstanceOf(ResponseStatusException.class)
                .hasFieldOrPropertyWithValue("status", HttpStatus.NOT_FOUND);

    }

}
