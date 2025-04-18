package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.factory.MissionFactory;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.util.MissionType;

import java.util.List;

public class MissionService implements IMissionService{
    private final IMemberService memberService;
    private final List<Mission> missions;

    public MissionService(IMemberService memberService, List<Mission> missions) {
        this.memberService = memberService;
        this.missions = missions; //
    }

    @Override
    public String showCurrentOption(boolean missionStatus) {
        if (missionStatus) {
            return currentMission();
        } else {
            return missionOptions();
        }
    }

    private String missionOptions() {
        //retorna a lista para visualizar quais as disponiveis
    }

    private String currentMission() {
        //retorna a missao de um id baseado ou no ano atual ou no id de missão do membro
    }

    private Mission startMission(int serialCode, String missionType) {
        Member member = memberService.getMemberByBipeCode(serialCode);
        Mission mission = MissionFactory.createMission(missionType);
        member.getBipe().setCurrentMission(mission);
        return mission;
    }

}
