package kr.re.keti.disposable.cloudservice.cloudserver.common;

public class Response {

    private String type;
    private String title;
    private String detail;

    public Response(String type, String title, String detail) {
        this.type = type;
        this.title = title;
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type=" + type +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
