package org.mapledpmlab.type.dealcyclesolo;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.sql.Timestamp;

@Getter
@Setter
public class KaiserSkillEvent extends SkillEvent {
    private int gauge;

    public KaiserSkillEvent(Skill skill, Timestamp start, Timestamp end, int gauge) {
        super(skill, start, end);
        this.gauge = gauge;
    }

    @Override
    public String toString() {
        return "SkillEvent{" +
                "skill=" + super.getSkill() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", currentHp=" + gauge +
                "}";
    }
}
