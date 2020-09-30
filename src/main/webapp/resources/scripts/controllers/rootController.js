'use strict';

_CONVERTER_APP.controller("rootController", ['$scope', 'converterService', function ($scope, converterService) {
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
    $scope.inpTextarea = "";
    $scope.outTextarea = "";
    $scope.convert = function convert() {
        if ($scope.check.type === "JSON" || $scope.check.type === "XML") {
            $scope.outTextarea = converterService.convert($scope.check.type, $scope.inpTextarea)
                .then(
                    function (success){
                        $scope.outTextarea = success.data.response;
                    },
                    function (error) {
                        $scope.outTextarea = error.data.response;
                    }
                );
        }
    };
}]);
