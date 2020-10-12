package by.grodno.krivosheev.controllers;

import by.grodno.krivosheev.core.AbstractObject;
import by.grodno.krivosheev.core.Converter;
import by.grodno.krivosheev.core.Parser;
import by.grodno.krivosheev.models.AbstractModel;
import by.grodno.krivosheev.models.ConverterModel;
import by.grodno.krivosheev.models.ErrorModel;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @RequestMapping(value = "/toJSON", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AbstractModel> toJSON(@RequestParam(value = "source") @NotNull String source) {
        return responseEntity("JSON", source);
    }

    @RequestMapping(value = "/toXML", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AbstractModel> toXML(@RequestParam(value = "source") @NotNull String source) {
        return responseEntity("XML", source);
    }

    @NotNull
    private ResponseEntity<AbstractModel> responseEntity(@NotNull String type, String source) {
        if (source.equals("")) return new ResponseEntity<>(new ErrorModel((short) 400, "Input text empty!"), HttpStatus.BAD_REQUEST);
        AbstractObject obj = new AbstractObject() {
            @Override
            public String toString() {
                return "Empty object!";
            }
        };
        try {
            if (type.equals("JSON")) {
                obj = Converter.toJSON(Parser.getObjectXML(source));
            } else if (type.equals("XML")) {
                obj = Converter.toXML(Parser.getObjectJSON(source));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorModel((short) 409, e.getMessage() == null ? "Error!!! Input text incorrect!" : e.getMessage()), HttpStatus.CONFLICT);
        }
        if (obj.toString().equals("Empty object!")) return new ResponseEntity<>(new ErrorModel((short) 409, "Input text incorrect!"), HttpStatus.CONFLICT);
        return new ResponseEntity<>(new ConverterModel(type, obj.toString()), HttpStatus.OK);
    }
}
