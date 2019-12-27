package kr.re.keti.disposable.cloudservice.cloudserver.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OutPutParameter {

    private int Id;
    private String dataType;
    private String unitCategory;
    private String unit;   // Todo: enum Type 고려
    private double minValue;
    private double maxValue;



    public enum UnitCategory {
        ATEMP("000"),
        TEMP("001"),
        AHUM("002"),
        HUM("003"),
        ACO2("004"),
        CO2("005");

        private String code;
        UnitCategory(String code) {
            this.code = code;
        }

        @JsonValue
        public String getCode() {
            return code;
        }

        @JsonCreator
        public static UnitCategory getString(String code) {
            return Arrays.stream(UnitCategory.values())
                    .filter(v -> v.getCode().equals(code))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("No matching constant for [" + code + "]"));
        }
    }

}
