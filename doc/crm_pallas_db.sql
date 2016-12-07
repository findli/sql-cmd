CREATE SCHEMA crm_pallas;

CREATE TABLE crm_pallas.address ( 
	id                   serial  NOT NULL,
	country              varchar(2)  ,
	city                 varchar  ,
	street               varchar  ,
	building_number      varchar  ,
	zipcode              integer  ,
	office_room          varchar  ,
	CONSTRAINT pk_address PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.currency ( 
	id                   serial  NOT NULL,
	title                varchar(50)  NOT NULL,
	short_title          varchar(3)  NOT NULL,
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
	title                varchar(100)  NOT NULL,
	short_title          varchar(3)  NOT NULL,
	CONSTRAINT pk_language PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.period_in_days_type ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	days_in_period       integer  ,
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
	color                varchar(6)  ,
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
	title                varchar  ,
	CONSTRAINT pk_task_type PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas.timezone ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	shift_in_hours       smallint  ,
	CONSTRAINT pk_timezone PRIMARY KEY ( id )
 );

CREATE TABLE crm_pallas."user" ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  NOT NULL,
	last_name            varchar(100)  NOT NULL,
	password_hash        varchar(50)  NOT NULL,
	email                varchar(100)  ,
	is_admin             bool  NOT NULL,
	rights               integer  ,
	photo_path           varchar(500)  ,
	is_notification_enabled bool  NOT NULL,
	notes                varchar  ,
	creation_date_time   timestamp  NOT NULL,
	language_id          integer  NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY ( id ),
	CONSTRAINT fk_user FOREIGN KEY ( language_id ) REFERENCES crm_pallas."language"( id )    
 );

CREATE INDEX idx_user ON crm_pallas."user" ( language_id );

CREATE TABLE crm_pallas.user_phones ( 
	id                   serial  NOT NULL,
	user_id              integer  ,
	phone_type_id        integer  ,
	phone_number         varchar  NOT NULL,
	CONSTRAINT pk_user_phones PRIMARY KEY ( id ),
	CONSTRAINT fk_user_phones FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_user_phones_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id )    
 );

CREATE INDEX idx_user_phones ON crm_pallas.user_phones ( user_id );

CREATE INDEX idx_user_phones_0 ON crm_pallas.user_phones ( phone_type_id );

CREATE TABLE crm_pallas.company ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	phone_number         varchar  ,
	email                varchar(50)  ,
	website              varchar(200)  ,
	address_id           integer  ,
	responsible_user_id  integer  NOT NULL,
	is_deleted           integer  NOT NULL,
	CONSTRAINT pk_company PRIMARY KEY ( id ),
	CONSTRAINT fk_company FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_company_0 FOREIGN KEY ( address_id ) REFERENCES crm_pallas.address( id )    
 );

CREATE INDEX idx_company ON crm_pallas.company ( responsible_user_id );

CREATE INDEX idx_company_0 ON crm_pallas.company ( address_id );

CREATE TABLE crm_pallas.company_tag ( 
	company_id           integer  NOT NULL,
	tag_id               integer  NOT NULL,
	CONSTRAINT fk_company_tag FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    ,
	CONSTRAINT fk_company_tag_0 FOREIGN KEY ( tag_id ) REFERENCES crm_pallas.tag( id )    
 );

CREATE INDEX idx_company_tag ON crm_pallas.company_tag ( company_id );

CREATE INDEX idx_company_tag_0 ON crm_pallas.company_tag ( tag_id );

CREATE TABLE crm_pallas.contact ( 
	id                   serial  NOT NULL,
	first_name           varchar(100)  ,
	last_name            varchar(100)  ,
	company_id           integer  ,
	post                 varchar  ,
	email                varchar  ,
	skype                varchar  ,
	responsible_user_id  integer  ,
	is_deleted           integer  NOT NULL,
	CONSTRAINT pk_contact PRIMARY KEY ( id ),
	CONSTRAINT fk_contact FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    
 );

CREATE INDEX idx_contact ON crm_pallas.contact ( company_id );

CREATE TABLE crm_pallas.contact_event ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	contact_id           integer  ,
	CONSTRAINT pk_contact_event PRIMARY KEY ( id ),
	CONSTRAINT fk_contact_event FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    
 );

CREATE INDEX idx_contact_event ON crm_pallas.contact_event ( contact_id );

CREATE TABLE crm_pallas.contact_phones ( 
	id                   serial  NOT NULL,
	contact_id           integer  ,
	phone_type_id        integer  ,
	phone_number         varchar  NOT NULL,
	CONSTRAINT pk_contact_phones PRIMARY KEY ( id ),
	CONSTRAINT fk_contact_phones FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_contact_phones_0 FOREIGN KEY ( phone_type_id ) REFERENCES crm_pallas.phone_type( id )    
 );

CREATE INDEX idx_contact_phones ON crm_pallas.contact_phones ( contact_id );

CREATE INDEX idx_contact_phones_0 ON crm_pallas.contact_phones ( phone_type_id );

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
	title                varchar(500)  NOT NULL,
	company_id           integer  NOT NULL,
	budget               integer  ,
	stage_id             integer  NOT NULL,
	responsible_user_id  integer  NOT NULL,
	is_deleted           integer  NOT NULL,
	CONSTRAINT pk_deal PRIMARY KEY ( id ),
	CONSTRAINT fk_deal FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_deal_0 FOREIGN KEY ( stage_id ) REFERENCES crm_pallas.stage( id )    ,
	CONSTRAINT fk_deal_1 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    
 );

CREATE INDEX idx_deal ON crm_pallas.deal ( responsible_user_id );

CREATE INDEX idx_deal_0 ON crm_pallas.deal ( stage_id );

CREATE INDEX idx_deal_1 ON crm_pallas.deal ( company_id );

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
	promoted_by_user_id  integer  NOT NULL,
	created              timestamp  NOT NULL,
	CONSTRAINT pk_event_history PRIMARY KEY ( id ),
	CONSTRAINT fk_event_history FOREIGN KEY ( promoted_by_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_event_history_0 FOREIGN KEY ( event_object_type_id ) REFERENCES crm_pallas.event_object_type( id )    ,
	CONSTRAINT fk_event_history_1 FOREIGN KEY ( event_action_type_id ) REFERENCES crm_pallas.event_action_type( id )    
 );

CREATE INDEX idx_event_history ON crm_pallas.event_history ( promoted_by_user_id );

CREATE INDEX idx_event_history_0 ON crm_pallas.event_history ( event_object_type_id );

CREATE INDEX idx_event_history_1 ON crm_pallas.event_history ( event_action_type_id );

CREATE TABLE crm_pallas.ip_white_list ( 
	id                   serial  NOT NULL,
	user_id              integer  NOT NULL,
	ip_address           varchar(100)  NOT NULL,
	CONSTRAINT pk_ip_white_list PRIMARY KEY ( id ),
	CONSTRAINT fk_ip_white_list FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    
 );

CREATE INDEX idx_ip_white_list ON crm_pallas.ip_white_list ( user_id );

CREATE TABLE crm_pallas.login_history ( 
	id                   serial  NOT NULL,
	user_id              integer  ,
	date_time            timestamp  ,
	ip_address           varchar(100)  ,
	browser              varchar  ,
	CONSTRAINT pk_login_history PRIMARY KEY ( id ),
	CONSTRAINT fk_login_history FOREIGN KEY ( user_id ) REFERENCES crm_pallas."user"( id )    
 );

CREATE INDEX idx_login_history ON crm_pallas.login_history ( user_id );

CREATE TABLE crm_pallas.note ( 
	id                   serial  NOT NULL,
	note_text            varchar  NOT NULL,
	created_by_user_id   integer  ,
	created_date_time    timestamp  NOT NULL,
	deal_id              integer  ,
	contact_id           integer  ,
	company_id           integer  ,
	CONSTRAINT pk_note PRIMARY KEY ( id ),
	CONSTRAINT fk_note FOREIGN KEY ( created_by_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_note_1 FOREIGN KEY ( deal_id ) REFERENCES crm_pallas.deal( id )    ,
	CONSTRAINT fk_note_2 FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_note_3 FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    
 );

CREATE INDEX idx_note ON crm_pallas.note ( created_by_user_id );

CREATE INDEX idx_note_1 ON crm_pallas.note ( deal_id );

CREATE INDEX idx_note_2 ON crm_pallas.note ( contact_id );

CREATE INDEX idx_note_3 ON crm_pallas.note ( company_id );

CREATE TABLE crm_pallas.settings ( 
	id                   serial  NOT NULL,
	default_language_id  integer  NOT NULL,
	timezone_id          integer  NOT NULL,
	currency_id          integer  NOT NULL,
	CONSTRAINT pk_settings PRIMARY KEY ( id ),
	CONSTRAINT fk_settings FOREIGN KEY ( timezone_id ) REFERENCES crm_pallas.timezone( id )    ,
	CONSTRAINT fk_settings_0 FOREIGN KEY ( currency_id ) REFERENCES crm_pallas.currency( id )    ,
	CONSTRAINT fk_settings_1 FOREIGN KEY ( default_language_id ) REFERENCES crm_pallas."language"( id )    
 );

CREATE INDEX idx_settings ON crm_pallas.settings ( timezone_id );

CREATE INDEX idx_settings_0 ON crm_pallas.settings ( currency_id );

CREATE INDEX idx_settings_1 ON crm_pallas.settings ( default_language_id );

CREATE TABLE crm_pallas.task ( 
	id                   serial  NOT NULL,
	title                varchar  NOT NULL,
	task_type_id         integer  ,
	description          integer  NOT NULL,
	deadline_date        date  ,
	period_in_days_type_id integer  ,
	period_in_minutes    integer  ,
	responsible_user_id  integer  ,
	is_finished          bool  NOT NULL,
	is_deleted           bool  NOT NULL,
	CONSTRAINT pk_task PRIMARY KEY ( id ),
	CONSTRAINT fk_task FOREIGN KEY ( responsible_user_id ) REFERENCES crm_pallas."user"( id )    ,
	CONSTRAINT fk_task_0 FOREIGN KEY ( period_in_days_type_id ) REFERENCES crm_pallas.period_in_days_type( id )    ,
	CONSTRAINT fk_task_1 FOREIGN KEY ( task_type_id ) REFERENCES crm_pallas.task_type( id )    
 );

CREATE INDEX idx_task ON crm_pallas.task ( responsible_user_id );

CREATE INDEX idx_task_0 ON crm_pallas.task ( period_in_days_type_id );

CREATE INDEX idx_task_1 ON crm_pallas.task ( task_type_id );

CREATE TABLE crm_pallas.company_task ( 
	company_id           integer  NOT NULL,
	task_id              integer  NOT NULL,
	CONSTRAINT fk_company_task FOREIGN KEY ( company_id ) REFERENCES crm_pallas.company( id )    ,
	CONSTRAINT fk_company_task_0 FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id )    
 );

CREATE INDEX idx_company_task ON crm_pallas.company_task ( company_id );

CREATE INDEX idx_company_task_0 ON crm_pallas.company_task ( task_id );

CREATE TABLE crm_pallas.contact_task ( 
	contact_id           integer  NOT NULL,
	task_id              integer  NOT NULL,
	CONSTRAINT fk_contact_task_contact FOREIGN KEY ( contact_id ) REFERENCES crm_pallas.contact( id )    ,
	CONSTRAINT fk_contact_task_task FOREIGN KEY ( task_id ) REFERENCES crm_pallas.task( id )    
 );

CREATE INDEX idx_contact_task ON crm_pallas.contact_task ( contact_id );

CREATE INDEX idx_contact_task_0 ON crm_pallas.contact_task ( task_id );

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
	file_size_in_bytes   varchar  ,
	creation_date_time   date  NOT NULL,
	note_id              integer  NOT NULL,
	CONSTRAINT pk_file PRIMARY KEY ( id ),
	CONSTRAINT fk_file_note FOREIGN KEY ( note_id ) REFERENCES crm_pallas.note( id )    
 );

CREATE INDEX idx_file ON crm_pallas."file" ( note_id );

