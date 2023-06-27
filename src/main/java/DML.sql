INSERT INTO choice (CHOICE_ID, CHOICE)
VALUES 
('A001', '(1) 전혀 아니다.'),
('A002', '(2) 아니다.'),
('A003', '(3) 그렇다.'),
('A004', '(4) 매우그렇다.')
;

INSERT INTO question_choice (QUESTIONS_ID, CHOICE_ID)
VALUES 
('Q001', 'A001'),
('Q002', 'A002'),
('Q003', 'A003'),
('Q004', 'A004');

INSERT INTO questions (QUESTIONS, QUESTIONS_ID)
VALUES 
('1. 교수는 수업 전 강의 목표를 명확히 제시하였습니까?', 'Q001'),
('2. 강의의 내용은 체계적이고 성의있게 구성되었는가?', 'Q002'),
('3. 교수는 강의 내용에 대해 전문적 지식이 있었는가?', 'Q003'),
('4. 강의 진행 속도는 적절하였는가?', 'Q004');

INSERT INTO respondents (RESPONDENTS, RESPONDENTS_ID, PASSWORD)
VALUES 
('손흥민', 'R001', '1111'), ('김제니', 'R002', '2222'), ('박서준', 'R003', '3333'), ('수스', 'R004', '4444');

INSERT INTO statistics (STATISTICS_ID, RESPONDENTS_ID, QUESTIONS_ID, CHOICE_ID)
VALUES 
('C001', 'R001', 'Q001', 'A001'),
('C002', 'R002', 'Q002', 'A002'),
('C003', 'R003', 'Q003', 'A003'),
('C004', 'R004', 'Q004', 'A004')
;