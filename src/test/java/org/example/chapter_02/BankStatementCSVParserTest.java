package org.example.chapter_02;

import org.example.chapter_02.BankStatementCSVParser;
import org.example.chapter_02.BankStatementParser;
import org.example.chapter_02.BankTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

class BankStatementCSVParserTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction result = bankStatementParser.parseFrom(line);

        double tolerance = 0.0d;

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        assertThat(result.getDate()).isEqualTo(expected.getDate());
        assertThat(result.getAmount()).isCloseTo(expected.getAmount(), offset(tolerance));
        assertThat(result.getDescription()).isEqualTo(expected.getDescription());

    }
}