package courseproject.courseprojectjavabd;

public class Publication {

    private int idPublication;
    private String codePublication;
    private String namePublication;
    private String typeSizePublication;
    private int numbPagesPublication;
    private int circulationPublication;
    private double amountPrintedSheetsPublication;


    public Publication(int idPublication, String codePublication, String namePublication, String typeSizePublication, int numbPagesPublication, int circulationPublication, double amountPrintedSheetsPublication) {
        this.idPublication = idPublication;
        this.codePublication = codePublication;
        this.namePublication = namePublication;
        this.typeSizePublication = typeSizePublication;
        this.numbPagesPublication = numbPagesPublication;
        this.circulationPublication = circulationPublication;
        this.amountPrintedSheetsPublication = amountPrintedSheetsPublication;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public String getCodePublication() {
        return codePublication;
    }

    public String getNamePublication() {
        return namePublication;
    }

    public String getTypeSizePublication() {
        return typeSizePublication;
    }

    public int getNumbPagesPublication() {
        return numbPagesPublication;
    }

    public int getCirculationPublication() {
        return circulationPublication;
    }

    public double getAmountPrintedSheetsPublication() {
        return amountPrintedSheetsPublication;
    }

}
