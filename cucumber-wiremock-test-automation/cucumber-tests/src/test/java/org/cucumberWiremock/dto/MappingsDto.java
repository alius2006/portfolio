package org.cucumberWiremock.dto;

import java.util.ArrayList;

public class MappingsDto {

    public ArrayList<MappingDto> mappings;
    public Meta meta;

    public static class Meta{
        public int total;
    }
}
