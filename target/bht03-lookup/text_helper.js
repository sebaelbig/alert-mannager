// External clipboard utility function
function copyTextToClipboard(text) {
  return navigator.clipboard
    .writeText(text)
    .then(function () {
      alert("Copied to clipboard!");
    })
    .catch(function (err) {
      console.error("Failed to copy text: ", err);
    });
}
