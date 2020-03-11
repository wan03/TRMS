$(document).ready(function() {
  $("#login").on("click", login);
});

function login() {
  let user = {};
  user.username = $("#username").val();
  user.password = $("#password").val();
  $.post("/trms/login", JSON.stringify(user))
    .fail(function() {
      $("#username").val("");
      $("#password").val("");
      let instance = M.Modal.getInstance($("#login_modal"));
      instance.open();
    })
    .done(() => {
      window.location.replace("dashboard");
    });
}
