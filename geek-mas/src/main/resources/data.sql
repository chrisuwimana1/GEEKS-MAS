--Insert admin

insert into user(username,admin,password) values('admin', true,'123456');

--Insert entries
insert into entry (name) values('FEB 2018');
insert into entry (name) values('MAY 2018');
insert into entry (name) values('AUG 2018');
insert into entry (name) values('NOV 2018');
insert into entry (name) values('FEB 2019');
insert into entry (name) values('MAY 2019');
insert into entry (name) values('AUG 2019');
insert into entry (name) values('NOV 2019');
insert into entry (name) values('FEB 2020');
insert into entry (name) values('MAY 2020');
insert into entry (name) values('AUG 2020');
insert into entry (name) values('NOV 2020');
insert into entry (name) values('FEB 2021');
insert into entry (name) values('MAY 2021');
insert into entry (name) values('AUG 2021');
insert into entry (name) values('NOV 2021');

--Insert students

insert into user(username,admin,password) values('987054', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(987054,1001987054,'Celestin Mbuyamba',1,'987054');
insert into user(username,admin,password) values('986953', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(986953,1001986953,'Christian Uwimana',1,'986953');
insert into user(username,admin,password) values('986997', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(986997,1001986997,'Halison Brito',1,'986997');
insert into user(username,admin,password) values('986999', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(986999,1001986999,'Christian Kika',1,'986999');
insert into user(username,admin,password) values('987046', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(987046,1001987046,'Jean De Dieu Irakunda',1,'987046');

insert into user(username,admin,password) values('887054', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(887054,1001887054,'Mbuyamba Celestin',2,'887054');
insert into user(username,admin,password) values('886953', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(886953,1001886953,'Uwimana Christian',2,'886953');
insert into user(username,admin,password) values('886997', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(886997,1001886997,'Brito Halison',2,'886997');
insert into user(username,admin,password) values('886999', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(886999,1001886999,'Kika Christian',2,'886999');
insert into user(username,admin,password) values('887046', false,'123456');
insert into student (id,bar_code_id,name,entry_id,user_username) values(887046,1001887046,'IrakundaJean De Dieu',2,'887046');

--Insert courses

insert into course (id,name,number_of_session,number_of_week) values ('CS401','Modern Practice Programming',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS425','Software Engineering',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS472','Web Programming',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS525','Advanced Software Development',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS435','Algorithms',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS471','Parallel Programming',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS488','Big Data Analytics',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS544','Enterprise Architecture',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS422','Database Management Systems',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS545','Web Application Architecture',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS582','Machine Learning',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS523','Big Data Technology',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('MGT5341','Career Strategies for Information Technology',0,4);
insert into course (id,name,number_of_session,number_of_week) values ('CS390','Fundamental Programming Practices',22,4);
insert into course (id,name,number_of_session,number_of_week) values ('FOR506B','STC Pt2 Leadership for Tech Managers',10,2);
insert into course (id,name,number_of_session,number_of_week) values ('FOR506A','STC Pt1',10,2);

--Insert location

insert into location (id,name) values('DB', 'Dalby Hall');
insert into location (id,name) values('MS','Maharishi School');
insert into location (id,name) values('MG','Men Golden Dome');
insert into location (id,name) values('WG','Women Golden Dome');

--Insert blocks

insert into block (name) values ('JAN 2019');
insert into block (name) values ('FEB 2019');
insert into block (name) values ('MAR 2019');
insert into block (name) values ('APR 2019');
insert into block (name) values ('MAY 2019');
insert into block (name) values ('JUN 2019');
insert into block (name) values ('JUL 2019');
insert into block (name) values ('AUG 2019');
insert into block (name) values ('SEP 2019');
insert into block (name) values ('OCT 2019');
insert into block (name) values ('NOV 2019');
insert into block (name) values ('DEC 2019');
insert into block (name) values ('JAN 2020');
insert into block (name) values ('FEB 2020');
insert into block (name) values ('MAR 2020');
insert into block (name) values ('APR 2020');
insert into block (name) values ('MAY 2020');
insert into block (name) values ('JUN 2020');
insert into block (name) values ('JUL 2020');
insert into block (name) values ('AUG 2020');
insert into block (name) values ('SEP 2020');
insert into block (name) values ('OCT 2020');
insert into block (name) values ('NOV 2020');
insert into block (name) values ('DEC 2020');

--Insert faculty
insert into user(username,admin,password) values('okalu@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Obinna Kalu','okalu@mum.edu');
insert into user(username,admin,password) values('pcorazza@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Paul Corazza','pcorazza@mum.edu');
insert into user(username,admin,password) values('mmukadam@cs.mum.edu', false,'123456');
insert into faculty (name,user_username) values('Mrudula Mukadam','mmukadam@cs.mum.edu');
insert into user(username,admin,password) values('rshrestha@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Rakesh Shrestha','rshrestha@mum.edu');
insert into user(username,admin,password) values('gguthrie@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Gregory Guthrie','gguthrie@mum.edu');
insert into user(username,admin,password) values('psalek@cs.mum.edu', false,'123456');
insert into faculty (name,user_username) values('Payman Salek','psalek@cs.mum.edu');
insert into user(username,admin,password) values('pphtoo@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Pont Pont Htoo','pphtoo@mum.edu');
insert into user(username,admin,password) values('blester@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Bruce Lester','blester@mum.edu');
insert into user(username,admin,password) values('mabdelrazik@mum.edu', false,'123456');
insert into faculty (name,user_username) values('Mohamed Abdelrazik','mabdelrazik@mum.edu');
insert into user(username,admin,password) values('mzijlstra@cs.mum.edu', false,'123456');
insert into faculty (name,user_username) values('Michael Zijlstra','mzijlstra@cs.mum.edu');

--Insert sections

insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M105','2019-04-29',1,'CS401',1);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M113','2019-04-29',1,'CS425',2);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M105','2019-04-29',1,'CS472',3);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M115','2019-04-29',1,'CS525',4);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M218','2019-04-29',1,'CS401',5);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M219','2019-04-29',1,'CS544',6);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('V29','2019-04-29',1,'CS523',7);

insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M105','2019-05-27',2,'FOR506A',5);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M113','2019-05-27',2,'CS545',3);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M105','2019-05-27',2,'CS523',6);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M115','2019-05-27',2,'CS544',2);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M218','2019-05-27',2,'CS435',1);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('M219','2019-05-27',2,'CS472',4);
insert into section (room_id,start_date,block_id,course_id,faculty_id) values('V29','2019-05-27',2,'CS425',7);

--Insert enroll

insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,987054);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,986953);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,986997);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,986999);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,987046);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,887054);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,886953);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,886997);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,886999);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',1,887046);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,987054);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,986953);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,986997);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,986999);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,987046);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,887054);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,886953);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,886997);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,886999);
insert into enroll (enroll_date,section_id,student_id) values('2019-04-01',2,887046);

--Insert cancelled session

insert into cancelled_session(session_date,block_id) values('2019-05-04',2);