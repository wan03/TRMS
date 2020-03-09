-- Create Tables

CREATE TABLE employee
(
  empid SERIAL PRIMARY KEY,
  fist_name VARCHAR,
  last_name VARCHAR,
  username VARCHAR NOT NULL UNIQUE,
  password VARCHAR NOT NULL,
  user_type VARCHAR NOT NULL,
  position VARCHAR,
  supervisor INTEGER,
  department_head INTEGER,
  available_reimbursement DECIMAL(8,2),
  pending_reimbursement DECIMAL(8,2)

);

CREATE TABLE reimbursement
(
  reimbid SERIAL PRIMARY KEY,
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

);

  -- Create Foreing Keys

  ALTER TABLE employee
ADD CONSTRAINT FK_Supervisor
FOREIGN KEY (supervisor) REFERENCES Employee (empid) ON DELETE CASCADE ON UPDATE NO ACTION;

  ALTER TABLE employee
ADD CONSTRAINT FK_Department_Head
FOREIGN KEY (department_head) REFERENCES Employee (empid) ON DELETE CASCADE ON UPDATE NO ACTION;

  ALTER TABLE reimbursement
ADD CONSTRAINT FK_Employee_ID
FOREIGN KEY (user_id) REFERENCES Employee (empid) ON DELETE CASCADE ON UPDATE NO ACTION;

  -- Insert into db


  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, available_reimbursement)
  VALUES
    ('Hermione', 'Weasley', 'hweasley', 'pass', 'departmeent head', 'Headmistress', 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, department_head, available_reimbursement)
  VALUES
    ('Theodore', 'Nott', 'tnott', 'pass', 'supervisor', 'Potions', 1, 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, department_head, available_reimbursement)
  VALUES
    ('Neville', 'Longbottom', 'nlongbottom', 'pass', 'supervisor', 'DADA', 1, 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, supervisor, department_head, available_reimbursement)
  VALUES
    ('Colin', 'Creevey', 'ccreevey', 'pass', 'employeee', 'Muggle Studies', 3, 1, 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, supervisor, department_head, available_reimbursement)
  VALUES
    ('Ronald', 'Weasley', 'rweasley', 'pass', 'employeee', 'Flying Instructor', 3, 1, 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, supervisor, department_head, available_reimbursement)
  VALUES
    ('Susan', 'Bones', 'sbones', 'pass', 'employeee', 'Charms', 2, 1, 1000);

  INSERT INTO employee
    (first_name, last_name, username, password, user_type, position, supervisor, department_head, available_reimbursement)
  VALUES
    ('Daphne', 'Greengrass', 'dgreengrass', 'pass', 'employeee', 'Transfiguration', 2, 1, 1000);

  INSERT INTO reimbursement
    (first_name, last_name, address, state, zip, user_id, email, institution_name, institution_address, institution_state, institution_zip, program_name, start_date, end_date, week_days, time_block, description, cost, grade_format, event_type, reimbursement_amount, justification, status)
  VALUES
    ('Ronald', 'Weasley', '325 N Florida', 'FL', '33817', 5, 'rwesley@hogwarts.edu', 'USF', '123 Laurel Ave', 'FL', '33898', 'Flying Training', '2020-12-11', '2021-01-01', '[Monday, Wednesday]', '[3:00pm - 5:00pm]', 'Training to improve flying', 500, 'Pass-Fail', 'training', 500, 'Improving my flying ability will allow me to be a more effective teacher.', 'pending');

  INSERT INTO reimbursement
    (first_name, last_name, address, state, zip, user_id, email, institution_name, institution_address, institution_state, institution_zip, program_name, start_date, end_date, week_days, time_block, description, cost, grade_format, event_type, reimbursement_amount, justification, status)
  VALUES
    ('Ronald', 'Weasley', '325 N Florida', 'FL', '33817', 5, 'rwesley@hogwarts.edu', 'USF', '123 Laurel Ave', 'FL', '33898', 'Leadearship Training', '2020-12-11', '2021-01-01', '[Tuesday, Thursday]', '[3:00pm - 5:00pm]', 'Training to improve leadership', 800, 'Presentation', 'training', 800, 'Learning more about leadership will allow me to be better with the students', 'pending');

  INSERT INTO reimbursement
    (first_name, last_name, address, state, zip, user_id, email, institution_name, institution_address, institution_state, institution_zip, program_name, start_date, end_date, week_days, time_block, description, cost, grade_format, event_type, reimbursement_amount, justification, status)
  VALUES
    ('Susan', 'Bones', '9678 S Tampa Ave', 'FL', '33747', 6, 'sbones@hogwarts.edu', 'USF', '123 Laurel Ave', 'FL', '33898', 'Leadearship Training', '2020-12-11', '2021-01-01', '[Tuesday, Thursday]', '[3:00pm - 5:00pm]', 'Training to improve leadership', 800, 'Presentation', 'training', 800, 'Learning more about leadership will allow me to be better with the students', 'pending');
