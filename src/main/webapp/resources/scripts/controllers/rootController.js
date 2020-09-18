'use strict';

_CONVERTER_APP.controller("rootController", function ($scope) {

    $scope.check = {};
    $scope.types = [{
        value: "JSON"
    }, {
        value: "XML"
    }];
    $scope.setOutType = function () {
        if ($scope.check.type === "JSON") {
            $scope.setClassOutTextarea = "";
            $scope.setClassConvertBtn = "";
            return "Output text type XML";
        }
        else if ($scope.check.type === "XML") {
            $scope.setClassOutTextarea = "";
            $scope.setClassConvertBtn = "";
            return "Output text type JSON";
        }
        else {
            $scope.setClassOutTextarea = "close";
            $scope.setClassConvertBtn = "btn-close";
            return "Select input text type";
        }
    };

});
