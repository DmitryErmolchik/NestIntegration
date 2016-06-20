package com.dim4tech.nest.service.loader;

import com.dim4tech.nest.domain.payload.Structure;

import java.net.URL;

public class StructureLoader extends AbstractLoader<Structure> {

    public StructureLoader(URL endpoint, String charset) {
        super(endpoint, charset);
    }

    public StructureLoader(URL endpoint) {
        super(endpoint);
    }

    @Override
    public Structure load(String accessToken) {
        return loadJsonData(accessToken, Structure.class);
    }
}
