<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="EN" ng-app="converterApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0" />
        <meta name="MobileOptimized" content="width" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <title>Converter</title>
        <meta name="description" content="Converter JSON, XML" />
        <link rel="canonical" href="https://converter-github.herokuapp.com/" />
        <link rel="stylesheet" href="<c:url value='/resources/style.css' />">
        <script src="<c:url value="/resources/scripts/events.js" />"></script>
        <link rel="icon" type="image/png" sizes="16x16" href="<c:url value='/resources/images/icons/favicon-16x16.png' />">
        <link rel="icon" type="image/png" sizes="24x24" href="<c:url value='/resources/images/icons/favicon-24x24.png' />">
        <link rel="icon" type="image/png" sizes="32x32" href="<c:url value='/resources/images/icons/favicon-32x32.png' />">
        <link rel="icon" type="image/png" sizes="36x36" href="<c:url value='/resources/images/icons/android-icon-36x36.png' />">
        <link rel="icon" type="image/png" sizes="48x48" href="<c:url value='/resources/images/icons/android-icon-48x48.png' />">
        <link rel="apple-touch-icon" sizes="57x57" href="<c:url value='/resources/images/icons/apple-icon-57x57.png' />">
        <link rel="apple-touch-icon" sizes="60x60" href="<c:url value='/resources/images/icons/apple-icon-60x60.png' />">
        <link rel="icon" type="image/png" sizes="72x72" href="<c:url value='/resources/images/icons/favicon-72x72.png' />">
        <link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/images/icons/apple-icon-76x76.png' />">
        <link rel="icon" type="image/png" sizes="96x96" href="<c:url value='/resources/images/icons/android-icon-96x96.png' />">
        <link rel="apple-touch-icon" sizes="114x114" href="<c:url value='/resources/images/icons/apple-icon-114x114.png' />">
        <link rel="apple-touch-icon" sizes="120x120" href="<c:url value='/resources/images/icons/apple-icon-120x120.png' />">
        <link rel="icon" type="image/png" sizes="128x128" href="<c:url value='/resources/images/icons/favicon-128x128.png' />">
        <link rel="icon" type="image/png" sizes="144x144" href="<c:url value='/resources/images/icons/favicon-144x144.png' />">
        <link rel="apple-touch-icon" sizes="152x152" href="<c:url value='/resources/images/icons/apple-icon-152x152.png' />">
        <link rel="apple-touch-icon" sizes="180x180" href="<c:url value='/resources/images/icons/apple-icon-180x180.png' />">
        <link rel="icon" type="image/png" sizes="192x192"  href="<c:url value='/resources/images/icons/android-icon-192x192.png' />">
        <link rel="icon" type="image/png" sizes="384x384" href="<c:url value='/resources/images/icons/favicon-384x384.png' />">
        <link rel="icon" type="image/png" sizes="512x512" href="<c:url value='/resources/images/icons/favicon-512x512.png' />">
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/favicon.ico' />">
        <link rel="shortcut icon" type="image/svg+xml" href="<c:url value='/resources/images/icons/favicon.svg' />">
        <meta property="og:title" content="Converter" />
        <meta property="og:site_name" content="converter-github.herokuapp.com" />
        <meta property="og:url" content="https://converter-github.herokuapp.com/" />
        <meta property="og:description" content="Converter JSON, XML" />
        <meta property="og:image" content="<c:url value='/resources/images/icons/favicon-512x512.png' />" />
        <meta property="og:locale" content="EN" />
    </head>

    <body ng-controller="rootController">

        <header>
             <h1 class="text-shadow-red">Converter</h1>
        </header>

        <main id="main" style="flex-direction: row;">

            <div class="wrap">
                <div class="label" >Input text type:
                    <label ng-repeat="radio in types">
                        <input type="radio" name="types" value="{{ radio.value }}" ng-model="check.type" />
                        {{ radio.value }}
                    </label>
                </div>
                <textarea aria-label="Input text"></textarea>
            </div>

            <div id="menu" style="flex-direction: column;" class="wrap-menu">
                <button id="convert" class="btn-convert" aria-label="Convert" title="Convert" ng-class="setClassConvertBtn"></button>
            </div>

            <div class="wrap">
                <div class="label">{{ setOutType() }}
                </div>
                <textarea readonly aria-label="Output text" ng-class="setClassOutTextarea"></textarea>
            </div>

        </main>

        <footer>
            <a id="github" href="https://github.com/EgorKrivosheev/converter.github.io" title="github: Egor Krivosheev"></a>
            <div id="version" class="text-shadow-red">{{ version }}</div>
        </footer>

    </body>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
    <script src="<c:url value="/resources/scripts/converterApp.js" />"></script>
    <script src="<c:url value="/resources/scripts/controllers/rootController.js" />"></script>

</html>
