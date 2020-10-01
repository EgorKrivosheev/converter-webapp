<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="EN" ng-app="converterApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0" />
        <meta name="MobileOptimized" content="width" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <title>Error 404</title>
        <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/favicon.ico' />">
        <style>
            * {
                padding: 0;
                margin: 0;
                border: 0;
                user-select: none;
                box-sizing: border-box;
            }
            html {
                width: 100%;
                height: 100%;
            }
            body {
                display: flex;
                flex-flow: column nowrap;
                width: 100%;
                height: 100%;
                font-size: 2.5vh;
                font-family: Georgia, serif;
                line-height: 1;
                background-color: red;
            }
            main {
                flex: auto;
                display: flex;
                flex-flow: column nowrap;
                justify-content: center;
                margin: 1em;
            }
            footer {
                display: flex;
                flex-flow: row nowrap;
                justify-content: space-between;
            }
            header, footer {
                flex: 0 1 auto;
                font-weight: bold;
                background-color: white;
                padding: 0.5em 1em;
            }
            .text-shadow-red {
                text-shadow: red 0.025em 0 0, red 0 0.025em 0,
                red -0.025em 0 0, red 0 -0.025em 0;
            }
            .text-shadow-white {
                text-shadow: white 0.025em 0 0, white 0 0.025em 0,
                white -0.025em 0 0, white 0 -0.025em 0;
            }
            .wrap-link {
                text-align: center;
                margin-top: 3em;
            }
            .link {
                display: inline-block;
                color: white;
                text-decoration: none;
                padding: 0.5em 1em;
                border: 0.25em solid black;
                text-shadow: black 0.025em 0 0, black 0 0.025em 0,
                black -0.025em 0 0, black 0 -0.025em 0;
            }
            #github {
                width: 1em;
                background: url(<c:url value='/resources/images/github.svg' />) center /cover no-repeat content-box padding-box transparent;
            }
            a:hover {
                transform: scale(1.25);
            }
            #version {
                display: inline-block;
                text-align: center;
            }
        </style>
    </head>

    <body>
        <header>
            <h1 class="text-shadow-red">Converter</h1>
        </header>

        <main>
            <h1 style="text-align: center" class="text-shadow-white">Error - 404</h1>
            <h2 style="text-align: center" class="text-shadow-white">Page not found</h2>
            <div class="wrap-link">
                <a class="link" href="<c:url value="/" />">Go main</a>
            </div>
        </main>

        <footer>
            <a id="github" href="https://github.com/EgorKrivosheev/converter.app" title="github: converter.app"></a>
            <div id="version" class="text-shadow-red">{{ version }}</div>
        </footer>
    </body>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.0/angular.min.js"></script>
    <script src="<c:url value="/resources/scripts/converterApp.js" />"></script>
</html>
