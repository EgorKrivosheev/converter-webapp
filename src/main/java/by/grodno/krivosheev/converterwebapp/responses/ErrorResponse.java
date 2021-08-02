package by.grodno.krivosheev.converterwebapp.responses;

public class ErrorResponse extends AbstractResponse {
    private final short codeError;

    public ErrorResponse(short code, String response) {
        super(response);
        this.codeError = code;
    }

    public short getCodeError() {
        return codeError;
    }
}
