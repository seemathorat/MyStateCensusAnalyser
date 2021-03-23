package com;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {

    public static final String STATE_CENSUS_DATA_CSV = "C:\\Users\\seema thorat\\IdeaProjects\\MyStateCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String STATE_CODE_CSV = "C:\\Users\\seema thorat\\IdeaProjects\\MyStateCensusAnalyser\\src\\main\\resources\\StateCode.CSV";
    public static final String WRONG_FILE = "/seema.txt";

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

    @Test
    public void GivenTheStateCensusCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void GivenTheStateCensusCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATE_CENSUS_DATA_CSV, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }
}

