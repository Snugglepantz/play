$("#searchterm").keyup(function() {
  var q = $("#searchterm").val();
  $("#results").empty();
  $.getJSON("http://" +document.location.host + "/Play/rest/customer/n/" + q, function(data) {
    $("#results").append("Results for <b>" + q + "</b>");
    $.each(data, function(i, item) {
      $("#results").append('<p>' + item.name + '</p>');
    });
  });
});
