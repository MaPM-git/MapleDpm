package org.mapledpmlab.type.dealcycle;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.Skill;

import java.sql.Timestamp;

@Getter
@Setter
public class SkillEvent {
    private Skill skill;
    private Timestamp start;
    private Timestamp end;

    public SkillEvent(Skill skill, Timestamp start, Timestamp end) {
        this.skill = skill;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SkillEvent{" +
                "skill=" + skill +
                ", start=" + start +
                ", end=" + end +
                "}";
    }
}
