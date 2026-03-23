## Data Format Design

### Employee Data Structure
```json
{
  "employeeId": "E001",
  "firstName": "John",
  "lastName": "Doe",
  "icPassport": "A1234567",
  "leaveBalance": 14
}
```

| Field | Type | Notes |
|---|---|---|
| `employeeId` | `VARCHAR(10)` | Prefix `E` + zero-padded number generated in Java e.g. `"E001"` |
| `firstName` | `VARCHAR(50)` | |
| `lastName` | `VARCHAR(50)` | |
| `icPassport` | `VARCHAR(15)` | |
| `leaveBalance` | `INT` | |

> Family details are stored in a separate table linked by `employeeId`.

---

### Family Details Data Structure
```json
{
  "employeeId": "E001",
  "spouseName": "Jane Doe",
  "children": 2
}
```

| Field | Type | Notes |
|---|---|---|
| `employeeId` | `VARCHAR(10)` | Primary key — one employee can have zero or one family record, never more |
| `spouseName` | `VARCHAR(50)` | |
| `children` | `INT` | |

---

### Leave Application Data Structure
```json
{
  "leaveId": "L001",
  "employeeId": "E001",
  "leaveType": "Annual Leave",
  "startDate": "2026-03-01",
  "endDate": "2026-03-05",
  "status": "Pending"
}
```

| Field | Type | Notes |
|---|---|---|
| `leaveId` | `VARCHAR(10)` | Prefix `L` + zero-padded number generated in Java e.g. `"L001"` |
| `employeeId` | `VARCHAR(10)` | Foreign key referencing `Employee(employeeId)` |
| `leaveType` | `VARCHAR(75)` | SQL `CHECK`: `Annual Leave`, `Sick Leave`, `Unpaid Leave`, `Emergency Leave` |
| `startDate` | `DATE` | Passed as `String` over RMI format `"YYYY-MM-DD"`, converted via `Date.valueOf()` in DAO |
| `endDate` | `DATE` | Same as `startDate` |
| `status` | `VARCHAR(20)` | SQL `CHECK`: `Pending`, `Approved`, `Rejected` |

---

### Leave History Format
```json
[
  {
    "leaveId": "L001",
    "status": "Approved"
  },
  {
    "leaveId": "L002",
    "status": "Rejected"
  }
]
```

| Field | Type | Notes |
|---|---|---|
| `leaveId` | `VARCHAR(10)` | Primary key + foreign key referencing `LeaveApplication(leaveId)` |
| `status` | `VARCHAR(20)` | SQL `CHECK`: `Approved`, `Rejected` only — no `Pending` |

> A record is inserted automatically when HR calls `updateLeaveStatus()` inside `HRMServiceImpl`.
> The array format represents multiple rows returned from `getHistoryByEmployee()`.