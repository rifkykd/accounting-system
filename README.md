# Accounting System ERP

A comprehensive, multi-tenant Finance and Accounting ERP system built with Java Spring Boot, JSP, and MongoDB.

## Features

### Core Modules
- **General Ledger & Chart of Accounts** - Complete GL setup with account hierarchy
- **Accounts Payable (AP)** - Vendor invoice management
- **Accounts Receivable (AR)** - Customer invoice tracking
- **Invoicing & Billing** - Sales and purchase invoice management
- **Journal Entries** - Debit/credit transactions

### Security & Multi-Tenancy
- ✅ JWT-based authentication
- ✅ Role-Based Access Control (ADMIN, ACCOUNTANT, MANAGER, VIEWER)
- ✅ Multi-tenant architecture with complete data isolation
- ✅ BCrypt password encryption

### Technology Stack
- **Backend**: Java 17, Spring Boot 3.2.0, Spring Security
- **Frontend**: JSP with Tomcat
- **Database**: MongoDB
- **Build**: Maven
- **Deployment**: Docker & Docker Compose

## Project Structure

```
accounting-system/
├── src/main/java/com/erp/accounting/
│   ├── model/              # Entity classes
│   ├── repository/         # MongoDB data access layers
│   ├── controller/         # REST API controllers
│   ├── security/           # JWT & Security configuration
│   ├── dto/                # Data transfer objects
│   └── AccountingSystemApplication.java
├── src/main/resources/     # Configuration files
├── src/main/webapp/        # JSP templates
├── pom.xml                 # Maven dependencies
├── Dockerfile              # Docker configuration
└── docker-compose.yml      # Docker Compose setup
```

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+
- MongoDB 4.4+
- Docker & Docker Compose (optional)

### Installation

#### Option 1: Local Development

1. **Clone the repository**
   ```bash
   git clone https://github.com/rifkykd/accounting-system.git
   cd accounting-system
   ```

2. **Start MongoDB**
   ```bash
   mongod
   ```

3. **Configure application.yml**
   ```yaml
   spring:
     data:
       mongodb:
         uri: mongodb://localhost:27017/accounting_erp
   ```

4. **Build and run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access the application**
   - Dashboard: http://localhost:8080
   - API Base: http://localhost:8080/api

#### Option 2: Docker

```bash
# Build and start containers
docker-compose up -d

# View logs
docker-compose logs -f app

# Stop containers
docker-compose down
```

## API Endpoints

### Authentication
- `POST /api/auth/login` - User login with JWT token

### Chart of Accounts
- `GET /api/chart-of-accounts/tenant/{tenantId}` - List all accounts
- `GET /api/chart-of-accounts/{id}` - Get account details
- `POST /api/chart-of-accounts` - Create new account
- `PUT /api/chart-of-accounts/{id}` - Update account
- `DELETE /api/chart-of-accounts/{id}` - Delete account

### Invoices
- `GET /api/invoices/tenant/{tenantId}` - List all invoices
- `GET /api/invoices/{id}` - Get invoice details
- `POST /api/invoices` - Create new invoice
- `PUT /api/invoices/{id}` - Update invoice
- `DELETE /api/invoices/{id}` - Delete invoice

## Database Models

### Collections

#### Tenants
```json
{
  "_id": "tenant_id",
  "name": "Company Name",
  "code": "COMP001",
  "industry": "Manufacturing",
  "active": true
}
```

#### Users
```json
{
  "_id": "user_id",
  "tenantId": "tenant_id",
  "username": "accountant1",
  "email": "user@company.com",
  "roles": ["ACCOUNTANT", "MANAGER"],
  "active": true
}
```

#### Chart of Accounts
```json
{
  "_id": "account_id",
  "tenantId": "tenant_id",
  "accountCode": "1010",
  "accountName": "Cash",
  "accountType": "ASSET",
  "balance": 50000
}
```

#### Journal Entries
```json
{
  "_id": "journal_id",
  "tenantId": "tenant_id",
  "journalNumber": "JNL-2026-001",
  "debitAccountCode": "1010",
  "creditAccountCode": "2010",
  "amount": 5000,
  "status": "POSTED"
}
```

#### Invoices
```json
{
  "_id": "invoice_id",
  "tenantId": "tenant_id",
  "invoiceNumber": "INV-001",
  "invoiceType": "SALES",
  "customerVendorName": "ACME Corp",
  "total": 5200,
  "status": "PAID",
  "paymentStatus": "PAID"
}
```

## Security

### Authentication Flow
1. User submits username, password, and tenantId
2. System validates credentials against MongoDB
3. JWT token is generated and returned
4. Token is included in Authorization header for subsequent requests
5. Spring Security validates token for each request

### Authorization
- **ADMIN** - Full system access
- **ACCOUNTANT** - GL, Journals, Invoices management
- **MANAGER** - View and approve transactions
- **VIEWER** - Read-only access to reports

## Configuration

Edit `src/main/resources/application.yml`:

```yaml
spring:
  application:
    name: accounting-system
  data:
    mongodb:
      uri: mongodb://localhost:27017/accounting_erp

jwt:
  secret: your-secret-key-change-this-in-production
  expiration: 86400000  # 24 hours

server:
  port: 8080
```

## Development

### Building
```bash
mvn clean install
```

### Running Tests
```bash
mvn test
```

### Code Quality
```bash
mvn sonar:sonar
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Roadmap

- [ ] Financial Reports (P&L, Balance Sheet, Trial Balance)
- [ ] Multi-currency support
- [ ] Tax compliance module
- [ ] Budget management
- [ ] Advanced payment tracking
- [ ] Audit trail
- [ ] Webhooks for integrations
- [ ] Mobile app

## License

MIT License - see LICENSE file for details

## Support

For issues and questions, please create an issue on GitHub.

## Authors

- Rifky (rifkykd)

---

**Happy accounting! 📊**