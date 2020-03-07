CREATE TABLE employee
(
  id SERIAL PRIMARY KEY,
  fistname VARCHAR,
  lastname VARCHAR,
  username VARCHAR NOT NULL UNIQUE,
  password VARCHAR NOT NULL,
  user_type VARCHAR NOT NULL,
  position VARCHAR,
  supervisor INTEGER,
  department_head INTEGER,
  available_reimbursement DECIMAL(8,2),
  pending_reimbursement DECIMAL(8,2)

)

CREATE TABLE reimbursement
(
  id SERIAL PRIMARY KEY,
  first_name VARCHAR,
  last_name VARCHAR,
  address VARCHAR,
  state VARCHAR,
  zip VARCHAR,
  user_id INTEGER,
  email VARCHAR,
  institution_name VARCHAR,
  institution_address VARCHAR,
  institution_state VARCHAR,
  institution_zip VARCHAR,
  program_name VARCHAR,
  start_date DATE,
  end_date DATE,
  week_days VARCHAR,
  time_block VARCHAR,
  description VARCHAR,
  cost DECIMAL(8,2),
  grade_format VARCHAR,
  event_type VARCHAR,
  reimbursement_amount DECIMAL(8,2),
  justification VARCHAR,
  status VARCHAR,
  file VARCHAR

)

  ALTER TABLE employee
ADD CONSTRAINT FK_Supervisor
FOREIGN KEY (supervisor) REFERENCES Employee (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

  ALTER TABLE employee
ADD CONSTRAINT FK_Department_Head
FOREIGN KEY (department_head) REFERENCES Employee (id) ON DELETE NO ACTION ON UPDATE NO ACTION;

  ALTER TABLE reimbursement
ADD CONSTRAINT FK_Employee_ID
FOREIGN KEY (user_id) REFERENCES Employee (id) ON DELETE NO ACTION ON UPDATE NO ACTION;