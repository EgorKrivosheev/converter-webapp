package by.grodno.krivosheev.converterwebapp.entities;

/**
 * Abstract class for create new model
 */
public abstract class AbstractEntity {
    private final String response;

    public AbstractEntity(String str) {
        this.response = str;
    }

    public String getResponse() {
        return response;
    }
}
