
create database testapp;




INSERT INTO `testapp`.`user` (`id`, `is_active`, `password`, `roles`, `user_name`) VALUES ('1000', 1, 'user@123', 'ROLE_ADMIN', 'user');
INSERT INTO `testapp`.`user` (`id`, `is_active`, `password`, `roles`, `user_name`) VALUES (null, 1, 'yaswanth@308', 'ROLE_ADMIN', 'yaswanth@308');

INSERT INTO plan (id,cost, plan_name) VALUES (1001,'1000', 'Plan1');
INSERT INTO plan (id,cost, plan_name) VALUES (1002,'2000', 'Plan2');
INSERT INTO plan (id,cost, plan_name) VALUES (1003,'3000', 'Plan3');


INSERT INTO `testapp`.`state` (`id`, `statename`) VALUES ('1001', 'AndhraPradesh');
INSERT INTO `testapp`.`state` (`id`, `statename`) VALUES ('1002', 'TamilNadu');
INSERT INTO `testapp`.`state` (`id`, `statename`) VALUES ('1003', 'Karnataka');

INSERT INTO `testapp`.`department` (`id`, `department_name`) VALUES ('1001', 'Cardiology');
INSERT INTO `testapp`.`department` (`id`, `department_name`) VALUES ('1002', 'Neurology');


INSERT INTO `testapp`.`physician` (`id`, `experience_years`, `first_name`, `last_name`, `physician_id`, `qualifications`, `department_id`, `plan_id`, `state_id`) VALUES ('1', '1', 'akhil', 'deep', 'PR001', 'Mbbs', '1001', '1001', '1001');

INSERT INTO `testapp`.`description` (`id`,`date_of_diagnosis`, `desp`, `symptoms`, `patient_id`, `physician_id`) VALUES ('1001','2020-07-03', 'godpls', 'god', '1001', '1');


INSERT INTO `testapp`.`bill` (`id`, `amount`, `cardnumber`, `payment_status`, `paymentmode`, `description_id`) VALUES ('1001', '4000', '1234567891', 'paid', 'cash', '1001');



