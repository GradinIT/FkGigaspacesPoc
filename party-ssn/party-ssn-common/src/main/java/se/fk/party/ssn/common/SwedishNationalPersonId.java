package se.fk.party.ssn.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
public class SwedishNationalPersonId extends NationalPersonId implements Serializable {
    private static final Pattern regexPattern = Pattern.compile("^(\\d{2})?(\\d{2})(\\d{2})(\\d{2})([-+]?)?((?!000)\\d{3})(\\d?)$");
    private String id;
    private int realDay;
    private String fullYear;
    private String century;
    private String year;
    private String month;
    private String day;
    private String numbers;
    private String controlNumber;

    @Builder
    public SwedishNationalPersonId(String id) {
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Boolean isValid() {
        return isValid(true);
    }

    public Boolean isValid(boolean allowCoordinationNumber) {
        Matcher matches = regexPattern.matcher(id);
        if (!matches.find()) return Boolean.FALSE;
        String century;
        String decade = matches.group(2);
        if (matches.group(1) != null && !matches.group(1).isEmpty()) {
            century = matches.group(1);
        } else {
            int born = LocalDate.now().getYear() - Integer.parseInt(decade);
            if (!matches.group(5).isEmpty() && matches.group(5).equals("+")) {
                born -= 100;
            }

            century = Integer.toString(born).substring(0, 2);
        }

        int day = Integer.parseInt(matches.group(4));
        if (allowCoordinationNumber) {
            day = day > 60 ? day - 60 : day;
        } else if (day > 60) {
            return Boolean.FALSE;
        }

        this.realDay = day;
        this.century = century;
        this.year = decade;
        this.fullYear = century + decade;
        this.month = matches.group(3);
        this.day = matches.group(4);
        this.numbers = matches.group(6) + matches.group(7);
        this.controlNumber = matches.group(7);

        try {
            DateTimeFormatter.ofPattern("yyyy MM dd").parse(String.format("%s %s %02d", this.fullYear, this.month, this.realDay));
        } catch (DateTimeParseException e) {
            return Boolean.FALSE;
        }


        // The format passed to Luhn method is supposed to be YYmmDDNNN
        // Hence all numbers that are less than 10 (or in last case 100) will have leading 0's added.
        if (luhnMod10Algorithm(String.format("%s%s%s%s", this.year, this.month, this.day, matches.group(6))) != Integer.parseInt(this.controlNumber)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Integer getAge() {
        return (LocalDate.of(Integer.parseInt(fullYear), Integer.parseInt(month), realDay).until(LocalDate.now())).getYears();
    }

    public Gender getGender() {
        return (Integer.parseInt(Character.toString(this.numbers.charAt(2))) % 2 == 1)?Gender.MALE:Gender.FEMALE;
    }

    private int luhnMod10Algorithm(String value) {
        // Luhn/mod10 algorithm. Used to calculate a checksum from the
        // passed value. The checksum is returned and tested against the control number
        // in the personal identity number to make sure that it is a valid number.

        int temp;
        int sum = 0;

        for (int i = 0; i < value.length(); i++) {
            temp = Character.getNumericValue(value.charAt(i));
            temp *= 2 - (i % 2);
            if (temp > 9)
                temp -= 9;

            sum += temp;
        }

        return (10 - (sum % 10)) % 10;
    }
}
