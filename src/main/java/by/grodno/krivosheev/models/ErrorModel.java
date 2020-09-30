package by.grodno.krivosheev.models;

public class ErrorModel extends AbstractModel {
    private final short codeError;

    public ErrorModel(short code, String response) {
        super(response);
        this.codeError = code;
    }

    public short getCodeError() {
        return codeError;
    }

    @Override
    public String toString() {
        return "{ \"codeError\": " + codeError + ", \"response\": " + this.getResponse() + " }";
    }
}
