-- a) Salespersons with no orders to Samsonic
SELECT s.name
FROM Salesperson s
WHERE NOT EXISTS (
    SELECT 1
    FROM Orders o
    JOIN Customer c ON c.id = o.customer_id
    WHERE o.salesperson_id = s.id AND c.name = 'Samsonic'
);

-- b) Append '*' to salespersons with two or more orders
UPDATE Salesperson
SET name = CONCAT(name, '*')
WHERE id IN (
    SELECT salesperson_id
    FROM Orders
    GROUP BY salesperson_id
    HAVING COUNT(*) >= 2
);

-- c) Delete salespersons with orders to Jackson
DELETE FROM Salesperson s
WHERE EXISTS (
    SELECT 1
    FROM Orders o
    JOIN Customer c ON c.id = o.customer_id
    WHERE o.salesperson_id = s.id AND c.city = 'Jackson'
);

-- d) Total sales per salesperson
SELECT s.id, s.name, COALESCE(SUM(o.amount), 0) AS total_sales
FROM Salesperson s
LEFT JOIN Orders o ON o.salesperson_id = s.id
GROUP BY s.id, s.name;
