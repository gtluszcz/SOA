package Models;

public class ShowList {
    private Boolean showAuthor = true;
    private Boolean showTitle = true;
    private Boolean showPrice = true;
    private Boolean showGenre = true;
    private Boolean showCurrency = true;
    private Boolean showPages = true;

    public Boolean getShowAuthor() {
        return showAuthor;
    }

    public void setShowAuthor(Boolean showAuthor) {
        this.showAuthor = showAuthor;
    }

    public Boolean getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(Boolean showTitle) {
        this.showTitle = showTitle;
    }

    public Boolean getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(Boolean showPrice) {
        this.showPrice = showPrice;
    }

    public Boolean getShowGenre() {
        return showGenre;
    }

    public void setShowGenre(Boolean showGenre) {
        this.showGenre = showGenre;
    }

    public Boolean getShowCurrency() {
        return showCurrency;
    }

    public void setShowCurrency(Boolean showCurrency) {
        this.showCurrency = showCurrency;
    }

    public Boolean getShowPages() {
        return showPages;
    }

    public void setShowPages(Boolean showPages) {
        this.showPages = showPages;
    }
}
