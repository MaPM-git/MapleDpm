package org.mapledpmlab.type.dealcycle;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.sql.Timestamp;

@Getter
@Setter
public class ArkSkillEvent extends SkillEvent {
    private boolean isSpecter;

    public ArkSkillEvent(Skill skill, Timestamp start, Timestamp end, boolean isSpecter) {
        super(skill, start, end);
        this.isSpecter = isSpecter;
    }

    @Override
    public String toString() {
        return "SkillEvent{" +
                "skill=" + super.getSkill() +
                ", start=" + super.getStart() +
                ", end=" + super.getEnd() +
                ", isSpecter=" + isSpecter +
                "}";
    }
}
