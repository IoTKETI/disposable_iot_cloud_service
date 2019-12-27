package kr.re.keti.disposable.cloudservice.cloudserver.http;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Parameter {

    private int id;
    private String dataType;
    private String fullName;
    private String shortName;
    private double value;

}
