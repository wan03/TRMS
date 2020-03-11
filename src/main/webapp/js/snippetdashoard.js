let form = JSON.parse(data);
let row1 = $("<div>").addClass("row");
let id = $("<p>").addClass("col s6");
let employee = $("<p>").addClass("col s6");
row1.append(id, employee);
let row2 = $("<div>").addClass("row");
let address = $("<p>").addClass("col s4");
let userId = $("<p>").addClass("col s4");
let email = $("<p>").addClass("col s4");
row2.append(address, userId, email);
let row3 = $("<div>").addClass("row");
let institutionName = $("<p>").addClass("col s6");
let institutionAddress = $("<p>").addClass("col s6");
row3.append(institutionName, institutionAddress);
let row4 = $("<div>").addClass("row");
let programName = $("<p>").addClass("col s4");
let startDate = $("<p>").addClass("col s4");
let endDate = $("<p>").addClass("col s4");
row4.append(programName, startDate, endDate);
let row5 = $("<div>").addClass("row");
let weekDays = $("<p>").addClass("col s6");
let timeBlock = $("<p>").addClass("col s6");
row5.append(weekDays, timeBlock);
let row6 = $("<div>").addClass("row");
let description = $("<p>").addClass("col s12");
row6.append(description);
let row7 = $("<div>").addClass("row");
let cost = $("<p>").addClass("col s3");
let reimbursementAmount = $("<p>").addClass("col s3");
let gradeFormat = $("<p>").addClass("col s3");
let eventType = $("<p>").addClass("col s3");
row7.append(cost, reimbursementAmount, gradeFormat, eventType);
let row8 = $("<div>").addClass("row");
let justification = $("<p>").addClass("col s6");
let infoRequest = $("<p>").addClass("col s6");
row8.append(justification, infoRequest);
let row9 = $("<div>").addClass("row");
let submitted = $("<p>").addClass("col s6");
let status = $("<p>").addClass("col s6");
row9.append(submitted, status);
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
id.text(form.reimbursementId);
employee.text(form.firstName + " " + form.lastName);
address.text(
  form.address + ", " + form.city + ", " + form.state + " " + form.zip
);
userId.text(form.userId);
email.text(form.email);
institutionName.text(form.institutionName);
institutionAddress.text(
  form.institutionaddress +
    ", " +
    form.institutioncity +
    ", " +
    form.institutionstate +
    " " +
    form.institutionzip
);
programName.text(form.programName);
startDate.text(
  form.startDate.month + "/" + form.startDate.day + "/" + form.startDate.year
);
endDate.text(
  form.endDate.month + "/" + form.endDate.day + "/" + form.endDate.year
);
weekDays.text(form.weekDays);
timeBlock.text(form.timeBlock);
description.text(form.description);
cost.text("$" + form.cost);
gradeFormat.text(form.gradeFormat);
eventType.text(form.eventType);
reimbursementAmount.text("$" + form.reimbursementAmount);
submitted.text(
  form.submitted.month + "/" + form.submitted.day + "/" + form.submitted.year
);
justification.text(form.justification);
status.text(form.status);
$("#reimbursement_table").css("display", "none");
$("#single_reimbursement").append(
  row1,
  row2,
  row3,
  row4,
  row5,
  row6,
  row7,
  row8,
  row9,
  requestInfoBtn,
  approveBtn
);
