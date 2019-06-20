SELECT *
FROM utenti
WHERE username = 'giuseppe' AND PASSWORD = 'password';

SELECT *
FROM utenti
WHERE username = 'giuseppe' AND PASSWORD = MD5('password');

SELECT *
FROM utenti
WHERE username = 'giuseppe' AND PASSWORD = '5f4dcc3b5aa765d61d8327deb882cf99';


SELECT MD5('test');