package com;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    public static final String STATE_CENSUS_DATA_CSV = "C:\\Users\\seema thorat\\IdeaProjects\\MyStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";


    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATE_CENSUS_DATA_CSV, StateCensus.class);
            System.out.println(count);
            Assertions.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
}

