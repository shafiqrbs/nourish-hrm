<!DOCTYPE html>
<html lang="en" ng-app="cloudErpLoginApp">
<head>
    <meta charset="UTF-8">
    <title>Welcome To Cloud Software Solution Ltd.</title>
    <meta http-equiv="X-UA-Compatible" content=="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/global/fonts/line-awesome/css/line-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="assets/global/fonts/open-sans/styles.css">
    <link rel="stylesheet" type="text/css" href="libs/tether/css/tether.min.css">
    <link rel="stylesheet" type="text/css" href="assets/global/styles/common.min.css">
    <link rel="stylesheet" type="text/css" href="assets/global/styles/pages/auth.min.css">
</head>
<body>

<div class="ks-page">
    <div class="ks-body">
        <div class="ks-logo"><img src="/assets/global/img/logos/clouderp-logo-dark.png" /></div>
        <div class="card panel panel-default ks-light ks-panel ks-login" ng-controller="loginController">
            <div class="card-block">
                <form class="form-container" action="/login" method="post">
                    <h4 class="ks-header">Login</h4>
                    <div class="form-group">
                        <div class="input-icon icon-left icon-lg icon-color-primary">
                            <input type="text" name="username"  class="form-control" placeholder="Username">
                            <span class="icon-addon">
                                <span class="la la-at"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-icon icon-left icon-lg icon-color-primary">
                            <input type="password" class="form-control" name="password" placeholder="Password">
                            <span class="icon-addon">
                                <span class="la la-key"></span>
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <button type="submit"  class="btn btn-primary btn-block">Login</button>
                    </div>
                    <div class="ks-text-center">
                        <a href="pages-forgot-password.html">Forgot your password?</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="ks-footer">
        <span class="ks-copyright">
         &copy; CloudERP <br />
        2017 - Version 1.0
        </span>
    </div>
</div>

<script src="/libs/jquery/jquery.min.js"></script>
<script src="/libs/tether/js/tether.min.js"></script>
<script src="/libs/bootstrap/js/bootstrap.min.js"></script>
<script src="/libs/angular/angular.min.js"></script>
<script src="/libs/angular/angular-ui-router.min.js"></script>
<script src="/assets/hrm/app/controller/account/loginController.js"></script>
</body>
</html>