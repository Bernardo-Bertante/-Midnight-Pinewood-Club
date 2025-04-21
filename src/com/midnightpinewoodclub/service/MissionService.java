package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.repository.IMissionRepository;

import java.util.List;

public class MissionService implements IMissionService{
    private final IMemberService memberService;
    private final IMissionRepository missionRepository;

    public MissionService(IMemberService memberService, IMissionRepository missionRepository) {
        this.memberService = memberService;
        this.missionRepository = missionRepository;
    }

    @Override
    public int getMissionsQuantity() {
        return missionRepository.getMissionsSize();
    }

    @Override
    public String showCurrentOption(boolean missionStatus, int serialCode) {
        if (missionStatus) {
            return currentMission(serialCode);
        } else {
            return missionOptions();
        }
    }

    private String missionOptions() {
        List<Mission> missions = missionRepository.getMissions();
        StringBuilder sb = new StringBuilder();
        if (missions.isEmpty()) {
            sb.append("║   (No items in inventory yet...)     ║\n");
        } else {
            int cont = 1;
            for (Mission mission : missions) {
                sb.append("╔══════════════════════════════════════╗\n");
                sb.append(String.format("║                %s [%d]                    ║\n", mission.getTitle(), cont));
                sb.append("╠══════════════════════════════════════╣\n");
                sb.append(String.format("║ %-28s ║\n", mission.getDescription()));
                sb.append(String.format("║ You will get: %-28s ║\n", mission.getReward().getName()));
                sb.append("╠══════════════════════════════════════╣\n");
                cont++;
            }
        }

        sb.append("╚══════════════════════════════════════╝\n");
        return sb.toString();
    }

    private String currentMission(int serialCode) {
        List<Mission> missions = missionRepository.getMissions();
        Member member = memberService.getMemberByBipeCode(serialCode);
        StringBuilder sb = new StringBuilder();
        if (missions.isEmpty()) {
            sb.append("No mission available for today!\n");
        } else {
            for (Mission mission : missions) {
                if (member.getBipe().getCurrentMissionId() == mission.getId()) {
                    sb.append("╔══════════════════════════════════════╗\n");
                    sb.append(String.format("║                %s                    ║\n", mission.getTitle()));
                    sb.append("╠══════════════════════════════════════╣\n");
                    sb.append(String.format("║ %-28s ║\n", mission.getDescription()));
                    sb.append(String.format("║ You will get: %-28s ║\n", mission.getReward().getName()));
                    sb.append("╚══════════════════════════════════════╝\n");
                    break;
                }
            }
        }
        return sb.toString();
    }

    //setmissionId

    //mission id começa nulo(0) -> ao escolher qual missao quer fazer pelas opcoes disponiveis -> seta o id daquela missao no bipe do membro e seta a missao e true in mission

    @Override
    public Mission getMissionById(int missionId) {
        return missionRepository.getMission(missionId);
    }

    @Override
    public String joinMission(int serialCode, int missionIndex) {
        Mission mission = missionRepository.getMissionByIndex(missionIndex);
        return memberService.setMission(serialCode, mission);
    }

    @Override
    public String startMissionStory(int serialCode) {
        Mission mission = memberService.getCurrentMission(serialCode);
        return mission.beginStory().tellStory();
    }

    @Override
    public String finishMission(int serialCode) {
        Mission mission = memberService.getCurrentMission(serialCode);
        Item reward = mission.getReward();
        memberService.addItem(serialCode, reward);
        return "\nYou received " + reward.getName();
    }

}
