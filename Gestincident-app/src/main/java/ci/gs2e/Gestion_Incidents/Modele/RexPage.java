package ci.gs2e.Gestion_Incidents.Modele;

import org.springframework.data.domain.Sort;

public class RexPage {
    private int PageNumber =0;
    private int pageSize = 10;
    private Sort.Direction sortDirection =  Sort.Direction.DESC;
    private String sortBy = "nom";
    private  String filterBy = "prenom";

    public int getPageNumber() {
        return PageNumber;
    }

    public void setPageNumber(int pageNumber) {
        PageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }
}
