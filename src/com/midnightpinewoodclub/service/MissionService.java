package com.midnightpinewoodclub.service;

import com.midnightpinewoodclub.model.Item;
import com.midnightpinewoodclub.model.Member;
import com.midnightpinewoodclub.model.missions.Mission;
import com.midnightpinewoodclub.model.stories.Story;
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
            sb.append("║   (No missions available yet...)     ║\n");
        } else {
            int cont = 1;
            for (Mission mission : missions) {
                sb.append("╔═════════════════════════════════════════════════════════════════════╗\n");
                sb.append(String.format("║ %-67s ║\n", formatText(mission.getTitle() + " [" + cont + "]", 67)));
                sb.append("╠═════════════════════════════════════════════════════════════════════╣\n");
                sb.append(String.format("║ %-67s ║\n", formatText(mission.getDescription(), 67)));
                sb.append(String.format("║ You will get: %-53s ║\n", formatText(mission.getReward().getName(), 53)));
                sb.append("╚═════════════════════════════════════════════════════════════════════╝\n");
                cont++;
            }
        }
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
                    sb.append("╔═════════════════════════════════════════════════════════════════════╗\n");
                    sb.append(String.format("║ %-67s ║\n", formatText(mission.getTitle(), 67)));
                    sb.append("╠═════════════════════════════════════════════════════════════════════╣\n");
                    sb.append(String.format("║ %-67s ║\n", formatText(mission.getDescription(), 67)));
                    sb.append(String.format("║ You will get: %-53s ║\n", formatText(mission.getReward().getName(), 53)));
                    sb.append("╚═════════════════════════════════════════════════════════════════════╝\n");
                    break;
                }
            }
        }
        return sb.toString();
    }

    private String formatText(String text, int length) {
        if (text.length() > length) {
            return text.substring(0, length - 3) + "...";
        } else {
            return String.format("%-" + length + "s", text);
        }
    }


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
        Story story = mission.beginStory();
        return story.tellStory();
    }

    @Override
    public String finishMission(int serialCode) {
        Mission mission = memberService.getCurrentMission(serialCode);
        Item reward = mission.getReward();
        memberService.levelUp(serialCode);
        memberService.setToNotInMission(serialCode);
        if (memberService.addItem(serialCode, reward)) {
            return "\nYou received " + reward.getName();
        }
        return "\nYou already got " + reward.getName();
    }

}
