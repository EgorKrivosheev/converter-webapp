package by.grodno.krivosheev.controllers;

import by.grodno.krivosheev.core.Converter;
import by.grodno.krivosheev.core.Parser;
import by.grodno.krivosheev.models.ConverterModel;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @RequestMapping(value = "/toJSON", method = RequestMethod.GET, produces = "application/json")
    public String responseObjectJSON(@RequestParam(value = "source") @NotNull String source) {
        return new ConverterModel("JSON", Converter.toJSON(Parser.getObjectXML(source)).toString()).toString();
    }

    @RequestMapping(value = "/toXML", method = RequestMethod.GET, produces = "application/json")
    public String responseObjectXML(@RequestParam(value = "source") @NotNull String source) {
        return new ConverterModel("XML", Converter.toXML(Parser.getObjectJSON(source)).toString()).toString();
    }
}
