ALTER TABLE crm_pallas."user"
  ADD password VARCHAR(255) NULL;

UPDATE crm_pallas."user"
SET password = 'password';