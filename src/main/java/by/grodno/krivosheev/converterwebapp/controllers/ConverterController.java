package by.grodno.krivosheev.converterwebapp.controllers;

import by.grodno.krivosheev.converterwebapp.entities.AbstractEntity;
import by.grodno.krivosheev.converterwebapp.entities.ConverterEntity;
import by.grodno.krivosheev.converterwebapp.entities.ErrorEntity;

import by.grodno.krivosheev.core.AbstractObject;
import by.grodno.krivosheev.core.Converter;
import by.grodno.krivosheev.objects.JsonObject;
import by.grodno.krivosheev.objects.XmlObject;

import org.jetbrains.annotations.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API", produces = "application/json")
public class ConverterController {

    @GetMapping(value = "/toJSON")
    public ResponseEntity<AbstractEntity> toJSON(@RequestParam(value = "source") @NotNull String source) {
        return responseEntity("JSON", source);
    }

    @GetMapping(value = "/toXML")
    public ResponseEntity<AbstractEntity> toXML(@RequestParam(value = "source") @NotNull String source) {
        return responseEntity("XML", source);
    }

    @NotNull
    private ResponseEntity<AbstractEntity> responseEntity(@NotNull String type, String source) {
        if (source.equals("")) {
            return new ResponseEntity<>(new ErrorEntity((short) 400, "Input text empty!"), HttpStatus.BAD_REQUEST);
        }
        AbstractObject obj = null;
        try {
            if (type.equals("JSON")) {
                obj = Converter.xmlToJson(new XmlObject(source));
            } else if (type.equals("XML")) {
                obj = Converter.jsonToXml(new JsonObject(source));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorEntity((short) 409, e.getMessage() == null ?
                    "Input text incorrect!" :
                    e.getMessage()), HttpStatus.CONFLICT);
        }
        if (obj == null || obj.isEmpty()) {
            return new ResponseEntity<>(new ErrorEntity((short) 409, "Input text incorrect!"), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ConverterEntity(type, obj.toString()), HttpStatus.OK);
    }
}
