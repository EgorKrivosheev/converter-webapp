package by.grodno.krivosheev.models;

public class ConverterModel extends AbstractModel {
    private final String typeResponse;

    public ConverterModel(String typeResponse, String response) {
        super(response);
        this.typeResponse = typeResponse;
    }

    public String getTypeResponse() {
        return typeResponse;
    }
}
