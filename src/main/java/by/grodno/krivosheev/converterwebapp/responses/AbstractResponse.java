package by.grodno.krivosheev.converterwebapp.responses;

public abstract class AbstractResponse {
    private final String response;

    public AbstractResponse(String str) {
        this.response = str;
    }

    public String getResponse() {
        return response;
    }
}
