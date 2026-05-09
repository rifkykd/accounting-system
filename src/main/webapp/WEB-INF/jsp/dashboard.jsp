<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounting System - Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
            background-color: #f5f7fa;
        }
        .container {
            display: flex;
            height: 100vh;
        }
        .sidebar {
            width: 250px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 20px;
            overflow-y: auto;
        }
        .sidebar h1 {
            font-size: 24px;
            margin-bottom: 30px;
        }
        .sidebar nav a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 12px 15px;
            border-radius: 5px;
            margin-bottom: 10px;
            transition: background 0.3s;
        }
        .sidebar nav a:hover {
            background: rgba(255,255,255,0.1);
        }
        .main-content {
            flex: 1;
            padding: 30px;
            overflow-y: auto;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }
        .header h2 {
            color: #2c3e50;
            font-size: 28px;
        }
        .user-info {
            text-align: right;
        }
        .cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }
        .card {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-left: 4px solid #667eea;
        }
        .card h3 {
            color: #7f8c8d;
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 10px;
            text-transform: uppercase;
        }
        .card .value {
            font-size: 28px;
            font-weight: bold;
            color: #2c3e50;
        }
        .card.asset { border-left-color: #3498db; }
        .card.liability { border-left-color: #e74c3c; }
        .card.revenue { border-left-color: #2ecc71; }
        .card.expense { border-left-color: #f39c12; }
        .table-section {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        .table-section h3 {
            margin-bottom: 20px;
            color: #2c3e50;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table th {
            background: #ecf0f1;
            padding: 12px;
            text-align: left;
            font-weight: 600;
            color: #2c3e50;
            border-bottom: 2px solid #bdc3c7;
        }
        table td {
            padding: 12px;
            border-bottom: 1px solid #ecf0f1;
        }
        table tr:hover {
            background: #f9f9f9;
        }
        .badge {
            display: inline-block;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
        }
        .badge.draft { background: #bdc3c7; color: white; }
        .badge.posted { background: #2ecc71; color: white; }
        .badge.paid { background: #3498db; color: white; }
        .badge.overdue { background: #e74c3c; color: white; }
    </style>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <h1>ERP</h1>
            <nav>
                <a href="#">Dashboard</a>
                <a href="#">Chart of Accounts</a>
                <a href="#">Journal Entries</a>
                <a href="#">Invoices</a>
                <a href="#">Reports</a>
                <a href="#">Settings</a>
                <a href="#">Logout</a>
            </nav>
        </div>
        
        <div class="main-content">
            <div class="header">
                <h2>Financial Dashboard</h2>
                <div class="user-info">
                    <p>Welcome, <strong>User</strong></p>
                </div>
            </div>

            <div class="cards">
                <div class="card asset">
                    <h3>Total Assets</h3>
                    <div class="value">$125,400</div>
                </div>
                <div class="card liability">
                    <h3>Total Liabilities</h3>
                    <div class="value">$45,200</div>
                </div>
                <div class="card revenue">
                    <h3>This Month Revenue</h3>
                    <div class="value">$28,900</div>
                </div>
                <div class="card expense">
                    <h3>This Month Expenses</h3>
                    <div class="value">$12,500</div>
                </div>
            </div>

            <div class="table-section">
                <h3>Recent Invoices</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Invoice #</th>
                            <th>Customer</th>
                            <th>Amount</th>
                            <th>Date</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>#INV-001</td>
                            <td>ACME Corp</td>
                            <td>$5,200.00</td>
                            <td>2026-05-08</td>
                            <td><span class="badge paid">Paid</span></td>
                        </tr>
                        <tr>
                            <td>#INV-002</td>
                            <td>Tech Solutions</td>
                            <td>$8,900.00</td>
                            <td>2026-05-07</td>
                            <td><span class="badge posted">Posted</span></td>
                        </tr>
                        <tr>
                            <td>#INV-003</td>
                            <td>Global Industries</td>
                            <td>$3,400.00</td>
                            <td>2026-05-01</td>
                            <td><span class="badge overdue">Overdue</span></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>