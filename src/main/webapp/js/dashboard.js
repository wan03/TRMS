$(document).ready(function() {
  getReimbursemets();
  $("#request_button").on("click", sendRequest);
});

function getReimbursemets() {
  $.get("/trms/reimbursement", function(data, status) {
    if (status === "success" && data) {
      let reimbursements = JSON.parse(data);
      for (let form of reimbursements) {
        let row = $("<tr>");
        let id = $("<td>");
        let employee = $("<td>");
        let institutionName = $("<td>");
        let programName = $("<td>");
        let startDate = $("<td>");
        let endDate = $("<td>");
        let weekDays = $("<td>");
        let timeBlock = $("<td>");
        let cost = $("<td>");
        let reimbursementAmount = $("<td>");
        let submitted = $("<td>");
        let status = $("<td>");
        id.text(form.reimbursementId);
        employee.text(form.firstName + " " + form.lastName);
        institutionName.text(form.institutionName);
        programName.text(form.programName);
        startDate.text(
          form.startDate.month +
            "/" +
            form.startDate.day +
            "/" +
            form.startDate.year
        );
        endDate.text(
          form.endDate.month + "/" + form.endDate.day + "/" + form.endDate.year
        );
        weekDays.text(form.weekDays);
        timeBlock.text(form.timeBlock);
        cost.text("$" + form.cost);
        reimbursementAmount.text("$" + form.reimbursementAmount);
        submitted.text(
          form.submitted.month +
            "/" +
            form.submitted.day +
            "/" +
            form.submitted.year
        );
        status.text(form.status);
        row.append(
          id,
          employee,
          institutionName,
          programName,
          startDate,
          endDate,
          weekDays,
          timeBlock,
          cost,
          reimbursementAmount,
          submitted,
          status
        );
        row.attr("rid", form.reimbursementId);
        row.on("click", singleReimbursement);
        $("#reimbursement_table_body").append(row);
      }
    }
  });
}

function singleReimbursement() {
  event.preventDefault;
  let rid = $(this).attr("rid");
  $("#reimbursement_table").css("display", "none");
  $("#single_form").css("display", "block");
  $.get("/trms/reimbursement/" + rid, function(data, status) {
    if (status === "success" && data) {
      let form = JSON.parse(data);
      console.log(form);
      $("#first_name").val(form.firstName);
      $("#last_name").val(form.lastName);
      $("#city").val(form.city);
      $("#address").val(form.address);
      $("#state").val(form.state);
      $("#zip").val(form.zip);
      $("#user_id").val(form.userId);
      $("#email").val(form.email);
      $("#submitted").val(
        form.submitted.month +
          "/" +
          form.submitted.day +
          "/" +
          form.submitted.year
      );
      $("#institution").val(form.institutionName);
      $("#intaddress").val(form.institutionaddress);
      $("#intcity").val(form.institutioncity);
      $("#intstate").val(form.institutionstate);
      $("#intzip").val(form.institutionzip);
      $("#program_name").val(form.programName);
      $("#start_date").val(
        form.startDate.month +
          "/" +
          form.startDate.day +
          "/" +
          form.startDate.year
      );
      $("#end_date").val(
        form.endDate.month + "/" + form.endDate.day + "/" + form.endDate.year
      );
      $("#day_week").val(form.weekDays);
      $("#time_block").val(form.timeBlock);
      $("#description").val(form.description);
      $("#cost").val(form.cost);
      $("#grade_format").val(form.gradeFormat);
      $("#event_type").val(form.eventType);
      $("#reimbursement_amount").val(form.reimbursementAmount);
      $("#justification").val(form.justification);
      $("#information_request").val(form.informationRequest);
      let requestInfoBtn = $("<a>")
        .addClass("waves-effect waves-light blue lighten-1 btn")
        .attr("id", "requestBtn")
        .on("click", requestInfo)
        .text("Information Request")
        .attr("rid", form.reimbursementId);
      let approveBtn = $("<a>")
        .addClass("waves-effect waves-light blue lighten-1 btn")
        .attr("id", "approveBtn")
        .on("click", approveReimbursement)
        .text("Approve")
        .attr("rid", form.reimbursementId);
      $("#single_buttons").append(requestInfoBtn, approveBtn);
    }
  });
}

function approveReimbursement() {
  event.preventDefault;
  let form = {};
  let id = $(this).attr("rid");
  console.log(id);
  form.reimbursementId = id;
  $.ajax({
    method: "PUT",
    url: "/trms/reimbursement",
    data: JSON.stringify(form)
  }).done(() => {
    let instance = M.Modal.getInstance($("#approve_modal"));
    instance.open();
  });
}

function requestInfo() {
  let instance = M.Modal.getInstance($("#request_modal"));
  instance.open();
}

function sendRequest() {
  event.preventDefault;
  let form = {};
  form.informationRequest = $("#request_description").val();
  let id = $("#requestBtn").attr("rid");
  console.log(id);
  form.reimbursementId = id;
  $.ajax({
    method: "PUT",
    url: "/trms/reimbursement",
    data: JSON.stringify(form)
  });
}
