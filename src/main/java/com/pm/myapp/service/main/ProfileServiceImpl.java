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
    public boolean editProfile(Map<String, Object> profile) {
        log.debug("Service editProfileImage({}) invoked.", profile);

        int affectedLine = this.mapper.modifyProfile(profile);
        boolean result = (affectedLine == 1);

        log.info("result: {}", result);

        return result;
    } // editProfileImage

    @Override
    public boolean withdrawal(String email) {
        log.debug("Service withdrawal({}) invoked.", email);

        int affectedLine = this.mapper.deleteUser(email);

        boolean result = (affectedLine == 1);

        log.info("result: {}", result);

        return result;
    } // withdrawal

} // end class
