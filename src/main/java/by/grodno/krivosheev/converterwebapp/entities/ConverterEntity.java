package by.grodno.krivosheev.converterwebapp.entities;

public class ConverterEntity extends AbstractEntity {
    private final String typeResponse;

    public ConverterEntity(String typeResponse, String response) {
        super(response);
        this.typeResponse = typeResponse;
    }

    public String getTypeResponse() {
        return typeResponse;
    }
}
