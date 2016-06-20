package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Structure;
import com.dim4tech.nest.domain.payload.StructureId;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URL;
import java.util.Map;

public class StructuresLoader extends AbstractLoader<Map<StructureId, Structure>> {

    public StructuresLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public StructuresLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Map<StructureId, Structure> load(String accessToken) {
        return loadJsonData(accessToken, new TypeReference<Map<StructureId, Structure>>() {});
    }
}
