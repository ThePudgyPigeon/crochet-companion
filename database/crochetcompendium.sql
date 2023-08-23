DROP TABLE IF EXISTS crochet_stitch, stitch_name, stitch_instructions, additional_notes, project, project_crochet_stitch;

CREATE TABLE crochet_stitch (
	crochet_stitch_id serial,
	stitch_description text NOT NULL,
	CONSTRAINT PK_crochet_stitch_id PRIMARY KEY (crochet_stitch_id)
	);
	
CREATE TABLE stitch_name (
	stitch_name_id serial,
	crochet_stitch_id NOT NULL,
	name VARCHAR(100) NOT NULL,
	abbreviation VARCHAR(10),
	is_primary_name boolean NOT NULL,
	is_primary_abbreviation boolean
	CONSTRAINT PK_stitch_name_id PRIMARY KEY (stitch_name_id),
	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id)
	);

CREATE TABLE stitch_instructions (
	stitch_instructions_id serial,
	crochet_stitch_id NOT NULL,
	row text NOT NULL,
	number integer NOT NULL,
	CONSTRAINT PK_stitch_instructions_id PRIMARY KEY (stitch_instructions_id),
	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id)
	);
	
CREATE TABLE additional_notes (
	additional_notes_id serial,
	notes text,
	crochet_stitch_id NOT NULL,
	CONSTRAINT PK_additional_notes_id PRIMARY KEY (additional_notes_id)
	);

CREATE TABLE project (
	project_id serial,
	CONSTRAINT PK_project_id PRIMARY KEY (projet_id),
	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY (crochet_stitch_id)
	);
	
CREATE TABLE project_crochet_stitch (
	project_id NOT NULL,
	crochet_stitch_id NOT NULL,
	CONSTRAINT PK_project_crochet_stitch PRIMARY KEY(project_id, crochet_stitch_id),
	CONSTRAINT FK_project_id FOREIGN KEY(project_id) REFERENCES project(project_id),
	CONSTRAINT FK_crochet_stitch_id FOREIGN KEY(member_id) REFERENCES crochet_stitch(crochet_stitch_id)
	);

INSERT INTO crochet_stitch (stitch_description)
VALUES ('A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	('A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
	 it can produce 3D shapes and interesting spaces'),
	('This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
	  create surface detail on your project.'),
	('A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.');
	
INSERT INTO stitch_name (crochet_stitch_id, name, is_primary_name, abbreviation, is_primary_abbreviation)
VALUES ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Single Crochet', true, 'sc', true),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'UK Double Crochet', false, 'dc', false),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
	   it can produce 3D shapes and interesting spaces'), 'Chain Stitch', true, 'ch', true),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
	   create surface detail on your project.'), 'Slip Stitch', true, 'sl st', true),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Double Crochet', true, 'dc', true),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Treble', false, 'tr', false);

INSERT INTO stitch_instructions(crochet_stitch_id, row, number)
VALUES ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Insert your hook into the necessary stitch or chain, makeing sure to catch both upper loops', 1),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Yarn over', 2),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Draw the yarn through the stitch (2 loops on hook)', 3),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Yarn over', 4),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.'),
	   'Draw the yarn through both loops on your hook to complete the stitch', 5),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
	   it can produce 3D shapes and interesting spaces'), 'Yarn over', 1),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
	   it can produce 3D shapes and interesting spaces'), 'Catch the yarn with the tip of your hook and pull it through the loop already on your hook', 2),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work 
	   it can produce 3D shapes and interesting spaces'), 'Repeat as many times as required by your pattern', 3),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
	   create surface detail on your project.'), 'Insert your hook into the necessary stitch', 1),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
	   create surface detail on your project.'), 'Yarn over', 2),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to 
	   create surface detail on your project.'), 'Draw the yarn through both the stitch and the loop on your hook', 3),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Yarn over', 1),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Insert your hook into the necessary stitch or chain', 2),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Yarn over your hook again and draw the new loop through the stitch (3 loops on hook)', 3,
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Yarn over and pull the yarn through the first two loops on your hook', 4),
	   ((SELECT crochet_stitch_id FROM crochet_stitch WHERE stitch_description = 'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.'),
	   'Yarn over and pull the yarn through the remaining two loops on your hook to complete the stitch', 5);

		
		
		
		
		
		
		
		
		