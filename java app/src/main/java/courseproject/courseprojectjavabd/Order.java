package courseproject.courseprojectjavabd;

import java.util.Calendar;
import java.util.Date;

public class Order {
    private int idOrder;
    private String numbOrder;
    private String printProductTypeOrder;
    private String idClientOrder;
    private String idPublicationOrder;
    private String idPrintingHouseOrder;
    private Date startDateOrder;
    private Date endDateOrder;
    private String statusFulfilmentOrder;
    private Double priceOrder;
    private String statusPaymentOrder;


    public Order(int idOrder, String numbOrder, String printProductTypeOrder, String idClientOrder, String idPublicationOrder, String idPrintingHouseOrder, Date startDateOrder, Date endDateOrder, String statusFulfilmentOrder, Double priceOrder, String statusPaymentOrder) {
        this.idOrder = idOrder;
        this.numbOrder = numbOrder;
        this.printProductTypeOrder = printProductTypeOrder;
        this.idClientOrder = idClientOrder;
        this.idPublicationOrder = idPublicationOrder;
        this.idPrintingHouseOrder = idPrintingHouseOrder;
        this.startDateOrder = startDateOrder;
        this.endDateOrder = endDateOrder;
        this.statusFulfilmentOrder = statusFulfilmentOrder;
        this.priceOrder = priceOrder;
        this.statusPaymentOrder = statusPaymentOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public String getNumbOrder() {
        return numbOrder;
    }


    public String getPrintProductTypeOrder() {
        return printProductTypeOrder;
    }


    public String getIdClientOrder() {
        return idClientOrder;
    }


    public String getIdPublicationOrder() {
        return idPublicationOrder;
    }

    public String getIdPrintingHouseOrder() {
        return idPrintingHouseOrder;
    }

    public Date getStartDateOrder() {
        return startDateOrder;
    }

    public Date getEndDateOrder() {
        return endDateOrder;
    }


    public String getStatusFulfilmentOrder() {
        return statusFulfilmentOrder;
    }


    public Double getPriceOrder() {
        return priceOrder;
    }

    public String getStatusPaymentOrder() {
        return statusPaymentOrder;
    }

}
