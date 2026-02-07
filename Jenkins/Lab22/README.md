# Lab 21 – Role-Based Authorization in Jenkins (RBAC)

## Objective
The objective of this lab is to configure Role-Based Access Control (RBAC) in Jenkins by creating two users with different permission levels:
- user1 → Admin
- user2 → Read-only

## Environment
- Jenkins URL: http://localhost:8080
- Authorization Strategy: Project-based Matrix Authorization Strategy

## Steps

### Step 1 – Access Jenkins
Open Jenkins in a browser at http://localhost:8080 and login as admin.

### Step 2 – Enable Security and Authorization
Go to Manage Jenkins → Configure Global Security.
Select Project-based Matrix Authorization Strategy.
Grant admin user Overall → Administer and save.

### Step 3 – Create Users
Create two users:
user1 (Admin) and user2 (Read-only).

### Step 4 – Assign Permissions
user1: All permissions.
user2: Overall → Read.

### Step 5 – Verify Access
user1 should have full access.
user2 should have read-only access.

## Result
RBAC successfully configured.

![Build](screenshots/step1.jpg)
![Build](screenshots/step2.jpg)
![Build](screenshots/step3.jpg)

---

## Author

Fatma Alaa Hassan