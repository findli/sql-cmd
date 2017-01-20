CREATE SCHEMA crm_pallas;

CREATE SEQUENCE crm_pallas.address_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.company_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.contact_event_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.contact_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.contact_phone_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.currency_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.deal_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.event_action_type_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.event_history_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.event_object_type_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.file_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.ip_white_list_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.language_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.login_history_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.note_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.period_in_days_type_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.phone_type_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.settings_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.stage_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.tag_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.task_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.task_type_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.timezone_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.user_id_seq START WITH 1;

CREATE SEQUENCE crm_pallas.user_phone_id_seq START WITH 1;

CREATE TABLE crm_pallas.address ( 
	id                   serial  NOT NULL,
	country              varchar(100)  ,
	city                 varchar(100)  ,
	street               varchar(150)  ,
	building_number      varchar(10)  ,
	zipcode              integer  ,
	office_room          varchar(20)  ,
	CONSTRAINT pk_address PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.currency ( 
	id                   serial  NOT NULL,
	title                varchar(50)  ,
	short_title          varchar(3)  ,
	CONSTRAINT pk_currency PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.event_action_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_event_action_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.event_object_type ( 
	id                   serial  NOT NULL,
	title                varchar(50)  NOT NULL,
	CONSTRAINT pk_event_object_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."file" ( 
	id                   serial  NOT NULL,
	file_name            varchar(255)  ,
	file_path            varchar(1500)  NOT NULL,
	file_size_in_bytes   bigint  NOT NULL,
	creation_date_time   timestamp  NOT NULL,
	CONSTRAINT pk_file PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."language" ( 
	id                   serial  NOT NULL,
	title                varchar(100)  ,
	short_title          varchar(3)  ,
	CONSTRAINT pk_language PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.period_in_days_type ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	days_in_period       integer  NOT NULL,
	CONSTRAINT pk_period_in_days_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.phone_type ( 
	id                   serial  NOT NULL,
	title                varchar(100)  NOT NULL,
	CONSTRAINT pk_phone_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.stage ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	color                varchar(6)  ,
	priority             smallint  ,
	is_deletable         bool  NOT NULL,
	CONSTRAINT pk_stage PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.tag ( 
	id                   serial  NOT NULL,
	title                varchar(200)  NOT NULL,
	CONSTRAINT pk_tag PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.task_type ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	CONSTRAINT pk_task_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.timezone ( 
	id                   serial  NOT NULL,
	title                varchar(500)  ,
	shift_in_hours       smallint  ,
	CONSTRAINT pk_timezone PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."user" ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  ,
	last_name            varchar(100)  NOT NULL,
	password_hash        varchar(50)  ,
	email                varchar(100)  ,
	is_admin             bool  NOT NULL,
	rights               integer  ,
	photo_path           varchar(500)  ,
	is_notification_enabled bool  ,
	note                 varchar(5000)  ,
	creation_date_time   timestamp  NOT NULL,
	language_id          integer  ,
	CONSTRAINT pk_user PRIMARY KEY ( id )
 );

CREATE INDEX idx_user ON crm_pallas."user" ( language_id );

CREATE TABLE crm_pallas.user_phone ( 
	id                   serial  NOT NULL,
	user_id              integer  NOT NULL,
	phone_type_id        integer  NOT NULL,
	phone_number         varchar(20)  ,
	CONSTRAINT pk_user_phone PRIMARY KEY ( id )
 );

CREATE INDEX idx_user_phone ON crm_pallas.user_phone ( user_id );

CREATE INDEX idx_user_phone_0 ON crm_pallas.user_phone ( phone_type_id );

CREATE TABLE crm_pallas.company ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	phone_number         varchar(20)  ,
	email                varchar(50)  ,
	website              varchar(200)  ,
	address_id           integer  NOT NULL,
	responsible_user_id  integer  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_company PRIMARY KEY ( id )
 );

CREATE INDEX idx_company ON crm_pallas.company ( responsible_user_id );

CREATE INDEX idx_company_0 ON crm_pallas.company ( address_id );

CREATE TABLE crm_pallas.company_tag ( 
	company_id           integer  NOT NULL,
	tag_id               integer  NOT NULL
 );

CREATE INDEX idx_company_tag ON crm_pallas.company_tag ( tag_id );

CREATE INDEX idx_company_tag_0 ON crm_pallas.company_tag ( company_id );

CREATE TABLE crm_pallas.contact ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  ,
	last_name            varchar(100)  NOT NULL,
	company_id           integer  NOT NULL,
	post                 varchar(500)  ,
	email                varchar(100)  ,
	skype                varchar(100)  ,
	responsible_user_id  integer  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_contact PRIMARY KEY ( id )
 );

CREATE INDEX idx_contact ON crm_pallas.contact ( responsible_user_id );

CREATE INDEX idx_contact_0 ON crm_pallas.contact ( company_id );

CREATE TABLE crm_pallas.contact_event ( 
	id                   serial  NOT NULL,
	contact_id           integer  NOT NULL,
	CONSTRAINT pk_contact_event PRIMARY KEY ( id )
 );

CREATE INDEX idx_contact_event ON crm_pallas.contact_event ( contact_id );

CREATE TABLE crm_pallas.contact_phone ( 
	id                   serial  NOT NULL,
	contact_id           integer  NOT NULL,
	phone_type_id        integer  NOT NULL,
	phone_number         varchar(20)  NOT NULL,
	CONSTRAINT pk_contact_phone PRIMARY KEY ( id )
 );

CREATE INDEX idx_contact_phone ON crm_pallas.contact_phone ( contact_id );

CREATE INDEX idx_contact_phone_0 ON crm_pallas.contact_phone ( phone_type_id );

CREATE TABLE crm_pallas.contact_tag ( 
	contact_id           integer  NOT NULL,
	tag_id               integer  NOT NULL
 );

CREATE INDEX idx_contact_note ON crm_pallas.contact_tag ( tag_id );

CREATE INDEX idx_contact_note_0 ON crm_pallas.contact_tag ( contact_id );

CREATE TABLE crm_pallas.deal ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	company_id           integer  NOT NULL,
	budget               integer  ,
	stage_id             integer  NOT NULL,
	responsible_user_id  integer  NOT NULL,
	is_deleted           bool  NOT NULL,
	primary_contact_id   integer  ,
	date_create          timestamp  ,
	CONSTRAINT pk_deal PRIMARY KEY ( id )
 );

CREATE INDEX idx_deal ON crm_pallas.deal ( responsible_user_id );

CREATE INDEX idx_deal_0 ON crm_pallas.deal ( stage_id );

CREATE INDEX idx_deal_1 ON crm_pallas.deal ( company_id );

CREATE INDEX idx_deal_2 ON crm_pallas.deal ( primary_contact_id );

CREATE TABLE crm_pallas.deal_tag ( 
	deal_id              integer  NOT NULL,
	tag_id               integer  NOT NULL
 );

CREATE INDEX idx_deal_tag ON crm_pallas.deal_tag ( deal_id );

CREATE INDEX idx_deal_tag_0 ON crm_pallas.deal_tag ( tag_id );

CREATE TABLE crm_pallas.event_history ( 
	id                   serial  NOT NULL,
	event_object_type_id integer  NOT NULL,
	event_action_type_id integer  NOT NULL,
	object_id            integer  NOT NULL,
	promoted_by_user_id  integer  NOT NULL,
	date_time            timestamp  NOT NULL,
	CONSTRAINT pk_event_history PRIMARY KEY ( id )
 );

CREATE INDEX idx_event_history ON crm_pallas.event_history ( event_object_type_id );

CREATE INDEX idx_event_history_0 ON crm_pallas.event_history ( event_action_type_id );

CREATE INDEX idx_event_history_1 ON crm_pallas.event_history ( promoted_by_user_id );

CREATE TABLE crm_pallas.ip_white_list ( 
	id                   serial  NOT NULL,
	user_id              integer  NOT NULL,
	ip_address           varchar(15)  NOT NULL,
	CONSTRAINT pk_ip_white_list PRIMARY KEY ( id )
 );

CREATE INDEX idx_ip_white_list ON crm_pallas.ip_white_list ( user_id );

CREATE TABLE crm_pallas.login_history ( 
	id                   serial  NOT NULL,
	user_id              integer  NOT NULL,
	date_time            timestamp  NOT NULL,
	ip_address           varchar  NOT NULL,
	browser              varchar(100)  NOT NULL,
	CONSTRAINT pk_login_history PRIMARY KEY ( id )
 );

CREATE INDEX idx_login_history ON crm_pallas.login_history ( user_id );

CREATE TABLE crm_pallas.note ( 
	id                   serial  NOT NULL,
	note_text            varchar(2000)  NOT NULL,
	created_by_user_id   integer  NOT NULL,
	creation_date_time   timestamp  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_note PRIMARY KEY ( id )
 );

CREATE INDEX idx_note ON crm_pallas.note ( created_by_user_id );

CREATE TABLE crm_pallas.note_file ( 
	note_id              integer  NOT NULL,
	file_id              integer  NOT NULL
 );

CREATE INDEX idx_note_file ON crm_pallas.note_file ( file_id );

CREATE INDEX idx_note_file_0 ON crm_pallas.note_file ( note_id );

CREATE TABLE crm_pallas.settings ( 
	id                   serial  NOT NULL,
	default_language_id  integer  NOT NULL,
	timezone_id          integer  NOT NULL,
	currency_id          integer  NOT NULL,
	CONSTRAINT pk_settings PRIMARY KEY ( id )
 );

CREATE INDEX idx_settings ON crm_pallas.settings ( default_language_id );

CREATE INDEX idx_settings_0 ON crm_pallas.settings ( currency_id );

CREATE INDEX idx_settings_1 ON crm_pallas.settings ( timezone_id );

CREATE TABLE crm_pallas.task ( 
	id                   serial  NOT NULL,
	title                varchar(500)  NOT NULL,
	task_type_id         integer  NOT NULL,
	description          varchar(15000)  NOT NULL,
	deadline_date        date  ,
	deadline_time        time  ,
	period_in_days_type_id integer  NOT NULL,
	period_in_minutes    integer  ,
	responsible_user_id  integer  NOT NULL,
	is_finished          bool  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_task PRIMARY KEY ( id )
 );

CREATE INDEX idx_task ON crm_pallas.task ( responsible_user_id );

CREATE INDEX idx_task_0 ON crm_pallas.task ( period_in_days_type_id );

CREATE INDEX idx_task_1 ON crm_pallas.task ( task_type_id );

CREATE TABLE crm_pallas.company_note ( 
	company_id           integer  NOT NULL,
	note_id              integer  NOT NULL
 );

CREATE INDEX idx_company_note ON crm_pallas.company_note ( company_id );

CREATE INDEX idx_company_note_0 ON crm_pallas.company_note ( note_id );

CREATE TABLE crm_pallas.company_task ( 
	company_id           integer  NOT NULL,
	task_id              integer  NOT NULL
 );

CREATE INDEX idx_company_task ON crm_pallas.company_task ( company_id );

CREATE INDEX idx_company_task_0 ON crm_pallas.company_task ( task_id );

CREATE TABLE crm_pallas.contact_deal ( 
	contact_id           integer  NOT NULL,
	deal_id              integer  NOT NULL
 );

CREATE INDEX idx_contact_deal ON crm_pallas.contact_deal ( contact_id );

CREATE INDEX idx_contact_deal_0 ON crm_pallas.contact_deal ( deal_id );

CREATE TABLE crm_pallas.contact_note ( 
	contact_id           integer  NOT NULL,
	note_id              integer  NOT NULL
 );

CREATE INDEX idx_contact_note_1 ON crm_pallas.contact_note ( contact_id );

CREATE INDEX idx_contact_note_2 ON crm_pallas.contact_note ( note_id );

CREATE TABLE crm_pallas.contact_task ( 
	contact_id           integer  NOT NULL,
	task_id              integer  NOT NULL
 );

CREATE INDEX idx_contact_task ON crm_pallas.contact_task ( contact_id );

CREATE INDEX idx_contact_task_0 ON crm_pallas.contact_task ( task_id );

CREATE TABLE crm_pallas.deal_note ( 
	deal_id              integer  NOT NULL,
	note_id              integer  NOT NULL
 );

CREATE INDEX idx_deal_note ON crm_pallas.deal_note ( deal_id );

CREATE INDEX idx_deal_note_0 ON crm_pallas.deal_note ( note_id );

CREATE TABLE crm_pallas.deal_task ( 
	deal_id              integer  NOT NULL,
	task_id              integer  NOT NULL
 );

CREATE INDEX idx_deal_task ON crm_pallas.deal_task ( deal_id );

CREATE INDEX idx_deal_task_0 ON crm_pallas.deal_task ( task_id );

ALTER TABLE crm_pallas.company ADD CONSTRAINT fk_company FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_company ON crm_pallas.company IS '';

ALTER TABLE crm_pallas.company ADD CONSTRAINT fk_company_0 FOREIGN KEY ( address_id ) REFERENCES crm_pallas.address( id );

COMMENT ON CONSTRAINT fk_company_0 ON crm_pallas.company IS '';

ALTER TABLE crm_pallas.company_note ADD CONSTRAINT fk_company_note FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

COMMENT ON CONSTRAINT fk_company_note ON crm_pallas.company_note IS '';

ALTER TABLE crm_pallas.company_note ADD CONSTRAINT fk_company_note_0 FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id );

COMMENT ON CONSTRAINT fk_company_note_0 ON crm_pallas.company_note IS '';

ALTER TABLE crm_pallas.company_tag ADD CONSTRAINT fk_company_tag FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id );

COMMENT ON CONSTRAINT fk_company_tag ON crm_pallas.company_tag IS '';

ALTER TABLE crm_pallas.company_tag ADD CONSTRAINT fk_company_tag_0 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

COMMENT ON CONSTRAINT fk_company_tag_0 ON crm_pallas.company_tag IS '';

ALTER TABLE crm_pallas.company_task ADD CONSTRAINT fk_company_task FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

COMMENT ON CONSTRAINT fk_company_task ON crm_pallas.company_task IS '';

ALTER TABLE crm_pallas.company_task ADD CONSTRAINT fk_company_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id );

COMMENT ON CONSTRAINT fk_company_task_0 ON crm_pallas.company_task IS '';

ALTER TABLE crm_pallas.contact ADD CONSTRAINT fk_contact FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_contact ON crm_pallas.contact IS '';

ALTER TABLE crm_pallas.contact ADD CONSTRAINT fk_contact_0 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

COMMENT ON CONSTRAINT fk_contact_0 ON crm_pallas.contact IS '';

ALTER TABLE crm_pallas.contact_deal ADD CONSTRAINT fk_contact_deal FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_deal ON crm_pallas.contact_deal IS '';

ALTER TABLE crm_pallas.contact_deal ADD CONSTRAINT fk_contact_deal_0 FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id );

COMMENT ON CONSTRAINT fk_contact_deal_0 ON crm_pallas.contact_deal IS '';

ALTER TABLE crm_pallas.contact_event ADD CONSTRAINT fk_contact_event FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_event ON crm_pallas.contact_event IS '';

ALTER TABLE crm_pallas.contact_note ADD CONSTRAINT fk_contact_note FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_note ON crm_pallas.contact_note IS '';

ALTER TABLE crm_pallas.contact_note ADD CONSTRAINT fk_contact_note_1 FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id );

COMMENT ON CONSTRAINT fk_contact_note_1 ON crm_pallas.contact_note IS '';

ALTER TABLE crm_pallas.contact_phone ADD CONSTRAINT fk_contact_phone FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_phone ON crm_pallas.contact_phone IS '';

ALTER TABLE crm_pallas.contact_phone ADD CONSTRAINT fk_contact_phone_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id );

COMMENT ON CONSTRAINT fk_contact_phone_0 ON crm_pallas.contact_phone IS '';

ALTER TABLE crm_pallas.contact_tag ADD CONSTRAINT fk_contact_tag_0 FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_tag_0 ON crm_pallas.contact_tag IS '';

ALTER TABLE crm_pallas.contact_tag ADD CONSTRAINT fk_contact_tag FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id );

COMMENT ON CONSTRAINT fk_contact_tag ON crm_pallas.contact_tag IS '';

ALTER TABLE crm_pallas.contact_task ADD CONSTRAINT fk_contact_task FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_contact_task ON crm_pallas.contact_task IS '';

ALTER TABLE crm_pallas.contact_task ADD CONSTRAINT fk_contact_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id );

COMMENT ON CONSTRAINT fk_contact_task_0 ON crm_pallas.contact_task IS '';

ALTER TABLE crm_pallas.deal ADD CONSTRAINT fk_deal FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_deal ON crm_pallas.deal IS '';

ALTER TABLE crm_pallas.deal ADD CONSTRAINT fk_deal_0 FOREIGN KEY ( stage_id ) REFERENCES crm_pallas.stage( id );

COMMENT ON CONSTRAINT fk_deal_0 ON crm_pallas.deal IS '';

ALTER TABLE crm_pallas.deal ADD CONSTRAINT fk_deal_2 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

COMMENT ON CONSTRAINT fk_deal_2 ON crm_pallas.deal IS '';

ALTER TABLE crm_pallas.deal ADD CONSTRAINT fk_deal_1 FOREIGN KEY ( primary_contact_id ) REFERENCES crm_pallas.contact( id );

COMMENT ON CONSTRAINT fk_deal_1 ON crm_pallas.deal IS '';

ALTER TABLE crm_pallas.deal_note ADD CONSTRAINT fk_deal_note FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id );

COMMENT ON CONSTRAINT fk_deal_note ON crm_pallas.deal_note IS '';

ALTER TABLE crm_pallas.deal_note ADD CONSTRAINT fk_deal_note_0 FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id );

COMMENT ON CONSTRAINT fk_deal_note_0 ON crm_pallas.deal_note IS '';

ALTER TABLE crm_pallas.deal_tag ADD CONSTRAINT fk_deal_tag FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id );

COMMENT ON CONSTRAINT fk_deal_tag ON crm_pallas.deal_tag IS '';

ALTER TABLE crm_pallas.deal_tag ADD CONSTRAINT fk_deal_tag_0 FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id );

COMMENT ON CONSTRAINT fk_deal_tag_0 ON crm_pallas.deal_tag IS '';

ALTER TABLE crm_pallas.deal_task ADD CONSTRAINT fk_deal_task FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id );

COMMENT ON CONSTRAINT fk_deal_task ON crm_pallas.deal_task IS '';

ALTER TABLE crm_pallas.deal_task ADD CONSTRAINT fk_deal_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id );

COMMENT ON CONSTRAINT fk_deal_task_0 ON crm_pallas.deal_task IS '';

ALTER TABLE crm_pallas.event_history ADD CONSTRAINT fk_event_history_0 FOREIGN KEY ( event_object_type_id ) REFERENCES crm_pallas.event_object_type( id );

COMMENT ON CONSTRAINT fk_event_history_0 ON crm_pallas.event_history IS '';

ALTER TABLE crm_pallas.event_history ADD CONSTRAINT fk_event_history FOREIGN KEY ( event_action_type_id ) REFERENCES crm_pallas.event_action_type( id );

COMMENT ON CONSTRAINT fk_event_history ON crm_pallas.event_history IS '';

ALTER TABLE crm_pallas.event_history ADD CONSTRAINT fk_event_history_1 FOREIGN KEY ( promoted_by_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_event_history_1 ON crm_pallas.event_history IS '';

ALTER TABLE crm_pallas.ip_white_list ADD CONSTRAINT fk_ip_white_list FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_ip_white_list ON crm_pallas.ip_white_list IS '';

ALTER TABLE crm_pallas.login_history ADD CONSTRAINT fk_login_history FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_login_history ON crm_pallas.login_history IS '';

ALTER TABLE crm_pallas.note ADD CONSTRAINT fk_note FOREIGN KEY ( created_by_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_note ON crm_pallas.note IS '';

ALTER TABLE crm_pallas.note_file ADD CONSTRAINT fk_note_file FOREIGN KEY ( file_id ) REFERENCES crm_pallas."file"( id );

COMMENT ON CONSTRAINT fk_note_file ON crm_pallas.note_file IS '';

ALTER TABLE crm_pallas.note_file ADD CONSTRAINT fk_note_file_0 FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id );

COMMENT ON CONSTRAINT fk_note_file_0 ON crm_pallas.note_file IS '';

ALTER TABLE crm_pallas.settings ADD CONSTRAINT fk_settings FOREIGN KEY ( default_language_id ) REFERENCES crm_pallas."language"( id );

COMMENT ON CONSTRAINT fk_settings ON crm_pallas.settings IS '';

ALTER TABLE crm_pallas.settings ADD CONSTRAINT fk_settings_0 FOREIGN KEY ( currency_id ) REFERENCES crm_pallas.currency( id );

COMMENT ON CONSTRAINT fk_settings_0 ON crm_pallas.settings IS '';

ALTER TABLE crm_pallas.settings ADD CONSTRAINT fk_settings_1 FOREIGN KEY ( timezone_id ) REFERENCES crm_pallas.timezone( id );

COMMENT ON CONSTRAINT fk_settings_1 ON crm_pallas.settings IS '';

ALTER TABLE crm_pallas.task ADD CONSTRAINT fk_task FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_task ON crm_pallas.task IS '';

ALTER TABLE crm_pallas.task ADD CONSTRAINT fk_task_0 FOREIGN KEY ( period_in_days_type_id ) REFERENCES crm_pallas.period_in_days_type( id );

COMMENT ON CONSTRAINT fk_task_0 ON crm_pallas.task IS '';

ALTER TABLE crm_pallas.task ADD CONSTRAINT fk_task_1 FOREIGN KEY ( task_type_id ) REFERENCES crm_pallas.task_type( id );

COMMENT ON CONSTRAINT fk_task_1 ON crm_pallas.task IS '';

ALTER TABLE crm_pallas."user" ADD CONSTRAINT fk_user FOREIGN KEY ( language_id ) REFERENCES crm_pallas."language"( id );

COMMENT ON CONSTRAINT fk_user ON crm_pallas."user" IS '';

ALTER TABLE crm_pallas.user_phone ADD CONSTRAINT fk_user_phone FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id );

COMMENT ON CONSTRAINT fk_user_phone ON crm_pallas.user_phone IS '';

ALTER TABLE crm_pallas.user_phone ADD CONSTRAINT fk_user_phone_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id );

COMMENT ON CONSTRAINT fk_user_phone_0 ON crm_pallas.user_phone IS '';

INSERT INTO crm_pallas.address( country, city, street, building_number, zipcode, office_room, id ) VALUES ( 'ukraine', 'kyiv', 'lenina', '10', 4050, '12', 1 ); 

INSERT INTO crm_pallas."language"( title, short_title, id ) VALUES ( 'ukr', 'ukr', 1 ); 

INSERT INTO crm_pallas.stage( title, color, priority, is_deletable, id ) VALUES ( 'main', 'white', 1, false, 1 ); 
INSERT INTO crm_pallas.stage( title, color, priority, is_deletable, id ) VALUES ( 'meeting', 'white', 1, false, 2 ); 

INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'main', 1 ); 
INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'priority', 2 ); 
INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'important', 3 ); 
INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'conditional', 4 ); 
INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'working', 5 ); 
INSERT INTO crm_pallas.task_type( title, id ) VALUES ( 'production', 6 ); 

INSERT INTO crm_pallas."user"( first_name, last_name, password_hash, email, is_admin, rights, photo_path, is_notification_enabled, note, creation_date_time, language_id, id ) VALUES ( 'Masha', 'Petrova', '', 'masha@google.com', true, 1, '', true, 'note2', '2016-07-25 12:16:01', 1, 2 ); 
INSERT INTO crm_pallas."user"( first_name, last_name, password_hash, email, is_admin, rights, photo_path, is_notification_enabled, note, creation_date_time, language_id, id ) VALUES ( 'Petya', 'Ivanov', '', 'petya@google.com', true, 1, '', true, 'note2', '2016-07-25 12:16:01', 1, 3 ); 
INSERT INTO crm_pallas."user"( first_name, last_name, password_hash, email, is_admin, rights, photo_path, is_notification_enabled, note, creation_date_time, language_id, id ) VALUES ( 'Alexay', 'Potapov', '', 'e@google.com', true, 1, '', true, 'note', '2016-03-15 12:16:01', 1, 1 ); 
INSERT INTO crm_pallas."user"( first_name, last_name, password_hash, email, is_admin, rights, photo_path, is_notification_enabled, note, creation_date_time, language_id, id ) VALUES ( 'Petya2', 'Agafonov', '', 'petya@google.com', true, 1, '', true, 'note2', '2016-07-25 12:16:01', 1, 4 ); 

INSERT INTO crm_pallas.company( title, phone_number, email, website, address_id, responsible_user_id, is_deleted, id ) VALUES ( 'Bank', '34655', 'bank2@google.com', 'google', 1, 2, false, 2 ); 
INSERT INTO crm_pallas.company( title, phone_number, email, website, address_id, responsible_user_id, is_deleted, id ) VALUES ( 'STO', '34455', 'eerr@google.com', 'google', 1, 1, false, 1 ); 
INSERT INTO crm_pallas.company( title, phone_number, email, website, address_id, responsible_user_id, is_deleted, id ) VALUES ( 'Factory', '34655', 'bank2@google.com', 'google', 1, 1, false, 3 ); 

INSERT INTO crm_pallas.contact( first_name, last_name, company_id, post, email, skype, responsible_user_id, is_deleted, id ) VALUES ( 'Anton', 'Karimov', 1, 'manager', 'anton@gmail.com', 'skype', 1, false, 1 ); 
INSERT INTO crm_pallas.contact( first_name, last_name, company_id, post, email, skype, responsible_user_id, is_deleted, id ) VALUES ( 'Alla', 'Ivanova', 2, 'hr manager', 'alla@gmail.com', 'skype', 1, false, 2 ); 

INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'dealName', 1, 20000, 1, 1, false, 1, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'newDeal', 2, 500, 2, 1, false, 3, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'newDeal3', 1, 150, 2, 1, false, 5, 2, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'роцлуождлйжлпщфо', 1, 12000, 1, 1, false, 7, 2, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'new best deal', 1, 111, 1, 1, false, 8, 2, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'кптлфьд', 1, 3455, 1, 1, false, 6, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'newDeal2', 1, 100, 2, 1, false, 4, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Super Deal', 2, 5400, 2, 2, false, 2, 2, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'новая сделка', 1, 5, 1, 1, false, 9, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'новая сдлека2', 1, 10, 1, 1, false, 10, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'dealDeal', 1, 0, 1, 1, false, 11, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'первая сделка', 1, 15, 1, 1, false, 12, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'сделка14', 1, 0, 1, 1, true, 16, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'сделка13', 1, 12, 1, 1, true, 15, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'сделка55', 1, 1000, 1, 1, true, 13, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Дело№', 1, 15, 1, 1, false, 17, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'newDealWithTime', 1, 12, 1, 1, false, 18, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'gig', 1, 12, 1, 1, false, 19, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'fads', 1, 0, 1, 1, false, 20, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( '2016-11-19 23:43:55.730000 +2:0:0', 1, 1223, 1, 1, false, 21, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'yoga', 1, 123, 1, 1, false, 22, 1, null ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Новая сделка', 1, 123, 1, 1, false, 28, 1, '2016-11-20 14:30:26.442' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'cltkсделка', 1, 10, 1, 3, false, 29, 1, '2016-11-20 15:49:04.043' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Factory', 3, 1, 1, 2, false, 35, 1, '2016-11-21 10:48:01.253' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Bank2', 2, 1, 1, 2, false, 36, 1, '2016-11-21 10:48:44.111' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Bank', 2, 10, 1, 3, false, 37, 1, '2016-11-21 10:55:43.221' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'factory', 3, 12, 1, 2, false, 38, 1, '2016-11-21 11:02:28.085' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'fact', 3, 12, 1, 2, false, 39, 1, '2016-11-21 11:03:59.525' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'fact2', 3, 0, 1, 2, false, 40, 1, '2016-11-21 11:08:16.759' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'ptya', 2, 10, 2, 2, false, 41, 2, '2016-11-21 11:43:34.347' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'Best', 2, 1, 2, 2, false, 43, 2, '2016-11-21 11:55:16.171' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'deal_for_task', 1, 123, 2, 3, false, 44, 2, '2016-11-21 12:02:37.227' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'new Deal', 3, 111, 1, 1, false, 46, 2, '2016-11-22 12:59:07.076' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'n2', 2, 2, 1, 2, false, 61, 2, '2016-11-22 21:17:29.077' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'n2', 3, 2, 1, 3, false, 62, 2, '2016-11-22 22:45:41.377' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'т22', 2, 22, 1, 2, false, 67, 1, '2016-11-23 12:20:10.446' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'т23', 3, 23, 1, 1, false, 68, 1, '2016-11-23 12:24:08.087' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'т24', 2, 24, 1, 2, false, 69, 1, '2016-11-23 12:29:58.362' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( '25', 2, 25, 1, 2, false, 70, 1, '2016-11-23 12:29:58.362' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( '26', 2, 26, 1, 2, false, 71, 1, '2016-11-23 12:29:58.362' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'pow', 2, 222, 1, 2, false, 74, 1, '2016-11-23 13:18:32.05' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'и223', 2, 223, 1, 2, false, 75, 1, '2016-11-23 13:48:00.279' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'и22343', 2, 3321, 1, 2, false, 76, 1, '2016-11-23 13:49:28.581' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'т7228748', 2, 1224, 1, 2, false, 77, 1, '2016-11-23 13:52:44.73' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'вфмфы', 2, 3445, 1, 2, false, 78, 1, '2016-11-23 13:54:41.213' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'т344ку', 2, 22344, 1, 2, false, 79, 1, '2016-11-23 14:20:20.482' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'вфмуым', 2, 3445, 1, 2, false, 80, 1, '2016-11-23 14:26:37.303' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'кцпце', 2, 54566, 1, 2, false, 81, 1, '2016-11-23 14:31:08.206' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'олрцуд', 2, 578920, 1, 2, false, 82, 1, '2016-11-23 14:35:13.654' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'наме', 2, 1, 1, 2, false, 83, 1, '2016-11-23 14:38:57.567' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'deal', 2, 1, 1, 2, false, 85, 1, '2016-11-23 14:42:53.644' ); 
INSERT INTO crm_pallas.deal( title, company_id, budget, stage_id, responsible_user_id, is_deleted, id, primary_contact_id, date_create ) VALUES ( 'new', 3, 333, 1, 2, false, 86, 1, '2016-11-23 15:46:19.361' ); 

INSERT INTO crm_pallas.contact_deal( contact_id, deal_id ) VALUES ( 1, 1 ); 

INSERT INTO crm_pallas.language(id, title, short_title) VALUES ( 2, 'English', 'en');
INSERT INTO crm_pallas.language(id, title, short_title) VALUES ( 3, 'Russian', 'ru');

INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (1, 'Сегодня', 1);
INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (2, 'Весь день', 1);
INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (3, 'Завтра', 1);
INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (4, 'Следующая неделя', 7);
INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (5, 'Следующий месяц', 30);
INSERT INTO crm_pallas.period_in_days_type(id, title, days_in_period) VALUES (6, 'Следующий год', 30);

INSERT INTO crm_pallas.task(id, title, task_type_id, description, deadline_date, deadline_time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted) VALUES (1, 'Deal1', 1, 'Test Deal', '2015-05-12', '12:24', 1, 30, 1, false, false);
INSERT INTO crm_pallas.task(id, title, task_type_id, description, deadline_date, deadline_time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted) VALUES (2, 'Deal2', 2, 'Test Deal2', '2016-08-12', '12:24', 2, 30, 2, false, false);
INSERT INTO crm_pallas.task(id, title, task_type_id, description, deadline_date, deadline_time, period_in_days_type_id, period_in_minutes, responsible_user_id, is_finished, is_deleted) VALUES (3, 'Contact', 3, 'Test Task', '2016-10-08', '15:24', 3, 30, 3, false, false);
