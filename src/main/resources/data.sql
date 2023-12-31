INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'), ('ROLE_MODERATOR'), ('ROLE_USER')
ON CONFLICT (name) DO NOTHING;

INSERT INTO crochet_stitch (stitch_name, stitch_description, stitch_abbreviation)
VALUES
    ('Single Crochet',
    'A single crochet is a sturdy, dense stitch, useful in any project where you needs your stitches to be close together.',
    'sc'),
	('Chain',
	'A chain of stitches is very useful and can be as long or as short as required. When working in rows, it provides the foundation of your piece, and in decorative work it can produce 3D shapes and interesting spaces',
	'ch'),
	('Slip Stitch',
	'This shallow stitch has almost no height at all and is useful for moving the hook along to a new place or joining stitches together, and it can also be used to create surface detail on your project.',
	'sl'),
	('Double Crochet',
	'A double crochet differs from a single crochet by being slightly taller. This is achieved by wrapping the yarn around your hook before you begin creating the stitch.',
	'dc');

INSERT INTO stitch_instructions(crochet_stitch_id, row, line_number)
VALUES
    ((SELECT id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'),
	'Insert your hook into the necessary stitch or chain, making sure to catch both upper loops',
	1),
	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'),
	'Yarn over',
	2),
	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'),
	'Draw the yarn through the stitch (2 loops on hook)',
	3),
	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'),
	'Yarn over',
	4),
	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Single Crochet'),
 	'Draw the yarn through both loops on your hook to complete the stitch',
 	5),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Chain'),
 	'Yarn over',
 	1),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Chain'),
 	'Catch the yarn with the tip of your hook and pull it through the loop already on your hook',
 	2),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Chain'),
 	'Repeat as many times as required by your pattern',
 	3),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'),
 	'Insert your hook into the necessary stitch',
 	1),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'),
 	'Yarn over',
 	2),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Slip Stitch'),
 	'Draw the yarn through both the stitch and the loop on your hook',
 	3),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'),
 	'Yarn over',
 	1),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'),
 	'Insert your hook into the necessary stitch or chain',
 	2),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'),
 	'Yarn over your hook again and draw the new loop through the stitch (3 loops on hook)',
 	3),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'),
 	'Yarn over and pull the yarn through the first two loops on your hook',
 	4),
 	((SELECT id FROM crochet_stitch WHERE stitch_name = 'Double Crochet'),
 	'Yarn over and pull the yarn through the remaining two loops on your hook to complete the stitch',
 	5);
