package com.cheraten.threatmodel.service;

import com.cheraten.threatmodel.entity.ISystem;
import com.cheraten.threatmodel.entity.Threat;
import com.cheraten.threatmodel.repo.ISystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ISystemService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    ISystemRepository isystemRepository;

    public ISystem findISystemById(Long id) {
        Optional<ISystem> isystemFromDb = isystemRepository.findById(id);
        return isystemFromDb.orElse(new ISystem());
    }

    public List<ISystem> allISystems() {
        return isystemRepository.findAll();
    }

    public boolean saveISystem(ISystem isystem) {
        ISystem isystemFromDB = isystemRepository.findByName(isystem.getName());

        if (isystemFromDB != null) {
            return false;
        }
        isystemRepository.save(isystem);
        return true;
    }

    public boolean setSecLevelByName(Long isystemId, String securityLevel) {
        ISystem isystem = findISystemById(isystemId);

        if (isystem == null) {
            return false;
        }

        isystem.setSecurityLevel(securityLevel);
        isystemRepository.save(isystem);
        return true;
    }

    public boolean deleteISystem(Long id) {
        if (isystemRepository.findById(id).isPresent()) {
            isystemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void setThreatListByISystem(ISystem isystem, List<Threat> allThreats) {
        List<Threat> threatList = new ArrayList<>();
        for (int i = 0; i < allThreats.size(); i++) {
            if (allThreats.get(i).getIsystem().getId() == isystem.getId())
                threatList.add(allThreats.get(i));
        }
        isystem.setThreats(threatList);
    }

    public List<ISystem> isystemgtList(Long idMin) {
        return em.createQuery("SELECT is FROM ISystem is WHERE is.id > :paramId", ISystem.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
