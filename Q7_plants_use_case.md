# Question 7 – Plants Use Case

The system allows administrators to create, update, delete, and search plants.

## Business Rules
- Plant code is mandatory, numeric, and unique.
- Description is optional, max 10 alphanumeric characters.
- Only administrators can delete plants.

## Validation and Security
- Server-side validation
- Unique database constraint
- Role-based access control
