INSERT INTO brand (name, oper_rate_str, multi_value) VALUES
('VISA', 'y/m', 1),
('NARA', 'd', 0.5),
('AMEX', 'm', 0.1);

INSERT INTO card (brand_id, number, cardholder, exp_date) VALUES
(1, '1234567812345678', 'Juan Perez', '2025-12-31'), -- Tarjeta para VISA
(2, '8765432187654321', 'Maria Gomez', '2024-11-30'), -- Tarjeta para NARA
(3, '1122334455667788', 'Carlos Lopez', '2026-10-15'); -- Tarjeta para AMEX

INSERT INTO operation (card_id, value, date)
VALUES (1, 500.00, '2024-10-05');

INSERT INTO operation (card_id, value, date)
VALUES (2, 750.00, '2023-05-04');

INSERT INTO operation (card_id, value, date)
VALUES (3, 1200.00, '2024-10-03');