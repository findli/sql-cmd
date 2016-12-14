CREATE SCHEMA crm_pallas;

CREATE TABLE crm_pallas.address ( 
	id                   serial  NOT NULL,
	country              varchar  ,
	city                 varchar  ,
	street               varchar  ,
	building_number      varchar  ,
	zipcode              varchar  ,
	office_room          varchar  ,
	CONSTRAINT pk_address PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.company ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	phone_number         varchar  ,
	email                varchar  ,
	website              varchar  ,
	address_id           integer  ,
	responsible_user_id  integer  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_company PRIMARY KEY ( id ),
	CONSTRAINT fk_company FOREIGN KEY ( address_id ) REFERENCES crm_pallas.address( id )    
 );

CREATE INDEX idx_company ON crm_pallas.company ( address_id );

CREATE TABLE crm_pallas.contact ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  ,
	last_name            varchar(100)  ,
	company_id           integer  NOT NULL,
	post                 varchar  ,
	email                varchar  ,
	skype                varchar  ,
	responsible_user_id  integer  ,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_contact PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.contact_event ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	contact_id           integer  ,
	CONSTRAINT pk_contact_event PRIMARY KEY ( id ),
	CONSTRAINT fk_contact_event FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    
 );

CREATE INDEX idx_contact_event ON crm_pallas.contact_event ( contact_id );

CREATE TABLE crm_pallas.currency ( 
	id                   serial  NOT NULL,
	title                varchar  ,
	short_title          varchar  ,
	CONSTRAINT pk_currency PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.event_action_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_event_action_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.event_object_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_event_object_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."language" ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	short_title          varchar(3)  NOT NULL,
	CONSTRAINT pk_language_0 PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.period_in_days_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	days_in_period       integer  NOT NULL,
	CONSTRAINT pk_period_in_days_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.phone_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_phone_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.stage ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	color                varchar  ,
	priority             smallint  ,
	is_deletable         bool  NOT NULL,
	CONSTRAINT pk_stage PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.tag ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_tag PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.task_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	CONSTRAINT pk_task_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.timezone ( 
	id                   serial  NOT NULL,
	title                varchar  ,
	shift_in_hours       varchar  ,
	CONSTRAINT pk_timezone PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."user" ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  ,
	last_name            varchar(100)  ,
	password_hash        varchar  ,
	email                varchar  ,
	is_admin             bool  NOT NULL,
	rights               integer  ,
	photo_path           varchar  ,
	is_notification_enabled bool  NOT NULL,
	note                 varchar  ,
	creation_date_time   timestamp  NOT NULL,
	language_id          integer  ,
	CONSTRAINT pk_user PRIMARY KEY ( id ),
	CONSTRAINT fk_user FOREIGN KEY ( language_id ) REFERENCES crm_pallas."language"( id )    
 );

CREATE INDEX idx_user ON crm_pallas."user" ( language_id );

CREATE TABLE crm_pallas.user_phone ( 
	id                   serial  NOT NULL,
	user_id              integer  ,
	phone_type_id        integer  ,
	phone_number         varchar  ,
	CONSTRAINT pk_user_phone PRIMARY KEY ( id ),
	CONSTRAINT fk_user_phone FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_user_phone_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id )    
 );

CREATE INDEX idx_user_phone ON crm_pallas.user_phone ( user_id );

CREATE INDEX idx_user_phone_0 ON crm_pallas.user_phone ( phone_type_id );

CREATE TABLE crm_pallas.company_tag ( 
	company_id           integer  NOT NULL,
	tag_id               integer  NOT NULL,
	CONSTRAINT fk_company_tag FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    ,
	CONSTRAINT fk_company_tag_0 FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id )    
 );

CREATE INDEX idx_company_tag ON crm_pallas.company_tag ( company_id );

CREATE INDEX idx_company_tag_0 ON crm_pallas.company_tag ( tag_id );

CREATE TABLE crm_pallas.contact_phone ( 
	id                   serial  NOT NULL,
	contact_id           integer  NOT NULL,
	phone_type_id        integer  NOT NULL,
	phone_number         integer  NOT NULL,
	CONSTRAINT pk_contact_phone PRIMARY KEY ( id ),
	CONSTRAINT fk_contact_phone FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_contact_phone_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id )    
 );

CREATE INDEX idx_contact_phone ON crm_pallas.contact_phone ( contact_id );

CREATE INDEX idx_contact_phone_0 ON crm_pallas.contact_phone ( phone_type_id );

CREATE TABLE crm_pallas.contact_tag ( 
	contact_id           integer  NOT NULL,
	tag_id               integer  NOT NULL,
	CONSTRAINT fk_contact_tag FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_contact_tag_0 FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id )    
 );

CREATE INDEX idx_contact_tag ON crm_pallas.contact_tag ( contact_id );

CREATE INDEX idx_contact_tag_0 ON crm_pallas.contact_tag ( tag_id );

CREATE TABLE crm_pallas.deal ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	company_id           integer  NOT NULL,
	budget               integer  ,
	stage_id             integer  NOT NULL,
	responsible_user_id  integer  NOT NULL,
	is_deleted           bool  NOT NULL,
	created              timestamp  NOT NULL,
	updated              timestamp  ,
	primary_contact_id   integer  NOT NULL,
	CONSTRAINT pk_deal PRIMARY KEY ( id ),
	CONSTRAINT fk_deal FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_deal_0 FOREIGN KEY ( stage_id ) REFERENCES crm_pallas.stage( id )    ,
	CONSTRAINT fk_deal_1 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    ,
	CONSTRAINT fk_deal_2 FOREIGN KEY ( primary_contact_id ) REFERENCES crm_pallas.contact( id )    
 );

CREATE INDEX idx_deal ON crm_pallas.deal ( responsible_user_id );

CREATE INDEX idx_deal_0 ON crm_pallas.deal ( stage_id );

CREATE INDEX idx_deal_1 ON crm_pallas.deal ( company_id );

CREATE INDEX idx_deal_2 ON crm_pallas.deal ( primary_contact_id );

CREATE TABLE crm_pallas.deal_contact ( 
	deal_id              integer  NOT NULL,
	contact_id           integer  NOT NULL,
	CONSTRAINT fk_deal_contact FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id )    ,
	CONSTRAINT fk_deal_contact_0 FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    
 );

CREATE INDEX idx_deal_contact ON crm_pallas.deal_contact ( deal_id );

CREATE INDEX idx_deal_contact_0 ON crm_pallas.deal_contact ( contact_id );

CREATE TABLE crm_pallas.deal_tag ( 
	deal_id              integer  NOT NULL,
	tag_id               integer  NOT NULL,
	CONSTRAINT fk_deal_tag FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id )    ,
	CONSTRAINT fk_deal_tag_0 FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id )    
 );

CREATE INDEX idx_deal_tag ON crm_pallas.deal_tag ( deal_id );

CREATE INDEX idx_deal_tag_0 ON crm_pallas.deal_tag ( tag_id );

CREATE TABLE crm_pallas.event_history ( 
	id                   serial  NOT NULL,
	event_object_type_id integer  ,
	event_action_type_id integer  ,
	object_id            integer  ,
	promouted_by_user_id integer  ,
	date_time            timestamp  NOT NULL,
	CONSTRAINT pk_event_history PRIMARY KEY ( id ),
	CONSTRAINT fk_event_history FOREIGN KEY ( promouted_by_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_event_history_0 FOREIGN KEY ( event_object_type_id ) REFERENCES crm_pallas.event_object_type( id )    ,
	CONSTRAINT fk_event_history_1 FOREIGN KEY ( event_action_type_id ) REFERENCES crm_pallas.event_action_type( id )    
 );

CREATE INDEX idx_event_history ON crm_pallas.event_history ( promouted_by_user_id );

CREATE INDEX idx_event_history_0 ON crm_pallas.event_history ( event_object_type_id );

CREATE INDEX idx_event_history_1 ON crm_pallas.event_history ( event_action_type_id );

CREATE TABLE crm_pallas.ip_white_list ( 
	id                   serial  NOT NULL,
	user_id              integer  ,
	ip_address           varchar(100)  ,
	CONSTRAINT pk_ip_white_list PRIMARY KEY ( id ),
	CONSTRAINT fk_ip_white_list FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    
 );

CREATE INDEX idx_ip_white_list ON crm_pallas.ip_white_list ( user_id );

CREATE TABLE crm_pallas.login_history ( 
	id                   serial  NOT NULL,
	user_id              integer  NOT NULL,
	date_time            timestamp  NOT NULL,
	ip_address           varchar(100)  ,
	browser              varchar  ,
	CONSTRAINT pk_login_history PRIMARY KEY ( id ),
	CONSTRAINT fk_login_history FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    
 );

CREATE INDEX idx_login_history ON crm_pallas.login_history ( user_id );

CREATE TABLE crm_pallas.note ( 
	id                   serial  NOT NULL,
	note_text            varchar  NOT NULL,
	created_by_user_id   integer  NOT NULL,
	created_date_time    timestamp  NOT NULL,
	deal_id              integer  ,
	contact_id           integer  ,
	company_id           integer  ,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_note PRIMARY KEY ( id ),
	CONSTRAINT fk_note FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id )    ,
	CONSTRAINT fk_note_0 FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_note_1 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    
 );

CREATE INDEX idx_note ON crm_pallas.note ( deal_id );

CREATE INDEX idx_note_0 ON crm_pallas.note ( contact_id );

CREATE INDEX idx_note_1 ON crm_pallas.note ( company_id );

CREATE TABLE crm_pallas.settings ( 
	id                   serial  NOT NULL,
	default_language_id  integer  ,
	timezone_id          integer  ,
	currency_id          integer  ,
	CONSTRAINT pk_settings PRIMARY KEY ( id ),
	CONSTRAINT fk_settings FOREIGN KEY ( default_language_id ) REFERENCES crm_pallas."language"( id )    ,
	CONSTRAINT fk_settings_0 FOREIGN KEY ( timezone_id ) REFERENCES crm_pallas.timezone( id )    ,
	CONSTRAINT fk_settings_1 FOREIGN KEY ( currency_id ) REFERENCES crm_pallas.currency( id )    
 );

CREATE INDEX idx_settings ON crm_pallas.settings ( default_language_id );

CREATE INDEX idx_settings_0 ON crm_pallas.settings ( timezone_id );

CREATE INDEX idx_settings_1 ON crm_pallas.settings ( currency_id );

CREATE TABLE crm_pallas.task ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	task_type_id         integer  ,
	description          varchar  ,
	deadline_date        date  ,
	deadline_time        time  ,
	period_in_days_type_id integer  ,
	period_in_minutes    integer  ,
	responsible_user_id  integer  ,
	is_finished          bool  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_task PRIMARY KEY ( id ),
	CONSTRAINT fk_task FOREIGN KEY ( period_in_days_type_id ) REFERENCES crm_pallas.period_in_days_type( id )    ,
	CONSTRAINT fk_task_0 FOREIGN KEY ( task_type_id ) REFERENCES crm_pallas.task_type( id )    
 );

CREATE INDEX idx_task ON crm_pallas.task ( period_in_days_type_id );

CREATE INDEX idx_task_0 ON crm_pallas.task ( task_type_id );

CREATE TABLE crm_pallas.company_task ( 
	company_id           integer  NOT NULL,
	task_id              integer  NOT NULL,
	CONSTRAINT fk_company_task FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    ,
	CONSTRAINT fk_company_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id )    
 );

CREATE INDEX idx_company_task ON crm_pallas.company_task ( company_id );

CREATE INDEX idx_company_task_0 ON crm_pallas.company_task ( task_id );

CREATE TABLE crm_pallas.contact_tasks ( 
	contact_id           integer  NOT NULL,
	task_id              integer  NOT NULL,
	CONSTRAINT fk_contact_tasks FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_contact_tasks_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id )    
 );

CREATE INDEX idx_contact_tasks ON crm_pallas.contact_tasks ( contact_id );

CREATE INDEX idx_contact_tasks_0 ON crm_pallas.contact_tasks ( task_id );

CREATE TABLE crm_pallas.deal_task ( 
	deal_id              integer  NOT NULL,
	task_id              integer  NOT NULL,
	CONSTRAINT fk_deal_task FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id )    ,
	CONSTRAINT fk_deal_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id )    
 );

CREATE INDEX idx_deal_task ON crm_pallas.deal_task ( deal_id );

CREATE INDEX idx_deal_task_0 ON crm_pallas.deal_task ( task_id );

CREATE TABLE crm_pallas."file" ( 
	id                   serial  NOT NULL,
	file_name            varchar(100)  ,
	file_path            varchar  ,
	file_size_in_bytes   integer  ,
	creation_date_time   timestamp  NOT NULL,
	note_id              integer  ,
	CONSTRAINT pk_file PRIMARY KEY ( id ),
	CONSTRAINT fk_file FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id )    
 );

CREATE INDEX idx_file ON crm_pallas."file" ( note_id );

ALTER TABLE company ADD FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id );

ALTER TABLE contact ADD FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id );

