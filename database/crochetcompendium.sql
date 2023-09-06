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
 	CONSTRAINT PK_additional_notes_id PRIMARY KEY (additional_notes_id)
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

 INSERT INTO crochet_stitch (stitch_name, stitch_description)
 VALUES ('Single Crochet', 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
 	('Chain Stitch', 'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
 	 it can produce 3D shapes and interesting spaces'),
 	('Slip Stitch', 'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
 	  create surface detail on your project.'),
 	('Double Crochet', 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.');
	

  INSERT INTO stitch_instructions(crochet_stitch_id, row, number)
  VALUES ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'), 'Insert your hook into the necessary stitch or chain, makeing sure to catch both upper loops', 1),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'), 'Yarn over', 2),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'), 'Draw the yarn through the stitch (2 loops on hook)', 3),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'), 'Yarn over', 4),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'), 'Draw the yarn through both loops on your hook to complete the stitch', 5),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Chain Stitch'), 'Yarn over', 1),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Chain Stitch'), 'Catch the yarn with the tip of your hook and pull it through the loop already on your hook', 2),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Chain Stitch'), 'Repeat as many times as required by your pattern', 3),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'), 'Insert your hook into the necessary stitch or chain', 1),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'), 'Yarn over', 2),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'), 'Draw the yarn through both the stitch and the loop on your hook', 3),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'), 'Yarn over', 1),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'), 'Insert your hook into the necessary stitch or chain', 2),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'), 'Yarn over your hook again and draw the new loop through the stitch (3 loops on hook)', 3),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'), 'Yarn over and pull the yarn through the first two loops on your hook', 4),
  	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'), 'Yarn over and pull the yarn through the remaining two loops on your hook to complete the stitch', 5);

		
COMMIT;
		
		
		
		
		
		
		
		
		