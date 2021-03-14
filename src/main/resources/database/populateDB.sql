INSERT INTO users VALUES
(1, 'Andrew', 'andrew@prds.gov', '+7 (123) 322-0001', 'Offline', 'January 25, 6 BC 01:59:59'),
(2, 'Peter', 'petr@prds.gov', '+7 (123) 322-0002', 'Offline', 'January 25, 6 BC 01:59:59'),
(3, 'John', 'john@prds.gov', '+7 (123) 322-0003', 'Offline', 'January 25, 6 BC 01:59:59'),
(4, 'James', 'james@prds.gov', '+7 (123) 322-0004', 'Offline', 'January 25, 6 BC 01:59:59'),
(5, 'Philip', 'philip@prds.gov', '+7 (123) 322-0005', 'Offline', 'January 25, 6 BC 01:59:59'),
(6, 'Bartholomew', 'bartho@prds.gov', '+7 (123) 322-0006', 'Offline', 'January 25, 6 BC 01:59:59'),
(7, 'Matthew', 'matt@prds.gov', '+7 (123) 322-0007', 'Offline', 'January 25, 6 BC 01:59:59'),
(8, 'Thomas', 'thom@prds.gov', '+7 (123) 322-0008', 'Offline', 'January 25, 6 BC 01:59:59'),
(9, 'James', 'jms@prds.gov', '+7 (123) 322-0009', 'Offline', 'January 25, 6 BC 01:59:59'),
(10, 'Jude', 'lebbaeus@prds.gov', '+7 (191) 322-0010', 'Offline', 'January 25, 6 BC 01:59:59'),
(11, 'Simon', 'simon@prds.gov', '+7 (123) 322-0011', 'Offline', 'January 25, 6 BC 01:59:59'),
(12, 'Judas', 'betrayer@inferno.hl', '+7 (666) 999-0012', 'Offline', 'January 25, 6 BC 01:59:59');

SELECT setval(pg_get_serial_sequence('users', 'id'), coalesce(max(id)+1, 1), false) FROM users;
