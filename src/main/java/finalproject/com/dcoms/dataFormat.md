## Data Format Design

### Employee Data Structure
```json
{
  "employeeId": "E001",
  "firstName": "John",
  "lastName": "Doe",
  "icPassport": "A1234567",
  "leaveBalance": 14,
  "familyDetails": {
    "spouseName": "Jane Doe",
    "children": 2
  }
}
```

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