'use strict';

_CONVERTER_APP.service("converterService", ['$http', '$q', function ($http, $q) {
    return {
        convert: convert
    };

    function convert(type, str) {
        let defer = $q.defer();
        let url_API = "API/";

        if (type === "JSON") {
            url_API += "toXML";
        } else if (type === "XML") {
            url_API += "toJSON";
        }
        $http.get(url_API, { params: { source: str } })
            .then(
                function (success) {
                    defer.resolve(success);
                },
                function (error) {
                    defer.reject(error);
                }
            );
        return defer.promise;
    }
}]);
