package org.mapledpmlab.type.dealcycleduo;

import org.mapledpmlab.type.JobContinuous.BishopContinuous;
import org.mapledpmlab.type.JobContinuous.BowmasterContinuous;
import org.mapledpmlab.type.dealcyclesolo.Bishop2ContinuousDealCycle;
import org.mapledpmlab.type.dealcyclesolo.BowmasterContinuousDealCycle;
import org.mapledpmlab.type.dealcyclesolo.SkillEvent;
import org.mapledpmlab.type.etc.DuoDealCycle;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.AngelOfLibraCharity;
import org.mapledpmlab.type.skill.buffskill.bishop.AngelOfLibraCharityParty;
import org.mapledpmlab.type.skill.buffskill.bishop.Pray2;
import org.mapledpmlab.type.skill.buffskill.bishop.Pray2Party2;

public class BishopCannonShooter2DealCycle extends DuoDealCycle {

    public BishopCannonShooter2DealCycle() {
        setName("비숍 + 캐슈(2분)");
        setDescription("비숍(컨티) + 캐슈(2분)");

        setDealCycle1(new Bishop2ContinuousDealCycle(new BishopContinuous()));
        setDealCycle2(new BowmasterContinuousDealCycle(new BowmasterContinuous()));

        getDealCycle2().getBuffSkillList().add(new Pray2Party2(0L));
        getDealCycle2().getBuffSkillList().add(new AngelOfLibraCharityParty(0L));

        getDealCycle1().getPartyDealCycle().add(getDealCycle2());
        getDealCycle2().getPartyDealCycle().add(getDealCycle1());

        getDealCycle2().setSoloDealCycle();
        getDealCycle1().setNukeTimeList(getDealCycle2().getNukeTimeList());
        getDealCycle1().setDuoDealCycle3();

        System.out.println(getDealCycle1().getRestraintRingStartTime());
        System.out.println(getDealCycle1().getOriginXRestraintRingStartTime());
        System.out.println(getDealCycle2().getRestraintRingStartTime());
        System.out.println(getDealCycle2().getOriginXRestraintRingStartTime());


        for (SkillEvent skillEvent : getDealCycle1().getSkillEventList()) {
            if (
                    skillEvent.getSkill() instanceof BuffSkill
                            && !(skillEvent.getSkill() instanceof Pray2Party2)
                            && !(skillEvent.getSkill() instanceof AngelOfLibraCharityParty)
            ) {
                if (((BuffSkill) skillEvent.getSkill()).isPartyBuff()) {
                    getDealCycle2().getSkillEventList().add(skillEvent);
                }
            }
            if (skillEvent.getSkill() instanceof Pray2) {
                getDealCycle2().getSkillEventList().add(new SkillEvent(new Pray2Party2(0L), skillEvent.getStart(), skillEvent.getEnd()));
            } else if (skillEvent.getSkill() instanceof AngelOfLibraCharity) {
                getDealCycle2().getSkillEventList().add(new SkillEvent(new AngelOfLibraCharityParty(0L), skillEvent.getStart(), skillEvent.getEnd()));
            }
        }

        getDealCycle1().sortEventTimeList();
        getDealCycle2().sortEventTimeList();

        getDealCycle1().applyDoping();
        getDealCycle2().applyDoping();
        getDealCycle2().getJob().addIgnoreDefenseList(44L);     // 엔젤릭 터치

        getDealCycle1().setRestraintRingStartTime(getDealCycle2().getRestraintRingStartTime());
        getDealCycle1().setRestraintRingEndTime(getDealCycle2().getRestraintRingEndTime());
        getDealCycle1().setFortyEndTime(getDealCycle2().getFortyEndTime());
        getDealCycle1().setOriginXRestraintRingStartTime(getDealCycle2().getOriginXRestraintRingStartTime());
        getDealCycle1().setOriginXRestraintRingEndTime(getDealCycle2().getOriginXRestraintRingEndTime());
    }
}
