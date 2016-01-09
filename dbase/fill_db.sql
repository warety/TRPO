INSERT INTO AUTH(ID,NAME,LOGIN,HASH,SALT) VALUES
       (1, 'John Doe', 'jdoe',
       'cca635b25156988da32d2f77c44d67a',
       'saltsaltsalt'), -- sup3rpaZZ
       (2, 'Jane Row', 'jrow',
       'd3f1872ff3dd7e2cef9be2af9cf58fb',
       'supersalt'); -- Qweqrty12

INSERT INTO ROLES (ID,AUTH_ID,ROLE,RESOURCE) VALUES
       (1,1,'READ', 'a'),
       (2,1,'WRITE', 'a.b'),
       (3,2,'EXECUTE', 'a.b.c'),
       (4,1,'EXECUTE', 'a.bc');


