$(document).ready(function() {
  getReimbursemets();
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
        $("#reimbursement_table").append(row);
      }
    }
  });
}
