// Function to decode JWT token and get expiration
function getTokenExpiration(token) {
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
      return new Date(payload.exp * 1000).toLocaleString();
    }
    return "No expiration found in token";
  } catch (e) {
    return "Invalid token format";
  }
}
