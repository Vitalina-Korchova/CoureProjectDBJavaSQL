package courseproject.courseprojectjavabd;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Map;

public class ExecuteQueries {

    private DBConnection dbConnection = new DBConnection();
    CrudFindQueryMethods crudFindFunc = new CrudFindQueryMethods(dbConnection);

    public void getInfoAboutAuthorsThatBooksPublishedOftenByQuarters(TableView<Map<String, Object>> tableView){

        String query = """
                WITH AuthorQuarterStats AS (
                 SELECT\s
                     a.author_name,
                     QUARTER(o.order_start_date) AS quarter,
                     YEAR(o.order_start_date) AS year,
                     COUNT(o.order_id) AS orders_count
                 FROM\s
                     author a
                 JOIN\s
                     publication_author pa ON a.author_id = pa.author_id
                 JOIN\s
                     publication p ON pa.publication_id = p.publication_id
                 JOIN\s
                     ordering o ON p.publication_id = o.publication_id
                 WHERE\s
                     o.print_product_type = 'Книга'
                 GROUP BY\s
                     a.author_name, quarter, year
             )

             SELECT\s
                 author_name AS 'ПІБ автора',
                 quarter AS 'Квартал',
                 year AS 'Рік',
                 orders_count AS 'Кількість книг'
             FROM\s
                 AuthorQuarterStats
             WHERE\s
                 (quarter, year, orders_count) IN (
                     SELECT\s
                         quarter,
                         year,
                         MAX(orders_count)
                     FROM\s
                         AuthorQuarterStats
                     GROUP BY\s
                         quarter, year
                 )
             ORDER BY\s
                 year, quarter, orders_count DESC;
                
        """;

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ПІБ автора");
        tableView.getColumns().get(1).setText("Квартал");
        tableView.getColumns().get(2).setText("Рік");
        tableView.getColumns().get(3).setText("Кількість книг");
        tableView.setItems(results);
    }

    public void DisplayInfoPublicationInProgress(TableView<Map<String, Object>> tableView){
        String query = """
                SELECT\s
                    ordering.order_id,
                    ordering.print_product_type,
                    ordering.order_start_date,
                    ordering.order_end_date,
                    ordering.order_status_fulfilment,
                    ordering.order_price,
                    publication.publication_name,
                    client.client_name,
                    printing_house.printing_house_name \s
                FROM\s
                    ordering\s
                JOIN\s
                    publication ON ordering.publication_id = publication.publication_id
                JOIN\s
                    client ON ordering.client_id = client.client_id \s
                JOIN\s
                    printing_house ON ordering.printing_house_id = printing_house.printing_house_id \s
                WHERE\s
                    ordering.order_status_fulfilment = 'У процесі'\s
                ORDER BY\s
                    ordering.order_start_date DESC;
        """;

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("Вид друкованої продукції");
        tableView.getColumns().get(2).setText("Дата прийому замовлення");
        tableView.getColumns().get(3).setText("Дата виконання замовлення");
        tableView.getColumns().get(4).setText("Статус виконання");
        tableView.getColumns().get(5).setText("Вартість");
        tableView.getColumns().get(6).setText("Назва видання");
        tableView.getColumns().get(7).setText("ПІБ клієнта");
        tableView.getColumns().get(8).setText("Назва друкарні");
        tableView.setItems(results);
    }

    public void GetTotalVolumePrintedProductsInPrintedSheetsForQuarters(TableView<Map<String, Object>> tableView){
        String query = """
                SELECT\s
                    QUARTER(ordering.order_start_date) AS quarter,
                    YEAR(ordering.order_start_date) AS year,
                    ROUND(SUM(publication.publication_circulation * publication.publication_amount_printed_sheets), 2) AS total_printed_sheets
                FROM\s
                    ordering
                JOIN\s
                    publication ON ordering.publication_id = publication.publication_id
                WHERE\s
                    ordering.order_status_fulfilment = 'Виконано'
                GROUP BY\s
                    quarter, year
                ORDER BY\s
                    year, quarter;
        """;

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("Квартал");
        tableView.getColumns().get(1).setText("Рік");
        tableView.getColumns().get(2).setText("Загальна кількість роздрукованих аркушів");
        tableView.setItems(results);
    }

    public void GetInfoAboutTheMostLoadedPrintingHouseByMonths(TableView<Map<String, Object>> tableView){
        String query = """
                WITH max_orders_per_month AS (
                    SELECT\s
                        YEAR(order_start_date) AS year,
                        MONTH(order_start_date) AS month,
                        printing_house_id,
                        COUNT(order_id) AS total_orders
                    FROM\s
                        ordering
                    WHERE
                        order_status_fulfilment != 'Скасовано' \s
                    GROUP BY\s
                        YEAR(order_start_date), MONTH(order_start_date), printing_house_id
                ),
                max_order_count AS (
                    SELECT\s
                        year,
                        month,
                        MAX(total_orders) AS max_orders
                    FROM\s
                        max_orders_per_month
                    GROUP BY\s
                        year, month
                )
                SELECT\s
                    printing_house.printing_house_name,
                    max_orders_per_month.month,
                    max_orders_per_month.year,
                    max_orders_per_month.total_orders
                FROM\s
                    max_orders_per_month
                JOIN\s
                    printing_house ON max_orders_per_month.printing_house_id = printing_house.printing_house_id
                JOIN\s
                    max_order_count ON max_orders_per_month.year = max_order_count.year
                                    AND max_orders_per_month.month = max_order_count.month
                                    AND max_orders_per_month.total_orders = max_order_count.max_orders
                ORDER BY\s
                    max_orders_per_month.year, max_orders_per_month.month, max_orders_per_month.total_orders DESC;
        """;

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("Назва друкарні");
        tableView.getColumns().get(1).setText("Місяць");
        tableView.getColumns().get(2).setText("Рік");
        tableView.getColumns().get(3).setText("Кількість замовлень");
        tableView.setItems(results);

    }

    //запит складений з двох (5 запит)
    public void GetInformationOfOrdersForCertainPeriodOfTime(TableView<Map<String, Object>> tableView, DatePicker pick1, DatePicker pick2) {
        LocalDate startDate = pick1.getValue();
        LocalDate endDate = pick2.getValue();

        String query = String.format("""
            SELECT
                ordering.order_id,
                ordering.order_numb,
                ordering.print_product_type,
                client.client_name AS client_name,
                publication.publication_name AS publication_name,
                printing_house.printing_house_name AS printing_house_name,
                ordering.order_start_date,
                ordering.order_end_date,
                ordering.order_status_fulfilment,
                ordering.order_price
            FROM
                ordering
            JOIN
                client ON ordering.client_id = client.client_id
            JOIN
                publication ON ordering.publication_id = publication.publication_id
            JOIN
                printing_house ON ordering.printing_house_id = printing_house.printing_house_id
            WHERE
                ordering.order_start_date BETWEEN '%s' AND '%s';
        """, startDate.toString(), endDate.toString());

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("Номер Замовлення");
        tableView.getColumns().get(2).setText("Вид друкованої продукції");
        tableView.getColumns().get(3).setText("ПІБ клієнта");
        tableView.getColumns().get(4).setText("Назва видання");
        tableView.getColumns().get(5).setText("Назва друкарні");
        tableView.getColumns().get(6).setText("Дата прийому замовлення");
        tableView.getColumns().get(7).setText("Дата виконання замовлення");
        tableView.getColumns().get(8).setText("Статус виконання");
        tableView.getColumns().get(9).setText("Вартість");
        tableView.setItems(results);
    }
    public void GetNumberOfOrdersForCertainPeriodOfTime (TextField field, DatePicker pick1, DatePicker pick2){

        LocalDate startDate = pick1.getValue();
        LocalDate endDate = pick2.getValue();

        String query = String.format("""
        SELECT\s
        COUNT(ordering.order_id) AS total_orders
        FROM\s
            ordering
        WHERE\s
           ordering.order_start_date BETWEEN '%s' AND '%s';
        """, startDate.toString(), endDate.toString());

        Integer totalOrders = crudFindFunc.executeSingleValueQuery(query);
        if (totalOrders != null) {
            field.setText(totalOrders.toString());
        } else {
            field.setText("0");
        }
    }
    //

    //запит складений з двох (6 запит)
    public void GetInformationOfOrdersByVariousTypesPublishingProducts(TableView<Map<String, Object>> tableView, ComboBox<String> field){

        String typeProduct = field.getValue();
        String query = String.format("""
          SELECT\s
              ordering.order_id,
              ordering.order_numb,
              ordering.print_product_type,
              ordering.order_start_date,
              ordering.order_end_date,
              ordering.order_status_fulfilment,
              client.client_name AS client_name,                    \s
              publication.publication_name AS publication_name,    \s
              printing_house.printing_house_name AS printing_house_name,\s
              ordering.order_price
          FROM\s
              ordering
          JOIN\s
              client ON ordering.client_id = client.client_id            \s
          JOIN\s
              publication ON ordering.publication_id = publication.publication_id
          JOIN\s
              printing_house ON ordering.printing_house_id = printing_house.printing_house_id\s
          WHERE\s
              ordering.print_product_type = '%s' \s
          ORDER BY\s
              ordering.order_start_date;
        """, typeProduct);

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("Номер Замовлення");
        tableView.getColumns().get(2).setText("Вид друкованої продукції");
        tableView.getColumns().get(3).setText("Дата прийому замовлення");
        tableView.getColumns().get(4).setText("Дата виконання замовлення");
        tableView.getColumns().get(5).setText("Статус виконання");
        tableView.getColumns().get(6).setText("ПІБ клієнта");
        tableView.getColumns().get(7).setText("Назва видання");
        tableView.getColumns().get(8).setText("Назва друкарні");
        tableView.getColumns().get(9).setText("Вартість");
        tableView.setItems(results);
    }
    public void GetNumberOfOrdersByVariousTypesPublishingProducts(TextField field, ComboBox<String> fieldType){
        String typeProduct = fieldType.getValue();
        String query = String.format("""
        SELECT\s
        COUNT(ordering.order_id)  AS total_orders
        FROM\s
            ordering
        WHERE\s
            ordering.print_product_type = '%s'
        """,typeProduct );

        Integer totalOrders = crudFindFunc.executeSingleValueQuery(query);
        if (totalOrders != null) {
            field.setText(totalOrders.toString());
        } else {
            field.setText("0");
        }
    }
    //

    //запит складений з двох (7 запит)
    public void GetInformationAboutOrdersInvolvingCertainAuthor(TableView<Map<String, Object>> tableView, TextField field){
        String author = field.getText();
        String query = String.format("""
                SELECT
                    o.order_id,
                    a.author_name, \s
                    o.order_numb,
                    o.print_product_type,
                    o.order_start_date,
                    o.order_end_date,
                    o.order_status_fulfilment,
                    p.publication_name AS publication_name,
                    o.order_price
                FROM
                    ordering o
                JOIN
                    publication p ON o.publication_id = p.publication_id
                JOIN
                    publication_author pa ON p.publication_id = pa.publication_id
                JOIN
                    author a ON pa.author_id = a.author_id
                WHERE
                    a.author_name LIKE '%s%%'
                ORDER BY
                    o.order_start_date;
                
        """, author);

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("ПІБ автора");
        tableView.getColumns().get(2).setText("Номер замовлення");
        tableView.getColumns().get(3).setText("Вид друкованої продукції");
        tableView.getColumns().get(4).setText("Дата прийому замовлення");
        tableView.getColumns().get(5).setText("Дата виконання замовлення");
        tableView.getColumns().get(6).setText("Статус виконання");
        tableView.getColumns().get(7).setText("Назва видання");
        tableView.getColumns().get(8).setText("Вартість");
        tableView.setItems(results);

    }
    public void GetNumberOfOrdersInvolvingCertainAuthor(TextField field, TextField fieldAuthor){
        String authorField = fieldAuthor.getText();
        String query = String.format("""
                SELECT
                   COUNT(o.order_id) AS total_orders
               FROM
                   ordering o
               JOIN
                   publication p ON o.publication_id = p.publication_id
               JOIN
                   publication_author pa ON p.publication_id = pa.publication_id
               JOIN
                   author a ON pa.author_id = a.author_id
               WHERE
                   a.author_name LIKE '%s%%';
                
        """,authorField );

        Integer totalOrders = crudFindFunc.executeSingleValueQuery(query);
        if (totalOrders != null) {
            field.setText(totalOrders.toString());
        } else {
            field.setText("0");
        }
    }
    //

    //запит складений з двох (8 запит)
    public void GetInformationAboutOrdersThatHaveBeenCanceledThroughNonPaymentCancellationByTheCustomer(TableView<Map<String, Object>> tableView){
        String query = """
        SELECT\s
            ordering.order_id,
            ordering.order_numb,
            ordering.print_product_type,
            ordering.order_start_date,
            ordering.order_end_date,
            ordering.order_status_fulfilment,
            ordering.order_price,
            ordering.order_status_payment,
            client.client_name AS client_name,                    
            publication.publication_name AS publication_name
          \s
        FROM\s
            ordering
        JOIN\s
            client ON ordering.client_id = client.client_id             
        JOIN\s
            publication ON ordering.publication_id = publication.publication_id
        WHERE\s
            ordering.order_status_fulfilment = 'Скасовано'\s
            AND ordering.order_status_payment = 'Неоплачено'\s
        ORDER BY\s
            ordering.order_start_date;
        """;

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("Номер Замовлення");
        tableView.getColumns().get(2).setText("Вид друкованої продукції");
        tableView.getColumns().get(3).setText("Дата прийому замовлення");
        tableView.getColumns().get(4).setText("Дата виконання замовлення");
        tableView.getColumns().get(5).setText("Статус виконання");
        tableView.getColumns().get(6).setText("Вартість");
        tableView.getColumns().get(7).setText("Статус оплати");
        tableView.getColumns().get(8).setText("ПІБ клієнта");
        tableView.getColumns().get(9).setText("Назва видання");
        tableView.setItems(results);
    }
    public void GetNumberOfOrdersThatHaveBeenCanceledThroughNonPaymentCancellationByTheCustomer(TextField field){
        String query = """
        SELECT\s
             COUNT(ordering.order_id)  AS total_cancelled_and_unpaid_orders\s
        FROM\s
            ordering
        WHERE\s
            ordering.order_status_fulfilment = 'Скасовано'\s
            AND ordering.order_status_payment = 'Неоплачено'
        """;

        Integer totalOrders = crudFindFunc.executeSingleValueQuery(query);
        if (totalOrders != null) {
            field.setText(totalOrders.toString());
        } else {
            field.setText("0");
        }
    }
    //

    //запит складений з двох (9 запит)
    public void GetInformationOrdersThatHasBeenMadePrivatePersonOrOrganization(TableView<Map<String, Object>> tableView, TextField clientField){
        String fieldClient = clientField.getText();
        String query = String.format("""
        SELECT\s
            ordering.order_id,
            client.client_name, \s
            client.client_type, \s
            ordering.order_numb,
            ordering.print_product_type,
            ordering.order_start_date,
            ordering.order_end_date,
            ordering.order_status_fulfilment,
            ordering.order_price,
            publication.publication_name AS publication_name,
            printing_house.printing_house_name AS printing_house_name
          \s
        FROM\s
            ordering
        JOIN\s
            publication ON ordering.publication_id = publication.publication_id
        JOIN\s
            printing_house ON ordering.printing_house_id = printing_house.printing_house_id\s
        JOIN\s
            client ON ordering.client_id = client.client_id \s
        WHERE\s
            client.client_name LIKE '%s%%' \s
            AND ( client.client_type = 'Організація' OR client.client_type = 'Приватна особа')
        ORDER BY\s
            ordering.order_start_date;
        """, fieldClient);


        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("ID Замовлення");
        tableView.getColumns().get(1).setText("ПІБ клієнта");
        tableView.getColumns().get(2).setText("Тип клієнта");
        tableView.getColumns().get(3).setText("Номер замовлення");
        tableView.getColumns().get(4).setText("Вид друкованої продукції");
        tableView.getColumns().get(5).setText("Дата прийому замовлення");
        tableView.getColumns().get(6).setText("Дата виконання замовлення");
        tableView.getColumns().get(7).setText("Статус виконання");
        tableView.getColumns().get(8).setText("Вартість");
        tableView.getColumns().get(9).setText("Назва видання");
        tableView.getColumns().get(10).setText("Назва друкарні");
        tableView.setItems(results);

    }
    public void GetNumberOrdersThatHasBeenMadePrivatePersonOrOrganization (TextField field, TextField clientField){
        String fieldClient = clientField.getText();
        String query = String.format("""
        SELECT\s
            COUNT(ordering.order_id)  AS total_orders\s
        FROM\s
            ordering
        JOIN\s
            client ON ordering.client_id = client.client_id  
        WHERE\s
            client.client_name LIKE '%s%%' 
            AND ( client.client_type = 'Організація' OR client.client_type = 'Приватна особа')
        """, fieldClient);

        Integer totalOrders = crudFindFunc.executeSingleValueQuery(query);
        if (totalOrders != null) {
            field.setText(totalOrders.toString());
        } else {
            field.setText("0");
        }
    }
    //

    public void CalculateTheProfitOfThePublishingHouseForTheMonth(TableView<Map<String, Object>> tableView, ComboBox<Integer> fieldMonth, ComboBox<Integer> fieldYear){
        Integer month = fieldMonth.getValue();
        Integer year = fieldYear.getValue();
        String query = String.format("""
        SELECT\s
            MONTH(ordering.order_start_date) AS month,
            YEAR(ordering.order_start_date) AS year,
            SUM(ordering.order_price) AS total_profit
        FROM\s
            ordering
        WHERE\s
            ordering.order_status_fulfilment = 'Виконано'
            AND MONTH(ordering.order_start_date) = %d  
            AND YEAR(ordering.order_start_date) = %d    
        GROUP BY\s
            MONTH(ordering.order_start_date),\s
            YEAR(ordering.order_start_date);
        """, month,year);

        ObservableList<Map<String, Object>> results = crudFindFunc.executeQuery(query);
        crudFindFunc.generateTableColumns(tableView, results);
        tableView.getColumns().get(0).setText("Місяць");
        tableView.getColumns().get(1).setText("Рік");
        tableView.getColumns().get(2).setText("Прибуток");
        tableView.setItems(results);
    }

}
