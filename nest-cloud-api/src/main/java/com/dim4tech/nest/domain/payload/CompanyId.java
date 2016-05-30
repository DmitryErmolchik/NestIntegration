package com.dim4tech.nest.domain.payload;

import java.util.Objects;

public class CompanyId {
    private final String id;

    public CompanyId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyId companyId = (CompanyId) o;
        return Objects.equals(id, companyId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
