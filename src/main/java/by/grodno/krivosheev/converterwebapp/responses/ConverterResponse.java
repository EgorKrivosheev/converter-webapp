package by.grodno.krivosheev.converterwebapp.responses;

public class ConverterResponse extends AbstractResponse {
    private final String typeResponse;

    public ConverterResponse(String typeResponse, String response) {
        super(response);
        this.typeResponse = typeResponse;
    }

    public String getTypeResponse() {
        return typeResponse;
    }
}
