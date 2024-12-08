package courseproject.courseprojectjavabd;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.skin.TableColumnHeader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.sql.Date;
import java.util.*;
import java.util.function.Function;

public class MainWindowController {

    //region FXML Elements

    //block general and leftPane elements

    @FXML
    private AnchorPane mainWindowPane;

    @FXML
    private Button btnClient;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnPublication;

    @FXML
    private Button btnAuthor;

    @FXML
    private Button btnAddUser;

    @FXML
    private Button btnPrintingHouse;

    @FXML
    private Button btnFindInfo;

    @FXML
    private Button btnKeys;

    @FXML
    private Button btnLogout;

    @FXML
    private ImageView iconUserRolePanel;

   ////////////////////////////////////////////////////////
   //block Order elements

    @FXML
    private Pane paneOrder;

    @FXML
    private Button btnAddOrderDB;

    @FXML
    private Button btnClearFieldsFindOrder;

    @FXML
    private Button btnClearFieldsOrder;

    @FXML
    private Button btnRemoveOrderDB;

    @FXML
    private Button btnUpdateOrderDB;

    @FXML
    private TableColumn<Order, Date> columnEndDateOrder;

    @FXML
    private TableColumn<Order, String> columnIDClientOrder;

    @FXML
    private TableColumn<Order, Integer> columnIDOrder;

    @FXML
    private TableColumn<Order, String> columnIDPrintingHouseOrder;

    @FXML
    private TableColumn<Order, String> columnIDPublicationOrder;

    @FXML
    private TableColumn<Order, String> columnNumbOrderOrder;

    @FXML
    private TableColumn<Order, Double> columnPriceOrder;

    @FXML
    private TableColumn<Order, Date> columnStartDateOrder;

    @FXML
    private TableColumn<Order, String> columnStatusFulfilmentOrder;

    @FXML
    private TableColumn<Order, String> columnStatusPaymentOrder;

    @FXML
    private TableColumn<Order, String> columnTypeOrder;

    @FXML
    private DatePicker fieldEndDateOrder;

    @FXML
    private TextField fieldIDClientOrder;

    @FXML
    private TextField fieldIDPrintingHouseOrder;

    @FXML
    private TextField fieldIDPublicationOrder;

    @FXML
    private TextField fieldNumbOrderFindOrder;

    @FXML
    private TextField fieldNumbOrderOrder;

    @FXML
    private TextField fieldPriceOrder;

    @FXML
    private DatePicker fieldStartDateOrder;

    @FXML
    private ComboBox<String> fieldStatusFulfilmentOrder;

    @FXML
    private ComboBox<String> fieldStatusPaymentOrder;

    @FXML
    private ComboBox<String> fieldTypePublicationOrder;

    @FXML
    private TextField fieldTypePublicationFindOrder;

    @FXML
    private TextField fieldStatusFulfilmentFindOrder;

    @FXML
    private TextField fieldStatusPaymentFindOrder;

    @FXML
    private TableView<Order> tableOrder;



    ////////////////////////////////////////////////////////////////
    //block Client elements

    @FXML
    private Pane paneClient;

    @FXML
    private  TableView<Client> tableClient;

    @FXML
    private TableColumn<Client, String> columnAddressClient;

    @FXML
    private TableColumn<Client,String> columnEmailClient;

    @FXML
    private TableColumn<Client, Integer> columnIDClient;

    @FXML
    private TableColumn<Client, String> columnNameClient;

    @FXML
    private TableColumn<Client, String> columnNumbPhoneClient;

    @FXML
    private TableColumn<Client, String> columnTypeClient;

    @FXML
    private ComboBox<String> fieldTypeClient;

    @FXML
    private TextField fieldAddressClient;

    @FXML
    private TextField fieldEmailClient;

    @FXML
    private TextField fieldNameClient;

    @FXML
    private TextField fieldNameClientFind;

    @FXML
    private TextField fieldNumbPhoneClient;

    @FXML
    private TextField fieldTypeClientFind;

    @FXML
    private  Button btnAddClientDB;

    @FXML
    private  Button btnRemoveClientDB;

    @FXML
    private Button btnUpdateClientDB;

    @FXML
    private Button btnClearFieldsClient;

    @FXML
    private Button btnClearFieldsFindClient;

    @FXML
    private ImageView iconClient;
    ////////////////////////////////////////////////////////
    //block Publication elements

    @FXML
    private Pane panePublication;

    @FXML
    private TextField fieldNumberPagesPublication;

    @FXML
    private TextField fieldCirculationPublication;

    @FXML
    private TextField fieldCodePublication;

    @FXML
    private TextField fieldNamePublication;

    @FXML
    private ComboBox<String> fieldTypeSizePublication;

    @FXML
    private TextField fieldAmountPrintedSheetsPublication;

    @FXML
    private ImageView helpHowCalculatePublication;

    @FXML
    private Button btnAddPublicationDB;

    @FXML
    private Button btnCalculatePublication;

    @FXML
    private Button btnClearFieldsPublication;

    @FXML
    private Button btnRemovePublicationDB;

    @FXML
    private Button btnUpdatePublicationDB;

    @FXML
    private TextField fieldCodePublicationFind;

    @FXML
    private TextField fieldNamePublicationFind;

    @FXML
    private Button btnClearFieldsFindPublication;

    @FXML
    private TableView<Publication> tablePublication;

    @FXML
    private TableColumn<Publication, Double> columnAmountPrintedSheetsPublication;

    @FXML
    private TableColumn<Publication, Integer> columnCirculationPublication;

    @FXML
    private TableColumn<Publication, String> columnCodePublication;

    @FXML
    private TableColumn<Publication, Integer> columnIDPublication;

    @FXML
    private TableColumn<Publication, String> columnNamePublication;

    @FXML
    private TableColumn<Publication, Integer> columnNumberPagesPublication;

    @FXML
    private TableColumn<Publication, String> columnTypeSizePublication;

    @FXML
    private ImageView iconPublication;


    ////////////////////////////////////////////////////////
    //block Author elements

    @FXML
    private Pane paneAuthor;

    @FXML
    private Button btnAddAuthorDB;

    @FXML
    private Button btnClearFieldsAuthor;

    @FXML
    private Button btnGetDataClientAuthor;

    @FXML
    private Button btnRemoveAuthorDB;

    @FXML
    private Button btnUpdateAuthorDB;

    @FXML
    private TextArea fieldAdditionalInfoAuthor;

    @FXML
    private TextField fieldAddressAuthor;

    @FXML
    private TextField fieldEmailAuthor;

    @FXML
    private TextField fieldIDClientGetDataAuthor;

    @FXML
    private TextField fieldNameAuthor;

    @FXML
    private TextField fieldNumbPhoneAuthor;

    @FXML
    private Button btnClearFieldsFindAuthor;

    @FXML
    private TextField fieldNameAuthorFind;

    @FXML
    private TableView<Author> tableAuthor;

    @FXML
    private TableColumn<Author, String> columnNumbPhoneAuthor;

    @FXML
    private TableColumn<Author, String > columnNameAuthor;

    @FXML
    private TableColumn<Author, Integer> columnIDAuthor;

    @FXML
    private TableColumn<Author, String> columnEmailAuthor;

    @FXML
    private TableColumn<Author, String> columnAddressAuthor;

    @FXML
    private TableColumn<Author, String> columnAdditionalInfoAuthor;

    @FXML
    private ImageView iconAuthor;
///////////////////////////////////////////////////////////////

   //block PublicationAuthor elements
   @FXML
   private Pane panePublicationAuthor;

    @FXML
    private Button btnPublicationAuthor;

    @FXML
    private Button btnAddPublicationAuthorDB;

    @FXML
    private Button btnClearFieldsFindPublicationAuthor;

    @FXML
    private Button btnClearFieldsPublicationAuthorDB;

    @FXML
    private Button btnRemovePublicationAuthorDB;

    @FXML
    private Button btnUpdatePublicationAuthorDB;

    @FXML
    private TableColumn<PublicationAuthor, String> columnIDAuthorConnection;

    @FXML
    private TableColumn<PublicationAuthor, Integer> columnIDPublicationAuthor;

    @FXML
    private TableColumn<PublicationAuthor, String> columnIDPublicationConnection;

    @FXML
    private TextField fieldIDAuthorConnection;

    @FXML
    private TextField fieldIDAuthorPublicationAuthorFind;

    @FXML
    private TextField fieldIDPublicationConnection;

    @FXML
    private TextField fieldIDPublicationPublicationAuthorFind;

    @FXML
    private TableView<PublicationAuthor> tablePublicationAuthor;

    @FXML
    private ImageView iconConnectionPublicationAuthor;

    ////////////////////////////////////////////////////////
    //block PrintingHouse elements

    @FXML
    private Pane panePrintingHouse;

    @FXML
    private TextField fieldNamePrintingHouse;

    @FXML
    private TextField fieldAddressPrintingHouse;

    @FXML
    private TextField fieldNumberPhonePrintingHouse;

    @FXML
    private TextField fieldEmailPrintingHouse;

    @FXML
    private Button btnAddPrintingHouseDB;

    @FXML
    private Button btnRemovePrintingHouseDB;

    @FXML
    private Button btnUpdatePrintingHouseDB;

    @FXML
    private Button btnClearFieldsPrintingHouseDB;

    @FXML
    private Button btnClearFieldsFindPrintingHouse;

    @FXML
    private TextField fieldNamePrintingHouseFind;

    @FXML
    private TableView<PrintingHouse> tablePrintingHouse;

    @FXML
    private TableColumn<PrintingHouse,Integer> columnIDPrintingHouse;

    @FXML
    private TableColumn<PrintingHouse,String> columnNamePrintingHouse;

    @FXML
    private TableColumn<PrintingHouse, String> columnNumbPhonePrintingHouse;

    @FXML
    private TableColumn<PrintingHouse, String> columnEmailPrintingHouse;

    @FXML
    private TableColumn<PrintingHouse, String> columnAddressPrintingHouse;

    @FXML
    private ImageView iconPrintingHouse;

    ////////////////////////////////////////////////////////
    //block Queries elements

    @FXML
    private Pane paneQueries;

    @FXML
    private Button btnClearFieldsQuery;

    @FXML
    private Button btnExecuteQuery;

    @FXML
    private Button btnClearQuery;

    @FXML
    private TextField fieldAuthorQuery;

    @FXML
    private ComboBox<Integer> fieldYearQuery;

    @FXML
    private ComboBox<Integer> fieldMonthQuery;

    @FXML
    private ComboBox<String> fieldChooseQuery;

    @FXML
    private TextField fieldGeneralNumberQuery;

    @FXML
    private TextField fieldClientQuery;

    @FXML
    private DatePicker fieldFirstDateQuery;

    @FXML
    private ComboBox<String> fieldProductTypeQuery;

    @FXML
    private DatePicker fieldSecondDateQuery;

    @FXML
    private TableView<Map<String, Object>>tableQuery;

    @FXML
    private ImageView iconFind;


    ////////////////////////////////////////////////////////
    //block Add User

    @FXML
    private TextField fieldLoginAddUser;

    @FXML
    private ImageView iconAddUser;

    @FXML
    private Pane paneAddUser;

    @FXML
    private TextField fieldPasswordAddUser;

    @FXML
    private ComboBox<String> fieldRoleAddUser;

    @FXML
    private CheckBox checkMarkAddUser;

    @FXML
    private CheckBox checkMarkQueries;

    @FXML
    private CheckBox checkMarkTableAuthor;

    @FXML
    private CheckBox checkMarkTableClient;

    @FXML
    private CheckBox checkMarkTablePrintingHouse;

    @FXML
    private CheckBox checkMarkTablePublication;

    @FXML
    private Button btnAddUserToKeys;

    @FXML
    private Button btnClearFieldsAddUser;

    ////////////////////////////////////////////////////////
    //block Keys elements

    @FXML
    private Pane paneKeys;

    @FXML
    private ImageView btnReloadPage;

    @FXML
    private ImageView iconKeys;

    @FXML
    private Button btnUpdateKeysDB;

    @FXML
    private Button btnRemoveKeysDB;

    @FXML
    private Button btnClearFieldsKeysDB;

    @FXML
    private Button btnClearFieldsFindKeys;

    @FXML
    private CheckBox checkMarkAddUserForKeys;

    @FXML
    private CheckBox checkMarkQueriesForKeys;

    @FXML
    private CheckBox checkMarkTableAuthorForKeys;

    @FXML
    private CheckBox checkMarkTableClientForKeys;

    @FXML
    private CheckBox checkMarkTablePrintingHouseForKeys;

    @FXML
    private CheckBox checkMarkTablePublicationForKeys;

    @FXML
    private TableColumn<Keys, Integer> columnIDKeys;

    @FXML
    private TableColumn<Keys, String> columnLoginKeys;

    @FXML
    private TableColumn<Keys, String> columnPasswordKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionAddUserKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionQueriesKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionTableAuthorKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionTableClientKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionTablePrintingHouseKeys;

    @FXML
    private TableColumn<Keys, Boolean> columnPermissionTablePublicationKeys;

    @FXML
    private TableColumn<Keys, String> columnRoleKeys;

    @FXML
    private TextField fieldLoginKeys;

    @FXML
    private TextField fieldLoginKeysFind;

    @FXML
    private TextField fieldPasswordKeys;

    @FXML
    private ComboBox<String> fieldRoleKeys;

    @FXML
    private TableView<Keys> tableKeys;

    ///permission messages
    @FXML
    private Label messagePermissionAuthor;

    @FXML
    private Label messagePermissionClient;

    @FXML
    private Label messagePermissionOrder;

    @FXML
    private Label messagePermissionPrintingHouse;

    @FXML
    private Label messagePermissionPublication;

    @FXML
    private Label messagePermissionQueries;

    @FXML
    private Label messagePermissionKeys;

    @FXML
    private Label messagePermissionAddUser;

    @FXML
    private Label messagePermissionPublicationAuthor;


    ////////////////////////////////////////////////////////

    //_____________________________________________________________________________
    //endregion

    //region Different variables and Lists
    //different variables
    //масиви для комбобоксів для UI
    ObservableList<String> listTypeClient = FXCollections.observableArrayList("Організація", "Приватна особа","Угруповання авторів", "Представник учасника");
    ObservableList<String> listRoleUser = FXCollections.observableArrayList("Адміністратор", "Оператор","Гість");
    ObservableList<String> listRoleUserWithoutAdmin = FXCollections.observableArrayList( "Оператор","Гість");
    ObservableList<String> listTypeSizePublication = FXCollections.observableArrayList("Бланк А4", "Бланк А5", "Брошура А4",
            "Брошура А5", "Буклет А4", "Буклет А5", "Буклет А3", "Візитка 90x50 мм", "Візитка 85x55 мм", "Газета А2",
            "Газета А3","Журнал А4", "Журнал A5", "Каталог А4","Каталог А5", "Книга А5", "Книга А4", "Листівка А6",
            "Листівка А5","Листівка 10x15 см ","Плакат А1", "Плакат А2", "Постер А1","Постер А2", "Сертифікат A4", "Сертифікат A5");

    ObservableList<String> listPrintProductTypeOrder = FXCollections.observableArrayList("Бланк", "Брошура", "Буклет", "Візитка",
            "Газета", "Журнал", "Каталог", "Книга", "Листівка", "Плакат", "Постер", "Сертифікат");

    ObservableList<String> listStatusFulfilmentOrder =  FXCollections.observableArrayList("В очікуванні", "У процесі", "Виконано", "Скасовано");
    ObservableList<String> listStatusPaymentOrder = FXCollections.observableArrayList("Неоплачено", "Оплачено");

    //робочі змінні
    private Button activeButton;
    private DBConnection dbConnection = new DBConnection();
    private Keys keys;
    private Keys currentUser;
    CrudFindQueryMethods crudFindFunc = new CrudFindQueryMethods(dbConnection);
    AdditionalMethods additionalMethods = new AdditionalMethods(dbConnection);


    //булеві змінні для корегування додавання об'єктів після методу ClickDisplay
    boolean functionClickDisplayAppliedClientBlock = false;
    boolean functionClickDisplayAppliedAuthorBlock = false;
    boolean functionClickDisplayAppliedPublicationBlock = false;
    boolean functionClickDisplayAppliedPrintingHouseBlock = false;
    boolean functionClickDisplayAppliedOrderBlock = false;
    boolean functionClickDisplayAppliedPublicationAuthorBlock = false;

    //масив запитів
    ObservableList<String> listQueries = FXCollections.observableArrayList(
            "Вивести інформацію про авторів, книги яких найчастіше друкуються за кварталами",
            "Вивести інформацію про замовлення, які знаходяться в роботі",
            "Одержати загальний обсяг роздрукованої продукції в друкованих аркушах за квартали",
            "Одержати інформацію про найбільш завантажені друкарні по місяцях",
            "Одержати інформацію та загальну кількість замовлень за певний період часу",
            "Одержати інформацію та загальну кількість замовлень за різними видами видавничої продукції",
            "Одержати інформацію та загальну кількість замовлень за участю певних авторів",
            "Одержати інформацію та загальну кількість замовлень, які були скасовані через неоплату та через відміну замовником",
            "Одержати інформацію та кількість замовлень, які зробила відповідна приватна особа чи організація",
            "Розрахувати прибуток видавництва за місяць"
    );

    ObservableList<Integer> listMonths = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
    ObservableList<Integer> listYears = FXCollections.observableArrayList(2023, 2024);
    ExecuteQueries executeQueries = new ExecuteQueries();
    //endregion


    @FXML
    public void initialize()  {
        setVisiblePane();
        initializeButtons();
        blockClient();
        blockOrder();
        blockPublication();
        blockAuthor();
        blockPublicationAuthorIntermediate();
        blockPrintingHouse();
        blockAddUser();
        Logout();
        blockKeys();
        blockQuery();

    }

    private void setVisiblePane() {   //показувати панелі (натискаючи на кнопки змінюється панель)
        paneClient.setVisible(false);
        paneOrder.setVisible(true);
        panePublication.setVisible(false);
        paneAuthor.setVisible(false);
        panePublicationAuthor.setVisible(false);
        panePrintingHouse.setVisible(false);
        paneQueries.setVisible(false);
        paneAddUser.setVisible(false);
        paneKeys.setVisible(false);
    }

    private void initializeButtons() {  //(ховер кнопок і кліки)
        btnOrder.getStyleClass().add("clicked");
        activeButton = btnOrder;

        btnClient.setOnAction(event -> handleButtonClick(btnClient, paneClient));
        btnOrder.setOnAction(event -> handleButtonClick(btnOrder, paneOrder));
        btnAuthor.setOnAction(event -> handleButtonClick(btnAuthor, paneAuthor));
        btnPublicationAuthor.setOnAction(event -> handleButtonClick(btnPublicationAuthor, panePublicationAuthor));
        btnKeys.setOnAction(event -> handleButtonClick(btnKeys, paneKeys));
        btnAddUser.setOnAction(event -> handleButtonClick(btnAddUser, paneAddUser));
        btnPrintingHouse.setOnAction(event -> handleButtonClick(btnPrintingHouse, panePrintingHouse));
        btnPublication.setOnAction(event -> handleButtonClick(btnPublication, panePublication));
        btnFindInfo.setOnAction(event -> handleButtonClick(btnFindInfo, paneQueries));
    }

    private void initializeComboBoxes() {  // викликається в fetchUserData
        fieldTypeClient.setItems(listTypeClient);
        fieldTypeClient.setValue("Організація");
        fieldTypeSizePublication.setItems(listTypeSizePublication);
        fieldTypeSizePublication.setValue("Бланк А4");
        fieldTypePublicationOrder.setItems(listPrintProductTypeOrder);
        fieldTypePublicationOrder.setValue("Бланк");
        fieldStatusFulfilmentOrder.setItems(listStatusFulfilmentOrder);
        fieldStatusFulfilmentOrder.setValue("В очікуванні");
        fieldStatusPaymentOrder.setItems(listStatusPaymentOrder);
        fieldStatusPaymentOrder.setValue("Неоплачено");
        fieldRoleAddUser.setValue("Гість");
        fieldRoleKeys.setItems(listRoleUser);
        fieldRoleKeys.setValue("Адміністратор");
        fieldChooseQuery.setItems(listQueries);
        fieldChooseQuery.setPromptText("Обрати запит: ");
        fieldProductTypeQuery.setItems(listPrintProductTypeOrder);
        fieldProductTypeQuery.setValue("Бланк");
        fieldMonthQuery.setItems(listMonths);
        fieldMonthQuery.setValue(1);
        fieldYearQuery.setItems(listYears);
        fieldYearQuery.setValue(2024);

        if (currentUser != null && ("Адміністратор".equalsIgnoreCase(currentUser.getRoleUser()) )) {
            fieldRoleAddUser.setItems(listRoleUserWithoutAdmin);
        } else {
            fieldRoleAddUser.setItems(listRoleUser);
        }
    }

    private void handleButtonClick(Button button, Pane paneToShow) { //для ховера кнопок і кліку UI допоміжна функція!
        String clickedClass = "clicked";

        if (activeButton != null && activeButton != button) {
            activeButton.getStyleClass().remove(clickedClass);
        }

        if (button.getStyleClass().contains(clickedClass)) {
            button.getStyleClass().remove(clickedClass);
            activeButton = null;
        } else {
            button.getStyleClass().add(clickedClass);
            activeButton = button;
        }

        if (paneToShow != null) {
            paneClient.setVisible(paneToShow == paneClient);
            paneOrder.setVisible(paneToShow == paneOrder);
            panePublication.setVisible(paneToShow == panePublication);
            paneAuthor.setVisible(paneToShow == paneAuthor);
            panePublicationAuthor.setVisible( paneToShow== panePublicationAuthor);
            panePrintingHouse.setVisible(paneToShow == panePrintingHouse);
            paneQueries.setVisible(paneToShow == paneQueries);
            paneAddUser.setVisible(paneToShow == paneAddUser);
            paneKeys.setVisible(paneToShow == paneKeys);

        }
    }


    //Опис кожного блоку
    //region blockClient
    //Опис функціонала блоку Клієнта

    public void blockClient(){
        //різні масиви для передачі у функції
        FilteredList<Client> filteredClientList;
        List<TableColumn<Client, ?>> tableColumnsClient = Arrays.asList(
                columnIDClient, columnTypeClient, columnNameClient, columnAddressClient, columnNumbPhoneClient, columnEmailClient);
        List<String> nameVariablesClassClient = Arrays.asList(
                "idClient", "typeClient", "nameClient", "addressClient", "numbPhoneClient", "emailClient");

        String query = "SELECT * FROM client";
        List<String> columnNamesDBClient = Arrays.asList("client_id", "client_type", "client_name", "client_address", "client_number_phone", "client_email");

        Function<ResultSet, Client> mapper = rs -> {
            try {
                return new Client(
                        rs.getInt("client_id"),
                        rs.getString("client_type"),
                        rs.getString("client_name"),
                        rs.getString("client_address"),
                        rs.getString("client_number_phone"),
                        rs.getString("client_email")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<Client> clientList = crudFindFunc.getList(query, columnNamesDBClient, mapper);
        filteredClientList = new FilteredList<>(clientList, p -> true);
        tableClient.setItems(filteredClientList);

        //показ даних в таблиці при завантаженні, клік по об'єкту і передача даних в поля
        //два методи пошуку в таблиці
        crudFindFunc.displayDataInTable(tableClient, tableColumnsClient, nameVariablesClassClient, filteredClientList);
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tableClient, () -> {
            fillFormFieldsClient();
            functionClickDisplayAppliedClientBlock = true;
        });
        crudFindFunc.FindInTable(fieldTypeClientFind, columnTypeClient, filteredClientList);
        crudFindFunc.FindInTable(fieldNameClientFind, columnNameClient, filteredClientList);

        //запити
        String queryAdd = "INSERT INTO client (client_type, client_name, client_address, client_number_phone, client_email) VALUES (?, ?, ?, ?, ?)";
        String queryUpdate = "UPDATE client SET client_type = ?, client_name = ?, client_address = ?, client_number_phone = ?, client_email = ? WHERE client_id = ?";
        String queryRemove = "DELETE FROM client WHERE client_id = ?";

        //опис кнопки додати об'єкт
        btnAddClientDB.setOnMouseClicked(event -> {
            if (functionClickDisplayAppliedClientBlock) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
            } else {
                if(checkingFieldsClient("", "")) {  // Передаємо пустий рядок для номера телефону і null для email
                    Map<String, Object> clientFieldsAdd = new LinkedHashMap<>();
                    clientFieldsAdd.put("client_type", fieldTypeClient.getValue());
                    clientFieldsAdd.put("client_name", fieldNameClient.getText());
                    clientFieldsAdd.put("client_address", fieldAddressClient.getText());
                    clientFieldsAdd.put("client_number_phone", fieldNumbPhoneClient.getText());
                    clientFieldsAdd.put("client_email", fieldEmailClient.getText());

                    boolean successFlag = crudFindFunc.addObject(clientFieldsAdd, queryAdd);
                    if (successFlag) {
                        crudFindFunc.updateList(query, columnNamesDBClient, mapper, clientList);
                        ClearFieldsClient();
                    }
                }
            }
        });

        //опис кнопки оновити об'єкт
        btnUpdateClientDB.setOnMouseClicked(event -> {
            Client selectedClient = tableClient.getSelectionModel().getSelectedItem();
            if (selectedClient == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }

            if(checkingFieldsClient(selectedClient.getNumbPhoneClient(), selectedClient.getEmailClient())) {
                Map<String, Object> clientFieldsUpdate = new LinkedHashMap<>();
                clientFieldsUpdate.put("client_type", fieldTypeClient.getValue());
                clientFieldsUpdate.put("client_name", fieldNameClient.getText());
                clientFieldsUpdate.put("client_address", fieldAddressClient.getText());
                clientFieldsUpdate.put("client_number_phone", fieldNumbPhoneClient.getText());
                clientFieldsUpdate.put("client_email", fieldEmailClient.getText());

                boolean successFlag = crudFindFunc.updateObject(clientFieldsUpdate, queryUpdate, selectedClient.getIdClient());
                if(successFlag) {
                    crudFindFunc.updateList(query, columnNamesDBClient, mapper, clientList);
                    ClearFieldsClient();
                }

            }
        });

        //опис кнопки видалити об'єкт
        btnRemoveClientDB.setOnMouseClicked(event ->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                ClearFieldsClient();
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tableClient, Client::getIdClient);
            crudFindFunc.updateList(query, columnNamesDBClient, mapper, clientList);
            ClearFieldsClient();
        });

        //опис кнопок очистити поля
        btnClearFieldsFindClient.setOnMouseClicked(event ->{
            fieldTypeClientFind.setText(null);
            fieldNameClientFind.setText(null);

        });

        btnClearFieldsClient.setOnMouseClicked(event ->{
            ClearFieldsClient();
        });


    }

    private void fillFormFieldsClient(){ //допоміжна функція шо буде показувати данні
        Client selectedClient = tableClient.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            fieldTypeClient.setValue(selectedClient.getTypeClient());
            fieldNameClient.setText(selectedClient.getNameClient());
            fieldAddressClient.setText(selectedClient.getAddressClient());
            fieldNumbPhoneClient.setText(selectedClient.getNumbPhoneClient());
            fieldEmailClient.setText(selectedClient.getEmailClient());
        }
    }

    private void ClearFieldsClient(){
        fieldTypeClient.setValue("Організація");
        fieldNameClient.setText(null);
        fieldAddressClient.setText(null);
        fieldNumbPhoneClient.setText(null);
        fieldEmailClient.setText(null);
        tableClient.getSelectionModel().clearSelection();
        functionClickDisplayAppliedClientBlock = false; // Скидаємо флаг після додавання
    }

    private boolean checkingFieldsClient(String numberPhone, String email) {
        //перевірка пустих полів
        List<TextField> fieldsClient = Arrays.asList(fieldNameClient, fieldAddressClient, fieldNumbPhoneClient);
        for (TextField field : fieldsClient){
            if(field.getText() == null || field.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                return false;
            }
        }

        //перевірка номера телефону індивідуальність
        String numberPhoneClient = fieldNumbPhoneClient.getText();
        if (!numberPhoneClient.equals(numberPhone)) {
            String queryCheckPhone = "SELECT COUNT(*) FROM client WHERE client_number_phone = ?";
            String alertErrorPhone = "Такий номер телефона вже існує! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorPhone, queryCheckPhone, numberPhoneClient, fieldNumbPhoneClient)) {
                return false;
            }
        }

        //перевірка пошти індивідуальність
        String emailClient = fieldEmailClient.getText() != null ? fieldEmailClient.getText() : "";
        if (!emailClient.isEmpty() && !emailClient.equals(email)) {
            String queryCheckEmail = "SELECT COUNT(*) FROM client WHERE client_email = ?";
            String alertErrorEmail = "Така електронна пошта вже існує! Будь ласка, замініть на іншу!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorEmail, queryCheckEmail, emailClient, fieldEmailClient)) {
                return false;
            }
        }

        if(!fieldNumbPhoneClient.getText().matches("^0\\d{9}$")){
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Номер телефона має складатися з цифр!Рядок повинен містити 10 цифр!");
            return false;
        }

        if (fieldEmailClient.getText() != null && !fieldEmailClient.getText().isEmpty()) {
            if (!fieldEmailClient.getText() .matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Електронна пошта введена неправильно!");
                return false;
            }
        }

        return true;
    }
    //endregion

    //region blockOrder
    private void blockOrder(){

        FilteredList<Order> filteredOrderList;
        List<TableColumn<Order, ?>> tableColumnsOrder = Arrays.asList(columnIDOrder,columnNumbOrderOrder, columnTypeOrder, columnIDClientOrder,columnIDPublicationOrder,
                columnIDPrintingHouseOrder, columnStartDateOrder, columnEndDateOrder, columnStatusFulfilmentOrder, columnPriceOrder, columnStatusPaymentOrder);

        List<String> nameVariablesClassOrder = Arrays.asList("idOrder", "numbOrder", "printProductTypeOrder", "idClientOrder", "idPublicationOrder","idPrintingHouseOrder",
                "startDateOrder","endDateOrder", "statusFulfilmentOrder","priceOrder", "statusPaymentOrder");

        String query = "SELECT * FROM ordering";
        List<String> columnNamesDBOrder = Arrays.asList("order_id", "order_numb", "print_product_type", "client_id", "publication_id", "printing_house_id","order_start_date",
                "order_end_date", "order_status_fulfilment", "order_price", "order_status_payment");

        Function<ResultSet, Order> mapper = rs -> {
            try {
                String clientName = additionalMethods.getNameFromID(rs.getInt("client_id"), "client", "client_id", "client_name");
                String publicationName = additionalMethods.getNameFromID(rs.getInt("publication_id"), "publication", "publication_id", "publication_name");
                String printingHouseName = additionalMethods.getNameFromID(rs.getInt("printing_house_id"), "printing_house", "printing_house_id", "printing_house_name");
                Date startDateOrder = new Date(rs.getTimestamp("order_start_date").getTime());
                Date endDateOrder = new Date(rs.getTimestamp("order_end_date").getTime());

                return new Order(
                        rs.getInt("order_id"),
                        rs.getString("order_numb"),
                        rs.getString("print_product_type"),
                        clientName,
                        publicationName,
                        printingHouseName,
                        startDateOrder,
                        endDateOrder,
                        rs.getString("order_status_fulfilment"),
                        rs.getDouble("order_price"),
                        rs.getString("order_status_payment")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<Order> orderList = crudFindFunc.getList(query, columnNamesDBOrder, mapper);
        filteredOrderList = new FilteredList<>(orderList, p -> true);
        tableOrder.setItems(filteredOrderList);

        //показ даних в таблиці при завантаженні, клік по об'єкту і передача даних в поля
        crudFindFunc.displayDataInTable(tableOrder, tableColumnsOrder, nameVariablesClassOrder, filteredOrderList);
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tableOrder, () -> {
            fillFromFieldsOrder();
            functionClickDisplayAppliedOrderBlock = true;
        });
        crudFindFunc.FindInTable(fieldNumbOrderFindOrder, columnNumbOrderOrder, filteredOrderList);
        crudFindFunc.FindInTable(fieldTypePublicationFindOrder, columnTypeOrder, filteredOrderList);
        crudFindFunc.FindInTable(fieldStatusFulfilmentFindOrder, columnStatusFulfilmentOrder, filteredOrderList);
        crudFindFunc.FindInTable(fieldStatusPaymentFindOrder, columnStatusPaymentOrder, filteredOrderList);

        //запити
        String queryAdd = "INSERT INTO ordering (order_numb,print_product_type, client_id, publication_id,printing_house_id," +
                "order_start_date, order_end_date, order_status_fulfilment,order_price, order_status_payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryUpdate = "UPDATE ordering SET order_numb = ?, print_product_type = ?, client_id = ?, " +
                "publication_id = ?, printing_house_id = ?, order_start_date = ?, " +
                "order_end_date = ?, order_status_fulfilment = ?, order_price = ?, order_status_payment = ? " +
                "WHERE order_id = ?";
        String queryRemove = "DELETE FROM ordering WHERE order_id = ?";


        fieldStartDateOrder.setEditable(false);
        fieldEndDateOrder.setEditable(false);

        btnAddOrderDB.setOnMouseClicked(ev->{
            if (functionClickDisplayAppliedOrderBlock) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
            } else{
                if(checkingFieldsOrder("","")){
                    Map<String, Object> orderFieldsAdd = new LinkedHashMap<>();
                    orderFieldsAdd.put("order_numb", fieldNumbOrderOrder.getText());
                    orderFieldsAdd.put("print_product_type", fieldTypePublicationOrder.getValue());
                    orderFieldsAdd.put("client_id", fieldIDClientOrder.getText());
                    orderFieldsAdd.put("publication_id", fieldIDPublicationOrder.getText());
                    orderFieldsAdd.put("printing_house_id", fieldIDPrintingHouseOrder.getText());
                    orderFieldsAdd.put("order_start_date", fieldStartDateOrder.getValue());
                    orderFieldsAdd.put("order_end_date", fieldEndDateOrder.getValue());
                    orderFieldsAdd.put("order_status_fulfilment", fieldStatusFulfilmentOrder.getValue());
                    orderFieldsAdd.put("order_price", fieldPriceOrder.getText());
                    orderFieldsAdd.put("order_status_payment", fieldStatusPaymentOrder.getValue());

                    boolean successFlag = crudFindFunc.addObject(orderFieldsAdd,queryAdd);
                    if(successFlag){
                        crudFindFunc.updateList(query, columnNamesDBOrder, mapper, orderList);
                        clearFieldsOrder();
                    }
                }
            }
        });

        btnUpdateOrderDB.setOnMouseClicked(ev->{
            Order selectedOrder = tableOrder.getSelectionModel().getSelectedItem();
            if (selectedOrder == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }

            if(checkingFieldsOrder(selectedOrder.getNumbOrder(), selectedOrder.getIdPublicationOrder())){
                Map<String, Object> orderFieldsUpdate = new LinkedHashMap<>();
                orderFieldsUpdate.put("order_numb", fieldNumbOrderOrder.getText());
                orderFieldsUpdate.put("print_product_type", fieldTypePublicationOrder.getValue());
                orderFieldsUpdate.put("client_id", fieldIDClientOrder.getText());
                orderFieldsUpdate.put("publication_id", fieldIDPublicationOrder.getText());
                orderFieldsUpdate.put("printing_house_id", fieldIDPrintingHouseOrder.getText());
                orderFieldsUpdate.put("order_start_date", fieldStartDateOrder.getValue());
                orderFieldsUpdate.put("order_end_date", fieldEndDateOrder.getValue());
                orderFieldsUpdate.put("order_status_fulfilment", fieldStatusFulfilmentOrder.getValue());
                orderFieldsUpdate.put("order_price", fieldPriceOrder.getText());
                orderFieldsUpdate.put("order_status_payment", fieldStatusPaymentOrder.getValue());

                boolean successFlag = crudFindFunc.updateObject(orderFieldsUpdate,queryUpdate, selectedOrder.getIdOrder());
                if(successFlag){
                    crudFindFunc.updateList(query, columnNamesDBOrder, mapper, orderList);
                    clearFieldsOrder();
                }

            }

        });


        btnRemoveOrderDB.setOnMouseClicked(ev->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                clearFieldsOrder();
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tableOrder, Order::getIdOrder);
            crudFindFunc.updateList(query, columnNamesDBOrder, mapper, orderList);
            clearFieldsOrder();
        });

        btnClearFieldsOrder.setOnMouseClicked(ev->{
            clearFieldsOrder();
        });

        btnClearFieldsFindOrder.setOnMouseClicked(ev->{
            fieldNumbOrderFindOrder.clear();
            fieldTypePublicationFindOrder.clear();
            fieldStatusFulfilmentFindOrder.clear();
            fieldStatusPaymentFindOrder.clear();
        });

    }

    private void fillFromFieldsOrder(){
        Order selectedOrder = tableOrder.getSelectionModel().getSelectedItem();
        if(selectedOrder!= null){
            int clientID = additionalMethods.cutAllGetOnlyID(String.valueOf(selectedOrder.getIdClientOrder()));
            int publicationID = additionalMethods.cutAllGetOnlyID(String.valueOf(selectedOrder.getIdPublicationOrder()));
            int printingHouseID = additionalMethods.cutAllGetOnlyID(String.valueOf(selectedOrder.getIdPrintingHouseOrder()));

            fieldNumbOrderOrder.setText(selectedOrder.getNumbOrder());
            fieldTypePublicationOrder.setValue(selectedOrder.getPrintProductTypeOrder());
            fieldIDClientOrder.setText(String.valueOf(clientID));
            fieldIDPublicationOrder.setText(String.valueOf(publicationID));
            fieldIDPrintingHouseOrder.setText(String.valueOf(printingHouseID));
            fieldStartDateOrder.setValue(LocalDate.parse(String.valueOf(selectedOrder.getStartDateOrder()) ) );
            fieldEndDateOrder.setValue(LocalDate.parse(String.valueOf(selectedOrder.getEndDateOrder()) ));
            fieldStatusFulfilmentOrder.setValue(selectedOrder.getStatusFulfilmentOrder());
            fieldPriceOrder.setText(String.valueOf(selectedOrder.getPriceOrder()));
            fieldStatusPaymentOrder.setValue(selectedOrder.getStatusPaymentOrder());


        }
    }

    private void clearFieldsOrder(){
        fieldNumbOrderOrder.clear();
        fieldTypePublicationOrder.setValue("Бланк");
        fieldIDClientOrder.clear();
        fieldIDPublicationOrder.clear();
        fieldIDPrintingHouseOrder.clear();
        fieldStartDateOrder.setValue(null);
        fieldEndDateOrder.setValue(null);
        fieldStatusFulfilmentOrder.setValue("В очікуванні");
        fieldPriceOrder.clear();
        fieldStatusPaymentOrder.setValue("Неоплачено");
        tableOrder.getSelectionModel().clearSelection();
        functionClickDisplayAppliedOrderBlock = false;
    }

    private boolean checkingFieldsOrder(String currentNumbOrder,String idPublicationCurrent){

        // Перевірка пустих полів
        List<Node> fieldsOrder = Arrays.asList(
                fieldNumbOrderOrder, fieldIDClientOrder, fieldIDPublicationOrder,
                fieldIDPrintingHouseOrder, fieldPriceOrder, fieldStartDateOrder, fieldEndDateOrder
        );

        for (Node field : fieldsOrder) {
            if (field instanceof TextField) {
                TextField textField = (TextField) field;
                if (textField.getText() == null || textField.getText().trim().isEmpty()) {
                    crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                    return false;
                }
            } else if (field instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) field;
                if (datePicker.getValue() == null) {
                    crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Виберіть дату та заповніть необхідні поля!");
                    return false;
                }
            }
        }

        // Перевірка індивідуальності номера замовлення
        String numbOrder = fieldNumbOrderOrder.getText();
        if (!numbOrder.equals(currentNumbOrder)) {
            String queryCheckNumb = "SELECT COUNT(*) FROM ordering WHERE order_numb = ?";
            String alertErrorNumb = "Номер такого замовлення вже існує! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorNumb, queryCheckNumb, numbOrder, fieldNumbOrderOrder)) {
                return false;
            }
        }


        // Перевірка індивідуальності айді видання
        String idPublication = fieldIDPublicationOrder.getText().trim();
        int formattedCurrentIDPublication = additionalMethods.cutAllGetOnlyID(idPublicationCurrent);
        if (!idPublication.equals(String.valueOf(formattedCurrentIDPublication))) {
            String queryCheckID= "SELECT COUNT(*) FROM ordering WHERE publication_id = ?";
            String alertErrorID = "Видання з таким ID вже існує! Будь ласка, замініть на інше!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorID, queryCheckID, idPublication, fieldIDPublicationOrder)) {
                return false;
            }
        }

        //Перевірка щоб поле містило число
        List<TextField> fieldsWithNumbers = Arrays.asList(
                fieldIDClientOrder, fieldIDPublicationOrder, fieldIDPrintingHouseOrder, fieldPriceOrder );

        TextField invalidField = additionalMethods.checkIsNumberValue(fieldsWithNumbers);
        if (invalidField != null) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Поле " + invalidField.getId()+ " має містити число!");
            return false;
        }

        // Перевірка чи існує id клієнта, видання, друкарні в системі
        String queryCheckClient = "SELECT * FROM client WHERE client_id = ?";
        String clientIDText = fieldIDClientOrder.getText().trim();
        String alertErrorClient = "Клієнта з ID " + clientIDText + " не існує!";
        if (!additionalMethods.checkDataInDB(alertErrorClient, queryCheckClient, clientIDText)) {
            return false;
        }

        String queryCheckPublication = "SELECT * FROM publication WHERE publication_id = ?";
        String publicationIDText = fieldIDPublicationOrder.getText().trim();
        String alertErrorPublication = "Видання з ID " + publicationIDText + " не існує!";
        if (!additionalMethods.checkDataInDB(alertErrorPublication, queryCheckPublication, publicationIDText)) {
            return false;
        }

        String queryCheckPrintingHouse = "SELECT * FROM printing_house WHERE printing_house_id = ?";
        String printingHouseIDText = fieldIDPrintingHouseOrder.getText().trim();
        String alertErrorPrintingHouse = "Друкарня з ID " + printingHouseIDText + " не існує!";
        if (!additionalMethods.checkDataInDB(alertErrorPrintingHouse, queryCheckPrintingHouse, printingHouseIDText)) {
            return false;
        }

        //Перевірка, щоб дата закінчення замовлення не була меншою за дату прийняття
        LocalDate startDate = fieldStartDateOrder.getValue();
        LocalDate endDate = fieldEndDateOrder.getValue();

        if (startDate != null && endDate != null) {
            if (endDate.isBefore(startDate)) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Дата виконання не може бути меншою за дату прийняття!");
                return false;
            }

        }

        //перевірка вид друкованої продукції повинен збігатись з видом видання
        String queryCheckTypePublication = "SELECT * FROM publication WHERE publication_type_size LIKE ? AND publication_id = ?";
        String publicationTypeIDText = "%"+fieldTypePublicationOrder.getValue().trim()+ "%";
        String publicationID = fieldIDPublicationOrder.getText().trim();
        String alertErrorTypePublication = "Вид друкованої продукції та видання повинні збігатись!";
        if (!additionalMethods.checkTypePublicationOrderInDB(alertErrorTypePublication, queryCheckTypePublication, publicationTypeIDText, fieldTypePublicationOrder, publicationID)) {
            return false;
        }

        if (!fieldNumbOrderOrder.getText().matches("^0000[a-zA-Z]\\d+$")) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Неправильний формат номеру замовлення!");
            return false;
        }

        return true;
    }

    //endregion

    //region blockPublication
    ///Опис функціоналу блоку Видання
    private void blockPublication(){

        FilteredList<Publication> filteredPublicationList;
        List<TableColumn<Publication, ?>> tableColumnsPublication = Arrays.asList(columnIDPublication,columnCodePublication, columnNamePublication, columnTypeSizePublication,
                columnNumberPagesPublication, columnCirculationPublication, columnAmountPrintedSheetsPublication);

        List<String> nameVariablesClassPublication = Arrays.asList("idPublication", "codePublication", "namePublication", "typeSizePublication",
                "numbPagesPublication", "circulationPublication", "amountPrintedSheetsPublication");

        String query = "SELECT * FROM publication";
        List<String> columnNamesDBPublication = Arrays.asList("publication_id", "publication_code", "publication_name", "publication_type_size", "publication_number_pages",
                "publication_circulation", "publication_amount_printed_sheets");

        Function<ResultSet, Publication> mapper = rs -> {
            try {

                return new Publication(
                        rs.getInt("publication_id"),
                        rs.getString("publication_code"),
                        rs.getString("publication_name"),
                        rs.getString("publication_type_size"),
                        rs.getInt("publication_number_pages"),
                        rs.getInt("publication_circulation"),
                        rs.getDouble("publication_amount_printed_sheets")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<Publication> publicationList = crudFindFunc.getList(query, columnNamesDBPublication, mapper);
        filteredPublicationList = new FilteredList<>(publicationList, p -> true);
        tablePublication.setItems(filteredPublicationList);

        //показ даних в таблиці при завантаженні, клік по об'єкту і передача даних в поля
        crudFindFunc.displayDataInTable(tablePublication, tableColumnsPublication, nameVariablesClassPublication, filteredPublicationList);
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tablePublication, () -> {
            fillFormFieldsPublication();
            functionClickDisplayAppliedPublicationBlock = true;
        });
        crudFindFunc.FindInTable(fieldCodePublicationFind, columnCodePublication, filteredPublicationList);
        crudFindFunc.FindInTable(fieldNamePublicationFind, columnNamePublication, filteredPublicationList);

        //запити
        String queryAdd = "INSERT INTO publication (publication_code, publication_name, publication_type_size, publication_number_pages," +
                " publication_circulation, publication_amount_printed_sheets) VALUES (?, ?, ?, ?, ?, ?)";
        String queryUpdate = "UPDATE publication SET publication_code = ?, publication_name = ?, publication_type_size = ?, " +
                "publication_number_pages = ?, publication_circulation = ?, publication_amount_printed_sheets = ? " +
                "WHERE publication_id = ?";
        String queryRemove = "DELETE FROM publication WHERE publication_id = ?";

        fieldAmountPrintedSheetsPublication.setEditable(false);

        //опис кнопки додати об'єкт
        btnAddPublicationDB.setOnMouseClicked(ev->{
            if (functionClickDisplayAppliedPublicationBlock) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
            } else{
                if(checkingFieldsPublication("","")){
                    Map<String, Object> publicationFieldsAdd = new LinkedHashMap<>();
                    publicationFieldsAdd.put("publication_code", fieldCodePublication.getText());
                    publicationFieldsAdd.put("publication_name", fieldNamePublication.getText());
                    publicationFieldsAdd.put("publication_type_size", fieldTypeSizePublication.getValue());
                    publicationFieldsAdd.put("publication_number_pages", fieldNumberPagesPublication.getText());
                    publicationFieldsAdd.put("publication_circulation", fieldCirculationPublication.getText());
                    publicationFieldsAdd.put("publication_amount_printed_sheets", fieldAmountPrintedSheetsPublication.getText());
                    boolean successFlag = crudFindFunc.addObject(publicationFieldsAdd,queryAdd);
                    if(successFlag){
                        crudFindFunc.updateList(query, columnNamesDBPublication, mapper, publicationList);
                        ClearFieldsPublication();
                    }
                }
            }


        });

        btnUpdatePublicationDB.setOnMouseClicked(ev->{

            Publication selectedPublication = tablePublication.getSelectionModel().getSelectedItem();
            if (selectedPublication == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }
            if(checkingFieldsPublication(selectedPublication.getNamePublication(), selectedPublication.getCodePublication())){
                Map<String, Object> publicationFieldsUpdate = new LinkedHashMap<>();
                publicationFieldsUpdate.put("publication_code", fieldCodePublication.getText());
                publicationFieldsUpdate.put("publication_name", fieldNamePublication.getText());
                publicationFieldsUpdate.put("publication_type_size", fieldTypeSizePublication.getValue());
                publicationFieldsUpdate.put("publication_number_pages", fieldNumberPagesPublication.getText());
                publicationFieldsUpdate.put("publication_circulation", fieldCirculationPublication.getText());
                publicationFieldsUpdate.put("publication_amount_printed_sheets", fieldAmountPrintedSheetsPublication.getText());
                boolean successFlag = crudFindFunc.updateObject(publicationFieldsUpdate,queryUpdate, selectedPublication.getIdPublication());
                if(successFlag){
                    crudFindFunc.updateList(query, columnNamesDBPublication, mapper, publicationList);
                    ClearFieldsPublication();
                }

            }

        });

        btnRemovePublicationDB.setOnMouseClicked(ev->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                ClearFieldsPublication();
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tablePublication, Publication::getIdPublication);
            crudFindFunc.updateList(query, columnNamesDBPublication, mapper, publicationList);
            ClearFieldsPublication();
        });

        //розрахунок
        btnCalculatePublication.setOnMouseClicked(ev->{
            if (fieldNumberPagesPublication.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, заповніть поле кількість сторінок!");
                return;
            }
            CalculateAmountPrintedSheets(fieldTypeSizePublication.getValue(), Integer.parseInt(fieldNumberPagesPublication.getText()), fieldAmountPrintedSheetsPublication);
        });

        //опис кнопок очистити поля
        btnClearFieldsFindPublication.setOnMouseClicked(event ->{
            fieldCodePublicationFind.clear();
            fieldNamePublicationFind.clear();

        });

        btnClearFieldsPublication.setOnMouseClicked(event ->{
            ClearFieldsPublication();
        });

        //підсказка щодо розрахунку
        helpHowCalculatePublication.setOnMouseClicked(ev->{
            crudFindFunc.showAlert(Alert.AlertType.INFORMATION, "Підказка", "Введіть кількість сторінок, тип і розмір видання, після цього натисніть 'Розрахувати'. В полі автоматично з'явиться число!");
        });

    }

    private void fillFormFieldsPublication(){ //допоміжна функція шо буде показувати данні
        Publication selectedPublication= tablePublication.getSelectionModel().getSelectedItem();
        if (selectedPublication != null) {
            fieldCodePublication.setText(selectedPublication.getCodePublication());
            fieldNamePublication.setText(selectedPublication.getNamePublication());
            fieldTypeSizePublication.setValue(selectedPublication.getTypeSizePublication());
            fieldNumberPagesPublication.setText(String.valueOf(selectedPublication.getNumbPagesPublication()));
            fieldCirculationPublication.setText(String.valueOf(selectedPublication.getCirculationPublication()));
            fieldAmountPrintedSheetsPublication.setText(String.valueOf(selectedPublication.getAmountPrintedSheetsPublication()));

        }
    }

    private void ClearFieldsPublication(){
        fieldCodePublication.clear();
        fieldNamePublication.clear();
        fieldTypeSizePublication.setValue("Бланк А4");
        fieldNumberPagesPublication.clear();
        fieldCirculationPublication.clear();
        fieldAmountPrintedSheetsPublication.clear();
        tablePublication.getSelectionModel().clearSelection();
        functionClickDisplayAppliedPublicationBlock = false;
    }

    private boolean checkingFieldsPublication(String currentName, String currentCode) {

        //перевірка пустих полів
        List<TextField> fieldsPublication = Arrays.asList(fieldCodePublication,fieldNamePublication,
                fieldCirculationPublication, fieldNumberPagesPublication, fieldAmountPrintedSheetsPublication);
        for (TextField field : fieldsPublication){
            if(field.getText() == null || field.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                return false;
            }
        }

        // Перевірка індивідуальності імені
        String namePublication = fieldNamePublication.getText();
        if (!namePublication.equals(currentName)) {
            String queryCheckName = "SELECT COUNT(*) FROM publication WHERE publication_name = ?";
            String alertErrorName = "Видання з такою назвою вже існує! Будь ласка, замініть на інше!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorName, queryCheckName, namePublication, fieldNamePublication)) {
                return false;
            }
        }

        // Перевірка індивідуальності коду
        String codePublication = fieldCodePublication.getText();
        if (!codePublication.equals(currentCode)) {
            String queryCheckCode = "SELECT COUNT(*) FROM publication WHERE publication_code = ?";
            String alertErrorCode = "Такий код вже існує в системі! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorCode, queryCheckCode, codePublication, fieldCodePublication)) {
                return false;
            }
        }


        if (!fieldCirculationPublication.getText() .matches("^-?\\d+$")) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Поле тираж має містити ціле число!");
            return false;
        }

        if (!fieldNumberPagesPublication.getText() .matches("^-?\\d+$")) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Поле кількість сторінок має містити ціле число!");
            return false;
        }

        if (!fieldCodePublication.getText() .matches("^\\d{2}[a-zA-Z]\\d{2}[a-zA-Z]\\d{2}[a-zA-Z]\\d{2}$")) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Неправильний формат коду видання!");
            return false;
        }

        return true;
    }

    private void CalculateAmountPrintedSheets(String typePublication, int numberPages, TextField fieldAmountPrintedSheets){
        double coefficient = 0;
        if(typePublication == "Бланк А4"|| typePublication== "Брошура А4" || typePublication== "Буклет А4"
        || typePublication == "Журнал А4" || typePublication == "Каталог А4" || typePublication == "Книга А4"
        || typePublication == "Сертифікат A4" ){
            coefficient = 0.0833;
        }else if(typePublication == "Бланк А5"|| typePublication == "Брошура А5"|| typePublication == "Буклет А5"
        || typePublication == "Каталог А5" || typePublication == "Книга А5" || typePublication == "Листівка А5"
        || typePublication == "Сертифікат A5" || typePublication == "Журнал A5") {
            coefficient = 0.03125;
        }else if(typePublication == "Газета А2"|| typePublication == "Плакат А2"|| typePublication == "Постер А2"){
            coefficient = 0.25 ;
        } else if(typePublication == "Буклет А3" ||  typePublication == "Газета А3" ){
            coefficient = 0.125 ;
        } else if(typePublication == "Плакат А1" || typePublication == "Постер А1" ) {
            coefficient = 0.5;
        } else if(typePublication == "Візитка 90x50 мм"){
            coefficient = 0.004 ;
        } else if(typePublication == "Візитка 85x55 мм"){
            coefficient = 0.0038 ;
        } else if (typePublication == "Листівка А6"){
            coefficient = 0.0156 ;
        } else if(typePublication == "Листівка 10x15 см"){
            coefficient = 0.0136 ;
        }
        double  finalResult = numberPages * coefficient;
        String formattedResult = String.format(Locale.US, "%.4f", finalResult);
        fieldAmountPrintedSheets.setText(formattedResult);

    }

    //endregion

    //region blockAuthor
    ///Опис функціоналу блоку Автора
    private void blockAuthor(){


        //різні масиви для передачі у функції
        FilteredList<Author> filteredAuthorList;
        List<TableColumn<Author, ?>> tableColumnsAuthor = Arrays.asList(columnIDAuthor, columnNameAuthor,
                columnAddressAuthor, columnNumbPhoneAuthor, columnEmailAuthor, columnAdditionalInfoAuthor);
        List<String> nameVariablesClassAuthor = Arrays.asList("idAuthor", "nameAuthor", "addressAuthor",
                "numbPhoneAuthor", "emailAuthor", "additionalInfoAuthor");

        String query = "SELECT * FROM author";
        List<String> columnNamesDBAuthor = Arrays.asList("author_id", "author_name", "author_address", "author_number_phone",
                "author_email", "author_additional_info");

        Function<ResultSet, Author> mapper = rs -> {
            try {
                return new Author(
                        rs.getInt("author_id"),
                        rs.getString("author_name"),
                        rs.getString("author_address"),
                        rs.getString("author_number_phone"),
                        rs.getString("author_email"),
                        rs.getString("author_additional_info")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<Author> authorList = crudFindFunc.getList(query, columnNamesDBAuthor, mapper);
        filteredAuthorList = new FilteredList<>(authorList, p -> true);
        tableAuthor.setItems(filteredAuthorList);

        //показ даних в таблиці при завантаженні, клік по об'єкту і передача данних в поля
        //метод пошуку в таблиці
        crudFindFunc.displayDataInTable(tableAuthor, tableColumnsAuthor, nameVariablesClassAuthor, filteredAuthorList);
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tableAuthor, () -> {
            fillFormFieldsAuthor();
            functionClickDisplayAppliedAuthorBlock = true;
        });
        crudFindFunc.FindInTable(fieldNameAuthorFind, columnNameAuthor, filteredAuthorList);

        //запити
        String queryAdd = "INSERT INTO author (author_name, author_address, author_number_phone, author_email, author_additional_info) VALUES (?, ?, ?, ?, ?)";
        String queryUpdate = "UPDATE author SET author_name = ?, author_address = ?, author_number_phone = ?, author_email = ?, author_additional_info = ? WHERE author_id = ?";
        String queryRemove = "DELETE FROM author WHERE author_id = ?";

        btnAddAuthorDB.setOnMouseClicked( ev-> {
            if (functionClickDisplayAppliedAuthorBlock) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
            } else {
                if(CheckFieldsAuthor("", "")){
                    Map<String, Object> authorFieldsAdd = new LinkedHashMap<>();
                    authorFieldsAdd.put("author_name", fieldNameAuthor.getText());
                    authorFieldsAdd.put("author_address", fieldAddressAuthor.getText());
                    authorFieldsAdd.put("author_number_phone", fieldNumbPhoneAuthor.getText());
                    authorFieldsAdd.put("author_email", fieldEmailAuthor.getText());
                    authorFieldsAdd.put("author_additional_info", fieldAdditionalInfoAuthor.getText());

                    boolean successFlag = crudFindFunc.addObject(authorFieldsAdd, queryAdd);

                    if (successFlag) {
                        crudFindFunc.updateList(query, columnNamesDBAuthor, mapper, authorList);
                        ClearFieldsAuthor();
                    }
                }

            }

        });
        //опис кнопки оновити об'єкт
        btnUpdateAuthorDB.setOnMouseClicked(ev->{

            Author selectedAuthor = tableAuthor.getSelectionModel().getSelectedItem();
            if (selectedAuthor == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }

            if(CheckFieldsAuthor(selectedAuthor.getNumbPhoneAuthor(), selectedAuthor.getEmailAuthor())) {
                Map<String, Object> authorFieldsUpdate = new LinkedHashMap<>();
                authorFieldsUpdate.put("author_name", fieldNameAuthor.getText());
                authorFieldsUpdate.put("author_address", fieldAddressAuthor.getText());
                authorFieldsUpdate.put("author_number_phone", fieldNumbPhoneAuthor.getText());
                authorFieldsUpdate.put("author_email", fieldEmailAuthor.getText());
                authorFieldsUpdate.put("author_additional_info", fieldAdditionalInfoAuthor.getText());


                boolean successFlag = crudFindFunc.updateObject(authorFieldsUpdate, queryUpdate, selectedAuthor.getIdAuthor());
                if (successFlag) {
                    crudFindFunc.updateList(query, columnNamesDBAuthor, mapper, authorList);
                    ClearFieldsAuthor();
                }

            }
        });

        //опис кнопки видалити об'єкт
        btnRemoveAuthorDB.setOnMouseClicked(ev->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                ClearFieldsAuthor();
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tableAuthor, Author::getIdAuthor);
            crudFindFunc.updateList(query, columnNamesDBAuthor, mapper, authorList);
            ClearFieldsAuthor();
        });

        btnGetDataClientAuthor.setOnMouseClicked(ev->{
            getDataClientForAuthor(fieldIDClientGetDataAuthor, fieldNameAuthor, fieldAddressAuthor, fieldNumbPhoneAuthor, fieldEmailAuthor);
        });

        //опис кнопок очистити поля
        btnClearFieldsAuthor.setOnMouseClicked(ev->{
            ClearFieldsAuthor();
        });

        btnClearFieldsFindAuthor.setOnMouseClicked(ev->{
            fieldNameAuthorFind.clear();
        });

    }

    private void fillFormFieldsAuthor(){
        Author selectedAuthor = tableAuthor.getSelectionModel().getSelectedItem();
        if(selectedAuthor != null){
            fieldNameAuthor.setText(selectedAuthor.getNameAuthor());
            fieldAddressAuthor.setText(selectedAuthor.getAddressAuthor());
            fieldNumbPhoneAuthor.setText(selectedAuthor.getNumbPhoneAuthor());
            fieldEmailAuthor.setText(selectedAuthor.getEmailAuthor());
            fieldAdditionalInfoAuthor.setText(selectedAuthor.getAdditionalInfoAuthor());
        }

    }

    private void ClearFieldsAuthor(){
        fieldNameAuthor.clear();
        fieldAddressAuthor.clear();
        fieldNumbPhoneAuthor.clear();
        fieldEmailAuthor.clear();
        fieldAdditionalInfoAuthor.clear();
        fieldIDClientGetDataAuthor.clear();
        tableAuthor.getSelectionModel().clearSelection();
        functionClickDisplayAppliedAuthorBlock = false;
    }

    private boolean CheckFieldsAuthor(String currentNumberPhone, String currentEmail){

        //перевірка пустих полів
        List<TextField> fieldsAuthor = Arrays.asList(fieldNameAuthor, fieldAddressAuthor, fieldNumbPhoneAuthor);
        for (TextField field : fieldsAuthor){
            if(field.getText() == null || field.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                return false;
            }
        }


        // Перевірка індивідуальності номера телефона
        String numbPhoneAuthor = fieldNumbPhoneAuthor.getText();
        if (!numbPhoneAuthor.equals(currentNumberPhone)) {
            String queryCheckName = "SELECT COUNT(*) FROM author WHERE author_number_phone = ?";
            String alertErrorName = "Такий номер телефона вже існує! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorName, queryCheckName, numbPhoneAuthor, fieldNumbPhoneAuthor)) {
                return false;
            }
        }

        //перевірка пошти індивідуальність
        String emailAuthor = fieldEmailAuthor.getText() != null ? fieldEmailAuthor.getText() : "";
        if (!emailAuthor.isEmpty() && !emailAuthor.equals(currentEmail)) {
            String queryCheckEmail = "SELECT COUNT(*) FROM author WHERE author_email = ?";
            String alertErrorEmail = "Така електронна пошта вже існує! Будь ласка, замініть на іншу!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorEmail, queryCheckEmail, emailAuthor, fieldEmailAuthor)) {
                return false;
            }
        }

        if(!fieldNumbPhoneAuthor.getText().matches("^0\\d{9}$")){
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Номер телефона має складатися з цифр!Рядок повинен містити 10 цифр!");
            return false;
        }

        if (fieldEmailAuthor.getText() != null && !fieldEmailAuthor.getText().isEmpty()) {
            if (!fieldEmailAuthor.getText() .matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Електронна пошта введена неправильно!");
                return false;
            }
        }

        return true;
    }

    //функція буде отримувати данні автора за ID
    private void getDataClientForAuthor(TextField fieldID, TextField name, TextField address,
                                        TextField numbPhone, TextField email) {
        Connection connectionDB = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String query = "SELECT client_name, client_address, client_number_phone, client_email, client_type FROM client WHERE client_id = ?";
            preparedStatement = connectionDB.prepareStatement(query);
            preparedStatement.setString(1, fieldID.getText());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String clientType = resultSet.getString("client_type");

                if ("Організація".equalsIgnoreCase(clientType)) {
                    crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Клієнт з таким ID є представником організації!");
                } else {
                    name.setText(resultSet.getString("client_name"));
                    address.setText(resultSet.getString("client_address"));
                    numbPhone.setText(resultSet.getString("client_number_phone"));
                    email.setText(resultSet.getString("client_email"));
                }
            } else {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Клієнта не було знайдено за таким ID!");
            }
        } catch (SQLException e) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Виникла помилка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connectionDB != null) connectionDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region blockPublicationAuthorIntermediate
   public void blockPublicationAuthorIntermediate(){
       FilteredList<PublicationAuthor> filteredPublicationAuthorList;
       List<TableColumn<PublicationAuthor,?>> tableColumnsPublicationAuthor = Arrays.asList(columnIDPublicationAuthor,
               columnIDPublicationConnection, columnIDAuthorConnection);

       List<String> nameVariablesClassPublicationAuthor = Arrays.asList("idPublicationAuthor", "IDPublicationPA",
               "IDAuthorPA");
       String query = "SELECT * FROM publication_author";
       List<String> columnNamesDBPublicationAuthor = Arrays.asList("publication_author_id", "publication_id",
               "author_id");

       Function<ResultSet, PublicationAuthor> mapper = rs -> {
           try {
               String publicationName = additionalMethods.getNameFromID(rs.getInt("publication_id"), "publication", "publication_id", "publication_name");
               String authorName = additionalMethods.getNameFromID(rs.getInt("author_id"), "author", "author_id", "author_name");
               return new PublicationAuthor(
                       rs.getInt("publication_author_id"),
                       publicationName,
                       authorName
               );
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       };

       ObservableList<PublicationAuthor> publicationAuthorList = crudFindFunc.getList(query, columnNamesDBPublicationAuthor, mapper);
       filteredPublicationAuthorList = new FilteredList<>(publicationAuthorList, p ->true);
       tablePublicationAuthor.setItems(filteredPublicationAuthorList);

       crudFindFunc.displayDataInTable(tablePublicationAuthor,tableColumnsPublicationAuthor,nameVariablesClassPublicationAuthor,filteredPublicationAuthorList );
       crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tablePublicationAuthor, () -> {
           fillFormFieldsPublicationAuthor();
           functionClickDisplayAppliedPublicationAuthorBlock = true;
       });
       crudFindFunc.FindInTable( fieldIDPublicationPublicationAuthorFind,columnIDPublicationConnection, filteredPublicationAuthorList);
       crudFindFunc.FindInTable( fieldIDAuthorPublicationAuthorFind,columnIDAuthorConnection, filteredPublicationAuthorList);

       //запити
       String queryAdd = "INSERT INTO publication_author (publication_id, author_id) VALUES (?, ?)";
       String queryUpdate = "UPDATE publication_author SET publication_id = ?, author_id = ? WHERE publication_author_id = ?";
       String queryRemove = "DELETE FROM publication_author WHERE publication_author_id = ?";

       //опис кнопки додати об'єкт
       btnAddPublicationAuthorDB.setOnMouseClicked(ev->{

           if (functionClickDisplayAppliedPublicationAuthorBlock) {
               crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
           } else {
               if(checkingFieldsPublicationAuthor()){
                   Map<String, Object> publicationAuthorFieldsAdd = new LinkedHashMap<>();
                   publicationAuthorFieldsAdd.put("publication_id", fieldIDPublicationConnection.getText());
                   publicationAuthorFieldsAdd.put("author_id", fieldIDAuthorConnection.getText());

                   boolean successFlag = crudFindFunc.addObject(publicationAuthorFieldsAdd, queryAdd);

                   if(successFlag){
                       crudFindFunc.updateList(query, columnNamesDBPublicationAuthor, mapper, publicationAuthorList);
                       ClearFieldsPublicationAuthor();
                   }
               }
           }

       });

       //опис кнопки оновити об'єкт
       btnUpdatePublicationAuthorDB.setOnMouseClicked(ev ->{

           PublicationAuthor selectedPublicationAuthor = tablePublicationAuthor.getSelectionModel().getSelectedItem();

           if (selectedPublicationAuthor == null) {
               crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
               return;
           }
           if(checkingFieldsPublicationAuthor()){
               Map<String, Object> publicationAuthorFieldsUpdate = new LinkedHashMap<>();
               publicationAuthorFieldsUpdate.put("publication_id", fieldIDPublicationConnection.getText());
               publicationAuthorFieldsUpdate.put("author_id", fieldIDAuthorConnection.getText());

               boolean successFlag =  crudFindFunc.updateObject(publicationAuthorFieldsUpdate, queryUpdate,selectedPublicationAuthor.getIdPublicationAuthor() );
               if(successFlag){
                   crudFindFunc.updateList(query, columnNamesDBPublicationAuthor, mapper, publicationAuthorList);
                   ClearFieldsPublicationAuthor();
               }
           }

       });

       //опис кнопки видалити об'єкт
       btnRemovePublicationAuthorDB.setOnMouseClicked(ev->{
           if (!crudFindFunc.showDeleteConfirmation()) {
               ClearFieldsPublicationAuthor();
               return;
           }
           crudFindFunc.deleteObject(queryRemove, tablePublicationAuthor,PublicationAuthor::getIdPublicationAuthor);
           crudFindFunc.updateList(query, columnNamesDBPublicationAuthor, mapper, publicationAuthorList);
           ClearFieldsPublicationAuthor();
       });

       //опис кнопок очистити поля
       btnClearFieldsFindPublicationAuthor.setOnMouseClicked(ev->{
           fieldIDPublicationPublicationAuthorFind.clear();
           fieldIDAuthorPublicationAuthorFind.clear();
       });

       btnClearFieldsPublicationAuthorDB.setOnMouseClicked(ev->{
           ClearFieldsPublicationAuthor();
       });
   }

   public void ClearFieldsPublicationAuthor(){
        fieldIDAuthorConnection.clear();
        fieldIDPublicationConnection.clear();
        tablePublicationAuthor.getSelectionModel().clearSelection();
        functionClickDisplayAppliedPublicationAuthorBlock = false;
   }

   public void fillFormFieldsPublicationAuthor(){
       PublicationAuthor selectedPublicationAuthor= tablePublicationAuthor.getSelectionModel().getSelectedItem();
       if (selectedPublicationAuthor != null) {
           int publicationID = additionalMethods.cutAllGetOnlyID(String.valueOf(selectedPublicationAuthor.getIDPublicationPA()));
           int authorID = additionalMethods.cutAllGetOnlyID(String.valueOf(selectedPublicationAuthor.getIDAuthorPA()));
           fieldIDPublicationConnection.setText(String.valueOf(publicationID));
           fieldIDAuthorConnection.setText(String.valueOf(authorID));

       }
   }

   public boolean checkingFieldsPublicationAuthor(){
       //перевірка пустих полів
       List<TextField> fieldsPublicationAuthor = Arrays.asList(fieldIDAuthorConnection, fieldIDAuthorConnection);
       for (TextField field : fieldsPublicationAuthor){
           if(field.getText() == null || field.getText().trim().isEmpty()){
               crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
               return false;
           }
       }

       //Перевірка щоб поле містило число
       List<TextField> fieldsWithNumbers = Arrays.asList(fieldIDAuthorConnection,fieldIDAuthorConnection);

       TextField invalidField = additionalMethods.checkIsNumberValue(fieldsWithNumbers);
       if (invalidField != null) {
           crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Поле " + invalidField.getId()+ " має містити число!");
           return false;
       }

       // Перевірка чи існує id видання, автора в системі
       String queryCheckAuthor = "SELECT * FROM author WHERE author_id = ?";
       String authorIDText = fieldIDAuthorConnection.getText().trim();
       String alertErrorAuthor = "Автора з ID " + authorIDText + " не існує!";
       if (!additionalMethods.checkDataInDB(alertErrorAuthor, queryCheckAuthor, authorIDText)) {
           return false;
       }

       String queryCheckPublication = "SELECT * FROM publication WHERE publication_id = ?";
       String publicationIDText = fieldIDPublicationConnection.getText().trim();
       String alertErrorPublication = "Видання з ID " + publicationIDText + " не існує!";
       if (!additionalMethods.checkDataInDB(alertErrorPublication, queryCheckPublication, publicationIDText)) {
           return false;
       }

       //перевірка на неповторюваність айді видання та автора разом в одному записі
       String queryCheckPA = "SELECT * FROM publication_author WHERE publication_id = ? AND author_id = ?";
       String publicationId = fieldIDPublicationConnection.getText().trim();
       String authorId = fieldIDAuthorConnection.getText().trim();
       String alertErrorPA = "Такий запис вже існує в базі даних!";

       if (!additionalMethods.checkExistenceAuthorPublication(alertErrorPA, queryCheckPA, publicationId, authorId)) {
           return false;
       }

       return true;
   }

   //endregion

    //region blockPrintingHouse
    ///Опис функціонала блоку Друкарня
    private void blockPrintingHouse(){
        //різні масиви для передачі у функції
        FilteredList<PrintingHouse> filteredPrintingHouseList;
        List<TableColumn<PrintingHouse,?>> tableColumnsPrintHouse = Arrays.asList(columnIDPrintingHouse, columnNamePrintingHouse,
                columnAddressPrintingHouse, columnNumbPhonePrintingHouse, columnEmailPrintingHouse);

        List<String> nameVariablesClassPrintHouse = Arrays.asList("idPrintingHouse", "namePrintingHouse",
                "addressPrintingHouse", "numbPhonePrintingHouse", "emailPrintingHouse");

        String query = "SELECT * FROM printing_house";
        List<String> columnNamesDBPrintHouse = Arrays.asList("printing_house_id", "printing_house_name",
                "printing_house_address", "printing_house_number_phone", "printing_house_email");


        Function<ResultSet, PrintingHouse> mapper = rs -> {
            try {
                return new PrintingHouse(
                        rs.getInt("printing_house_id"),
                        rs.getString("printing_house_name"),
                        rs.getString("printing_house_address"),
                        rs.getString("printing_house_number_phone"),
                        rs.getString("printing_house_email")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<PrintingHouse> printHouseList = crudFindFunc.getList(query, columnNamesDBPrintHouse, mapper);
        filteredPrintingHouseList = new FilteredList<>(printHouseList, p ->true);
        tablePrintingHouse.setItems(filteredPrintingHouseList);

        //показ даних в таблиці при завантаженні, клік по об'єкту і передача даних в поля
        //один метод пошуку в таблиці
        crudFindFunc.displayDataInTable(tablePrintingHouse,tableColumnsPrintHouse,nameVariablesClassPrintHouse,filteredPrintingHouseList );
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tablePrintingHouse, () -> {
            fillFormFieldsPrintingHouse();
            functionClickDisplayAppliedPrintingHouseBlock = true;
        });
        crudFindFunc.FindInTable( fieldNamePrintingHouseFind,columnNamePrintingHouse, filteredPrintingHouseList);

        //запити
        String queryAdd = "INSERT INTO printing_house (printing_house_name, printing_house_address, printing_house_number_phone, printing_house_email) VALUES (?, ?, ?, ?)";
        String queryUpdate = "UPDATE printing_house SET printing_house_name = ?, printing_house_address = ?, printing_house_number_phone = ?, printing_house_email = ? WHERE printing_house_id = ?";
        String queryRemove = "DELETE FROM printing_house WHERE printing_house_id = ?";


        //опис кнопки додати об'єкт
        btnAddPrintingHouseDB.setOnMouseClicked(ev->{


            if (functionClickDisplayAppliedPrintingHouseBlock) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Не можна додати об'єкт, який вже існує! Очистіть поля і додайте новий об'єкт!");
            } else {
                if(checkingFieldsPrintingHouse("","", "")){
                    Map<String, Object> printHouseFieldsAdd = new LinkedHashMap<>();
                    printHouseFieldsAdd.put("printing_house_name", fieldNamePrintingHouse.getText());
                    printHouseFieldsAdd.put("printing_house_address", fieldAddressPrintingHouse.getText());
                    printHouseFieldsAdd.put("printing_house_number_phone", fieldNumberPhonePrintingHouse.getText());
                    printHouseFieldsAdd.put("printing_house_email", fieldEmailPrintingHouse.getText());

                    boolean successFlag = crudFindFunc.addObject(printHouseFieldsAdd, queryAdd);

                    if(successFlag){
                        crudFindFunc.updateList(query, columnNamesDBPrintHouse, mapper, printHouseList);
                        ClearFieldsPrintingHouse();
                    }
                }
            }

        });

        //опис кнопки оновити об'єкт
        btnUpdatePrintingHouseDB.setOnMouseClicked(ev ->{

            PrintingHouse selectedPrintingHouse = tablePrintingHouse.getSelectionModel().getSelectedItem();

            if (selectedPrintingHouse == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }
            if(checkingFieldsPrintingHouse(selectedPrintingHouse.getNamePrintingHouse(), selectedPrintingHouse.getNumbPhonePrintingHouse(), selectedPrintingHouse.getEmailPrintingHouse())){
                Map<String, Object> printHouseFieldsUpdate = new LinkedHashMap<>();
                printHouseFieldsUpdate.put("printing_house_name", fieldNamePrintingHouse.getText());
                printHouseFieldsUpdate.put("printing_house_address", fieldAddressPrintingHouse.getText());
                printHouseFieldsUpdate.put("printing_house_number_phone", fieldNumberPhonePrintingHouse.getText());
                printHouseFieldsUpdate.put("printing_house_email", fieldEmailPrintingHouse.getText());


                boolean successFlag =  crudFindFunc.updateObject(printHouseFieldsUpdate, queryUpdate,selectedPrintingHouse.getIdPrintingHouse() );
                if(successFlag){
                    crudFindFunc.updateList(query, columnNamesDBPrintHouse, mapper, printHouseList);
                    ClearFieldsPrintingHouse();
                }
            }

        });

        //опис кнопки видалити об'єкт
        btnRemovePrintingHouseDB.setOnMouseClicked(ev->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                ClearFieldsPrintingHouse();
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tablePrintingHouse,PrintingHouse::getIdPrintingHouse);
            crudFindFunc.updateList(query, columnNamesDBPrintHouse, mapper, printHouseList);
            ClearFieldsPrintingHouse();

        });

        //опис кнопок очистити поля
        btnClearFieldsFindPrintingHouse.setOnMouseClicked(ev->{
            fieldNamePrintingHouseFind.clear();
        });

        btnClearFieldsPrintingHouseDB.setOnMouseClicked(ev->{
            ClearFieldsPrintingHouse();
        });

    }

    private void ClearFieldsPrintingHouse(){
        fieldNamePrintingHouse.clear();
        fieldAddressPrintingHouse.clear();
        fieldNumberPhonePrintingHouse.clear();
        fieldEmailPrintingHouse.clear();
        tablePrintingHouse.getSelectionModel().clearSelection();
        functionClickDisplayAppliedPrintingHouseBlock = false;
    }

    private void fillFormFieldsPrintingHouse(){
        PrintingHouse selectedPrintingHouse = tablePrintingHouse.getSelectionModel().getSelectedItem();
        if (selectedPrintingHouse != null) {
            fieldNamePrintingHouse.setText(selectedPrintingHouse.getNamePrintingHouse());
            fieldAddressPrintingHouse.setText(selectedPrintingHouse.getAddressPrintingHouse());
            fieldNumberPhonePrintingHouse.setText(selectedPrintingHouse.getNumbPhonePrintingHouse());
            fieldEmailPrintingHouse.setText(selectedPrintingHouse.getEmailPrintingHouse());
        }
    }

    private boolean checkingFieldsPrintingHouse(String currentName, String currentNumbPhone, String currentEmail){

        //перевірка пустих полів
        List<TextField> fieldsPrintingHouse = Arrays.asList(fieldNamePrintingHouse, fieldNumberPhonePrintingHouse, fieldAddressPrintingHouse);
        for (TextField field : fieldsPrintingHouse){
            if(field.getText() == null || field.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                return false;
            }
        }

        // Перевірка індивідуальності імені
        String namePrintingHouse = fieldNamePrintingHouse.getText();
        if (!namePrintingHouse.equals(currentName)) {
            String queryCheckName = "SELECT COUNT(*) FROM printing_house WHERE printing_house_name = ?";
            String alertErrorName = "Друкарня з такою назвою вже існує! Будь ласка, замініть на іншу!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorName, queryCheckName, namePrintingHouse, fieldNamePrintingHouse)) {
                return false;
            }
        }

        //перевірка номера телефону індивідуальність
        String numberPhonePrintingHouse = fieldNumberPhonePrintingHouse.getText();
        if (!numberPhonePrintingHouse.equals(currentNumbPhone)) {
            String queryCheckPhone = "SELECT COUNT(*) FROM printing_house WHERE printing_house_number_phone = ?";
            String alertErrorPhone = "Такий номер телефона вже існує! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorPhone, queryCheckPhone, numberPhonePrintingHouse, fieldNumberPhonePrintingHouse)) {
                return false;
            }
        }

        //перевірка пошти індивідуальність
        String emailPrintingHouse = fieldEmailPrintingHouse.getText() != null ? fieldEmailPrintingHouse.getText() : "";
        if (!emailPrintingHouse.isEmpty() && !emailPrintingHouse.equals(currentEmail)) {
            String queryCheckEmail = "SELECT COUNT(*) FROM printing_house WHERE printing_house_email = ?";
            String alertErrorEmail = "Така електронна пошта вже існує! Будь ласка, замініть на іншу!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorEmail, queryCheckEmail, emailPrintingHouse, fieldEmailPrintingHouse)) {
                return false;
            }
        }

        if(!fieldNumberPhonePrintingHouse.getText().matches("^0\\d{9}$")){
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Номер телефона має складатися з цифр!Рядок повинен містити 10 цифр!");
            return false;
        }

        if (fieldEmailPrintingHouse.getText() != null && !fieldEmailPrintingHouse.getText().isEmpty()) {
            if (!fieldEmailPrintingHouse.getText() .matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Електронна пошта введена неправильно!");
                return false;
            }
        }


        return true;
    }

    //endregion

    //region blockAddUser
    ///Опис функціоналу блоку Додати користувача
    private void blockAddUser() {

        btnAddUserToKeys.setOnMouseClicked(mouseEvent -> {
            String userLogin = fieldLoginAddUser.getText();
            String userRole = fieldRoleAddUser.getValue().toString();
            String password = fieldPasswordAddUser.getText();
            String alertAddUserError = "Користувач з таким логіном вже існує!";
            String queryCheckUser = "SELECT COUNT(*) FROM keys_data WHERE user_login = ?";

            if (!additionalMethods.CheckForIndividualFields(alertAddUserError, queryCheckUser, userLogin, fieldLoginAddUser)) {
                return;
            }

            // Перевірка ролі та стану чекбокса "Додати користувача"
            if ((userRole.equals("Оператор") || userRole.equals("Гість")) && checkMarkAddUser.isSelected()) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Користувачі з роллю 'Оператор' або 'Гість' не можуть мати права додавати користувачів!");
                checkMarkAddUser.setSelected(false);
                return;
            }

            if (userLogin.trim().isEmpty() || password.trim().isEmpty()) {
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, заповніть всі поля!");
                return;
            }

            Map<String, Object> fieldsAddUser = new LinkedHashMap<>();
            fieldsAddUser.put("user_login", userLogin);
            fieldsAddUser.put("user_password", password);
            fieldsAddUser.put("user_role", userRole);
            fieldsAddUser.put("permission_table_client", checkMarkTableClient.isSelected() ? "T" : "F");
            fieldsAddUser.put("permission_table_publication", checkMarkTablePublication.isSelected() ? "T" : "F");
            fieldsAddUser.put("permission_table_author", checkMarkTableAuthor.isSelected() ? "T" : "F");
            fieldsAddUser.put("permission_table_printing_house", checkMarkTablePrintingHouse.isSelected() ? "T" : "F");
            fieldsAddUser.put("permission_queries", checkMarkQueries.isSelected() ? "T" : "F");
            fieldsAddUser.put("permission_add_user", checkMarkAddUser.isSelected() ? "T" : "F");

            String queryAddUser = "INSERT INTO keys_data (user_login, user_password, user_role, permission_table_client, " +
                    "permission_table_publication, permission_table_author, permission_table_printing_house, permission_queries, " +
                    "permission_add_user) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

           boolean successFlag = crudFindFunc.addObject(fieldsAddUser, queryAddUser);
           if(successFlag){
               ClearFieldsAddUser();
           }
        });

        btnClearFieldsAddUser.setOnMouseClicked(ev ->{
            ClearFieldsAddUser();
        });
    }

    private void ClearFieldsAddUser(){
        fieldLoginAddUser.clear();
        fieldPasswordAddUser.clear();
        fieldRoleAddUser.setValue("Гість");
        checkMarkTableClient.setSelected(false);
        checkMarkTablePublication.setSelected(false);
        checkMarkTableAuthor.setSelected(false);
        checkMarkTablePrintingHouse.setSelected(false);
        checkMarkQueries.setSelected(false);
        checkMarkAddUser.setSelected(false);
    }
    //endregion

    //region blockKeys
    private void blockKeys(){
        FilteredList<Keys> filteredKeysList;
        List<TableColumn<Keys, ?>> tableColumnsKeys = Arrays.asList(columnIDKeys,columnLoginKeys, columnPasswordKeys, columnRoleKeys,
                columnPermissionTableClientKeys, columnPermissionTablePublicationKeys, columnPermissionTableAuthorKeys,
                columnPermissionTablePrintingHouseKeys, columnPermissionQueriesKeys, columnPermissionAddUserKeys);
        List<String> nameVariablesClassKeys = Arrays.asList(
                "idUser", "loginUser", "passwordUser", "roleUser", "permissionTableClient", "permissionTablePublication",
                "permissionTableAuthor", "permissionTablePrintingHouse", "permissionQueries", "permissionAddUser");

        String query = "SELECT * FROM keys_data WHERE user_id != 1";
        List<String> columnNamesDBKeys = Arrays.asList("user_id", "user_login", "user_password", "user_role", "permission_table_client","permission_table_publication",
                "permission_table_author", "permission_table_printing_house", "permission_queries", "permission_add_user");


        Function<ResultSet, Keys> mapper = rs -> {
            try {
                return new Keys(
                        rs.getInt("user_id"),
                        rs.getString("user_login"),
                        rs.getString("user_password"),
                        rs.getString("user_role"),
                        rs.getBoolean("permission_table_client"),
                        rs.getBoolean("permission_table_publication"),
                        rs.getBoolean("permission_table_author"),
                        rs.getBoolean("permission_table_printing_house"),
                        rs.getBoolean("permission_queries"),
                        rs.getBoolean("permission_add_user")
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        };

        ObservableList<Keys> keysList = crudFindFunc.getList(query, columnNamesDBKeys, mapper);
        filteredKeysList = new FilteredList<>(keysList, p -> true);
        tableKeys.setItems(filteredKeysList);


        crudFindFunc.displayDataInTable(tableKeys, tableColumnsKeys, nameVariablesClassKeys, filteredKeysList);
        crudFindFunc.ClickAndDisplayDataInFieldsFromTable(tableKeys, () -> {
            fillFromFieldsKeys();
        });
        crudFindFunc.FindInTable(fieldLoginKeysFind, columnLoginKeys, filteredKeysList);

        //запити
        String queryUpdate = "UPDATE keys_data SET user_login = ?, user_password = ?, user_role = ?, permission_table_client = ?," +
                "permission_table_publication = ?, permission_table_author = ?, permission_table_printing_house = ?," +
                " permission_queries = ?, permission_add_user = ?  WHERE user_id = ?";
        String queryRemove = "DELETE FROM keys_data WHERE user_id = ?";

        btnUpdateKeysDB.setOnMouseClicked(ev->{
            Keys selectedKey = tableKeys.getSelectionModel().getSelectedItem();
            if (selectedKey == null) {
                crudFindFunc.showAlert(Alert.AlertType.WARNING, "Попередження", "Не обрано жодного об'єкта для редагування!");
                return;
            }

            if(checkFieldsKeys(selectedKey.getLoginUser())) {
                Map<String, Object> keysFieldsUpdate = new LinkedHashMap<>();
                keysFieldsUpdate.put("user_login", fieldLoginKeys.getText());
                keysFieldsUpdate.put("user_password", fieldPasswordKeys.getText());
                keysFieldsUpdate.put("user_role", fieldRoleKeys.getValue());
                keysFieldsUpdate.put("permission_table_client", checkMarkTableClientForKeys.isSelected() ? "T" : "F");
                keysFieldsUpdate.put("permission_table_publication", checkMarkTablePublicationForKeys.isSelected() ? "T" : "F");
                keysFieldsUpdate.put("permission_table_author", checkMarkTableAuthorForKeys.isSelected() ? "T" : "F");
                keysFieldsUpdate.put("permission_table_printing_house", checkMarkTablePrintingHouseForKeys.isSelected() ? "T" : "F");
                keysFieldsUpdate.put("permission_queries", checkMarkQueriesForKeys.isSelected() ? "T" : "F");
                keysFieldsUpdate.put("permission_add_user", checkMarkAddUserForKeys.isSelected() ? "T" : "F");

                boolean successFlag = crudFindFunc.updateObject(keysFieldsUpdate, queryUpdate, selectedKey.getIdUser());
                if(successFlag) {
                    crudFindFunc.updateList(query, columnNamesDBKeys, mapper, keysList);
                    ClearFieldsKeys();
                }
            }
        });

        //опис кнопки видалити об'єкт
        btnRemoveKeysDB.setOnMouseClicked(event ->{
            if (!crudFindFunc.showDeleteConfirmation()) {
                return;
            }
            crudFindFunc.deleteObject(queryRemove, tableKeys, Keys::getIdUser);
            crudFindFunc.updateList(query, columnNamesDBKeys, mapper, keysList);
            ClearFieldsKeys();
        });

        btnClearFieldsKeysDB.setOnMouseClicked(ev->{
            ClearFieldsKeys();
        });

        btnClearFieldsFindKeys.setOnMouseClicked(ev->{
            fieldLoginKeysFind.clear();
        });

        btnReloadPage.setOnMouseClicked(ev->{
            crudFindFunc.updateList(query, columnNamesDBKeys, mapper, keysList);
            ClearFieldsKeys();
        });


    }

    private void ClearFieldsKeys(){
        fieldLoginKeys.clear();
        fieldPasswordKeys.clear();
        fieldRoleKeys.setValue("Адміністратор");
        checkMarkTableClientForKeys.setSelected(false);
        checkMarkTableAuthorForKeys.setSelected(false);
        checkMarkTablePrintingHouseForKeys.setSelected(false);
        checkMarkTablePublicationForKeys.setSelected(false);
        checkMarkQueriesForKeys.setSelected(false);
        checkMarkAddUserForKeys.setSelected(false);
        tableKeys.getSelectionModel().clearSelection();
    }

    private  void fillFromFieldsKeys(){
        Keys selectedKey = tableKeys.getSelectionModel().getSelectedItem();
        if(selectedKey != null){
            fieldLoginKeys.setText(selectedKey.getLoginUser());
            fieldPasswordKeys.setText(selectedKey.getPasswordUser());
            fieldRoleKeys.setValue(selectedKey.getRoleUser());
            checkMarkTableClientForKeys.setSelected(selectedKey.getPermissionTableClient());
            checkMarkTableAuthorForKeys.setSelected(selectedKey.getPermissionTableAuthor());
            checkMarkTablePrintingHouseForKeys.setSelected(selectedKey.getPermissionTablePrintingHouse());
            checkMarkTablePublicationForKeys.setSelected(selectedKey.getPermissionTablePublication());
            checkMarkQueriesForKeys.setSelected(selectedKey.getPermissionQueries());
            checkMarkAddUserForKeys.setSelected(selectedKey.getPermissionAddUser());
        }
    }

    private boolean checkFieldsKeys(String currentLogin){
        //перевірка пустих полів
        List<TextField> fieldsKeys = Arrays.asList(fieldLoginKeys, fieldPasswordKeys);
        for (TextField field : fieldsKeys){
            if(field.getText() == null || field.getText().trim().isEmpty()){
                crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Заповніть всі необхідні поля!");
                return false;
            }
        }

        // Перевірка індивідуальності логіну
        String loginKeys = fieldLoginKeys.getText();
        if (!loginKeys.equals(currentLogin)) {
            String queryCheckLogin = "SELECT COUNT(*) FROM keys_data WHERE user_login = ?";
            String alertErrorLogin = "Такий логін вже існує! Будь ласка, замініть на інший!";

            if (!additionalMethods.CheckForIndividualFields(alertErrorLogin, queryCheckLogin, loginKeys, fieldLoginKeys)) {
                return false;
            }
        }


        // Перевірка ролі та стану чекбокса "Додати користувача"
        String userRole = fieldRoleKeys.getValue().toString();
        if ((userRole.equals("Оператор") || userRole.equals("Гість")) && checkMarkAddUserForKeys.isSelected()) {
            crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Користувачі з роллю 'Оператор' або 'Гість' не можуть мати права додавати користувачів!");
            checkMarkAddUserForKeys.setSelected(false);
            return false;
        }


        return true;
    }
    //endregion

    //region blockLogout
    ///Опис функціоналу Вийти

    private  void Logout() {
        btnLogout.setOnMouseClicked(ev ->{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in-form.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
            stage.setTitle("Вхід");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

            // закрити вікно MainWindowController
            Stage currentStage = (Stage) btnLogout.getScene().getWindow();
            currentStage.close();
        });

    }
    //endregion

    //region blockQuery
   private void blockQuery(){
        fieldGeneralNumberQuery.setEditable(false);

        //відображення потрібних полів для запитів
        fieldChooseQuery.valueProperty().addListener((observable, oldValue, newValue) -> {
           if (newValue != null && newValue.equals(listQueries.get(4))) {
               fieldFirstDateQuery.setVisible(true);
               fieldSecondDateQuery.setVisible(true);
           } else {
               fieldFirstDateQuery.setVisible(false);
               fieldSecondDateQuery.setVisible(false);
           }

            if (newValue != null && newValue.equals(listQueries.get(5))) {
                fieldProductTypeQuery.setVisible(true);
            } else {
                fieldProductTypeQuery.setVisible(false);
            }

            if (newValue != null && newValue.equals(listQueries.get(6))) {
                fieldAuthorQuery.setVisible(true);
            } else {
                fieldAuthorQuery.setVisible(false);
            }

            if (newValue != null && newValue.equals(listQueries.get(8))) {
                fieldClientQuery.setVisible(true);
            } else {
                fieldClientQuery.setVisible(false);
            }

            if (newValue != null && newValue.equals(listQueries.get(9))) {
                fieldMonthQuery.setVisible(true);
                fieldYearQuery.setVisible(true);
            } else {
                fieldMonthQuery.setVisible(false);
                fieldYearQuery.setVisible(false);
            }


        });

       //опис кнопки застосувати запит
        btnExecuteQuery.setOnMouseClicked(ev->{

            tableQuery.getItems().clear();
            tableQuery.getColumns().clear();

           String queryChoice = fieldChooseQuery.getValue();

           try{
           if(listQueries.get(0).equals(queryChoice)) {
               executeQueries.getInfoAboutAuthorsThatBooksPublishedOftenByQuarters(tableQuery);
           }
           if(listQueries.get(1).equals(queryChoice)){
               executeQueries.DisplayInfoPublicationInProgress(tableQuery);
           }
           if(listQueries.get(2).equals(queryChoice)){
               executeQueries.GetTotalVolumePrintedProductsInPrintedSheetsForQuarters(tableQuery);
           }
           if(listQueries.get(3).equals(queryChoice)){
               executeQueries.GetInfoAboutTheMostLoadedPrintingHouseByMonths(tableQuery);
           }
           if (listQueries.get(4).equals(queryChoice)) {
                if (fieldFirstDateQuery.getValue() == null || fieldSecondDateQuery.getValue() == null) {
                   crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, введіть обидві дати!");
                    return;
                }
                executeQueries.GetInformationOfOrdersForCertainPeriodOfTime(tableQuery, fieldFirstDateQuery, fieldSecondDateQuery);
                executeQueries.GetNumberOfOrdersForCertainPeriodOfTime(fieldGeneralNumberQuery, fieldFirstDateQuery, fieldSecondDateQuery);
           }
           if(listQueries.get(5).equals(queryChoice)){
                executeQueries.GetInformationOfOrdersByVariousTypesPublishingProducts(tableQuery,fieldProductTypeQuery);
                executeQueries.GetNumberOfOrdersByVariousTypesPublishingProducts(fieldGeneralNumberQuery, fieldProductTypeQuery);
           }
           if (listQueries.get(6).equals(queryChoice)) {
                if (fieldAuthorQuery.getText().isEmpty()) {
                    crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, введіть ПІБ автора!");
                    return;
                }
                executeQueries.GetInformationAboutOrdersInvolvingCertainAuthor(tableQuery, fieldAuthorQuery);
                executeQueries.GetNumberOfOrdersInvolvingCertainAuthor(fieldGeneralNumberQuery, fieldAuthorQuery);
           }
           if(listQueries.get(7).equals(queryChoice)){
                executeQueries.GetInformationAboutOrdersThatHaveBeenCanceledThroughNonPaymentCancellationByTheCustomer(tableQuery);
                executeQueries.GetNumberOfOrdersThatHaveBeenCanceledThroughNonPaymentCancellationByTheCustomer(fieldGeneralNumberQuery);
           }
           if (listQueries.get(8).equals(queryChoice)) {
                if (fieldClientQuery.getText().isEmpty()) {
                    crudFindFunc.showAlert(Alert.AlertType.ERROR, "Помилка", "Будь ласка, введіть ПІБ клієнта!");
                    return;
                }
                executeQueries.GetInformationOrdersThatHasBeenMadePrivatePersonOrOrganization(tableQuery, fieldClientQuery);
                executeQueries.GetNumberOrdersThatHasBeenMadePrivatePersonOrOrganization(fieldGeneralNumberQuery, fieldClientQuery);
           }
           if(listQueries.get(9).equals(queryChoice)){
                executeQueries.CalculateTheProfitOfThePublishingHouseForTheMonth(tableQuery, fieldMonthQuery, fieldYearQuery);
           }
           } catch (IndexOutOfBoundsException e) {

           }

       });

        //очищення запитів і таблиці
       btnClearQuery.setOnMouseClicked(ev->{
           fieldChooseQuery.setValue(listQueries.get(0));
           tableQuery.getColumns().clear();
           fieldGeneralNumberQuery.clear();
       });

       //очищення полів
       btnClearFieldsQuery.setOnMouseClicked(ev->{
           fieldFirstDateQuery.setValue(null);
           fieldSecondDateQuery.setValue(null);
           fieldProductTypeQuery.setValue("Бланк");
           fieldAuthorQuery.clear();
           fieldClientQuery.clear();
           fieldMonthQuery.setValue(listMonths.get(0));
           fieldYearQuery.setValue(listYears.get(1));
       });

   }
   //endregion


    ///Опис функціоналу Системи (ВХІД В СИСТЕМУ)

    //отримує логін та пароль з форми SignInForm
    public void getDataFromForm(String login, String password) {
        fetchUserData(login, password);
    }

    //по логіну і паролю буде витягувати всі данні з БД
    private void fetchUserData(String login, String password){

        Connection connectionDB = dbConnection.getConnection();
        String query = "SELECT * FROM keys_data WHERE user_login = ? AND user_password = ?";
        try (PreparedStatement preparedStatement = connectionDB.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                int userId = resultSet.getInt("user_id");
                String userRole = resultSet.getString("user_role");
                Boolean permissionTableClient = resultSet.getBoolean("permission_table_client");
                Boolean permissionTablePublication = resultSet.getBoolean("permission_table_publication");
                Boolean permissionTableAuthor = resultSet.getBoolean("permission_table_author");
                Boolean permissionTablePrintingHouse = resultSet.getBoolean("permission_table_printing_house");
                Boolean permissionQueries = resultSet.getBoolean("permission_queries");
                Boolean permissionAddUser = resultSet.getBoolean("permission_add_user");

                // Оновлення об'єкта keys з отриманими даними
                keys = new Keys(userId, login, password, userRole,
                        permissionTableClient, permissionTablePublication, permissionTableAuthor,
                        permissionTablePrintingHouse, permissionQueries,
                        permissionAddUser);

                currentUser = keys;
                System.out.println("Current user set: " + currentUser.getRoleUser());
                Platform.runLater(this::initializeComboBoxes);

                Permissions(userId, userRole, permissionTableClient,permissionTablePublication,
                        permissionTableAuthor,permissionTablePrintingHouse, permissionQueries, permissionAddUser);

            } else {
                System.out.println("User not found with provided login and password!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //дозволи
    private void Permissions(int id, String role, Boolean permissionTableClient,
                             Boolean permissionTablePublication, Boolean permissionTableAuthor,Boolean permissionTablePrintingHouse,
                             Boolean permissionQueries,  Boolean permissionAddUser ){

        if ("Адміністратор".equals(role)) {
            btnKeys.setVisible(false); //для всіх окрім власника
            iconKeys.setVisible(false);
            btnAddClientDB.setVisible(permissionTableClient);
            btnUpdateClientDB.setVisible(permissionTableClient);
            btnRemoveClientDB.setVisible(permissionTableClient);
            messagePermissionClient.setText(permissionTableClient ? "Доступ: повний" : "Доступ: перегляд даних");
            btnAddPublicationDB.setVisible(permissionTablePublication);
            btnUpdatePublicationDB.setVisible(permissionTablePublication);
            btnRemovePublicationDB.setVisible(permissionTablePublication);
            messagePermissionPublication.setText(permissionTablePublication ? "Доступ: повний" : "Доступ: перегляд даних");
            btnAddAuthorDB.setVisible(permissionTableAuthor);
            btnUpdateAuthorDB.setVisible(permissionTableAuthor);
            btnRemoveAuthorDB.setVisible(permissionTableAuthor);
            messagePermissionAuthor.setText(permissionTableAuthor ? "Доступ: повний" : "Доступ: перегляд даних");
            btnAddPublicationAuthorDB.setVisible(permissionTableAuthor||permissionTablePublication);
            btnUpdatePublicationAuthorDB.setVisible(permissionTableAuthor||permissionTablePublication);
            btnRemovePublicationAuthorDB.setVisible(permissionTableAuthor||permissionTablePublication);
            messagePermissionPublicationAuthor.setText(permissionTableAuthor || permissionTablePublication ? "Доступ: повний" : "Доступ: перегляд даних");
            btnAddPrintingHouseDB.setVisible(permissionTablePrintingHouse);
            btnUpdatePrintingHouseDB.setVisible(permissionTablePrintingHouse);
            btnRemovePrintingHouseDB.setVisible(permissionTablePrintingHouse);
            messagePermissionPrintingHouse.setText(permissionTablePrintingHouse ? "Доступ: повний" : "Доступ: перегляд даних");
            messagePermissionOrder.setText("Доступ: повний");
            btnFindInfo.setDisable(!permissionQueries);
            iconFind.setOpacity(permissionQueries ? 1.0 : 0.5);
            btnAddUser.setDisable(!permissionAddUser);
            iconAddUser.setOpacity(permissionAddUser ? 1.0 : 0.5);
            messagePermissionAddUser.setText("Доступ: повний");
            messagePermissionQueries.setText("Доступ: повний");

            iconUserRolePanel.setImage(new Image(getClass().getResourceAsStream("images/icon-user-admin.png")));
        }
        if("Оператор".equals(role)){
            btnKeys.setVisible(false);
            iconKeys.setVisible(false);
            //дозволи таблиця клієнта
            btnAddClientDB.setVisible(false);
            btnRemoveClientDB.setVisible(false);
            btnUpdateClientDB.setVisible(permissionTableClient);
            fieldTypeClient.setDisable(true);
            fieldNameClient.setDisable(true);
            messagePermissionClient.setText(permissionTableClient ? "Доступ: редагування даних" : "Доступ: перегляд даних");
            //дозволи таблиця замовлень
            btnAddOrderDB.setVisible(false);
            btnRemoveOrderDB.setVisible(false);
            fieldNumbOrderOrder.setDisable(true);
            fieldTypePublicationOrder.setDisable(true);
            fieldIDClientOrder.setDisable(true);
            fieldIDPublicationOrder.setDisable(true);
            fieldIDPrintingHouseOrder.setDisable(true);
            fieldStartDateOrder.setDisable(true);
            messagePermissionOrder.setText("Доступ: редагування даних");
            //дозволи таблиця видання
            btnAddPublicationDB.setVisible(false);
            btnRemovePublicationDB.setVisible(false);
            btnUpdatePublicationDB.setVisible(permissionTablePublication);
            fieldCodePublication.setDisable(true);
            fieldNamePublication.setDisable(true);
            fieldTypeSizePublication.setDisable(true);
            messagePermissionPublication.setText(permissionTablePublication ? "Доступ: редагування даних" : "Доступ: перегляд даних");
            //дозволи таблиця авторів
            btnAddAuthorDB.setVisible(false);
            btnRemoveAuthorDB.setVisible(false);
            btnUpdateAuthorDB.setVisible(permissionTableAuthor);
            fieldNameAuthor.setDisable(true);
            messagePermissionAuthor.setText(permissionTableAuthor ? "Доступ: редагування даних" : "Доступ: перегляд даних");
            //дозволи таблиця видання-автор
            btnAddPublicationAuthorDB.setVisible(false);
            btnUpdatePublicationAuthorDB.setVisible(false);
            btnRemovePublicationAuthorDB.setVisible(false);
            messagePermissionPublicationAuthor.setText("Доступ: перегляд даних");
            //дозволи таблиця друкарні
            btnAddPrintingHouseDB.setVisible(false);
            btnRemovePrintingHouseDB.setVisible(false);
            btnUpdatePrintingHouseDB.setVisible(permissionTablePrintingHouse);
            fieldNamePrintingHouse.setDisable(true);
            messagePermissionPrintingHouse.setText(permissionTablePrintingHouse ? "Доступ: редагування даних" : "Доступ: перегляд даних");
            //запити
            btnFindInfo.setDisable(!permissionQueries);
            messagePermissionQueries.setText("Доступ: повний");
            iconFind.setOpacity(permissionQueries ? 1.0 : 0.5);
            //додавання користувача
            btnAddUser.setDisable(true);
            iconAddUser.setOpacity(0.5);

            iconUserRolePanel.setImage(new Image(getClass().getResourceAsStream("images/icon-user-operator.png")));

        }
        if("Гість".equals(role)){
            btnKeys.setVisible(false); //для всіх окрім власника
            iconKeys.setVisible(false);

            btnAddClientDB.setVisible(false);
            btnUpdateClientDB.setVisible(false);
            btnRemoveClientDB.setVisible(false);
            btnClient.setDisable(!permissionTableClient);
            iconClient.setOpacity(permissionTableClient ? 1.0 : 0.5);
            messagePermissionClient.setText("Доступ: перегляд даних");

            btnAddOrderDB.setVisible(false);
            btnUpdateOrderDB.setVisible(false);
            btnRemoveOrderDB.setVisible(false);
            messagePermissionOrder.setText("Доступ: перегляд даних");

            btnAddPublicationDB.setVisible(false);
            btnUpdatePublicationDB.setVisible(false);
            btnRemovePublicationDB.setVisible(false);
            btnPublication.setDisable(!permissionTablePublication);
            iconPublication.setOpacity(permissionTablePublication ? 1.0 : 0.5);
            messagePermissionPublication.setText("Доступ: перегляд даних");

            btnAddAuthorDB.setVisible(false);
            btnUpdateAuthorDB.setVisible(false);
            btnRemoveAuthorDB.setVisible(false);
            btnAuthor.setDisable(!permissionTableAuthor);
            iconAuthor.setOpacity(permissionTableAuthor ? 1.0 : 0.5);
            messagePermissionAuthor.setText("Доступ: перегляд даних");

            btnAddPublicationAuthorDB.setVisible(false);
            btnUpdatePublicationAuthorDB.setVisible(false);
            btnRemovePublicationAuthorDB.setVisible(false);
            messagePermissionPublicationAuthor.setText("Доступ: перегляд даних");
            btnPublicationAuthor.setDisable(!permissionTablePublication && !permissionTableAuthor);
            iconConnectionPublicationAuthor.setOpacity(permissionTableAuthor || permissionTablePublication ? 1.0 : 0.5);

            btnAddPrintingHouseDB.setVisible(false);
            btnUpdatePrintingHouseDB.setVisible(false);
            btnRemovePrintingHouseDB.setVisible(false);
            btnPrintingHouse.setDisable(!permissionTablePrintingHouse);
            iconPrintingHouse.setOpacity(permissionTablePrintingHouse ? 1.0 : 0.5);
            messagePermissionPrintingHouse.setText("Доступ: перегляд даних");

            btnFindInfo.setDisable(!permissionQueries);
            messagePermissionQueries.setText("Доступ: повний");
            iconFind.setOpacity(permissionQueries ? 1.0 : 0.5);

            btnAddUser.setDisable(true);
            iconAddUser.setOpacity(0.5);

            iconUserRolePanel.setImage(new Image(getClass().getResourceAsStream("images/icon-user-visitor.png")));
        }

        if("Власник".equals(role)){
            System.out.println("Власник зайшов у систему!");
            messagePermissionClient.setText("Доступ: повний");
            messagePermissionOrder.setText("Доступ: повний");
            messagePermissionPublication.setText("Доступ: повний");
            messagePermissionAuthor.setText("Доступ: повний");
            messagePermissionPrintingHouse.setText("Доступ: повний");
            messagePermissionPublicationAuthor.setText("Доступ: повний");
            messagePermissionAddUser.setText("Доступ: повний");
            messagePermissionQueries.setText("Доступ: повний");
            messagePermissionKeys.setText("Доступ: повний");

            iconUserRolePanel.setImage(new Image(getClass().getResourceAsStream("images/icon-user-owner.png")));
        }
    }


}

