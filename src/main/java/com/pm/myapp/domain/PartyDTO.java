package com.pm.myapp.domain;

import lombok.Data;


@Data
public class PartyDTO {

    private String partyName;
    private String partyProfile;
    private Integer localCode;
    private Integer hobbyCode;
    private Integer partyCode;
    private String fileLocation;

} // end class
