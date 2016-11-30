CREATE SCHEMA IF NOT EXISTS crius;
SET search_path TO crius;

CREATE TABLE IF NOT EXISTS stage_deals (
  id int NOT NULL,
  name VARCHAR(100) NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS "language" (
  id int NOT NULL,
  name VARCHAR(45) NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS "user" (
  id SERIAL NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  is_admin BOOLEAN,
  phone VARCHAR(45),
  mobile_phone VARCHAR(45),
  note VARCHAR(300),
  deleted BOOLEAN,
  image BYTEA,
  url VARCHAR(100),
  language_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (language_id)
    REFERENCES language (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS company (
  id SERIAL NOT NULL,
  name VARCHAR(200) NOT NULL,
  phone VARCHAR(100) NOT NULL,
  email VARCHAR(45) NOT NULL,
  address VARCHAR(200) NOT NULL,
  responsible_user_id INT NOT NULL,
  web VARCHAR(45),
  deleted BOOLEAN,
  created_by_id INT NOT NULL,
  date_cteate TIMESTAMP,
  PRIMARY KEY (id),
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (created_by_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS position (
  id int NOT NULL,
  name VARCHAR(45),
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS contact (
  id SERIAL NOT NULL,
  name VARCHAR(300) NOT NULL,
  responsible_user_id INT NOT NULL,
  positionId INT NOT NULL,
  type_of_phone VARCHAR(45),
  phone VARCHAR(45),
  skype VARCHAR(45),
  email VARCHAR(45),
  deleted BOOLEAN,
  date_cteate TIMESTAMP,
  create_by_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (create_by_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (positionId)
    REFERENCES position (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS deal (
  id SERIAL NOT NULL,
  name VARCHAR(100) NOT NULL,
  stage_id INT NOT NULL,
  responsible_user_id INT,
  amount DECIMAL(20,2),
  company_id INT NOT NULL,
  deleted BOOLEAN,
  date_cteate TIMESTAMP,
  create_by_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (stage_id)
    REFERENCES stage_deals (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (create_by_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS task_type (
  id int NOT NULL,
  name VARCHAR(45) NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS task_status (
  id int NOT NULL,
  name VARCHAR(100) NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS task (
  id SERIAL NOT NULL,
  period INT NOT NULL,
  responsible_user_id INT NOT NULL,
  task_type_id INT NOT NULL,
  created_by_id INT NOT NULL,
  name VARCHAR(500),
  status_id INT NOT NULL,
  deleted BOOLEAN,
  date_create TIMESTAMP NOT NULL,
  company_id INT,
  contact_id INT,
  deal_id INT,
  PRIMARY KEY (id),
    FOREIGN KEY (responsible_user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (created_by_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (task_type_id)
    REFERENCES task_type (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (status_id)
    REFERENCES task_status (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (deal_id)
    REFERENCES deal (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS note (
  id SERIAL NOT NULL,
  note VARCHAR(500),
  created_by_id INT NOT NULL,
  date_cteate TIMESTAMP NOT NULL,
  deleted BOOLEAN,
  deal_id INT,
  company_id INT,
  contact_id INT,
  PRIMARY KEY (id),
    FOREIGN KEY (created_by_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (deal_id)
    REFERENCES deal (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS attached_file (
  id SERIAL NOT NULL,
  created_by_id INT NOT NULL,
  date_create TIMESTAMP NOT NULL,
  filename VARCHAR(100),
  filesize INT,
  deleted BOOLEAN,
  url_file VARCHAR(100) NULL,
  file BYTEA,
  contact_id INT NOT NULL,
  company_id INT NOT NULL,
  deal_id INT NOT NULL,
  PRIMARY KEY (id),
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,  
    FOREIGN KEY (deal_id)
    REFERENCES deal (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS "right" (
  id int NOT NULL,
  type_of_rule INT NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS value_rule (
  id SERIAL NOT NULL,
  user_id INT NOT NULL,
  right_id INT NOT NULL,
  rule_create BOOLEAN,
  rule_read BOOLEAN,
  rule_deleted BOOLEAN,
  rule_change BOOLEAN,
  rule_export BOOLEAN,
  deleted BOOLEAN,
  PRIMARY KEY (id),
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (right_id)
    REFERENCES "right" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS company_contact (
  company_id INT NOT NULL,
  contact_id INT NOT NULL,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS deal_contact (
  deal_id INT NOT NULL,
  contact_id INT NOT NULL,
    FOREIGN KEY (deal_id)
    REFERENCES deal (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS visit_history (
  id SERIAL NOT NULL,
  user_id INT NOT NULL,
  date_create TIMESTAMP NOT NULL,
  ip_address VARCHAR(45),
  browser VARCHAR(45),
  deleted BOOLEAN,
  PRIMARY KEY (id),
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS tag (
  id SERIAL NOT NULL,
  name VARCHAR(1000) NOT NULL,
  deleted BOOLEAN,
  PRIMARY KEY (id));



CREATE TABLE IF NOT EXISTS contact_company_tag (
  id SERIAL NOT NULL,
  contact_id INT,
  tag_id INT NOT NULL,
  company_id INT,
  deleted BOOLEAN,
  PRIMARY KEY (id),
    FOREIGN KEY (contact_id)
    REFERENCES contact (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (tag_id)
    REFERENCES tag (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (company_id)
    REFERENCES company (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS deal_tag (
  deal_id INT NOT NULL,
  tag_id INT NOT NULL,
    FOREIGN KEY (deal_id)
    REFERENCES deal (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (tag_id)
    REFERENCES tag (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS currency (
  id int NOT NULL,
  name VARCHAR(45) NOT NULL,
  active BOOLEAN,
  deleted BOOLEAN,
  PRIMARY KEY (id));

