BEGIN TRANSACTION;

  DROP TABLE IF EXISTS crochet_stitch, stitch_name, stitch_instructions, additional_notes, project, project_crochet_stitch;

  CREATE TABLE crochet_stitch (
  	crochet_stitch_id serial,
  	stitch_name VARCHAR(100) NOT NULL,
  	stitch_description VARCHAR(1000) NOT NULL,
  	stitch_abbreviation VARCHAR(10),
  	CONSTRAINT PK_crochet_stitch_id PRIMARY KEY (crochet_stitch_id)
   );

  CREATE TABLE stitch_instructions (
  	stitch_instructions_id serial,
  	crochet_stitch_id int NOT NULL,
 	row text NOT NULL,
 	number integer NOT NULL,
 	CONSTRAINT PK_stitch_instructions_id PRIMARY KEY (stitch_instructions_id),
 	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id) REFERENCES crochet_stitch(crochet_stitch_id)
 );
	
 CREATE TABLE additional_notes (
 	additional_notes_id serial,
 	notes text,
 	crochet_stitch_id int NOT NULL,
 	CONSTRAINT PK_additional_notes_id PRIMARY KEY (additional_notes_id),
	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id) REFERENCES crochet_stitch(crochet_stitch_id)
 );

 CREATE TABLE project (
 	project_id serial,
 	crochet_stitch_id int NOT NULL,
	project_name varchar(100),
 	CONSTRAINT PK_project_id PRIMARY KEY (project_id),
 	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id) REFERENCES crochet_stitch(crochet_stitch_id)
 );
	
 CREATE TABLE project_crochet_stitch (
 	project_id int NOT NULL,
 	crochet_stitch_id int NOT NULL,
 	CONSTRAINT PK_project_crochet_stitch PRIMARY KEY(project_id, crochet_stitch_id),
 	CONSTRAINT FK_project_id FOREIGN KEY(project_id) REFERENCES project(project_id),
 	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY(crochet_stitch_id) REFERENCES crochet_stitch(crochet_stitch_id)
 );

 INSERT INTO crochet_stitch (stitch_name, stitch_description, stitch_abbreviation)
 VALUES ('Stitch1', 'Test Description 1', 't1'),
 		('TestStitch2', 'Test Description 2', null),
		('TestStitch3', 'Test Description 3', 't3');
		
COMMIT;
		
		
