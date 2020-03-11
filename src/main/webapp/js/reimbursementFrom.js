$(document).ready(function() {
  $("#submit").on("click", sendForm);
  $("#event_type").on("change", calcAmount);
  $("#cost").on("keyup", calcAmount);
});

function calcAmount() {
  let eventType = $("#event_type").val();
  let cost = $("#cost").val();

  switch (eventType) {
    case "university":
      $("#reimbursement_amount").val(formatMoney(cost * 0.8));
      break;
    case "seminar":
      $("reimbursement_amount").val(formatMoney(cost * 0.6));
      break;
    case "cert_prep":
      $("reimbursement_amount").val(formatMoney(cost * 0.75));
      break;
    case "certification":
      $("reimbursement_amount").val(formatMoney(cost));
      break;
    case "training":
      $("reimbursement_amount").val(formatMoney(cost * 0.9));
      break;
    case "other":
      $("reimbursement_amount").val(formatMoney(cost * 0.3));
      break;
    default:
      break;
  }
}

function formatMoney(number) {
  let decPlaces = 2;
  let decSep = ".";
  let thouSep = ",";
  let sign = number < 0 ? "-" : "";
  let i = String(
    parseInt((number = Math.abs(Number(number) || 0).toFixed(decPlaces)))
  );
  let j;
  j = (j = i.length) > 3 ? j % 3 : 0;

  return (
    sign +
    (j ? i.substr(0, j) + thouSep : "") +
    i.substr(j).replace(/(\decSep{3})(?=\decSep)/g, "$1" + thouSep) +
    (decPlaces
      ? decSep +
        Math.abs(number - i)
          .toFixed(decPlaces)
          .slice(2)
      : "")
  );
}

function sendForm() {
  event.preventDefault;
  let form = {};
  form.firstName = $("#first_name").val();
  form.lastName = $("#last_name").val();
  form.address = $("#address").val();
  form.city = $("#city").val();
  form.state = $("#state").val();
  form.zip = $("#zip").val();
  form.userId = $("#user_id").val();
  form.email = $("#email").val();
  form.institutionName = $("#institution").val();
  form.institutionaddress = $("#intaddress").val();
  form.institutioncity = $("#intcity").val();
  form.institutionstate = $("#intstate").val();
  form.institutionzip = $("#intzip").val();
  form.programName = $("#program_name").val();
  form.startDate = $("#start_date").val();
  form.endDate = $("#end_date").val();
  form.weekDays = $("#day_week")
    .val()
    .toString();
  form.timeBlock = $("#time_block")
    .val()
    .toString();
  form.description = $("#description").val();
  form.cost = $("#cost").val();
  form.gradeFormat = $("#grade_format").val();
  form.eventType = $("#event_type").val();
  form.reimbursementAmount = $("#reimbursement_amount").val();
  form.justification = $("#justification").val();
  //TODO figure out how to handle file
  $.post("/trms/reimbursement", JSON.stringify(form)).done(() => {
    $("#first_name").val("");
    $("#last_name").val("");
    $("#city").val("");
    $("#address").val("");
    $("#state").val("");
    $("#zip").val("");
    $("#user_id").val("");
    $("#email").val("");
    $("#institution").val("");
    $("#intaddress").val("");
    $("#intcity").val("");
    $("#intstate").val("");
    $("#intzip").val("");
    $("#program_name").val("");
    $("#start_date").val("");
    $("#end_date").val("");
    $("#day_week").val("");
    $("#time_block").val("");
    $("#description").val("");
    $("#cost").val("");
    $("#grade_format").val("");
    $("#event_type").val("");
    $("#reimbursement_amount").val("");
    $("#justification").val("");
    let instance = M.Modal.getInstance($("#success_modal"));
    instance.open();
  });
}
