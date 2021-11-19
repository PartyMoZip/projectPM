package com.pm.myapp.service.main;

import com.pm.myapp.domain.PartyVO;
import com.pm.myapp.mapper.ProfileMapper;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@NoArgsConstructor

@Service
public class ProfileServiceImpl implements ProfileService {

    @Setter(onMethod_ = @Autowired)
    private ProfileMapper mapper;


    @Override
    public List<PartyVO> getMyPartyList(String email) {
        log.debug("Service getMyPartyList({}) invoked.", email);

        List<PartyVO> list = this.mapper.getMyPartyList(email);

        list.forEach(log::info);

        return list;
    } // getMyPartyList

    @Override
    public Integer editProfileImage(Map<String, Object> profile) {
        log.debug("Service editProfileImage({}) invoked.", profile);

        int result = this.mapper.modifyProfileImage(profile);

        log.info("result: {}", result);

        return result;
    } // editProfileImage

    @Override
    public Integer withdrawal(String email) {
        log.debug("Service withdrawal({}) invoked.", email);

        int result = this.mapper.deleteUser(email);

        log.info("result: {}", result);

        return result;
    } // withdrawal

} // end class
