package by.grodno.krivosheev.controllers;

import by.grodno.krivosheev.core.Parser;
import by.grodno.krivosheev.objects.ObjectJSON;
import by.grodno.krivosheev.objects.ObjectXML;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParserController {

    @RequestMapping(value = "/toJSON", method = RequestMethod.GET)
    public ObjectJSON responseObjectJSON(@NotNull String source) {
        return Parser.getObjectJSON(source);
    }

    @RequestMapping(value = "/toXML", method = RequestMethod.GET)
    public ObjectXML responseObjectXML(@NotNull String source) {
        return Parser.getObjectXML(source);
    }
}
