package com.walkers.sportslight.userStat.command.infrastructure.service;

import com.walkers.sportslight.user.command.domain.repository.ExperienceRepository;
import com.walkers.sportslight.userStat.command.domain.service.ExperienceCache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExperienceLocalCache implements ExperienceCache {

    private ExperienceRepository experienceRepository;

    public ExperienceLocalCache(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    @Cacheable(key = "#level", value = "requireExperience")
    public int getRequireExperience(int level) {
        return experienceRepository.findById((long) level)
                .orElseThrow(() -> new IllegalArgumentException("부적절한 접근입니다."))
                .getRequireExperience();
    }
}
