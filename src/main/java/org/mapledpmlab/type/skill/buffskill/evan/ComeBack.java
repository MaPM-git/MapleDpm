package org.mapledpmlab.type.skill.buffskill.evan;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ComeBack extends BuffSkill {
    public ComeBack() {
        this.setName("돌아와!");
        this.setDelay(30L);
    }
}
