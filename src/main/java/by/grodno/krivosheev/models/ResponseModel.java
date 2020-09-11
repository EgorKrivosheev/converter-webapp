package by.grodno.krivosheev.models;

public class ResponseModel {
    private final String textType;
    private final String text;


    public ResponseModel(String textType, String text) {
        this.textType = textType;
        this.text = text;
    }

    @Override
    public String toString() {
        return "{ \"textType\": " + textType + ", \"text\": " + text + " }";
    }
}
