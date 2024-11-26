package com.walkers.sportslight.motionChallenge.command.application.service;

import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeAddRequest;
import com.walkers.sportslight.motionChallenge.command.application.dto.MotionChallengeMapper;
import com.walkers.sportslight.motionChallenge.command.domain.aggregate.MotionChallenge;
import com.walkers.sportslight.motionChallenge.command.domain.repository.MotionChallengeRepository;
import com.walkers.sportslight.motionChallenge.command.domain.service.MotionFileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MotionChallengeService {

    private final MotionChallengeMapper motionChallengeMapper;
    private final MotionFileUploadService motionFileUploadService;
    private final ChallengeBoardService challengeBoardService;
    private final MotionChallengeRepository motionChallengeRepository;


    public MotionChallenge findById(long motionChallengeId){
        return motionChallengeRepository.findById(motionChallengeId)
                .orElseThrow(()-> new NoSuchElementException("해당하는 모션 챌린지가 존재하지 않습니다."));
    }

    public String getMotionImageUrl(long motionChallengeId){
        return findById(motionChallengeId).getMotionFileUrl();
    }




    public void updateMotionChallengeImage(long challengeId, MultipartFile challengeImage){
        String fileUploadUrl=null;
        try{
            fileUploadUrl = motionFileUploadService.uploadFile(challengeImage);

        } catch (IOException e){
            throw new RuntimeException("파일 업로드에 실패했습니다");
        }

        //log.info("나온 파일 url:{}", fileUploadUrl);
        challengeBoardService.setImage(challengeId, fileUploadUrl);
    }

    @Transactional
    public void updateParticipate(long motionChallengeId, int participateNumber){
        MotionChallenge motionChallenge = findById(motionChallengeId);
        motionChallenge.updateParticipateNumber(participateNumber);

    }

    public long addMotionChallenge(MotionChallengeAddRequest addRequest) {
        String fileUploadUrl=null;

        if (addRequest.getFile()==null){
            log.info("got only challenge content");
        } else{
            try{
                fileUploadUrl = motionFileUploadService.uploadFile(addRequest.getFile());
            } catch (IOException e) {
                throw new RuntimeException("파일 업로드에 실패했습니다");
            }
        }

        MotionChallenge motionChallenge = motionChallengeMapper.toChallenge(addRequest);

        return challengeBoardService.addMotionChallengeBoard(motionChallenge, null, fileUploadUrl);
    }



    public void deleteMotionChallenge(long motionChallengeId) {
        MotionChallenge motionChallenge = motionChallengeRepository.findById(motionChallengeId)
                .orElseThrow(()->new NoSuchElementException("해당 모션챌린지가 없음"));
        //motionFileUploadService.deleteFile();
        challengeBoardService.deleteMotionChallengeBoard(motionChallengeId);
    }
}
