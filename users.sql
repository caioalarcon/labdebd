DROP TABLE IF EXISTS users;

CREATE TABLE users
  (
     userid     INTEGER,
     login      TEXT,
     password   TEXT,
     tipo       TEXT,
     idoriginal INTEGER
  );

INSERT INTO users
            (userid,
             login,
             password,
             tipo,
             idoriginal)
VALUES      (0,
             'ADMIN',
             'ADMIN',
             'ADMINISTRADOR',
             0); 