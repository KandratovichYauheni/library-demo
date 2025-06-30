INSERT INTO roles (name, description) VALUES
  ('ADMIN', 'Administrator role with full access'),
  ('USER',  'Standard user role with limited access');

INSERT INTO users (username, password, email, created_at) VALUES
  ('admin',
   '$2a$10$M8UnlW556o3tPQU8H8vKwuuQUvheYR.WjwQyqQQDqU2U4VzONa7PO',
   'admin@library.com',
   NOW()
  );

INSERT INTO user_roles (user_id, role_id) VALUES
  (
    (SELECT id FROM users WHERE username = 'admin'),
    (SELECT id FROM roles WHERE name = 'ADMIN')
  ),
  (
    (SELECT id FROM users WHERE username = 'admin'),
    (SELECT id FROM roles WHERE name = 'USER')
  );