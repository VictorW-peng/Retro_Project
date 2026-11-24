INSERT INTO sys_user (user_name, user_password, salt, email, phone, gender,
                      create_user, create_time, modified_user, modified_time)
VALUES ('wp', '123456', NULL, 'wp@example.com', '13800000000', 1,
        'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP),
       ('alice', 'abcdef', NULL, 'alice@example.com', '13900000000', 2,
        'system', CURRENT_TIMESTAMP, 'system', CURRENT_TIMESTAMP);
