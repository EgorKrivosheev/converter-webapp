'use strict';

_CONVERTER_APP.controller("rootController", ['$scope', 'converterService', function ($scope, converterService) {
    $scope.check = {};
    $scope.types = [{
        value: "JSON"
    }, {
        value: "XML"
    }];
    $scope.inpTextarea = "";
    $scope.outTextarea = "";
    $scope.isSuccessOrError = true; // true = success request, false = request error

    $scope.setOutType = function () {
        if ($scope.check.type === "JSON" || $scope.check.type === "XML") {
            $scope.setClassOutTextarea = $scope.isSuccessOrError ?
                "success" :
                "error";
            $scope.setClassConvertBtn = "";
            $scope.placeholderInpTextarea = "Input " + $scope.check.type + " text";
            return "Output text type " + ($scope.check.type === "JSON" ?
                "XML" :
                "JSON");
        }
        $scope.setClassOutTextarea = "close";
        $scope.setClassConvertBtn = "btn-close";
        $scope.placeholderInpTextarea = "Select input text type";
        return "Select input text type";
    };
    $scope.convert = function convert() {
        if ($scope.check.type === "JSON" || $scope.check.type === "XML") {
            $scope.outTextarea = converterService.convert($scope.check.type, $scope.inpTextarea)
                .then(
                    function (success){
                        $scope.isSuccessOrError = true;
                        $scope.outTextarea = success.data.response;
                    },
                    function (error) {
                        $scope.isSuccessOrError = false;
                        $scope.outTextarea = error.data.response;
                    }
                );
        }
    };
}]);
