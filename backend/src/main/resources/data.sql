INSERT INTO tb_user (name, email, password) VALUES ('Alex', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('BOOTCAMP de HTML','http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZKSg4F_qPUfhMDr2lVM1Vhv8UlqUrt1eUHw&usqp=CAU');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2023-01-10T10:00:00Z', TIMESTAMP WITH TIME ZONE '2024-02-10T10:00:00Z', 1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2023-02-20T10:00:00Z', TIMESTAMP WITH TIME ZONE '2024-02-20T10:00:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal', 1, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('FORUM', 'Tire suas dúvidas', 2, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas', 3, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capitulo 1', 'Neste capilo vamos criar o projeto', 1, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 1, null);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capitulo 2', 'Neste capilo desenvolver o crud', 2, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 1, 1);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Capitulo 3', 'Neste capilo vamos finalizar projeto', 3, 'http://blog.coursify.me/wp-content/uploads/2017/12/conteudo-para-cursos-online-blog.jpg', 1, 2);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2023-01-30T13:00:00Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2023-01-30T13:00:00Z', null, true, false);