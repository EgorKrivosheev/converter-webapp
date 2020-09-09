package by.grodno.krivosheev.controllers;

import by.grodno.krivosheev.core.Converter;
import by.grodno.krivosheev.core.Parser;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParserController {

    @RequestMapping(value = "/toJSON", method = RequestMethod.GET)
    public String responseObjectJSON(@RequestParam(value = "source") @NotNull String source) {
        return Converter.toJSON(Parser.getObjectXML(source)).toString();
    }

    @RequestMapping(value = "/toXML", method = RequestMethod.GET)
    public String responseObjectXML(@RequestParam(value = "source") @NotNull String source) {
        return Converter.toXML(Parser.getObjectJSON(source)).toString();
    }
}
