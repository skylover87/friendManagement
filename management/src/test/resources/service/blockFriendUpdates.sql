TRUNCATE TABLE profile_account;
INSERT INTO profile_account (email_address) values ('sk@example.com');
INSERT INTO profile_account (email_address) values ('jm@example.com');

TRUNCATE TABLE subscribe_friend_news;
INSERT INTO subscribe_friend_news (id, owner_id, friend_id, subscribe_or_block) values (null, 'sk@example.com', 'jm@example.com', true);

TRUNCATE TABLE friends;
INSERT INTO friends (id, owner_id, friend_id) values (null, 'sk@example.com', 'jm@example.com');