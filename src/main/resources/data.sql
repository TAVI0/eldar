INSERT INTO card (id, brand, number, cardholder, exp_date, rate_value, oper_rate_str) VALUES
(1, 'VISA', '1234567', 'Marcos Tavio', '2025-10-05', 1.0, 'y/m'),
(2, 'NARA', '9876543', 'Linus Torvalds', '2024-05-01', 0.5, 'd'),
(3, 'AMEX', '5555555', 'Jhon Doe', '2025-12-30', 0.1, 'm');

INSERT INTO operation (card_id, value, date)
VALUES (1, 500.00, '2024-10-05');

INSERT INTO operation (card_id, value, date)
VALUES (2, 750.00, '2023-05-04');

INSERT INTO operation (card_id, value, date)
VALUES (3, 1200.00, '2024-10-03');