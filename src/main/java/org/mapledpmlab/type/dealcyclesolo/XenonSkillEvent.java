package org.mapledpmlab.type.dealcyclesolo;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.sql.Timestamp;

@Getter
@Setter
public class XenonSkillEvent extends SkillEvent {
    private Long currentEnergyCnt;

    public XenonSkillEvent(Skill skill, Timestamp start, Timestamp end, Long currentEnergyCnt) {
        super(skill, start, end);
        this.currentEnergyCnt = currentEnergyCnt;
    }

    @Override
    public String toString() {
        return "SkillEvent{" +
                "skill=" + super.getSkill() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", currentHp=" + currentEnergyCnt +
                "}";
    }
}
