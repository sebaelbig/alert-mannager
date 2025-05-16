import copyTextToClipboard from './text_helper.js';
import getTokenExpiration from './token_helper.js';
// app.js - Main Angular Application Module
angular
  .module("bht03LookupApp", [])
  .controller("LookupController", function ($scope, $http) {
    // Initialize variables
    $scope.bht03Code = "";
    $scope.prsUuid = null;
    $scope.sqlResults = [];
    $scope.ruleConfigurations = [];
    $scope.loading = false;
    $scope.error = null;
    $scope.showBenefits = false;

    // Function to perform the lookup
    $scope.performLookup = function () {
      if (!$scope.bht03Code) {
        $scope.error = "Please enter a BHT03 code";
        return;
      }

      $scope.loading = true;
      $scope.error = null;
      $scope.prsUuid = null;
      $scope.sqlResults = [];
      $scope.ruleConfigurations = [];

      // First get the UUID
      $http
        .get("./api/lookup/uuid", {
          params: { bht03Code: $scope.bht03Code },
        })
        .then(function (response) {
          if (response.data && response.data.uuid) {
            $scope.prsUuid = response.data.uuid;
            // Now get the details using the UUID
            return $http.get("./api/lookup/details", {
              params: { prsUuid: response.data.uuid },
            });
          } else {
            throw new Error("No UUID found in response");
          }
        })
        .then(function (detailsResponse) {
          $scope.loading = false;
          if (detailsResponse.data) {
            $scope.sqlResults = detailsResponse.data.sqlResults || [];
            $scope.ruleConfigurations =
              detailsResponse.data.ruleConfigurations || [];
          } else {
            $scope.error = "No results found or invalid response";
          }
        })
        .catch(function (error) {
          $scope.loading = false;
          $scope.error =
            "Error performing lookup: " +
            (error.data?.message || error.statusText || "Unknown error");
          console.error("Lookup error:", error);
        });
    };

    // Function to format JSON for display
    $scope.formatJson = function (jsonString) {
      try {
        const obj = JSON.parse(jsonString);
        if (obj.ruleBody) {
          // Find the index of 'rule' in the ruleBody string
          const ruleIndex = obj.ruleBody.indexOf("rule");
          if (ruleIndex !== -1) {
            // Keep only the content from 'rule' onwards
            obj.ruleBody = obj.ruleBody.substring(ruleIndex);
          }
        }
        return JSON.stringify(obj, null, 2);
      } catch (e) {
        return jsonString;
      }
    };

    // Add toggleRuleBody function
    $scope.toggleRuleBody = function (rule) {
      var collapseElement = document.getElementById(
        "ruleBody" + $scope.ruleConfigurations.indexOf(rule)
      );
      var bsCollapse = new bootstrap.Collapse(collapseElement, {
        toggle: true,
      });
    };

    $scope.copyToClipboard = function (text) {
      copyTextToClipboard(text);
    };
  })
  .controller("ScopesController", function ($scope, $http) {
    $scope.selectedEnvironment = "DEV";
    $scope.scopeName = "";
    $scope.authToken = "";
    $scope.loading = false;
    $scope.response = null;
    $scope.error = false;

    // Function to format scope name
    function formatScopeName(name) {
      return name.toUpperCase().replace(/\s+/g, "_");
    }

    // Function to get cookie value by name
    function getCookie(name) {
      const value = `; ${document.cookie}`;
      const parts = value.split(`; ${name}=`);
      if (parts.length === 2) return parts.pop().split(";").shift();
      return null;
    }

    $scope.submitScope = function () {
      if (!$scope.scopeName || !$scope.selectedEnvironment) {
        return;
      }

      $scope.loading = true;
      $scope.response = null;
      $scope.error = false;

      // Create the request data with formatted scope name
      const requestData = {
        relm: $scope.selectedEnvironment,
        scope: {
          name: formatScopeName($scope.scopeName),
          disabledByDefault: false,
          productId: 3,
          terminateAfterHit: true,
        },
      };

      // Add authToken if provided
      if ($scope.authToken) {
        requestData.authToken = $scope.authToken;
      } else {
        // Only get cookies if no authToken is provided
        const dsmSessionId = getCookie("dsm.sessionId");
        const jsessionId = getCookie("JSESSIONID");

        if (!dsmSessionId || !jsessionId) {
          $scope.error = true;
          $scope.response =
            "Required cookies are missing. Please ensure you are logged in or provide an auth token.";
          $scope.loading = false;
          return;
        }

        requestData.cookies = {
          "dsm.sessionId": dsmSessionId,
          JSESSIONID: jsessionId,
        };
      }

      $http
        .post("./api/lookup/scopes", requestData)
        .then(function (response) {
          $scope.response = JSON.stringify(response.data, null, 2);
          $scope.error = false;
        })
        .catch(function (error) {
          $scope.response = error.data?.message || "An error occurred";
          $scope.error = true;
        })
        .finally(function () {
          $scope.loading = false;
        });
    };

    // Initialize delete form variables
    $scope.deleteEnvironment = "DEV";
    $scope.scopeId = null;
    $scope.deleteAuthToken = "";
    $scope.deleteLoading = false;

    $scope.deleteScope = function () {
      $scope.deleteLoading = true;
      $scope.error = null;
      $scope.response = null;

      const realmId = $scope.deleteEnvironment;

      // Prepare request data
      let requestData = {
        relm: realmId,
        scopeId: $scope.scopeId,
      };

      if ($scope.deleteAuthToken) {
        requestData.authToken = $scope.deleteAuthToken;
      }

      // Make the DELETE request
      $http
        .delete("./api/lookup/scopes/" + $scope.scopeId, {
          headers: {
            Authorization: $scope.deleteAuthToken || "",
            Realm: $scope.deleteEnvironment, // Send as header instead of query param
          },
        })
        .then(function (response) {
          $scope.deleteLoading = false;
          $scope.response = "Scope deleted successfully";
          $scope.error = null;
        })
        .catch(function (error) {
          $scope.deleteLoading = false;
          $scope.error = error.data?.message || "Failed to delete scope";
          $scope.response = null;
        });
    };

    // Add token info display when token changes
    $scope.$watch("authToken", function (newValue) {
      if (newValue) {
        $scope.tokenExpiration = getTokenExpiration(newValue);
      } else {
        $scope.tokenExpiration = null;
      }
    });
    $scope.$watch("deleteAuthToken", function (newValue) {
      if (newValue) {
        $scope.tokenExpiration = getTokenExpiration(newValue);
      } else {
        $scope.tokenExpiration = null;
      }
    });

    // Add isTokenExpired function
    $scope.isTokenExpired = function (token) {
      if (!token) return false;
      try {
        const base64Url = token.split(".")[1];
        const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
        const jsonPayload = decodeURIComponent(
          atob(base64)
            .split("")
            .map(function (c) {
              return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
            })
            .join("")
        );

        const payload = JSON.parse(jsonPayload);
        if (payload.exp) {
          return Date.now() >= payload.exp * 1000;
        }
        return false;
      } catch (e) {
        return false;
      }
    };
    
    $scope.activateEnvironment = "DEV";
    $scope.activateScope = function() {
        $scope.activateLoading = true;
        $scope.activateError = false;
        $scope.activateResponse = '';

        var url = 'lookup/scopes/activate/' + 
                 $scope.activateEnvironment + '/' + 
                 $scope.activateScopeName + '/' + 
                 $scope.customerId;

        var headers = {
            'Content-Type': 'application/json'
        };
        
        if ($scope.activateAuthToken) {
            headers['Authorization'] = $scope.activateAuthToken;
        }

        $http.post(url, null, { headers: headers })
            .then(function(response) {
                $scope.activateResponse = 'Scope activated successfully';
                $scope.activateError = false;
            })
            .catch(function(error) {
                $scope.activateResponse = error.data.message || 'Failed to activate scope';
                $scope.activateError = true;
            })
            .finally(function() {
                $scope.activateLoading = false;
            });
    };
  });
