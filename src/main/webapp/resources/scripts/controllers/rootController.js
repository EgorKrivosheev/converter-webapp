'use strict';

_CONVERTER_APP.controller("rootController", function ($scope) {

    if ($scope.in_text_type === " JSON") {
        $scope.out_text_type = "XML";
    } else {
        $scope.out_text_type = "JSON";
    }

});
