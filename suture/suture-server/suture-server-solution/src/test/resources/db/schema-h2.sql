DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
    user_id       INT AUTO_INCREMENT PRIMARY KEY,
    user_name     VARCHAR(64)  NOT NULL,
    user_password VARCHAR(128) NOT NULL,
    salt          VARCHAR(64),
    email         VARCHAR(128),
    phone         VARCHAR(32),
    gender        INT,
    create_user   VARCHAR(64),
    create_time   TIMESTAMP,
    modified_user VARCHAR(64),
    modified_time TIMESTAMP
);
