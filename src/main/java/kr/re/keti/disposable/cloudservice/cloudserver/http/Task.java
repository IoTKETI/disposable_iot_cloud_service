package kr.re.keti.disposable.cloudservice.cloudserver.http;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
@ToString
public class Task {


    private int id;
    private String name;
    private String description;
    private String type;
    private Object category;
    private String inputParameters;
    private List<OutPutParameter> outputParameters;
    private List<FlexibleParameter> flexibleParameters;
    private List<StaticParameter> staticParameters;
    private String useYn;
    private String creator;
    private String modifier;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;

}
