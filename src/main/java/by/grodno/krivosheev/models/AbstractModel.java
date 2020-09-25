package by.grodno.krivosheev.models;

/**
 * Abstract class for create new model
 */
public abstract class AbstractModel {
    private final String response;

    public AbstractModel(String str) {
        this.response = str;
    }

    protected String getResponse() {
        return response;
    }

    public abstract String toString();
}
