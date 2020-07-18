package com.cheraten.threatmodel.service;

import com.cheraten.threatmodel.entity.ISystem;
import com.cheraten.threatmodel.entity.Threat;
import com.cheraten.threatmodel.repo.ISystemRepository;
import com.cheraten.threatmodel.repo.ThreatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ThreatService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    ThreatRepository threatRepository;
    @Autowired
    ISystemRepository isystemRepository;

    public Threat findThreatById(Long id) {
        Optional<Threat> threatFromDb = threatRepository.findById(id);
        return threatFromDb.orElse(new Threat());
    }

    public List<Threat> allThreats() {
        return threatRepository.findAll();
    }

    public boolean saveThreat(Threat threat) {
        List<Threat> threatFromDBNames = threatRepository.findByName(threat.getName());
        if (threatFromDBNames.size() != 0) {
            for (int i = 0; i < threatFromDBNames.size(); i++)
                if (threat.getIsystem().equals(threatFromDBNames.get(i).getIsystem())) {
                    return false;
                }
        }
        threatRepository.save(threat);
        return true;
    }

    public boolean renameThreat(Long threatId, String threatNewName) {
        System.out.println(findThreatById(threatId).getName());
        List<Threat> threatFromDBNames = threatRepository.findByName(threatNewName);
        if (threatFromDBNames.size() != 0) {
            for (int i = 0; i < threatFromDBNames.size(); i++)
                if (findThreatById(threatId).getIsystem().equals(threatFromDBNames.get(i).getIsystem())) {
                    return false;
                }
        }
        Threat threat = findThreatById(threatId);
        threat.setName(threatNewName);
        threatRepository.save(threat);
        return true;
    }

    public boolean replaceThreat(Long threatId, ISystem iSystem) {
        System.out.println(findThreatById(threatId).getName());
        List<Threat> threatFromDBNames = threatRepository.findByName(findThreatById(threatId).getName());
        if (threatFromDBNames.size() != 0) {
            for (int i = 0; i < threatFromDBNames.size(); i++)
                if (iSystem.equals(threatFromDBNames.get(i).getIsystem())) {
                    return false;
                }
        }
        Threat threat = findThreatById(threatId);
        threat.setIsystem(iSystem);
        threatRepository.save(threat);
        return true;
    }

    public boolean setProbabilityByName(Long id, String probability) {
        Threat threat = findThreatById(id);
        if (threat == null) {
            return false;
        }
        threat.setProbability(probability);
        threatRepository.save(threat);
        return true;
    }

    public boolean setFeasibilityByName(Long id, String feasibility) {
        Threat threat = findThreatById(id);

        if (threat == null) {
            return false;
        }

        threat.setFeasibility(feasibility);
        threatRepository.save(threat);
        return true;
    }

    public boolean setDangerByName(Long id, String danger) {
        Threat threat = findThreatById(id);
        if (threat == null) {
            return false;
        }
        threat.setDanger(danger);
        threatRepository.save(threat);
        return true;
    }

    public boolean setRelevanceByName(Long id, String relevance) {
        Threat threat = findThreatById(id);
        if (threat == null) {
            return false;
        }
        threat.setRelevance(relevance);
        threatRepository.save(threat);
        return true;
    }

    public boolean deleteThreat(Long id) {
        if (threatRepository.findById(id).isPresent()) {
            threatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Threat> threatgtList(Long idMin) {
        return em.createQuery("SELECT t FROM Threat t WHERE t.id > :paramId", Threat.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
