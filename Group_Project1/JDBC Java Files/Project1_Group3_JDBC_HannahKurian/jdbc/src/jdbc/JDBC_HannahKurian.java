package jdbc;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class JDBC_HannahKurian {

    private static final String serverName = "localhost"; 
    private static final String port = "13001"; 
    private static final String databaseName = "AdventureWorks2017"; 
    private static final String username = "sa"; 
    private static final String password = "PH@123456789"; 

    private static final String connectionUrl = String.format("jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s",
            serverName, port, databaseName, username, password);
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(JDBC_HannahKurian::initializeGUI);
    }
    
    private static void initializeGUI() {
        JFrame frame = new JFrame("SQL Query Selector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(0, 1)); // Main layout for sections

        JPanel mediumPanel = new JPanel(new GridLayout(0, 1));
        mediumPanel.setBorder(BorderFactory.createTitledBorder("Project 1 Queries - Hannah Kurian"));

        // Add subsections for each database under Medium
        JPanel northwindsPanel = new JPanel();
        northwindsPanel.setBorder(BorderFactory.createTitledBorder("Northwinds2022TSQLV7"));

       
        JPanel adventureWorksPanel = new JPanel();
        adventureWorksPanel.setBorder(BorderFactory.createTitledBorder("AdventureWorks2017"));
        
        JPanel adventureWorksDWPanel = new JPanel();
        adventureWorksDWPanel.setBorder(BorderFactory.createTitledBorder("AdventureWorksDW2017"));
        
        JPanel adventureWorksDWPanel1 = new JPanel();
        adventureWorksDWPanel1.setBorder(BorderFactory.createTitledBorder("AdventureWorksDW2017"));
        
        JPanel wideWorldImportersPanel = new JPanel();
        wideWorldImportersPanel.setBorder(BorderFactory.createTitledBorder("WideWorldImporters"));
        
        JPanel wideWorldImportersDWPanel = new JPanel();
        wideWorldImportersDWPanel.setBorder(BorderFactory.createTitledBorder("WideWorldImportersDW"));
        

        
        
        // Adding buttons for Complex Query 1, 2, 3, and 4
        JButton complexQueryButton1 = new JButton("Complex Query 1");
        complexQueryButton1.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButton1.setBackground(Color.CYAN); 
        complexQueryButton1.addActionListener(e -> executeQueryAndDisplayGUI(0));
        adventureWorksPanel.add(complexQueryButton1);

        JButton complexQueryButton2 = new JButton("Complex Query 2");
        complexQueryButton2.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButton2.setBackground(Color.CYAN); 
        complexQueryButton2.addActionListener(e -> executeQueryAndDisplayGUI(1)); 
        adventureWorksPanel.add(complexQueryButton2);
        
        JButton complexQueryButton3 = new JButton("Complex Query 3");
        complexQueryButton3.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButton3.setBackground(Color.CYAN); 
        complexQueryButton3.addActionListener(e -> executeQueryAndDisplayGUI(2)); 
        adventureWorksPanel.add(complexQueryButton3);
        
        
        JButton queryButtonDW2 = new JButton("Complex Query 4"); 
        queryButtonDW2.setFont(new Font("Arial", Font.PLAIN, 16));
        queryButtonDW2.setBackground(Color.CYAN); 
        queryButtonDW2.addActionListener(e -> executeQueryAndDisplayGUI(8)); 
        adventureWorksDWPanel1.add(queryButtonDW2);
        
        JButton complexQueryButton7 = new JButton("Complex Query 5");
        complexQueryButton7.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButton7.setBackground(Color.CYAN); 
        complexQueryButton7.addActionListener(e -> executeQueryAndDisplayGUI(12)); 
        northwindsPanel.add(complexQueryButton7);
        
        
        
        JButton complexQueryButton6 = new JButton("Complex Query 6");
        complexQueryButton6.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButton6.setBackground(Color.CYAN); 
        complexQueryButton6.addActionListener(e -> executeQueryAndDisplayGUI(15)); 
        northwindsPanel.add(complexQueryButton6);
        
        JButton complexQueryButtons6 = new JButton("Complex Query 7");
        complexQueryButtons6.setFont(new Font("Arial", Font.PLAIN, 16));
        complexQueryButtons6.setBackground(Color.CYAN); 
        complexQueryButtons6.addActionListener(e -> executeQueryAndDisplayGUI(20)); 
        northwindsPanel.add(complexQueryButtons6);

        mediumPanel.add(northwindsPanel);
        
        
        
        JButton queryButton1 = new JButton("Medium Query 1");
        queryButton1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButton1.setBackground(Color.LIGHT_GRAY); 
        queryButton1.addActionListener(e -> executeQueryAndDisplayGUI(3));
        adventureWorksPanel.add(queryButton1);

        JButton queryButton2 = new JButton("Medium Query 2");
        queryButton2.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButton2.setBackground(Color.LIGHT_GRAY);
        queryButton2.addActionListener(e -> executeQueryAndDisplayGUI(4));
        adventureWorksPanel.add(queryButton2);
        
        JButton queryButton3 = new JButton("Medium Query 3");
        queryButton3.setFont(new Font("Arial", Font.PLAIN, 16));
        queryButton3.setBackground(Color.LIGHT_GRAY); 
        queryButton3.addActionListener(e -> executeQueryAndDisplayGUI(5)); 
        adventureWorksPanel.add(queryButton3);
        
        JButton queryButton4 = new JButton("Medium Query 4");
        queryButton4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButton4.setBackground(Color.LIGHT_GRAY); 
        queryButton4.addActionListener(e -> executeQueryAndDisplayGUI(6)); 
        adventureWorksPanel.add(queryButton4);
        
        JButton queryButtonDW1 = new JButton("Medium Query 6"); 
        queryButtonDW1.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW1.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW1.addActionListener(e -> executeQueryAndDisplayGUI(7)); 
        adventureWorksDWPanel1.add(queryButtonDW1);
        
        JButton queryButtonDW3 = new JButton("Medium Query 7"); 
        queryButtonDW3.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW3.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW3.addActionListener(e -> executeQueryAndDisplayGUI(9)); 
        adventureWorksDWPanel1.add(queryButtonDW3);
        
        JButton queryButtonDW4 = new JButton("Medium Query 8"); 
        queryButtonDW4.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW4.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW4.addActionListener(e -> executeQueryAndDisplayGUI(10)); 
        northwindsPanel.add(queryButtonDW4);
        
        JButton queryButtonDW5 = new JButton("Medium Query 9"); 
        queryButtonDW5.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW5.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW5.addActionListener(e -> executeQueryAndDisplayGUI(11));
        adventureWorksDWPanel1.add(queryButtonDW5);
        
      ;
        
        JButton queryButtonDW7 = new JButton("Medium Query 10"); 
        queryButtonDW7.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW7.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW7.addActionListener(e -> executeQueryAndDisplayGUI(14)); 
        wideWorldImportersPanel.add(queryButtonDW7);
        
        JButton queryButtonDW8 = new JButton("Medium Query 11"); 
        queryButtonDW8.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW8.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW8.addActionListener(e -> executeQueryAndDisplayGUI(15)); 
        wideWorldImportersPanel.add(queryButtonDW8);
        
        JButton queryButtonDW9 = new JButton("Medium Query 12"); 
        queryButtonDW9.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW9.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW9.addActionListener(e -> executeQueryAndDisplayGUI(16)); 
        wideWorldImportersPanel.add(queryButtonDW9);
        
        JButton queryButtonWWIDW = new JButton("Medium Query 13"); 
        queryButtonWWIDW.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonWWIDW.setBackground(Color.LIGHT_GRAY); 
        queryButtonWWIDW.addActionListener(e -> executeQueryAndDisplayGUI(17)); 
        wideWorldImportersPanel.add(queryButtonWWIDW);
        
        JButton queryButtonWWIwDW = new JButton("Medium Query 14"); 
        queryButtonWWIwDW.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonWWIwDW.setBackground(Color.LIGHT_GRAY); 
        queryButtonWWIwDW.addActionListener(e -> executeQueryAndDisplayGUI(18)); 
        wideWorldImportersDWPanel.add(queryButtonWWIwDW);
        
        JButton queryButtonWWIaDW = new JButton("Medium Query 15"); 
        queryButtonWWIaDW.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonWWIaDW.setBackground(Color.LIGHT_GRAY);
        queryButtonWWIaDW.addActionListener(e -> executeQueryAndDisplayGUI(20)); 
        wideWorldImportersDWPanel.add(queryButtonWWIaDW);
       
        

        mediumPanel.add(adventureWorksPanel);

      
        JButton queryButtonDW = new JButton("Medium Query 11"); 
        queryButtonDW.setFont(new Font("Arial", Font.PLAIN, 16)); 
        queryButtonDW.setBackground(Color.LIGHT_GRAY); 
        queryButtonDW.addActionListener(e -> executeQueryAndDisplayGUI(10)); 
        adventureWorksDWPanel.add(queryButtonDW);
        
     

        mediumPanel.add(adventureWorksDWPanel1);


        mediumPanel.add(wideWorldImportersPanel);

        

        mediumPanel.add(wideWorldImportersDWPanel);

        mainPanel.add(mediumPanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Set the window size
        frame.setSize(800, 800);  

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void executeQueryAndDisplayGUI(int queryIndex) {
        JFrame frame = new JFrame("Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        String[] columnNames;
        switch (queryIndex) {
            case 0:
                columnNames = new String[]{"BusinessEntityId", "RateChangeDate", "Rate", "PayFrequency", "DepartmentName"};
                break;
            case 1:
            	columnNames = new String[] {"BusinessEntityId", "DepartmentName", "LatestRate"};
            	break;
            case 2:
            	columnNames = new String[] {"DepartmentName", "BusinessEntityId", "RateChangeDate", "Rate"};
            	break;
            case 3: 
            	columnNames = new String[] {"SalesOrderID", "SalesPersonEntityID", "SalesLastYear", "AssignmentStatus"};
            	break;
            case 4:
            	columnNames = new String[] {"SalesOrderID", "OrderDate", "ShipDate", "CustomerID", "Freight", "TaxAmt"};
            	break;
            case 5:
            	columnNames = new String[] {"SalesPersonID", "TerritoryID", "TotalSales"};
            	break;
            case 6:
            	columnNames = new String[] {"City", "EducationLevel", "NumberOfCustomers"};
            	break;
            case 7:
            	columnNames = new String[] {"City", "EnglishCountryRegionName", "NumberOfCustomers"};
            	break;
            case 8:
            	columnNames = new String[] {"CustomerFirstName", "CustomerLastName", "City", "CountryRegion", "State", "AccountManagerFirstName", "AccountManagerLastName"};
            	break;
            case 9:
            	columnNames = new String[] {"FirstName", "LastName", "Type"};
            	break;
            case 10:
            	columnNames = new String[] {"EmployeeID", "EmployeeLastName", "EmployeeFirstName", "EmployeeTitle", "CustomersInSameCity"};
            	break;
            case 11:
            	columnNames =  new String[] {"EmployeeID", "EmployeeLastName", "EmployeeFirstName", "EmployeeTitle", "TotalCustomers"};
            	break;
            case 12:
            	columnNames = new String[] {"EmployeeID", "EmployeeLastName", "EmployeeFirstName", "TotalShipmentsHandled"};
            	break;
            case 13:
            	columnNames = new String[] {"EmployeeID", "EmployeeFirstName", "EmployeeLastName", "suppliercountry", "NumberOfSuppliers"};
            	break;
            case 14:
            	columnNames = new String[] {"TotalTaxCollected"};
            	break;
            case 15:
            	columnNames = new String[] {"CustomerID", "NumberOfInvoices", "TotalTransactionAmount", "AverageTaxAmount", "LargestOrder"};
            	break;
            case 16:
            	columnNames = new String[]{"CustomerID", "TotalSpent"};
            	break;
            case 17:
            	columnNames = new String[] {"CustomerID", "InvoiceID", "TotalTransactionAmount", "TotalTaxAmount"};
            	break;
            case 18:
            	columnNames = new String[] {"Customer", "City", "State", "Country"};
            	break;
            case 19:
            	columnNames = new String[] {"Customer"};
            	break;
            case 20:
            	columnNames = new String[] {"CategoryId", "CategoryName","OrderMonth", "OrderYear ", "TotalSales"};
            	break;
            	
            default:
                columnNames = new String[]{"Column 1", "Column 2"}; 
                break;
        }
        
        model.setColumnIdentifiers(columnNames);
        
        String sqlQuery = getSqlQuery(queryIndex);
        if (sqlQuery.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No SQL query is defined for the selected option.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection connection = DriverManager.getConnection(connectionUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {

            // Populate the table model with data from the result set
            while (resultSet.next()) {
                Object[] row = new Object[columnNames.length];
                for (int i = 0; i < columnNames.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                model.addRow(row);
            }

            frame.setVisible(true);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error executing SQL query:\n" + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        
    }
    private static String getSqlQuery(int queryIndex) {
        switch (queryIndex) {
            case 0:
                return getLatestPayRate();
            case 1:
            	return executeDepartmentAndPayQuery();
            case 2: 
            	return payRateChange();
            case 3:
            	return salesOrder();
            case 4:
            	return getSalesOrderHeaderQuery();
            case 5:
            	return getSalesPersonQuery();
            case 6:
            	return getDimCustomerMalabarQuery();
            case 7:
            	return getDimCustomerByCountryRegionNameQuery();
            case 8:
            	return getCustomerEmployeeGeographyQuery();
            case 9:
            	return getCustomerEmployeeUnionQuery();
            case 10:
            	return getCustomersInSameCityQuery();
            case 11:
            	return getManagerEmployeesQuery();
            case 12:
            	return getEmployeeShipperMatchQuery();
            case 13:
            	return getCountrySuppliersQuery();
            case 14:
            	return getTotalTaxCollectedQuery();
            case 15:
            	return getCustomerTransactionsSummaryQuery();
            case 16:
            	return getCustomersAboveAverageSpendingQuery();
            case 17:
            	return getCustomerTransactionsYearlySummaryQuery();
            case 18:
            	return getCustomerCityDetailsQuery();
            case 19:
            	return getCustomersFromUSQuery();
            	
            case 20:
            	return getYearlySalesGrowthQuery();
            default:
                return "";
                
        }
    }
    
    //CASE 0
    private static String getLatestPayRate() {
    	return 
                "USE AdventureWorks2017; " +
                "WITH LatestPay AS ( " +
                "SELECT " +
                "    BusinessEntityId, " +
                "    RateChangeDate, " +
                "    Rate, " +
                "    PayFrequency, " +
                "    ROW_NUMBER() OVER(PARTITION BY BusinessEntityId ORDER BY RateChangeDate DESC) AS rn " +
                "FROM " +
                "    HumanResources.EmployeePayHistory " +
                "), " +
                "CurrentDepartment AS ( " +
                "SELECT " +
                "    e.BusinessEntityId, " +
                "    d.Name AS DepartmentName, " +
                "    ROW_NUMBER() OVER(PARTITION BY e.BusinessEntityId ORDER BY e.StartDate DESC) AS rn " +
                "FROM " +
                "    HumanResources.EmployeeDepartmentHistory AS e " +
                "INNER JOIN " +
                "    HumanResources.Department AS d ON e.DepartmentId = d.DepartmentId " +
                "WHERE " +
                "    e.EndDate IS NULL OR e.EndDate > GETDATE() " +
                ") " +
                "SELECT " +
                "    lp.BusinessEntityId, " +
                "    lp.RateChangeDate, " +
                "    lp.Rate, " +
                "    lp.PayFrequency, " +
                "    cd.DepartmentName " +
                "FROM " +
                "    LatestPay lp " +
                "INNER JOIN " +
                "    CurrentDepartment cd ON lp.BusinessEntityId = cd.BusinessEntityId " +
                "WHERE " +
                "    lp.rn = 1 AND cd.rn = 1;";
    }
    //CASE 1
    private static String executeDepartmentAndPayQuery() {
         return 
        		 "USE AdventureWorks2017; " +
        		    "WITH LatestDepartment AS ( " +
        		    "    SELECT " +
        		    "        BusinessEntityId, " +
        		    "        DepartmentId, " +
        		    "        MAX(StartDate) AS LatestStartDate " +
        		    "    FROM " +
        		    "        HumanResources.EmployeeDepartmentHistory " +
        		    "    WHERE " +
        		    "        StartDate < GETDATE() " +
        		    "    GROUP BY " +
        		    "        BusinessEntityId, DepartmentId " +
        		    "), " +
        		    "LatestPay AS ( " +
        		    "    SELECT " +
        		    "        BusinessEntityId, " +
        		    "        MAX(RateChangeDate) AS LatestRateChangeDate, " +
        		    "        MAX(Rate) AS LatestRate " +
        		    "    FROM " +
        		    "        HumanResources.EmployeePayHistory " +
        		    "    WHERE " +
        		    "        RateChangeDate < GETDATE() " +
        		    "    GROUP BY " +
        		    "        BusinessEntityId " +
        		    "), " +
        		    "DepartmentInfo AS ( " +
        		    "    SELECT " +
        		    "        ldc.BusinessEntityId, " +
        		    "        d.Name AS DepartmentName, " +
        		    "        lp.LatestRate " +
        		    "    FROM " +
        		    "        LatestDepartment ldc " +
        		    "    JOIN " +
        		    "        HumanResources.Department d ON ldc.DepartmentId = d.DepartmentId " +
        		    "    JOIN " +
        		    "        LatestPay lp ON ldc.BusinessEntityId = lp.BusinessEntityId " +
        		    ") " +
        		    "SELECT " +
        		    "    di.BusinessEntityId, " +
        		    "    di.DepartmentName, " +
        		    "    di.LatestRate " +
        		    "FROM " +
        		    "    DepartmentInfo di " +
        		    "ORDER BY " +
        		    "    di.BusinessEntityId;";
    }
    
    //CASE 2
    private static String payRateChange() {
    	return 
    			       "USE AdventureWorks2017; "
    				    + "WITH EmployeeLatestRateChange AS ( "
    				    + "    SELECT "
    				    + "        p.BusinessEntityId, "
    				    + "        p.RateChangeDate, "
    				    + "        p.Rate, "
    				    + "        ROW_NUMBER() OVER(PARTITION BY p.BusinessEntityId ORDER BY p.RateChangeDate DESC) AS rn " 
    				    + "    FROM "
    				    + "        HumanResources.EmployeePayHistory p "
    				    + "    WHERE "
    				    + "        p.RateChangeDate <= GETDATE() " 
    				    + "), "
    				    + "EmployeeCurrentDepartment AS ( "
    				    + "    SELECT "
    				    + "        edh.BusinessEntityId, "
    				    + "        edh.DepartmentId, "
    				    + "        ROW_NUMBER() OVER(PARTITION BY edh.BusinessEntityId ORDER BY COALESCE(edh.EndDate, GETDATE()) DESC) AS rn " 
    				    + "    FROM "
    				    + "        humanResources.EmployeeDepartmentHistory edh "
    				    + "    WHERE "
    				    + "        edh.EndDate IS NULL OR edh.EndDate > GETDATE() "
    				    + ") "
    				    + "SELECT "
    				    + "    d.Name AS DepartmentName, "
    				    + "    elrc.BusinessEntityId, "
    				    + "    elrc.RateChangeDate, "
    				    + "    elrc.Rate "
    				    + "FROM "
    				    + "    EmployeeLatestRateChange elrc "
    				    + "JOIN "
    				    + "    EmployeeCurrentDepartment ecd ON elrc.BusinessEntityId = ecd.BusinessEntityId AND ecd.rn = 1 "
    				    + "JOIN "
    				    + "    humanResources.Department d ON ecd.DepartmentId = d.DepartmentId "
    				    + "WHERE "
    				    + "    elrc.rn = 1 "
    				    + "ORDER BY "
    				    + "    elrc.RateChangeDate DESC, elrc.BusinessEntityId;";

    }
    
    //CASE 3
    private static String salesOrder() {
    	return 
    			"USE AdventureWorks2017; "
    	        + "SELECT "
    	        + "    soh.SalesOrderID, "
    	        + "    p.BusinessEntityID AS SalesPersonEntityID, "
    	        + "    p.SalesLastYear, "
    	        + "    CASE "
    	        + "        WHEN p.BusinessEntityID IS NULL THEN 'No salesperson assigned' "
    	        + "        ELSE 'Salesperson assigned' "
    	        + "    END AS AssignmentStatus "
    	        + "FROM "
    	        + "    Sales.SalesOrderHeader soh "
    	        + "FULL OUTER JOIN "
    	        + "    Sales.SalesPerson p ON soh.SalesPersonID = p.BusinessEntityID "
    	        + "ORDER BY "
    	        + "    soh.OrderDate DESC, soh.SalesOrderID;";
    }
    
    //CASE 4
    private static String getSalesOrderHeaderQuery() {
        return "USE AdventureWorks2017; "
                + "SELECT "
                + "    ssoh.SalesOrderID, "
                + "    ssoh.OrderDate, "
                + "    ssoh.ShipDate, "
                + "    ssoh.CustomerID, "
                + "    ssoh.Freight, "
                + "    ssoh.TaxAmt "
                + "FROM "
                + "    Sales.SalesOrderHeader ssoh "
                + "LEFT OUTER JOIN "
                + "    Sales.Store ss ON ssoh.CustomerID = ss.BusinessEntityID "
                + "ORDER BY "
                + "    ssoh.OrderDate DESC;";
    }

    //CASE 5
    private static String getSalesPersonQuery() {
        return "USE AdventureWorks2017; "
                + "SELECT "
                + "    p.BusinessEntityID AS SalesPersonID, "
                + "    p.TerritoryID, "
                + "    COALESCE(SUM(soh.Freight), 0) AS TotalSales "
                + "FROM "
                + "    Sales.SalesPerson p "
                + "LEFT OUTER JOIN "
                + "    Sales.SalesOrderHeader soh ON p.BusinessEntityID = soh.SalesPersonID "
                + "GROUP BY "
                + "    p.BusinessEntityID, p.TerritoryID "
                + "ORDER BY "
                + "    TotalSales DESC;";
    }
    
    //CASE 6
    private static String getDimCustomerMalabarQuery() {
        return "USE AdventureWorksDW2017; "
                + "SELECT "
                + "    dg.city, "
                + "    dc.EnglishEducation AS EducationLevel, "
                + "    COUNT(*) AS NumberOfCustomers "
                + "FROM "
                + "    dbo.DimCustomer dc "
                + "INNER JOIN "
                + "    dbo.DimGeography dg ON dc.GeographyKey = dg.GeographyKey "
                + "WHERE "
                + "    dg.city = 'Malabar' "
                + "GROUP BY "
                + "    dg.city, "
                + "    dc.EnglishEducation "
                + "ORDER BY "
                + "    NumberOfCustomers DESC;";
    }
    
    //CASE 7
    private static String getDimCustomerByCountryRegionNameQuery() {
        return "USE AdventureWorksDW2017; "
                + "SELECT "
                + "    g.City, "
                + "    g.EnglishCountryRegionName, "
                + "    COUNT(c.FirstName) AS NumberOfCustomers "
                + "FROM "
                + "    dbo.DimCustomer c "
                + "JOIN "
                + "    dbo.DimGeography g ON c.GeographyKey = g.GeographyKey "
                + "WHERE "
                + "    g.EnglishCountryRegionName IS NOT NULL "
                + "GROUP BY "
                + "    g.City, g.EnglishCountryRegionName "
                + "ORDER BY "
                + "    NumberOfCustomers DESC;";
    }
    
    //CASE 8
    private static String getCustomerEmployeeGeographyQuery() {
        return "USE AdventureWorksDW2017; "
                + "WITH CustomerGeography AS ( "
                + "    SELECT "
                + "        c.FirstName AS CustomerFirstName, "
                + "        c.LastName AS CustomerLastName, "
                + "        g.City, "
                + "        g.EnglishCountryRegionName, "
                + "        g.StateProvinceName "
                + "    FROM "
                + "        dbo.DimCustomer c "
                + "    JOIN "
                + "        dbo.DimGeography g ON c.GeographyKey = g.GeographyKey "
                + "), "
                + "EmployeeGeography AS ( "
                + "    SELECT "
                + "        e.FirstName AS EmployeeFirstName, "
                + "        e.LastName AS EmployeeLastName, "
                + "        g.City, "
                + "        e.DepartmentName "
                + "    FROM "
                + "        dbo.DimEmployee e "
                + "    JOIN "
                + "        dbo.DimGeography g ON e.SalesTerritoryKey = g.GeographyKey "
                + ") "
                + "SELECT "
                + "    cg.CustomerFirstName, "
                + "    cg.CustomerLastName, "
                + "    cg.City, "
                + "    cg.EnglishCountryRegionName AS CountryRegion, "
                + "    cg.StateProvinceName AS State, "
                + "    eg.EmployeeFirstName AS AccountManagerFirstName, "
                + "    eg.EmployeeLastName AS AccountManagerLastName "
                + "FROM "
                + "    CustomerGeography cg "
                + "JOIN "
                + "    EmployeeGeography eg ON cg.City = eg.City;";
    }
    //CASE 9
    private static String getCustomerEmployeeUnionQuery() {
        return "USE AdventureWorksDW2017; "
                + "SELECT "
                + "    FirstName, "
                + "    LastName, "
                + "    'Customer' AS Type "
                + "FROM "
                + "    dbo.DimCustomer "
                + "WHERE "
                + "    LastName IN ( "
                + "        SELECT LastName "
                + "        FROM dbo.DimEmployee "
                + "    ) "
                + "UNION ALL "
                + "SELECT "
                + "    FirstName, "
                + "    LastName, "
                + "    'Employee' AS Type "
                + "FROM "
                + "    dbo.DimEmployee "
                + "WHERE "
                + "    LastName IN ( "
                + "        SELECT LastName "
                + "        FROM dbo.DimCustomer "
                + "    ) "
                + "ORDER BY "
                + "    LastName, "
                + "    Type, "
                + "    FirstName;";
    }
    //CASE 10
    private static String getCustomersInSameCityQuery() {
        return "USE Northwinds2022TSQLV7 "
                + "SELECT "
                + "    e.EmployeeID, "
                + "    e.EmployeeLastName, "
                + "    e.EmployeeFirstName, "
                + "    e.EmployeeTitle, "
                + "    ( "
                + "        SELECT COUNT(*) "
                + "        FROM Sales.Customer AS c "
                + "        WHERE c.CustomerCity = e.EmployeeCity "
                + "    ) AS CustomersInSameCity "
                + "FROM "
                + "    HumanResources.Employee AS e "
                + "ORDER BY "
                + "    CustomersInSameCity DESC;";
    }
    //CASE 11
    private static String getManagerEmployeesQuery() {
        return "USE Northwinds2022TSQLV7; "
                + "WITH ManagerEmployees AS ( "
                + "    SELECT "
                + "        EmployeeID, "
                + "        EmployeeLastName, "
                + "        EmployeeFirstName, "
                + "        EmployeeTitle "
                + "    FROM "
                + "        HumanResources.Employee "
                + "    WHERE "
                + "        EmployeeTitle = 'Sales Manager' "
                + ") "
                + "SELECT "
                + "    me.EmployeeID, "
                + "    me.EmployeeLastName, "
                + "    me.EmployeeFirstName, "
                + "    me.EmployeeTitle, "
                + "    (SELECT COUNT(*) FROM Sales.Customer) AS TotalCustomers "
                + "FROM "
                + "    ManagerEmployees me;";
    }
    
    //CASE 12
    private static String getEmployeeShipperMatchQuery() {
        return "USE Northwinds2022TSQLV7; "
                + "WITH EmployeeShipperMatch AS ( "
                + "    SELECT "
                + "        e.EmployeeID, "
                + "        e.EmployeeLastName, "
                + "        e.EmployeeFirstName, "
                + "        s.ShipperID, "
                + "        s.ShipperCompanyName "
                + "    FROM "
                + "        HumanResources.Employee e "
                + "    CROSS JOIN "
                + "        Sales.Shipper s "
                + "    WHERE "
                + "        LEFT(e.EmployeeLastName, 1) = LEFT(s.ShipperCompanyName, 1) "
                + "), "
                + "ShipmentsPerShipper AS ( "
                + "    SELECT "
                + "        ShipperID, "
                + "        COUNT(*) AS NumberOfShipments "
                + "    FROM "
                + "        Sales.Shipper "
                + "    GROUP BY "
                + "        ShipperID "
                + ") "
                + "SELECT "
                + "    esm.EmployeeID, "
                + "    esm.EmployeeLastName, "
                + "    esm.EmployeeFirstName, "
                + "    SUM(sps.NumberOfShipments) AS TotalShipmentsHandled "
                + "FROM "
                + "    EmployeeShipperMatch esm "
                + "JOIN "
                + "    ShipmentsPerShipper sps ON esm.ShipperID = sps.ShipperID "
                + "GROUP BY "
                + "    esm.EmployeeID, esm.EmployeeLastName, esm.EmployeeFirstName "
                + "ORDER BY "
                + "    TotalShipmentsHandled DESC;";
    }
    //CASE 13
    private static String getCountrySuppliersQuery() {
        return "USE Northwinds2022TSQLV7; "
                + "WITH CountrySuppliers AS ( "
                + "    SELECT "
                + "        suppliercountry, "
                + "        COUNT(*) AS NumberOfSuppliers "
                + "    FROM "
                + "        Production.Supplier "
                + "    GROUP BY "
                + "        suppliercountry "
                + ") "
                + "SELECT "
                + "    e.EmployeeID, "
                + "    e.EmployeeFirstName, "
                + "    e.EmployeeLastName, "
                + "    cs.suppliercountry, "
                + "    cs.NumberOfSuppliers "
                + "FROM "
                + "    HumanResources.Employee e "
                + "CROSS JOIN "
                + "    CountrySuppliers cs "
                + "WHERE "
                + "    EXISTS ( "
                + "        SELECT 1 "
                + "        FROM Sales.Customer c "
                + "        WHERE c.CustomerCountry = cs.suppliercountry "
                + "    ) "
                + "ORDER BY "
                + "    cs.suppliercountry, e.EmployeeID;";
    }
    //CASE 14
    private static String getTotalTaxCollectedQuery() {
        return "USE WideWorldImporters; "
                + "WITH SupplierTax AS ( "
                + "    SELECT "
                + "        SUM(TaxAmount) AS TotalSupplierTax "
                + "    FROM "
                + "        Purchasing.SupplierTransactions "
                + "    WHERE "
                + "        YEAR(TransactionDate) = 2013 "
                + "), "
                + "CustomerTax AS ( "
                + "    SELECT "
                + "        SUM(TaxAmount) AS TotalCustomerTax "
                + "    FROM "
                + "        Sales.CustomerTransactions "
                + "    WHERE "
                + "        YEAR(TransactionDate) = 2013 "
                + ") "
                + "SELECT "
                + "    (SELECT TotalSupplierTax FROM SupplierTax) + (SELECT TotalCustomerTax FROM CustomerTax) AS TotalTaxCollected;";
    }
    //CASE 15
    private static String getCustomerTransactionsSummaryQuery() {
        return "USE WideWorldImporters; "
                + "SELECT "
                + "    ct.CustomerID, "
                + "    COUNT(i.InvoiceID) AS NumberOfInvoices, "
                + "    SUM(ct.TransactionAmount) AS TotalTransactionAmount, "
                + "    AVG(ct.TaxAmount) AS AverageTaxAmount, "
                + "    MAX(i.OrderID) AS LargestOrder "
                + "FROM "
                + "    Sales.CustomerTransactions ct "
                + "JOIN "
                + "    Sales.Invoices i ON ct.CustomerID = i.CustomerID "
                + "GROUP BY "
                + "    ct.CustomerID "
                + "ORDER BY "
                + "    TotalTransactionAmount DESC;";
    }
    
    //CASE 16
    private static String getCustomersAboveAverageSpendingQuery() {
        return "USE WideWorldImporters; "
                + "SELECT "
                + "    CT.CustomerID, "
                + "    SUM(CT.TransactionAmount) AS TotalSpent "
                + "FROM "
                + "    Sales.CustomerTransactions CT "
                + "GROUP BY "
                + "    CT.CustomerID "
                + "HAVING "
                + "    SUM(CT.TransactionAmount) > ("
                + "        SELECT AVG(TotalAmount) "
                + "        FROM ("
                + "            SELECT "
                + "                SUM(TransactionAmount) AS TotalAmount "
                + "            FROM "
                + "                Sales.CustomerTransactions "
                + "            GROUP BY "
                + "                CustomerID"
                + "        ) AS AvgTotal"
                + "    ) "
                + "ORDER BY "
                + "    TotalSpent DESC;";
    }
    //CASE 17
    private static String getCustomerTransactionsYearlySummaryQuery() {
        return "USE WideWorldImporters; "
                + "SELECT "
                + "    ct.CustomerID, "
                + "    i.InvoiceID, "
                + "    SUM(ct.TransactionAmount) AS TotalTransactionAmount, "
                + "    SUM(ct.TaxAmount) AS TotalTaxAmount "
                + "FROM "
                + "    Sales.CustomerTransactions ct "
                + "JOIN "
                + "    Sales.Invoices i ON ct.CustomerID = i.CustomerID "
                + "WHERE "
                + "    YEAR(i.OrderID) = YEAR(GETDATE()) "
                + "GROUP BY "
                + "    ct.CustomerID, "
                + "    i.InvoiceID "
                + "ORDER BY "
                + "    ct.CustomerID, i.InvoiceID;";
    }
    //CASE 18
    private static String getCustomerCityDetailsQuery() {
        return "USE WideWorldImportersDW;\n" +
                "SELECT\n" +
                "    c.Customer,\n" +
                "    (\n" +
                "        SELECT ci.City\n" +
                "        FROM Dimension.City ci\n" +
                "        WHERE ci.[City Key] = c.[Customer Key]\n" +
                "    ) AS City,\n" +
                "    (\n" +
                "        SELECT ci.[State Province]\n" +
                "        FROM Dimension.City ci\n" +
                "        WHERE ci.[City Key] = c.[Customer Key]\n" +
                "    ) AS State,\n" +
                "    (\n" +
                "        SELECT ci.Country\n" +
                "        FROM Dimension.City ci\n" +
                "        WHERE ci.[City Key] = c.[Customer Key]\n" +
                "    ) AS Country\n" +
                "FROM\n" +
                "    Dimension.Customer c\n" +
                "WHERE\n" +
                "    EXISTS (\n" +
                "        SELECT 1\n" +
                "        FROM Dimension.City ci\n" +
                "        WHERE ci.[City Key] = c.[Customer Key]\n" +
                "          AND ci.Country = 'United States'\n" +
                "    );";
    }
    //CASE 19
    private static String getCustomersFromUSQuery() {
        return "USE WideWorldImportersDW; " +
               "SELECT " +
               "    c.Customer " +
               "FROM " +
               "    Dimension.Customer c " +
               "WHERE " +
               "    c.[Customer Key] IN ( " +
               "        SELECT " +
               "            ci.[City Key] " +
               "        FROM " +
               "            Dimension.City ci " +
               "        WHERE " +
               "            ci.Country = 'United States' " +
               "    )";
    }
    //CASE 20
    private static String getYearlySalesGrowthQuery() {
        return "USE Northwinds2022TSQLV7; " +
               "DECLARE @query NVARCHAR(MAX); " +
               "SET @query = 'CREATE OR ALTER FUNCTION dbo.CalcYearlyGrowth (@thisYearSales MONEY, @lastYearSales MONEY) ' + " +
               "           'RETURNS FLOAT ' + " +
               "           'AS ' + " +
               "           'BEGIN ' + " +
               "           '    DECLARE @growth FLOAT; ' + " +
               "           '    IF @lastYearSales = 0 OR @lastYearSales IS NULL ' + " +
               "           '        SET @growth = NULL; ' + " +
               "           '    ELSE ' + " +
               "           '        SET @growth = (@thisYearSales - @lastYearSales) / @lastYearSales; ' + " +
               "           '    RETURN @growth; ' + " +
               "           'END;'; " +
               "EXEC sp_executesql @query; " +
               "WITH YearlySales AS ( " +
               "    SELECT " +
               "        c.CategoryID, " +
               "        c.CategoryName, " +
               "        YEAR(o.OrderDate) AS SalesYear, " +
               "        SUM(od.UnitPrice * od.Quantity) AS TotalYearlySales " +
               "    FROM Production.Category c " +
               "    JOIN Production.Product p ON c.CategoryID = p.CategoryID " +
               "    JOIN Sales.OrderDetail od ON p.ProductID = od.ProductID " +
               "    JOIN Sales.[Order] o ON od.OrderID = o.OrderID " +
               "    GROUP BY c.CategoryID, c.CategoryName, YEAR(o.OrderDate) " +
               ") " +
               "SELECT " +
               "    curr.CategoryID, " +
               "    curr.CategoryName, " +
               "    curr.SalesYear, " +
               "    curr.TotalYearlySales, " +
               "    dbo.CalcYearlyGrowth(curr.TotalYearlySales, prev.TotalYearlySales) AS YearlyGrowth " +
               "FROM YearlySales curr " +
               "LEFT JOIN YearlySales prev ON curr.CategoryID = prev.CategoryID AND curr.SalesYear = prev.SalesYear + 1 " +
               "ORDER BY curr.CategoryID, curr.SalesYear;";
    }





       
    
}