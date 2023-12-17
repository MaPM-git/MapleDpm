package org.mapledpmlab.type.dealcycle;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.sql.Timestamp;

@Getter
@Setter
public class DemonAvengerSkillEvent extends SkillEvent {
    private Long currentHp;

    public DemonAvengerSkillEvent(Skill skill, Timestamp start, Timestamp end, Long currentHp) {
        super(skill, start, end);
        this.currentHp = currentHp;
    }

    @Override
    public String toString() {
        return "SkillEvent{" +
                "skill=" + super.getSkill() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", currentHp=" + currentHp +
                "}";
    }
}
