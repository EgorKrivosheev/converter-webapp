package by.grodno.krivosheev.converterwebapp.entities;

public class ErrorEntity extends AbstractEntity {
    private final short codeError;

    public ErrorEntity(short code, String response) {
        super(response);
        this.codeError = code;
    }

    public short getCodeError() {
        return codeError;
    }
}
