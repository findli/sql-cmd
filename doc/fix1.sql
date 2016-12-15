ALTER TABLE company ADD FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );
ALTER TABLE contact ADD FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );