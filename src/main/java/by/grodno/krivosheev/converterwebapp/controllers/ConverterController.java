package by.grodno.krivosheev.converterwebapp.controllers;

import by.grodno.krivosheev.converterwebapp.responses.AbstractResponse;
import by.grodno.krivosheev.converterwebapp.responses.ConverterResponse;
import by.grodno.krivosheev.converterwebapp.responses.ErrorResponse;

import by.grodno.krivosheev.core.AbstractObject;
import by.grodno.krivosheev.core.Converter;

import by.grodno.krivosheev.objects.JsonObject;
import by.grodno.krivosheev.objects.XmlObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API", produces = "application/json")
public class ConverterController {

    @GetMapping(value = "/toJSON")
    public ResponseEntity<AbstractResponse> toJSON(@RequestParam(value = "source") String source) {
        return responseEntity("JSON", source);
    }

    @GetMapping(value = "/toXML")
    public ResponseEntity<AbstractResponse> toXML(@RequestParam(value = "source") String source) {
        return responseEntity("XML", source);
    }

    private ResponseEntity<AbstractResponse> responseEntity(String type, String source) {
        if (source.equals("")) {
            return new ResponseEntity<>(new ErrorResponse((short) 400, "Input text empty!"), HttpStatus.BAD_REQUEST);
        }
        AbstractObject obj = null;
        try {
            switch (type) {
                case "JSON":
                    obj = Converter.xmlToJson(new XmlObject(source));
                    break;
                case "XML":
                    obj = Converter.jsonToXml(new JsonObject(source));
                    break;
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErrorResponse((short) 409, e.getMessage() == null ?
                    "Input text incorrect!" :
                    e.getMessage()), HttpStatus.CONFLICT);
        }
        if (obj == null || obj.isEmpty()) {
            return new ResponseEntity<>(new ErrorResponse((short) 409, "Input text incorrect!"), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ConverterResponse(type, obj.toString()), HttpStatus.OK);
    }
}
