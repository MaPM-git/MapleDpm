package org.mapledpmlab.type.dealcycleduo;

import org.mapledpmlab.type.JobContinuous.BishopContinuous;
import org.mapledpmlab.type.dealcyclesolo.Bishop2ContinuousDealCycle;
import org.mapledpmlab.type.dealcyclesolo.SkillEvent;
import org.mapledpmlab.type.etc.DuoDealCycle;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.AngelOfLibraCharity;
import org.mapledpmlab.type.skill.buffskill.bishop.AngelOfLibraCharityParty;
import org.mapledpmlab.type.skill.buffskill.bishop.Pray2;
import org.mapledpmlab.type.skill.buffskill.bishop.Pray2Party2;

public class TwoBishopDealCycle2 extends DuoDealCycle {

    public TwoBishopDealCycle2() {
        setName("비숍 2인팟(극딜 따로)");
        setDescription("비숍(컨티) 2인팟\n1명은 극딜 1분 늦춤");

        setDealCycle1(new Bishop2ContinuousDealCycle(new BishopContinuous()));
        setDealCycle2(new Bishop2ContinuousDealCycle(new BishopContinuous()));

        getDealCycle1().getBuffSkillList().add(new Pray2Party2(0L));
        getDealCycle1().getBuffSkillList().add(new AngelOfLibraCharityParty(0L));
        getDealCycle2().getBuffSkillList().add(new Pray2Party2(0L));
        getDealCycle2().getBuffSkillList().add(new AngelOfLibraCharityParty(0L));

        getDealCycle1().getPartyDealCycle().add(getDealCycle2());
        getDealCycle2().getPartyDealCycle().add(getDealCycle1());

        getDealCycle1().setSoloDealCycle();
        getDealCycle2().setDuoDealCycle2();

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

        for (SkillEvent skillEvent : getDealCycle2().getSkillEventList()) {
            if (
                    skillEvent.getSkill() instanceof BuffSkill
                    && !(skillEvent.getSkill() instanceof Pray2Party2)
                    && !(skillEvent.getSkill() instanceof AngelOfLibraCharityParty)
            ) {
                if (((BuffSkill) skillEvent.getSkill()).isPartyBuff()) {
                    getDealCycle1().getSkillEventList().add(skillEvent);
                }
            }
            if (skillEvent.getSkill() instanceof Pray2) {
                getDealCycle1().getSkillEventList().add(new SkillEvent(new Pray2Party2(0L), skillEvent.getStart(), skillEvent.getEnd()));
            } else if (skillEvent.getSkill() instanceof AngelOfLibraCharity) {
                getDealCycle1().getSkillEventList().add(new SkillEvent(new AngelOfLibraCharityParty(0L), skillEvent.getStart(), skillEvent.getEnd()));
            }
        }

        getDealCycle1().sortEventTimeList();
        getDealCycle2().sortEventTimeList();

        getDealCycle1().applyDoping();
        getDealCycle2().applyDoping();

        getDealCycle2().setRestraintRingStartTime(getDealCycle1().getRestraintRingStartTime());
        getDealCycle2().setRestraintRingEndTime(getDealCycle1().getRestraintRingEndTime());
        getDealCycle2().setFortyEndTime(getDealCycle1().getFortyEndTime());
        getDealCycle2().setOriginXRestraintRingStartTime(getDealCycle1().getOriginXRestraintRingStartTime());
        getDealCycle2().setOriginXRestraintRingEndTime(getDealCycle1().getOriginXRestraintRingEndTime());
    }
}
